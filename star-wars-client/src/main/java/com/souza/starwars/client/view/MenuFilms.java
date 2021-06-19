package com.souza.starwars.client.view;

import java.util.Scanner;

import com.souza.starwars.client.controller.FilmsClientController;
import com.souza.starwars.client.exception.ClientApiException;

public class MenuFilms {

	
	public static void menuFilmes() {

		try {
			FilmsClientController filmsClientController = new FilmsClientController();
			
			Scanner menu = new Scanner(System.in);

			while (true) {

				System.out.print("\n\n##-- O que deseja fazer? --##\n");
				System.out.print("|------------------------------------------|\n");
				System.out.print("|  Opção 1 - Listar Filmes                 |\n");
				System.out.print("|  Opção 2 - Buscar filme por ID           |\n");
				System.out.print("|  Opção 3 - Buscar Filmes por nome        |\n");
				System.out.print("|  Opção 4 - Sair                          |\n");
				System.out.print("|------------------------------------------|\n");
				System.out.print("Digite uma opção: ");

				int opcao = menu.nextInt();

				if (opcao == 4) {
					System.out.print("\nAté logo e que a força esteja com você! =)\n");

					menu.close();
					System.exit(0);
				}

				switch (opcao) {
				case 1:
					try {
						filmsClientController.listaFilmes();
					} catch (Exception e) {
						MenuDecisao.menuDecisao();
					}
					break;

				case 2:
					menuBucarFilmesPorId();
					break;

				case 3:
					menuBucarFilmesPorNome();
					break;

				default:
					System.out.print("\nOpção Inválida tente novamente \n!");
					break;
				}
			}

		} catch (Exception e) {
			System.out.print("\nOpção Inválida tente novamente \n!");
			MenuDecisao.menuDecisao();
		}
	}

	
	public static void menuBucarFilmesPorId() {

		@SuppressWarnings("resource")
		Scanner menu = new Scanner(System.in);

		while (true) {

			System.out.print("\n\n##-- Buscar filmes por ID --##\n");
			System.out.print("|-----------------------------------------|\n");
			System.out.print("|  Para buscar filmes digite o ID         |\n");
			System.out.print("|-----------------------------------------|\n");
			System.out.print(" Digite: ");

			var entrada = menu.next();

			try {
				FilmsClientController.buscarFilmPorId(entrada);
				MenuDecisao.menuDecisao();
			} catch (ClientApiException e) {
				MenuDecisao.menuDecisao();
			}
		}
	}
	
	private static void menuBucarFilmesPorNome() {

		@SuppressWarnings("resource")
		Scanner menu = new Scanner(System.in);

		while (true) {

			System.out.print("\n\n##-- Buscar filmes por nome --##\n");
			System.out.print("|----------------------------------------------------------------|\n");
			System.out.print("|  Para buscar filmes digite o nome.                             |\n");
			System.out.print("|  *Obs: Você pode filtra os filmes por iniciais do nome         |\n");
			System.out.print("|----------------------------------------------------------------|\n");
			System.out.print(" Digite: ");

			var entrada = menu.next();

			try {
				FilmsClientController.buscarfilmesPorNome(entrada);
				MenuDecisao.menuDecisao();
				break;

			} catch (ClientApiException e) {
				MenuDecisao.menuDecisao();

			}
		}
	}

 }
