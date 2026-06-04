package domein;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class KapitaalTest {
	private Kapitaal k1, k2;

	@BeforeEach
	void setUp() {
		k1 = new Kapitaal(1000, 1.22);
		k2 = new Kapitaal(2000, 2.05);
	}

	void maakKapitaal_geldigBedragEnIntrest_maaktKapitaal() {
		assertEquals(1.22, k1.getIntrest());
		assertEquals(1000, k1.getBedrag());
	}

	@ParameterizedTest
	@ValueSource(doubles = { -200, -100, -0.001 })
	void maakKapitaal_ongeldigBedrag_werptException(double bedrag) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Kapitaal(bedrag, 1.47);
		});
	}

	@ParameterizedTest
	@ValueSource(doubles = { -200, -100, -0.001, 100.001, 200 })
	void maakKapitaal_ongeldigeIntrest_werptException(double intrest) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Kapitaal(1500, intrest);
		});
	}

	@Test
	void berekenKapitaalNaNJaar_0jaar_retourneertBedragVanKapitaal() {
		assertEquals(1000, k1.geefOpgebouwdKapitaal(0));
		assertEquals(2000, k2.geefOpgebouwdKapitaal(0));
	}

	@Test
	void berekenKapitaalNaNJaar_geldigAantalJaar_retourneertJuisteBedrag() {
		assertEquals(1354.12, k1.geefOpgebouwdKapitaal(25), 0.01);
		assertEquals(3321.66, k2.geefOpgebouwdKapitaal(25), 0.01);
	}

	@ParameterizedTest
	@ValueSource(doubles = { -200, -0.001 })
	void setBedrag_ongeldigeBedrag_werptException(double bedrag) {
		assertThrows(IllegalArgumentException.class, () -> {
			k1.setBedrag(bedrag);
		});
	}

	@ParameterizedTest
	@ValueSource(doubles = { -200, -0.001, 100.001, 200 })
	void setIntrest_ongeldigeIntrest_werptException(double intrest) {
		assertThrows(IllegalArgumentException.class, () -> {
			k1.setIntrest(intrest);
		});
	}

	@ParameterizedTest
	@ValueSource(doubles = { 0.001, 200.36 })
	void setBedrag_geldigeBedrag_pastBedragAan(double bedrag) {
		k1.setBedrag(bedrag);
		assertEquals(bedrag, k1.getBedrag());
	}

	@ParameterizedTest
	@ValueSource(doubles = { 0, 0.001, 25.36, 99.99, 100 })
	void setIntrest_geldigeIntrest_pastIntrestAan(double intrest) {
		k1.setIntrest(intrest);
		assertEquals(intrest, k1.getIntrest());
	}

}