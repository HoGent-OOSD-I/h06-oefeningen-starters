package domein;

import utils.Orientatie;

public class DomeinController {
	private Driehoek driehoek;

	public DomeinController() {
		this.driehoek = new Driehoek(Orientatie.LINKS_BOVEN, 5, '&');
	}

	public String geefVorm() {
		return driehoek.geefAlsTekening();
	}

	public void wijzigGrootte(int grootte) {
		driehoek.setGrootte(grootte);
	}

	public void wijzigTeken(char teken) {
		driehoek.setTeken(teken);
	}

	public void wijzigOrientatie(int orientatie) {
		//TODO
		// roep setOrientatie aan voor de driehoek instantie
		// geef de juiste waarde door voor de enum parameter
	}
}
