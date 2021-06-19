package com.souza.starwars.client.view;

import java.util.Scanner;

public class MenuInicial {

	public static void menuInicial() {

		try {

			Scanner menu = new Scanner(System.in);

			while (true) {
				System.out.print("\n##-- Bem-vindo ao SWAPI --##\n");
				System.out.print("##-- O que deseja consultar? --##\n");
				System.out.print("|------------------------------|\n");
				System.out.print("|  Opção 1 - Filmes            |\n");
				System.out.print("|  Opção 2 - Personagens       |\n");
				System.out.print("|  Opção 3 - Sair              |\n");
				System.out.print("|------------------------------|\n");
				System.out.print("Digite uma opção: ");

				int opcao = menu.nextInt();

				if (opcao == 3) {
					System.out.print("\nAté logo e que a força esteja com você! =)\n");

					menu.close();
					System.exit(0);
				}

				switch (opcao) {
				case 1:
					MenuFilms.menuFilmes();
					break;

				case 2:
					MenuPeople.menuPesonagem();
					break;

				default:
					System.out.print("\nOpção Inválida tente novamente \n!");
					menuInicial();
					break;
				}
			}
		} catch (Exception e) {
			System.out.print("\nOpção Inválida tente novamente \n!");
			menuInicial();
		}
	}
		 	
 } 
