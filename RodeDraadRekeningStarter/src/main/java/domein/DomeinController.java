package domein;

import java.math.BigDecimal;

public class DomeinController {
	private Bank miniBank = new Bank();

	public void voegRekeningToe(long rekeningNummer, String houder) {
		Rekening rekening = new Rekening(rekeningNummer, houder);
		miniBank.voegRekeningToe(rekening);
	}

	public void voegRekeningToe(long rekeningNummer, String houder, BigDecimal saldo) {
		Rekening rekening = new Rekening(rekeningNummer, houder, saldo);
		miniBank.voegRekeningToe(rekening);
	}

	// TODO (ook een RekeningDTO in package DTO maken,
    // deze bevat alle informatie van een Rekening, m.a.w. rekeningnummer, houder en saldo)
	//public RekeningDTO[] geefRekeningen() {
	  
	//}

	public void stort(int indexVanRekening, BigDecimal bedrag) {
		miniBank.stort(indexVanRekening, bedrag); 
	}

	public void haalAf(int indexVanRekening, BigDecimal bedrag) {
		miniBank.haalAf(indexVanRekening, bedrag);
	}

	public void schrijfOver(int indexVanRekening, int indexNaarRekening, BigDecimal bedrag) {
		miniBank.schrijfOver(indexVanRekening, indexNaarRekening, bedrag);
	}

}
