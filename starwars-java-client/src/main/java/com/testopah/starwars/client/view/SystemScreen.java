package com.testopah.starwars.client.view;

import java.util.Scanner;

import com.testopah.starwars.client.controller.PeopleClientController;
import com.testopah.starwars.client.exception.ClientApiException;

public class SystemScreen {

	public static void menuPrincipal() {

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
					System.out.print("\nAté logo e que a força esteja com você! =)");

					menu.close();
					System.exit(0);
				}

				switch (opcao) {
				case 1:

					break;

				case 2:
					menuPesonagem();
					break;

				default:
					System.out.print("\nOpção Inválida tente novamente \n!");
					menuPrincipal();
					break;
				}
			}
		} catch (Exception e) {
			System.out.print("\nOpção Inválida tente novamente \n!");
			menuPrincipal();
		}
	}

	public static void menuPesonagem() {

		try {

			Scanner menu = new Scanner(System.in);

			while (true) {

				System.out.print("\n\n##-- O que deseja fazer? --##\n");
				System.out.print("|------------------------------------------|\n");
				System.out.print("|  Opção 1 - Listar Pessonagem             |\n");
				System.out.print("|  Opção 2 - Buscar Personagem por ID      |\n");
				System.out.print("|  Opção 3 - Buscar Personagem por nome    |\n");
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
						PeopleClientController.listaPersonagens();
					} catch (Exception e) {
						menuDecisao();
					}
					break;

				case 2:
					menuBucarPersonagemPorId();
					break;

				case 3:
					menuBucarPersonagemPorNome();
					break;

				default:
					System.out.print("\nOpção Inválida tente novamente \n!");
					break;
				}
			}

		} catch (Exception e) {
			System.out.print("\nOpção Inválida tente novamente \n!");
			menuPrincipal();
		}
	}

	private static void menuBucarPersonagemPorNome() {

		@SuppressWarnings("resource")
		Scanner menu = new Scanner(System.in);

		while (true) {

			System.out.print("\n\n##-- Buscar Personagens por nome --##\n");
			System.out.print("|----------------------------------------------------------------|\n");
			System.out.print("|  Para buscar personagem digite o nome.                         |\n");
			System.out.print("|  *Obs: Você pode filtra o personagens por iniciais do nome     |\n");
			System.out.print("|----------------------------------------------------------------|\n");
			System.out.print(" Digite: ");

			var entrada = menu.next();

			try {
				PeopleClientController.buscarPersonagemPoNome(entrada);
				menuDecisao();
				break;

			} catch (ClientApiException e) {
				menuDecisao();

			}
		}
	}

	public static void menuBucarPersonagemPorId() {

		@SuppressWarnings("resource")
		Scanner menu = new Scanner(System.in);

		while (true) {

			System.out.print("\n\n##-- Buscar Personagem por ID --##\n");
			System.out.print("|-----------------------------------------|\n");
			System.out.print("|  Para buscar personagem digite o ID     |\n");
			System.out.print("|-----------------------------------------|\n");
			System.out.print(" Digite: ");

			var entrada = menu.next();

			try {
				PeopleClientController.buscarPersonagemPorId(entrada);
				menuDecisao();
			} catch (ClientApiException e) {
				menuDecisao();
			}
		}

	}

	public static void menuDecisao() {

		try {

			Scanner menu = new Scanner(System.in);

			while (true) {
				System.out.print("\n##-- Deseja Continuar no sistema? --##\n");
				System.out.print("|-------------------|\n");
				System.out.print("|  Opção 1 - Sim    |\n");
				System.out.print("|  Opção 2 - Sair   |\n");
				System.out.print("|-------------------|\n");
				System.out.print("Digite uma opção: ");

				int opcao = menu.nextInt();

				if (opcao == 2) {
					System.out.print("\nAté logo e que a força esteja com você! =)");

					menu.close();
					System.exit(0);
				}

				switch (opcao) {
				case 1:
					menuPrincipal();
					break;

				default:
					System.out.print("\nOpção Inválida tente novamente \n!");
					break;
				}
			}

		} catch (Exception e) {
			System.out.print("\nOpção Inválida tente novamente \n!");
			menuPrincipal();
		}
	}

}
