package domein;

public class DomeinController {

	private Kapitaal kapitaal;

	public void maakKapitaal(double startkapitaal, double intrest) {
		kapitaal = new Kapitaal(startkapitaal, intrest);
	}

	public void wijzigStartkapitaal(double startkapitaal) {
		kapitaal.setBedrag(startkapitaal);
	}

	public void wijzigIntrest(double intrest) {
		kapitaal.setIntrest(intrest);
	}

	public double geefOpgebouwdKapitaal(int aantalJaar) {
		return kapitaal.geefOpgebouwdKapitaal(aantalJaar);
	}

	public KapitaalDTO geefKapitaal() {
		// TODO - retourneer een kapitaalDTO-object die bedrag en intrest van kapitaal bevat
	}

}
