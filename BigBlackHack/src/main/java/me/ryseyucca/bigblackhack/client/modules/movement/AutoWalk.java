package me.ryseyucca.bigblackhack.client.modules.movement;

import org.lwjgl.input.Keyboard;

import me.ryseyucca.bigblackhack.client.modules.Category;
import me.ryseyucca.bigblackhack.client.modules.Module;
import net.minecraft.client.settings.KeyBinding;

public class AutoWalk extends Module {
	public AutoWalk() {
		super ("AutoWalk", "Walks for you, also you can press w to cancel", Keyboard.KEY_NONE , Category.MOVEMENT);
		this.setKey(Keyboard.KEY_N);
	}
	
	public void onEnable() {
		if(mc.currentScreen == null) {
			KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
		}
	}
	
	public void onDisable() {
		KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
	}

}
