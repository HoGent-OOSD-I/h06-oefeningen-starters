package main;

import cui.DriehoekApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		new DriehoekApplicatie(new DomeinController()).start();
	}

}
