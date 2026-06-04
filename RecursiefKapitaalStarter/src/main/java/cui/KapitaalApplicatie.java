package cui;

import java.util.Scanner;

import domein.DomeinController;
import static domein.Kapitaal.*;
import dto.KapitaalDTO;

public class KapitaalApplicatie {

	private DomeinController dc;
	private Scanner invoer = new Scanner(System.in);

	private static final int WIJZIG_KAPITAAL = 1;
	private static final int WIJZIG_INTREST = 2;
	private static final int TOON_KAPITAAL = 3;
	private static final int INTREST = 10;
	private static final int BEDRAG = 1000;
	private static final int AANTAL_JAREN = 10;
	
	private static final String[] menu = {"Startkapitaal wijzigen", "Intrest wijzigen", 
			"Overzicht kapitaalsopbouw tonen","Stoppen"};
	
	public KapitaalApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		dc.maakKapitaal(BEDRAG, INTREST);
		toonKapitaalsopbouw();
		int keuze = maakKeuze();
		while (keuze != menu.length) {
			switch (keuze) {
			case WIJZIG_KAPITAAL -> wijzigStartkapitaal();
			case WIJZIG_INTREST -> wijzigIntrest();
			case TOON_KAPITAAL -> toonKapitaalsopbouw();
			}
			keuze = maakKeuze();
		}
		System.out.println("Tot een volgende keer!");
	}

	private int maakKeuze() {
		int keuze;
		do {
			toonMenu();
			System.out.printf("Geef je keuze (1-%d): ", menu.length);
			keuze = invoer.nextInt();
		} while (keuze < 1 || keuze > menu.length);
		return keuze;
	}

	private void toonMenu()
	{
		int keuzenr = 1;
		System.out.printf("%n%n== MENU ==%n");
		for (String eenMenu: menu)
		{
			System.out.printf("%d. %s%n", keuzenr++, eenMenu);
		}
	}
	
	private void wijzigStartkapitaal() {
		double startkapitaal = geefWaarde(String.format("%nGeef het start kapitaal: "));
		dc.wijzigStartkapitaal(startkapitaal);
	}

	private void wijzigIntrest() {
		double intrest = geefWaarde(String.format("%nGeef de intrestvoet [%.0f-%.0f]: ", MIN_INTREST, MAX_INTREST));
		dc.wijzigIntrest(intrest);
	}

	private double geefWaarde(String boodschap)
	{
		System.out.print(boodschap);
		return invoer.nextDouble();
	}
	
	private void toonKapitaalsopbouw() {
		//TODO
	}
}
