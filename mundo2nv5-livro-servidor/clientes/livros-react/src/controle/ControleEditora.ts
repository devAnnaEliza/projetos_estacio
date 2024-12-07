import Editora from "../modelo/Editora";

const editoras: Array<Editora> = [
  {
    codEditora: 1,
    nome: "Alta Books",
  },
  {
    codEditora: 2,
    nome: "Pearson",
  },
  {
    codEditora: 3,
    nome: "Addison Wesley",
  },
];

export default class ControleEditora {
  getNomeEditora(codEditora: number): string {
    const resultado = editoras.find(editora => editora.codEditora === codEditora);
    return resultado ? resultado.nome : "Editora não encontrada";
  }

  getEditoras(): Array<Editora> {
    return editoras;
  }
}
