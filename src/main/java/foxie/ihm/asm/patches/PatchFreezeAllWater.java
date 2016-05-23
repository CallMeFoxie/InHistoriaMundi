package foxie.ihm.asm.patches;

/*
 * Copyright (c) 2016 Ashley "CallMeFoxie".
 * This code is provided as-is without any guarantees.
 * I refuse to take any blame if your computer starts behaving oddly, catches fire or turns into
 * a Skynet while working on this code in any way.
 * Feel free to check out the code as you want, it's open for anybody.
 */

import foxie.ihm.asm.MethodToPatch;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class PatchFreezeAllWater extends ClassPatch {
   public PatchFreezeAllWater(ClassWriter writer) {
      super(writer);
      matchingMethods.add(new MethodToPatch("updateBlocks", "()V"));
      matchingMethods.add(new MethodToPatch("j", "()V"));
   }

   @Override
   public MethodVisitor patchedVisitor(MethodVisitor parent) {
      return new PatchFreezeAllWaterVisitor(parent);
   }

   public class PatchFreezeAllWaterVisitor extends MethodVisitor {
      public PatchFreezeAllWaterVisitor(MethodVisitor visitor) {
         super(Opcodes.ASM4, visitor);
      }

      @Override
      public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
         if (desc.equals("(Lnet/minecraft/util/math/BlockPos;)Z") && (name.equals("canBlockFreezeNoWater") || name.equals("v"))) {
            super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraft/world/WorldServer", "canBlockFreezeWater", "(Lnet/minecraft/util/math/BlockPos;)Z", false);
         } else {
            super.visitMethodInsn(opcode, owner, name, desc, itf);
         }
      }
   }
}
