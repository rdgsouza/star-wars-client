package com.souza.starwars;

import org.springframework.stereotype.Component;

import com.testopah.starwars.client.view.MenuInicial;

@Component
public class Start_StarWarsMain {

	public static void main(String[] args) {

		MenuInicial.menuInicial();

	}
}