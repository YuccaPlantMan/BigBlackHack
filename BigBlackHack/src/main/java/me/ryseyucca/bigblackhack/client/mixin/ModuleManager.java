package me.ryseyucca.bigblackhack.client.mixin;

import java.util.ArrayList;
import java.util.List;

import me.ryseyucca.bigblackhack.BigBlackHack;
import me.ryseyucca.bigblackhack.client.modules.Category;
import me.ryseyucca.bigblackhack.client.modules.Module;
import me.ryseyucca.bigblackhack.client.modules.movement.AutoWalk;
import me.ryseyucca.bigblackhack.client.modules.movement.NoSlow;
import me.ryseyucca.bigblackhack.client.modules.movement.ToggleSprint;
import me.ryseyucca.bigblackhack.client.modules.nonblatant.TriggerBot;
import me.ryseyucca.bigblackhack.client.modules.render.FullBright;

public class ModuleManager {
	
	public ArrayList<Module> modules;
	
	public ModuleManager() {
		(modules = new ArrayList<Module>()).clear();
		this.modules.add(new FullBright());
		this.modules.add(new AutoWalk());
		this.modules.add(new TriggerBot());
		this.modules.add(new NoSlow());
		this.modules.add(new ToggleSprint());
	}
	
	public Module getModule(String name) {
		for(Module m : this.modules) {
			if(m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Module> getModuleList() {
		return this.modules;
	}
	
	public static List<Module> getModulesByCategory(Category c) {
		List<Module> modules = new ArrayList<Module>();
		
		for(Module m : BigBlackHack.moduleManager.modules) {
			if(m.getCategory() == c)
				modules.add(m);
		}
		return modules;
	}

}
