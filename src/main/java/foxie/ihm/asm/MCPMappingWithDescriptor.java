package foxie.ihm.asm;

/*
 * Copyright (c) 2016 Ashley "CallMeFoxie".
 * This code is provided as-is without any guarantees.
 * I refuse to take any blame if your computer starts behaving oddly, catches fire or turns into
 * a Skynet while working on this code in any way.
 * Feel free to check out the code as you want, it's open for anybody.
 */

import foxie.ihm.asm.patches.ClassPatch;

public class MCPMappingWithDescriptor extends MCPMapping {
   private String descObf;
   private String descDeobf;

   public MCPMappingWithDescriptor(String deobf, String obf, String desc) {
      super(deobf, obf);
      this.descObf = this.descDeobf = desc;
   }

   public MCPMappingWithDescriptor(String deobf, String obf, String descDeobf, String descObf) {
      super(deobf, obf);
      this.descDeobf = descDeobf;
      this.descObf = descObf;
   }

   public String getDescriptor() {
      return ClassPatch.isDeobfuscatedEnvironment() ? descDeobf : descObf;
   }

   public boolean matches(String name, String descriptor) {
      return super.matches(name) && descriptor.equals(getDescriptor());
   }
}
