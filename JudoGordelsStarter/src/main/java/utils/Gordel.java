package utils;

public enum Gordel {

	WIT("rok-kyu", "6de Kyu"), GEEL("go-kyu", "5de Kyu"), GROEN("san-kyu", "3de Kyu"), BLAUW("ni-kyu", "2de Kyu"),
	BRUIN("ik-kyu", "1ste Kyu"), ZWART("sho-dan", "1ste Dan");

	private String graad;
	private String japanseNaam;

	private Gordel(String japanseNaam, String graad) {
		this.japanseNaam = japanseNaam;
		this.graad = graad;
	}

	public String getGraad() {
		return graad;
	}

	public String getJapanseNaam() {
		return japanseNaam;
	}

	public Gordel geefVolgende() {
		return (this != ZWART) ? Gordel.values()[this.ordinal() + 1] : this;
	}
}
