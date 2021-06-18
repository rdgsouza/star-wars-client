package com.testopah.starwars;

import org.springframework.stereotype.Component;

import com.testopah.starwars.client.view.SystemScreen;

@Component
public class Start_StarWarsMain {

	public static void main(String[] args) {

		SystemScreen.menuPrincipal();

	}
}