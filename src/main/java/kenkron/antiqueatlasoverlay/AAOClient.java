package kenkron.antiqueatlasoverlay;

import java.io.File;

import hunternif.mc.atlas.AntiqueAtlasMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class AAOClient extends AAOCommon{

	AAORenderEventReceiver renderer;

    public void preInit(FMLPreInitializationEvent event){
    	//this is a client side only mod
    	renderer = new AAORenderEventReceiver();
    	AAOConfig.load(new File(AntiqueAtlasMod.proxy.getConfigDir(),"/AntiqueAtlasOverlay.cfg"), renderer);
    	System.out.println("loaded");
    }
    
    public void init(FMLInitializationEvent event)
    {
    	//this is a client side only mod
        MinecraftForge.EVENT_BUS.register(renderer);
    	System.out.println("registered");
    }
}
