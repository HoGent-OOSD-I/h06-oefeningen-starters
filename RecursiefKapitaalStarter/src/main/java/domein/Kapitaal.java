package domein;

public class Kapitaal {
	public static final double MIN_BEDRAG = 0, MIN_INTREST = 0, MAX_INTREST = 100;
	private double bedrag, intrest;

	public Kapitaal(double bedrag, double intrest) {
		setBedrag(bedrag);
		setIntrest(intrest);
	}

	public double getBedrag() {
		return bedrag;
	}

	public final void setBedrag(double bedrag) {
		// TODO - exception werpen indien niet aan domeinregel voldaan is
		this.bedrag = bedrag;
	}

	public double getIntrest() {
		return intrest;
	}

	public final void setIntrest(double intrest) {
		// TODO - exception werpen indien niet aan domeinregel voldaan is
		this.intrest = intrest;
	}

	public double geefOpgebouwdKapitaal(int aantalJaar) {
		// TODO - recursieve invulling geven
	}

}
