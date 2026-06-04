package utils;

public enum Orientatie {
	LINKS_BOVEN, RECHTS_BOVEN, RECHTS_ONDER, LINKS_ONDER;

	public String toString() {
		String name = this.name().replace('_', ' ');
		name = name.substring(0, 1).toUpperCase() + 
				name.substring(1).toLowerCase();
		return name;
	}
}
