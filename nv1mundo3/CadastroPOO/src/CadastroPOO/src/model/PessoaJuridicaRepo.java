package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//classe PessoaJuridicaRepo é um rep p guardar e manipular objetos de pj
public class PessoaJuridicaRepo {
    //lista p armazena as pj's no rep
    private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

    //método p inserir a pj no rep
    public void inserir(PessoaJuridica pessoaJuridica) {
        pessoasJuridicas.add(pessoaJuridica);
    }

    //metodo p alterar dados da pj no rep
    public void alterar(PessoaJuridica pessoaJuridica) {
        for (int i = 0; i < pessoasJuridicas.size(); i++) {
            PessoaJuridica p = pessoasJuridicas.get(i);
            if (p.getId() == pessoaJuridica.getId()) {
                pessoasJuridicas.set(i, pessoaJuridica);
                return;
            }
        }
    }

    // metodo p excluir a pj do rep usando id
    public void excluir(int id) {
        pessoasJuridicas.removeIf(p -> p.getId() == id);
    }

    //método p obter uma pj do rep usando id
    public PessoaJuridica obterPorId(int id) {
        for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
            if (pessoaJuridica.getId() == id) {
                return pessoaJuridica;
            }
        }
        return null;
    }

    //metodo p obter cópia da lista de pj's no rep
    public List<PessoaJuridica> obterTodos() {
        return new ArrayList<>(pessoasJuridicas);
    }

    //método p salvar dados do rep num arquivo
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(pessoasJuridicas);
        }
    }

    //metodo p recuperar dados do rep de um arquivo
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasJuridicas = (List<PessoaJuridica>) ois.readObject();
        }
    }
}
