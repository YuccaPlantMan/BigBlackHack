package me.ryseyucca.bigblackhack.client.modules.movement;

import org.lwjgl.input.Keyboard;

import me.ryseyucca.bigblackhack.client.modules.Category;
import me.ryseyucca.bigblackhack.client.modules.Module;

public class NoSlow extends Module {
	
	
	public NoSlow() {
		super ("NoSlow", "You won't be slowed :)", Keyboard.KEY_NONE, Category.MOVEMENT);
		this.setKey(Keyboard.KEY_P);
	}
	
	public void onEnable() {
		if(mc.player.isHandActive() && !mc.player.isRiding()) {
			mc.player.movementInput.moveStrafe *= 5;
			mc.player.movementInput.moveForward *= 5;
		}
	}
}
