package me.ryseyucca.bigblackhack;

import me.ryseyucca.bigblackhack.client.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = Info.MOD_ID, name = Info.MOD_NAME, version = Info.MOD_VERSION)
public class BigBlackHack {
	
	public static final EventBus EVENT_BUS = new EventBus();
	
	@Instance
	public static BigBlackHack instance;
	
	public BigBlackHack() { instance = this; }
	
	public static BigBlackHack getInstance() { return instance; } 
	
	@SidedProxy(clientSide = Info.CLIENT_PROXY_CLASS, serverSide = Info.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static void escClientInit() {
		//MinecraftForge.EVENT_BUS.register(this);
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(instance);
		//Thread t = new Thread(this::escClientInit);
		//t.start();
	}
	@EventHandler
	public void postInit(FMLPreInitializationEvent event) {
		
	}


}
