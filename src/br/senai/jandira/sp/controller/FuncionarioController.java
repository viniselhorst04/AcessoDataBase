package br.senai.jandira.sp.controller;

import br.senai.jandira.sp.model.Conexao;
import br.senai.jandira.sp.model.Funcionario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FuncionarioController {

    //Instanciar Conexao
    Conexao conexao = new Conexao();
    Connection connection = conexao.getConnection();
    Statement statement = connection.createStatement();

    public FuncionarioController() throws SQLException {
    }


    public void listarFuncionarios() throws SQLException {

        String queryConsulta = "SELECT * FROM funcionario";

        //Executa a Query criada (nesse caso "queryConsulta")
        ResultSet resultSet = statement.executeQuery(queryConsulta);

        Funcionario funcionario = new Funcionario();

        while (resultSet.next()){

            funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
            funcionario.setMatricula(resultSet.getString("matricula"));
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setSobrenome(resultSet.getString("sobrenome"));
            funcionario.setPermissao(resultSet.getInt("permissao"));
            funcionario.setDepartamento_FK(resultSet.getInt("departamento_FK"));

            System.out.println(funcionario.getIdFuncionario());
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getSobrenome());
            System.out.println(funcionario.getMatricula());
            System.out.println(funcionario.getPermissao());
            System.out.println(funcionario.getDepartamento_FK());
            System.out.println("--------------------------------------");
        }
    }

    public boolean deletarFuncionario() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual nome do Funcionario que quer excluir? ");
        String excluirUsuario = scanner.nextLine();


        String queryDeletar = "DELETE FROM funcionario WHERE nome = '" + excluirUsuario + "'";

        try {
            statement.executeUpdate(queryDeletar);
            return true;
        }catch (Exception erro){
            System.out.println(erro);
            return false;
        }

    }

    public void pesquisarFuncionario() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual nome do Funcionario que quer pesquisar? ");
        String nomeUsuario = scanner.nextLine();

        String queryPesquisar = "SELECT * FROM funcionario WHERE nome ='" + nomeUsuario + "'" ;

        //Executa a Query criada (nesse caso "queryConsulta")
        ResultSet resultSet = statement.executeQuery(queryPesquisar);

        Funcionario funcionario = new Funcionario();

        while (resultSet.next()){

            funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
            funcionario.setMatricula(resultSet.getString("matricula"));
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setSobrenome(resultSet.getString("sobrenome"));
            funcionario.setPermissao(resultSet.getInt("permissao"));
            funcionario.setDepartamento_FK(resultSet.getInt("departamento_FK"));


            System.out.println("\n"+funcionario.getIdFuncionario());
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getSobrenome());
            System.out.println(funcionario.getMatricula());
            System.out.println(funcionario.getPermissao());
            System.out.println(funcionario.getDepartamento_FK());
            System.out.println("--------------------------------------");
        }

    }

    public boolean adicionarFuncionario(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- Adicionar Funcionário -----------");
        System.out.println("ID do Funcionario: ");
        int idFunc = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nome do Funcionario: ");
        String nomeFunc = scanner.nextLine();
        System.out.println("Sobrenome do Funcionario: ");
        String sobrenomeFunc = scanner.nextLine();
        System.out.print("Matricula do Funcionario: ");
        String matriculaFunc = scanner.nextLine();
        System.out.print("Permissao do Funcionario: ");
        int permissaoFunc = scanner.nextInt();
        System.out.print("ID do Departamento do Funcionario: ");
        int IdDepFunc = scanner.nextInt();
        scanner.nextLine();

        String queryAdicionar = "INSERT INTO funcionario (idFuncionario, nome, sobrenome, matricula, permissao, departamento_FK) values (" +
               idFunc + "," + nomeFunc +"," + sobrenomeFunc + "," + matriculaFunc + "," + permissaoFunc + "," + IdDepFunc + ")";


        try {
            statement.executeUpdate(queryAdicionar);
            return true;
        }catch (Exception erro){
            System.out.println(erro);
            return false;
        }
    }

}
