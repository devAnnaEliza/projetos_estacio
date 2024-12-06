package model;

import java.io.Serializable;

public class Pessoa implements Serializable {
    //atributo q armazena o id
    private int id;

    //atributo q armazena o nome
    private String nome;

    //const padrão da classe pessoa
    public Pessoa() {}

    //const q permite criação da pessoa com id e nome especificados
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //método p exibir os detalhes da pessoa com id e nome
    public void exibir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
    }

    //getters e setters p acessar e mudar os atributos da pessoa

    //getter p obter o id
    public int getId() {
        return id;
    }

    //setter p definir o id
    public void setId(int id) {
        this.id = id;
    }

    //getter p obter o nome
    public String getNome() {
        return nome;
    }

    //setter p definir o nome
    public void setNome(String nome) {
        this.nome = nome;
    }
}
