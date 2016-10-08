package foxie.ihm.asm;

/*
 * Copyright (c) 2016 Ashley "CallMeFoxie".
 * This code is provided as-is without any guarantees.
 * I refuse to take any blame if your computer starts behaving oddly, catches fire or turns into
 * a Skynet while working on this code in any way.
 * Feel free to check out the code as you want, it's open for anybody.
 */

import foxie.ihm.asm.patches.ClassPatch;
import foxie.ihm.asm.patches.PatchFreezeAllWater;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraftforge.fml.common.FMLLog;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatchCollection implements IClassTransformer {
   public static Map<String, List<Class<? extends ClassPatch>>> patchClasses;

   static {
      addPatch(new MCPMapping("net.minecraft.world.WorldServer", "lq"), PatchFreezeAllWater.class);
   }

   public static void addPatch(MCPMapping classname, Class<? extends ClassPatch> patch) {
      if (patchClasses == null)
         patchClasses = new HashMap<String, List<Class<? extends ClassPatch>>>();

      if (patchClasses.get(classname.getName()) != null) {
         patchClasses.get(classname.getName()).add(patch);
      } else {
         List<Class<? extends ClassPatch>> tmp = new ArrayList<Class<? extends ClassPatch>>();
         tmp.add(patch);
         patchClasses.put(classname.getName(), tmp);
      }
   }

   @Override
   public byte[] transform(String origName, String newName, byte[] bytecode) {
      if (patchClasses.containsKey(origName)) {
         ClassReader rd;
         ClassWriter wr;
         for (Class<? extends ClassPatch> patch : patchClasses.get(origName)) {
            try {
               rd = new ClassReader(bytecode);
               wr = new ClassWriter(ClassWriter.COMPUTE_MAXS);
               ClassVisitor patcher = patch.getDeclaredConstructor(ClassWriter.class).newInstance(wr);
               rd.accept(patcher, ClassReader.EXPAND_FRAMES);
               bytecode = wr.toByteArray();
               FMLLog.info("Successfully patched " + origName + " with " + patch.toString());
            } catch (Exception e) {
               FMLLog.warning("Failed to patch class " + origName + " with " + patch.toString() + " :( - things will not work properly!");
            }
         }
      }

      return bytecode;
   }
}
