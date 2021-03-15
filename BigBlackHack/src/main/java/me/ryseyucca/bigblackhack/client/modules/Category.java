package me.ryseyucca.bigblackhack.client.modules;

public enum Category {
	COMBAT("combat"), MISC("misc"), MOVEMENT("movement"), NONBLATANT("nonblatant"), PLAYER("player"), RENDER("render");
	
	public String name;
	public int moduleIndex;
	
	Category(String name) {
		this.name = name;
	}
	

}
