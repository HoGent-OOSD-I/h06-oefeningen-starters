package cui;

public class GetallenApplicatie {
	
	public void start() {
		int[] herschikteGetallen = {};

		// Gebruik de voorbeeldarray
		int[] getallen = { -5, 2, 7, -4, 3, 9, -1, -8 };

		// Test je code met enkel positieve getallen
		// int[] getallen = { 77, 67, 71, 74, 45, 44, 23, 0 };

		// Test je code met enkel negatieve getallen
		// int[] getallen = { -77, -67, -71, -74, -45, -44, -23, -10 };
		
		// Gebruik array van willekeurige getallen
		//vulMetWillekeurigeGetallen(getallen);

		System.out.println("Bij aanvang");
		System.out.println("===========");
		System.out.println("De array getallen bevat:");
		toonGetallen(getallen);
		System.out.println("De array herschikteGetallen bevat:");
		toonGetallen(herschikteGetallen);

		// stap 1:
		// herschikken van de getallen zonder het argument te wijzigen
		herschikteGetallen = GetallenHerschikker.herschikZonderMutatie(getallen);
		System.out.println("Na de aanroep naar de methode 'herschikZonderMutatie'");
		System.out.println("=====================================================");
		System.out.println("De array getallen is ongewijzigd:");
		toonGetallen(getallen);
		System.out.println("De array herschikteGetallen bevat het resultaat:");
		toonGetallen(herschikteGetallen);

		// stap 2
		// herschikken van de getallen door het argument te wijzigen
		GetallenHerschikker.herschikMetMutatie(getallen);
		System.out.println("Na de aanroep naar de methode 'herschikMetMutatie'");
		System.out.println("==================================================");
		System.out.println("De array getallen is gemuteerd:");
		toonGetallen(getallen);
		System.out.println("De array herschikteGetallen kwam hier niet aan te pas en is ongewijzigd:");
		toonGetallen(herschikteGetallen);
	}

	private void toonGetallen(int[] getallen) {
		System.out.print("--> ");
		if (getallen.length == 0)
			System.out.print("deze array bevat geen getallen");
		else
			for (int getal : getallen)
				System.out.printf("%5d", getal);
		System.out.println("\n");
	}

//TODO	
	//Voeg private methode vulMetWillekeurigeGetallen toe

}
