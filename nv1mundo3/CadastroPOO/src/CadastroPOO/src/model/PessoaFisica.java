package model;

import java.io.Serializable;

//classe pessoafisica recebe características da classe pessoa
public class PessoaFisica extends Pessoa implements Serializable {
    //atributo q armazena o CPF da pf
    private String cpf;

    //atributo q armazena a idade da pf
    private int idade;

    //const q permite criação de pessoa física com id, nome, cpf e idade especificados
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        //chama o const da classe pai (pessoa) para inicializar id e nome 
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    //getters e setters p acessar e mudar os atributos de pessoa física

    //getter p obter CPF da pf
    public String getCpf() {
        return cpf;
    }

    //setter p definir CPF da pf
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //getter p obter a idade da pf
    public int getIdade() {
        return idade;
    }

    //setter p definir idade da pf
    public void setIdade(int idade) {
        this.idade = idade;
    }

    //metodo da classe pai p mostrar detalhes da pf
    @Override
    public void exibir() {
        //chama o método exibir da classe pai p mostrar id e nome
        super.exibir();
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
    }
}
