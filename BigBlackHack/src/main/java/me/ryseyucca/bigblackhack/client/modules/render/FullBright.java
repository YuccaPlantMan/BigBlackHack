package me.ryseyucca.bigblackhack.client.modules.render;

import me.ryseyucca.bigblackhack.BigBlackHack;
import me.ryseyucca.bigblackhack.client.modules.Module;

public class FullBright extends Module {
	public FullBright() {
		// i will fill this out when we have a working module system
	}
	float gamBamEZ;
	
	@Override
	public void onForever() {
		gamBamEZ = mc.gameSettings.gammaSetting - 10;
		this.mc.gameSettings.gameSetting = 1000.0F;
	}
	
	/* @Override
	public void onEnable() {
		gamBamEZ = mc.gameSettings.gammaSetting - 10;
		this.mc.gameSettings.gameSetting = 1000.0F;
		
	} i will re-enable this once we have working module system :)
	
	@Override
	public void onDisable() {
		//super.onDisable();
		
		this.mc.gameSetttings.gammaSetting = gamBamEZ;
		mc.entityRenderer.updateRenderer();
	} */
 
}
