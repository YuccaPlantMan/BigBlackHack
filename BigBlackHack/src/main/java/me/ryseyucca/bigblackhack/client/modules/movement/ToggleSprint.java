package me.ryseyucca.bigblackhack.client.modules.movement;

import org.lwjgl.input.Keyboard;

import me.ryseyucca.bigblackhack.client.modules.Category;
import me.ryseyucca.bigblackhack.client.modules.Module;
import net.minecraft.client.Minecraft;

public class ToggleSprint extends Module {
	
	private Minecraft mc = Minecraft.getMinecraft();
	public boolean on;
	
	public ToggleSprint() {
		super ("ToggleSprint", "You can Toggle Sprint no more walking for u >:D", Keyboard.KEY_NONE, Category.MOVEMENT);
		this.setKey(Keyboard.KEY_O);
	}
	
	@Override
	public void onUpdate() {
		if(mc.player.movementInput.moveForward > 0 && !mc.player.isSneaking() && !mc.player.collidedHorizontally) {
			mc.player.setSprinting(true);
		}
		// idk why this doesn't work
	}
}
