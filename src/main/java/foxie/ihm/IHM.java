package foxie.ihm;

/*
 * Copyright (c) 2016 Ashley "CallMeFoxie".
 * This code is provided as-is without any guarantees.
 * I refuse to take any blame if your computer starts behaving oddly, catches fire or turns into
 * a Skynet while working on this code in any way.
 * Feel free to check out the code as you want, it's open for anybody.
 */

import foxie.lib.Config;
import foxie.lib.IFoxieMod;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = IHM.MODID, name = IHM.NAME, version = IHM.VERSION,
        dependencies = "required-after:FoxieLib;required-after:CalendarAPI")
public class IHM implements IFoxieMod {
   public static final String MODID = "inhistoriamundi";
   public static final String NAME = "In Historia Mundi";
   public static final String AUTHOR = "CallMeFoxie";
   public static final String VERSION = "@VERSION@";

   @Mod.Instance(MODID)
   public static IHM INSTANCE;

   private Config config;

   @Override
   public Config getConfig() {
      return config;
   }

   @Override
   public String getModId() {
      return MODID;
   }
}
