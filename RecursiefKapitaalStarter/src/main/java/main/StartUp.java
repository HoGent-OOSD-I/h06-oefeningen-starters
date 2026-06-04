package main;

import cui.KapitaalApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		new KapitaalApplicatie(new DomeinController()).start();
	}

}
