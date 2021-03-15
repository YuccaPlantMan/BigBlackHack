package me.ryseyucca.bigblackhack;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import me.ryseyucca.bigblackhack.client.mixin.ModuleManager;
import me.ryseyucca.bigblackhack.client.modules.Module;
import me.ryseyucca.bigblackhack.client.proxy.CommonProxy;
import me.ryseyucca.bigblackhack.client.ui.Hud;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = Info.MOD_ID, name = Info.MOD_NAME, version = Info.MOD_VERSION)
public class BigBlackHack {
	public static ArrayList<Module> modules;
	
	public static ModuleManager moduleManager;
	public static Hud hud;
	
	public static final EventBus EVENT_BUS = new EventBus();
	
	@Instance
	public static BigBlackHack instance;
	
	public BigBlackHack() { instance = this; }
	
	public static BigBlackHack getInstance() { return instance; } 
	
	@SidedProxy(clientSide = Info.CLIENT_PROXY_CLASS, serverSide = Info.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public Object synchronize = new Object();
	
	public static void escClientInit() {
		//MinecraftForge.EVENT_BUS.register(this);
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(instance);
		MinecraftForge.EVENT_BUS.register(new Hud());
		moduleManager = new ModuleManager();
		hud = new Hud();
		//Thread t = new Thread(this::escClientInit);
		//t.start();
	}
	@EventHandler
	public void postInit(FMLPreInitializationEvent event) {
		
	}
	
	@SubscribeEvent
	public void key(KeyInputEvent e) {
		if(Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
			return;
		try {
			if(Keyboard.isCreated()) {
				if(Keyboard.getEventKeyState()) {
					int keyCode = Keyboard.getEventKey();
					if(keyCode<= 0)
						return;
					for(Module m : moduleManager.modules) {
						if(m.getKey() == keyCode && keyCode > 0) {
							m.toggle();
						}
					}
				}
			}
		} catch (Exception q) {q.printStackTrace(); }
	}
}
