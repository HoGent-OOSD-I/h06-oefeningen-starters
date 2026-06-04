package domein;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(OrderAnnotation.class)
class DoosTest {

	private final static String DEFAULT_KLEUR = "rood";
	private final static double DEFAULT_RIBBE = 1.0;

	private void controleWaarden(double resLengte, double resBreedte, double resHoogte, String resKleur, Doos doos)
	{
		assertEquals(resLengte, doos.getLengte());
		assertEquals(resBreedte, doos.getBreedte());
		assertEquals(resHoogte, doos.getHoogte());
		assertEquals(resKleur, doos.getKleur());
	}

	@Test
	void maakDoos_geldigeAfmetingenEnKleur_maaktDoosMetOpgegevenAfmetingenEnKleur() {
		Doos doos = new Doos(1, 2, 3, "groen");
		controleWaarden(1.0, 2.0, 3.0, "groen", doos);
	}

	@Test
	void maakDoos_geenAfmetingenEnKleur_maaktDoosMetDefaultdAfmetingenEnKleur() {
		Doos doos = new Doos();
		controleWaarden(DEFAULT_RIBBE, DEFAULT_RIBBE, DEFAULT_RIBBE, DEFAULT_KLEUR, doos);
	}

	@Test
	void maakDoos_geldigeAfmetingenEnGeenKleur_maaktDoosMetOpgegevenAfmetingenEnDefaultKleur() {
		Doos doos = new Doos(1, 2, 3);
		controleWaarden(1.0, 2.0, 3.0, DEFAULT_KLEUR, doos);
	}

	@Test
	void maakDoos_geldigeKleurEnGeenAfmetingen_maaktDoosMetOpgegevenKleurEnDefaultAfmetingen() {
		Doos doos = new Doos("groen");
		controleWaarden(DEFAULT_RIBBE, DEFAULT_RIBBE, DEFAULT_RIBBE, "groen", doos);
	}

	/**
	 *
	 * @param lengte
	 */
	@ParameterizedTest
	@ValueSource(ints={-100, -2, 0})
	void maakDoos_ongeldigeLengte_werptException(int lengte) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Doos(lengte, 1, 1);
		});
	}

	/**
	 *
	 * @param breedte
	 */
	@ParameterizedTest
	@ValueSource(ints={-100, -2, 0})
	void maakDoos_ongeldigeBreedte_werptException(int breedte) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Doos(1, breedte, 1);
		});

	}

	/**
	 *
	 * @param hoogte
	 */
	@ParameterizedTest
	@ValueSource(ints={-100, -2, 0})
	void maakDoos_ongeldigeHoogte_werptException(int hoogte) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Doos(1, 1, hoogte);
		});

	}

	/**
	 *
	 * @param kleur
	 */
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings={"   ", "\t\t"})
	void maakDoos_ongeldigeKleur_werptException(String kleur) {
		assertThrows(IllegalArgumentException.class, () -> new Doos(1, 2, 3, kleur));
	}

	// De waarde van de static variabele aantalDozenGemaakt verhoogt telkens
	// er in een test-methode 1 of meerdere dozen worden gemaakt.
	// Via de @order kunnen we aangeven dat onderstaande testen steeds als
	// eerste twee testen moeten uitgevoerd worden.
	// Zo kunnen we exact bepalen welke waarde we verwachten in de
	/**
	 * De waarde van de static variabele aantalDozenGemaakt verhoogt telkens
	 * er in een test-methode 1 of meerdere dozen worden gemaakt.
	 * Via de @order kunnen we aangeven dat onderstaande testen steeds als
	 * eerste twee testen moeten uitgevoerd worden.
	 * Zo kunnen we exact bepalen welke waarde we verwachten in de
	 * static variable aantalDozenGemaakt.
	 */
	@Order(1)
	@Test
	void maakDoos_nieuweDoosGemaakt_verhoogtAantalDozenGemaakt() {
		assertEquals(0, Doos.getAantalDozenGemaakt());
		new Doos(); // eerste doos
		assertEquals(1, Doos.getAantalDozenGemaakt());
		new Doos(1, 2, 3, "groen"); // tweede doos
		new Doos("groen"); // derde doos
		new Doos(1, 2, 3); // vierde doos
		assertEquals(4, Doos.getAantalDozenGemaakt());
	}

	@Order(2)
	@Test
	void maakDoos_vijfdeDoos_maaktDoosMetCorrecteCode() {
		Doos d1 = new Doos(); // vijfde doos
		assertEquals("D000000000000005", d1.getCode());
	}

}
