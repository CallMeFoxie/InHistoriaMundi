package foxie.ihm.asm.patches;

/*
 * Copyright (c) 2016 Ashley "CallMeFoxie".
 * This code is provided as-is without any guarantees.
 * I refuse to take any blame if your computer starts behaving oddly, catches fire or turns into
 * a Skynet while working on this code in any way.
 * Feel free to check out the code as you want, it's open for anybody.
 */

import foxie.ihm.asm.MethodToPatch;
import net.minecraft.launchwrapper.Launch;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.HashSet;
import java.util.Set;

public abstract class ClassPatch extends ClassVisitor {

   public Set<MethodToPatch> matchingMethods = new HashSet<MethodToPatch>();

   public ClassPatch(ClassWriter writer) {
      super(Opcodes.ASM4, writer);
   }

   public static Boolean isDeobfuscatedEnvironment() {
      return (Boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");
   }

   public abstract MethodVisitor patchedVisitor(MethodVisitor parent);

   @Override
   public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
      for (MethodToPatch patch : matchingMethods) {
         if (patch.matchesMethod(name, desc))
            return patchedVisitor(super.visitMethod(access, name, desc, signature, exceptions));
      }

      return super.visitMethod(access, name, desc, signature, exceptions);
   }
}
