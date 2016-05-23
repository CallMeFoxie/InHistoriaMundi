package foxie.ihm.asm;


/*
 * Copyright (c) 2016 Ashley "CallMeFoxie".
 * This code is provided as-is without any guarantees.
 * I refuse to take any blame if your computer starts behaving oddly, catches fire or turns into
 * a Skynet while working on this code in any way.
 * Feel free to check out the code as you want, it's open for anybody.
 */

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.9.4")
@IFMLLoadingPlugin.Name(IHMCoreLoader.NAME)
public class IHMCoreLoader implements IFMLLoadingPlugin {
   public static final String NAME = "IHM Core";

   @Override
   public String[] getASMTransformerClass() {
      return new String[]{PatchCollection.class.getName()};
   }

   @Override
   public String getModContainerClass() {
      return IHMCore.class.getName();
   }

   @Override
   public String getSetupClass() {
      return null;
   }

   @Override
   public void injectData(Map<String, Object> data) {

   }

   @Override
   public String getAccessTransformerClass() {
      return null;
   }
}
