package com.souza.starwars.client;

import org.springframework.stereotype.Component;

import com.souza.starwars.client.view.MenuInicial;

@Component
public class Start_StarWarsMain {

	public static void main(String[] args) {

		MenuInicial.menuInicial();

	}
}