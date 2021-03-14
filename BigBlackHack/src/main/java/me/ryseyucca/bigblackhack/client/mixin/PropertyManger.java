package me.ryseyucca.bigblackhack.client.mixin;

import me.ryseyucca.bigblackhack.client.modules.Module;

public class PropertyManger {
	
	public static class Property<Type> {
		public Type value, defaultvalue;
		public boolean onClickGui;
		
		
	}
	public static class DoubleProperty extends Property {
		public double min, max;
		public double increase;
		public boolean colorSlider;
		
		public DoubleProperty(Module module , String name, double value, double min, double max, double inc) {
			this.min = min;
			this.max = max;
			this.increase = inc;
			this.value = this.defaultvalue = value;
			colorSlider = false;
		}
		public DoubleProperty(Module module , String name, double value, double min, double max) {
			this.min = min;
			this.max = max;
			this.increase = 0;
			this.value = this.defaultvalue = value;
			colorSlider = false;
		}
		public DoubleProperty(Module module, String name, double value, double min, double max, boolean showOnGui) {
			this.min = min;
			this.max = max;
			this.increase = 0;
			this.value = this.defaultvalue = value;
			this.onClickGui = showOnGui;
			colorSlider = false;
		}
		public DoubleProperty(Module module, String name, double value, double min, double max, boolean showOnGui, boolean ColorSlider) {
			this.min = min;
			this.max = max;
			this.increase = 0;
			this.value = this.defaultvalue = value;
			this.onClickGui = showOnGui;
			colorSlider = ColorSlider;
		}
	}

}
