package me.ryseyucca.bigblackhack.client.ui;

import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;

import me.ryseyucca.bigblackhack.BigBlackHack;
import me.ryseyucca.bigblackhack.Info;
import me.ryseyucca.bigblackhack.client.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Hud extends GUI {
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	public static class ModuleComparator implements Comparator<Module> {
		
		@Override
		public int compare(Module arg0, Module arg1) {
			if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
				return -1;
			}
			if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
				return 1;
			}
			return 0;
		}
	}
	
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		Collections.sort(BigBlackHack.moduleManager.modules, new ModuleComparator());
		ScaledResolution sr = new ScaledResolution(mc);
		FontRenderer fr = mc.fontRenderer;
		
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			final int[] counter = {1};
			fr.drawStringWithShadow("BigBlackHack" + " " + "-" + " " + "Version" + " " + Info.MOD_VERSION, 2, 1, rainbow(counter[0] * 300));
			counter[0]++;
		}
		
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			int y = 2;
			final int[] counter = {1};
			for(Module mod : BigBlackHack.moduleManager.getModuleList()) {
				if(!mod.getName().equalsIgnoreCase("TabGUI") && mod.isToggled()) {
					fr.drawStringWithShadow(mod.getName(), sr.getScaledWidth() -fr.getStringWidth(mod.getName()) - 2, y, rainbow(counter[0] * 300));
					y += fr.FONT_HEIGHT;
					counter[0]++;
				}
			}
		}
	}
		public static int rainbow(int delay) {
			double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 10.0);
			rainbowState %= 360;
			return Color.getHSBColor((float) (rainbowState / 360f), 1f, 1f).getRGB();
	}
}
