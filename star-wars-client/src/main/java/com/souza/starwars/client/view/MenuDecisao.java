package com.souza.starwars.client.view;

import java.util.Scanner;

public class MenuDecisao {

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
					MenuInicial.menuInicial();
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

}
