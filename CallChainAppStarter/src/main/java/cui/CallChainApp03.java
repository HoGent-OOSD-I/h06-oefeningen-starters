package cui;

public class CallChainApp03 {
/*
 Verplaats nu in het programma zelf de methode aanroepen
 methodeB() en methodeC()
 (laat de aanroepen wel in dezelfde methode staan,
 i.e. aanroep methodeB() gebeurt vanuit methodeA en aanroep methodeC()
 gebeurt vanuit methodeB) zodat je volgende uitvoer krijgt.

Start B
Beeindig B
Start C
Beeindig C
Start A
Beeindig A
*/

	public static void main(String[] args) {
		new CallChainApp03().methodeA();
	}

	private void methodeA() {
		System.out.println("Start A");
		methodeB();
		System.out.println("Beeindig A");
	}

	private void methodeB() {
		methodeC();
		System.out.println("Start B");
		System.out.println("Beeindig B");
	}

	private void methodeC() {
		System.out.println("Start C");
		System.out.println("Beeindig C");
	}
}
