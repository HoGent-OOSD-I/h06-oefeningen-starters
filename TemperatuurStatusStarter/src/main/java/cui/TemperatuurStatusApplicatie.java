package cui;

import java.util.Scanner;

public class TemperatuurStatusApplicatie {

	public static void main(String[] args) {
		new TemperatuurStatusApplicatie().bepaalTemperatuurStatus();
	}
	
	private Scanner invoer = new Scanner(System.in);
	
	private void bepaalTemperatuurStatus()
	{	
		String schaal = "Celsius";
		System.out.printf("Geef de temperatuur (9999 om te stoppen): ");
		int temperatuur = invoer.nextInt();
		while (temperatuur != 9999) {
			String resultaat = geefTemperatuurStatus(temperatuur);
			System.out.printf("%d graden %s voelt aan als %s%n", temperatuur, schaal, resultaat);
			System.out.printf("Geef de temperatuur (9999 om te stoppen): ");
			temperatuur = invoer.nextInt();
		}
	}
	
}