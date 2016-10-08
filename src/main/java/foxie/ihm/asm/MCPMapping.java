package foxie.ihm.asm;

/*
 * Copyright (c) 2016 Ashley "CallMeFoxie".
 * This code is provided as-is without any guarantees.
 * I refuse to take any blame if your computer starts behaving oddly, catches fire or turns into
 * a Skynet while working on this code in any way.
 * Feel free to check out the code as you want, it's open for anybody.
 */

import foxie.ihm.asm.patches.ClassPatch;

public class MCPMapping {
   private String deobf;
   private String obf;

   public MCPMapping(String deobf, String obf) {
      this.deobf = deobf;
      this.obf = obf;
   }

   public String getName() {
      return ClassPatch.isDeobfuscatedEnvironment() ? deobf : obf;
   }

   public boolean matches(String name) {
      return name.equals(getName());
   }
}
