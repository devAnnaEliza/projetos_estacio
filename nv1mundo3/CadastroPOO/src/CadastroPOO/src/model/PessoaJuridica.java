package model;

import java.io.Serializable;

//classe pessoajuridica recebe características da classe pessoa
public class PessoaJuridica extends Pessoa implements Serializable {
    //atributo q controla o id q será atribuído a  pj
    private static int proximoId = 1;

    //atributo q armazena o CNPJ da pj
    private String cnpj;

    //const padrão da classe pj
    public PessoaJuridica() {
        //const vazio
    }

    //const q permite a criação de pj com id, nome e cnpj
    public PessoaJuridica(int id, String nome, String cnpj) {
        //chama o const da classe pessoa p iniciar id e nome
        super(id, nome);
        this.cnpj = cnpj;
    }

    //metodo da classe pessoa p exibir detalhes de pj
    @Override
    public void exibir() {
        //chama o método exibir da classe pai p mostrar id e nome
        super.exibir();
        System.out.println("CNPJ: " + cnpj);
    }

    //getters e setters p acessar e mudar o atributo de pj

    //getter p obter CNPJ da pj
    public String getCnpj() {
        return cnpj;
    }

    //setter p definir o CNPJ da pj
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    //metodo p definir id da pj
    @Override
    public void setId(int idAlterar) {
        throw new UnsupportedOperationException("Not supported yet."); // Mensagem de exceção gerada automaticamente.
    }
}
