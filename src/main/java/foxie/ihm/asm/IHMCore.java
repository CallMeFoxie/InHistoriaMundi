package foxie.ihm.asm;

/*
 * Copyright (c) 2016 Ashley "CallMeFoxie".
 * This code is provided as-is without any guarantees.
 * I refuse to take any blame if your computer starts behaving oddly, catches fire or turns into
 * a Skynet while working on this code in any way.
 * Feel free to check out the code as you want, it's open for anybody.
 */

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import foxie.ihm.IHM;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class IHMCore extends DummyModContainer {

   public IHMCore() {
      super(new ModMetadata());
      ModMetadata metadata = getMetadata();
      metadata.modId = IHM.MODID + "core";
      metadata.name = IHM.NAME + " Core";
      metadata.version = "1.0";
      metadata.authorList.add(IHM.AUTHOR);
   }

   @Override
   public boolean registerBus(EventBus bus, LoadController controller) {
      bus.register(this);
      return true;
   }

   @Subscribe
   public void modConstruction(FMLConstructionEvent event) {

   }

   @Mod.EventHandler
   public void preinit(FMLPreInitializationEvent event) {

   }

   @Mod.EventHandler
   public void postInit(FMLPostInitializationEvent event) {
   }
}
