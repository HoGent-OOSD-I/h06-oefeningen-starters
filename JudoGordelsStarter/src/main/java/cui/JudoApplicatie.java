package cui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utils.Gordel;

public class JudoApplicatie {
	private Scanner invoer = new Scanner(System.in);

	public void start() {
		String kleur = voerKleurIn(geefGeldigeKleuren());

		//TODO
		// ken de juiste gordel volgens "kleur" toe aan de variabele gordel
		Gordel gordel = null;

		//TODO
		// maak gebruik van de Gordel-getters om de juiste uitvoer te genereren
		System.out.printf("Proficiat, je graad is %s, dat is %s.%n", "to-do", "to-do");

		//TODO
		// zorg dat de else tak wordt uitgevoerd indien het een zwarte gordel betreft
		if (true)
			System.out.printf("Focus en train met veel discipline en inzet, je volgende gordel is %s!",
					gordel.geefVolgende());
		else
			System.out.println("Je bent een meester!");
	}

	// retourneert een geldig kleur in UPPERCASE karakters
	private String voerKleurIn(List<String> geldigeKleuren) {
		String kleur;
		do {
			System.out.printf("Welke kleur heeft je gordel %s? ", geefKleurenAlsTekstInLijst(geldigeKleuren));
			kleur = invoer.nextLine();
		} while (!geldigeKleuren.contains(kleur.toLowerCase()));
		return kleur.toUpperCase();
	}

	private String geefKleurenAlsTekstInLijst(List<String> geldigeKleuren) {
		String lijst = "(";
		for (String kleur : geldigeKleuren) {
			lijst += String.format("%s ", kleur);
		}
		lijst += ")";
		return lijst;
	}

	private List<String> geefGeldigeKleuren() {
		List<String> kleuren = new ArrayList<>();
		//TODO overloop alle gordels
		//for (Gordel gordel :         )
		//	kleuren.add(  TODO naam van de enum in kleine letters  );
		return kleuren;
	}

}
