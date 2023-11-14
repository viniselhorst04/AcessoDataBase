package br.senai.jandira.sp.controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    FuncionarioController funcionarioController = new FuncionarioController();

    public Menu() throws SQLException {
    }

    public void executarMenu() throws SQLException {

        boolean sair = false;

        while (!sair){

            System.out.println("============= MENU ============");
            System.out.println("1- Listar Funcionarios");
            System.out.println("2- Deletar Funcionarios");
            System.out.println("3- Pesquisar Funcionarios");
            System.out.println("4- Cadastrar Funcionarios");
            System.out.println("5- Sair");

            System.out.print("Escolha uma opção:");
            int opcaoUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoUsuario){

                case 1:

                    funcionarioController.listarFuncionarios();

                    break;

                case 2:

                    funcionarioController.deletarFuncionario();

                    break;

                case 3:

                    funcionarioController.pesquisarFuncionario();

                    break;

                case 4:

                    funcionarioController.adicionarFuncionario();

                    break;

                case 5:

                    sair = true;
                    break;
                default:
                    System.out.println("Escolha uma opção válida!");

            }

        }

    }

}
