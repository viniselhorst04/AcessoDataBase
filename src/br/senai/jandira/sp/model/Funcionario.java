package br.senai.jandira.sp.model;

public class Funcionario {

    private int idFuncionario,permissao,departamento_FK;
    private String nome, sobrenome, matricula;







    //GETTER AND SETTER
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getDepartamento_FK() {
        return departamento_FK;
    }

    public void setDepartamento_FK(int departamento_FK) {
        this.departamento_FK = departamento_FK;
    }
}
