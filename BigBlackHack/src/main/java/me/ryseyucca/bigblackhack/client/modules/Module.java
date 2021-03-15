package me.ryseyucca.bigblackhack.client.modules;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;

public class Module {
	protected static final Minecraft mc = Minecraft.getMinecraft();
	public static ArrayList<Module> modules;
	
	public String name, whatitdo;
	private int key;
	public Category category;
	public boolean toggled;

	public Module(String name, String whatitdo, int key, Category moduleCategory) {
		super();
		this.name = name;
		this.whatitdo = whatitdo;
		this.key = 0;
		this.category = category;
		this.toggled = false;
	}
	
	public String getDescription() {
		return whatitdo;
	}
	
	public void setDescription(String whatitdo) {
		this.whatitdo = whatitdo;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public boolean isToggled() {
		return toggled;
	}
	
	public void setToggled(boolean toggled) {
		this.toggled = toggled;
		if(this.toggled) {
			this.onEnable();
		} else {
			this.onDisable();
		}
	}
	
	public void toggle() {
		this.toggled = !this.toggled;
		
		if(this.toggled) {
			this.onEnable();
		} else {
			this.onDisable();
		}
	}
	
	public void enabled() {
		setToggled(true);
	}
	
	public void disabled() {
		setToggled(false);
	}
	
	public void onEnable() {
	}

	public void onDisable() {
	}

	public void onForever() {
	}
	
	public void onUpdate() {
	}
	
	public String getName() {
		return this.name;
	}
	
	public Category getCategory() {
		return this.category;
	}
}
