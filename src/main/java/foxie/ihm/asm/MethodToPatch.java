package foxie.ihm.asm;


/*
 * Copyright (c) 2016 Ashley "CallMeFoxie".
 * This code is provided as-is without any guarantees.
 * I refuse to take any blame if your computer starts behaving oddly, catches fire or turns into
 * a Skynet while working on this code in any way.
 * Feel free to check out the code as you want, it's open for anybody.
 */

public class MethodToPatch {
   public String name;
   public String descriptor;

   public MethodToPatch(MCPMappingWithDescriptor name) {
      this.name = name.getName();
      this.descriptor = name.getDescriptor();
   }

   public boolean matchesMethod(String name, String descriptor) {
      if (this.name.equals(name)) {
         if (this.descriptor != null && descriptor != null && this.descriptor.equals(descriptor))
            return true;
         if (this.descriptor == null && descriptor == null)
            return true;
      }

      return false;
   }
}