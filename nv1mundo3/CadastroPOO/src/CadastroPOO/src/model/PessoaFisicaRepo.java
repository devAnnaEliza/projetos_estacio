package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//classe PessoaFisicaRepo é um rep p guardar e manipular objetos de pf
public class PessoaFisicaRepo {
    //lista p armazenar as pessoas físicas no rep
    private List<PessoaFisica> pessoasFisicas = new ArrayList<>();

    //metodo p add a pf no rep
    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
    }

    //método p alterar os dados da pf no rep
    public void alterar(PessoaFisica pessoaFisica) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            PessoaFisica p = pessoasFisicas.get(i);
            if (p.getId() == pessoaFisica.getId()) {
                pessoasFisicas.set(i, pessoaFisica);
                return;
            }
        }
    }

    //nétodo p excluir a pf do rep pelo id
    public void excluir(int id) {
        pessoasFisicas.removeIf(p -> p.getId() == id);
    }

    //método p obter pf do rep pelo id
    public PessoaFisica obterPorId(int id) {
        for (PessoaFisica pessoaFisica : pessoasFisicas) {
            if (pessoaFisica.getId() == id) {
                return pessoaFisica;
            }
        }
        return null;
    }

    //método p obter uma cópia da lista de pf's no rep
    public List<PessoaFisica> obterTodos() {
        return new ArrayList<>(pessoasFisicas);
    }

    //metodo p salvar os dados do rep num arquivo
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(pessoasFisicas);
        }
    }

    //método p recuperar dados do rep de um arquivo
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasFisicas = (List<PessoaFisica>) ois.readObject();
        }
    }
} 
