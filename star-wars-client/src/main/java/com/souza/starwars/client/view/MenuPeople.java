package com.souza.starwars.client.view;

import java.util.Scanner;

import com.souza.starwars.client.controller.PeopleClientController;
import com.souza.starwars.client.exception.ClientApiException;

public class MenuPeople {

	public static void menuPesonagem() {

		try {

			Scanner menu = new Scanner(System.in);

			while (true) {

				System.out.print("\n\n##-- O que deseja fazer? --##\n");
				System.out.print("|------------------------------------------|\n");
				System.out.print("|  Opção 1 - Listar Pessonagem             |\n");
				System.out.print("|  Opção 2 - Buscar Personagem por ID      |\n");
				System.out.print("|  Opção 3 - Buscar Personagens por nome   |\n");
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
						PeopleClientController.listaPersonagens();
						MenuDecisao.menuDecisao();
					break;

				case 2:
					menuBucarPersonagemPorId();
					break;

				case 3:
					menuBucarPersonagensPorNome();
					break;

				default:
					System.out.print("\nOpção Inválida tente novamente \n!");
					break;
				}
			}

		} catch (Exception e) {
			System.out.print("\nOpção Inválida tente novamente \n!");
			MenuInicial.menuInicial();
		}
	}

	private static void menuBucarPersonagensPorNome() {

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
				MenuDecisao.menuDecisao();
				break;

			} catch (ClientApiException e) {
				MenuDecisao.menuDecisao();

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
				MenuDecisao.menuDecisao();
			} catch (ClientApiException e) {
				MenuDecisao.menuDecisao();
			}
		}
	}
	
}
