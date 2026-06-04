package domein;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComplexTest {

	private Complex c1, c2, c3;

	@BeforeEach
	void setUp() {
		c1 = new Complex();
		c2 = new Complex(5.2);
		c3 = new Complex(3.2, 5.4);
	}

	private void controleerWaarden(double resReeel, double resImaginair, Complex c)
	{
		assertEquals(resReeel, c.getReeel());
		assertEquals(resImaginair, c.getImaginair());
	}

	@Test
	void maakComplex_metReeelEnImaginairDeel_maaktComplexMetOpgegevenReeelEnImaginairDeel() {
		controleerWaarden(3.2, 5.4, c3);
	}

	@Test
	void maakComplex_metReeelDeel_maaktComplexMetImaginairDeel0() {
		controleerWaarden(5.2, 0.0, c2);
	}

	@Test
	void maakComplex_zonderReeelOfImagoinairDeel_maaktComplexMetReeelEnImaginairDeel0() {
		controleerWaarden(0.0, 0.0, c1);
	}

	@Test
	void telOp_retourneertEenComplexDieDeSomBevat() {
		Complex som = c3.telOp(c2);
		controleerWaarden(8.4, 5.4, som);
	}

	@Test
	void telOp_controleImaginairDeel_juisteWaarde() {
		assertEquals(5.4, (c2.telOp(c3)).getImaginair());
	}

	@Test
	void sommeer_lijstMetComplexeGetallen_maaktDeSomVanAlleGetallen() {
		List<Complex> complexeGetallen = new ArrayList<>();
		complexeGetallen.add(c2);
		complexeGetallen.add(c3);
		complexeGetallen.add(new Complex(1.0, 2.0));
		Complex som = Complex.sommeer(complexeGetallen);
		controleerWaarden(9.4, 7.4, som);
	}

}
