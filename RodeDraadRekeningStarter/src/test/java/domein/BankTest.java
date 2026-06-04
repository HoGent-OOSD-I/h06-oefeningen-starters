package domein;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {

	private Bank deBank;
	private Rekening r1, r2, r3, r4, r5;

	@BeforeEach
	void setUp() {
		deBank = new Bank();
		r1 = new Rekening(123456789123L, "Mali");
		r2 = new Rekening(123456789121L, "Tamu");
		r3 = new Rekening(123456789122L, "Evelyn");
		r4 = new Rekening(123456789124L, "Ethel");
		r5 = new Rekening(123456789125L, "Mazvita");
	}

	@Test
	void maakBank_MaaktEenLegeBank() {
		List<Rekening> alleRekeningen = new ArrayList<>();
		assertEquals(alleRekeningen, deBank.getRekeningen());
	}

	@Test
	void voegRekeningToe_BankMet2Rekeningen_VoegtRekeningToe() {
		voegRekeningen1En2Toe();
		List<Rekening> alleRekeningen = List.of(r1, r2 );
		assertEquals(alleRekeningen, deBank.getRekeningen());
	}

	@Test
	void voegRekeningToe_BankMet5Rekeningen_VoegtRekeningToe() {
		voegRekeningen1En2Toe();
		deBank.voegRekeningToe(r3);
		deBank.voegRekeningToe(r4);
		deBank.voegRekeningToe(r5);
		List<Rekening> alleRekeningen = List.of(r1, r2, r3, r4, r5);
		assertEquals(alleRekeningen, deBank.getRekeningen());
	}

	@Test
	void stort_IndexVanRekeningOK_SaldoStijgt() {
		voegRekeningen1En2Toe();
		deBank.stort(1, new BigDecimal(100));
		assertEquals(new BigDecimal(100), r2.getSaldo());
	}

	@Test
	void stort_IndexVanRekeningNegatief_SaldoStijgtNiet() {
		deBank.voegRekeningToe(r1);
		deBank.stort(-1, new BigDecimal(100));
		assertEquals(BigDecimal.ZERO, r1.getSaldo());
	}

	@Test
	void haalAf_IndexVanRekeningOK_SaldoDaalt() {
		voegRekeningen1En2Toe();
		deBank.stort(1, new BigDecimal(100));
		deBank.haalAf(1, new BigDecimal(30));
		assertEquals(new BigDecimal(70), r2.getSaldo());
	}

	@Test
	void haalAf_IndexVanRekeningNegatief_SaldoDaaltNiet() {
		deBank.voegRekeningToe(r1);
		deBank.haalAf(-1, new BigDecimal(100));
		assertEquals(BigDecimal.ZERO, r1.getSaldo());
	}
	@Test
	void schrijfOver_IndexVanRekeningenOk_overgeschreven() {
		voegRekeningen1En2Toe();
		deBank.stort(1, new BigDecimal(100));
		deBank.schrijfOver(1, 0, new BigDecimal(40));
		assertEquals(new BigDecimal(40), r1.getSaldo());
		assertEquals(new BigDecimal(60), r2.getSaldo());
	}
	
	private void voegRekeningen1En2Toe()
	{
		deBank.voegRekeningToe(r1);
		deBank.voegRekeningToe(r2);
	}
}
