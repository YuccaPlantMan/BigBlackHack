package me.ryseyucca.bigblackhack.client.modules.render;

import org.lwjgl.input.Keyboard;

import me.ryseyucca.bigblackhack.BigBlackHack;
import me.ryseyucca.bigblackhack.client.modules.Category;
import me.ryseyucca.bigblackhack.client.modules.Module;


public class FullBright extends Module {
	public FullBright() {
		super ("FullBright", "No more torches bby", Keyboard.KEY_NONE , Category.RENDER);
		this.setKey(Keyboard.KEY_M);
	}
	float oldGamma;
	
	@Override
	public void onEnable() {
		oldGamma = mc.gameSettings.gammaSetting;
		this.mc.gameSettings.gammaSetting = 1000.0F;
		
	}
	
	@Override
	public void onDisable() {
		this.mc.gameSettings.gammaSetting = oldGamma;
		mc.entityRenderer.updateRenderer();
	}
 
}
