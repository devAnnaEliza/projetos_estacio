import { Injectable } from '@angular/core';
import { Livro } from 'src/app/livro'; 

@Injectable({
  providedIn: 'root'
})

/* reutilizado do nv3*/
export class ControleLivrosService {
  livros: Array<Livro> = [
    {
      codigo: 1,
    codEditora: 1,
    titulo: "Use a Cabeça: Java",
    resumo:
      "Use a Cabeça! Java é uma experiência completa de aprendizado em programação orientada a objetos (OO) e Java.",
    autores: ['Bert Bates', 'Kathy Sierra'],
  },
  {
    codigo: 2,
    codEditora: 2,
    titulo: "Java, como Programar",
    resumo:
      "Milhões de alunos e profissionais aprenderam programação e desenvolvimento de software com os livros Deitel.",
    autores: ['Paul Deitel', 'Harvey Deitel'],
  },
  {
    codigo: 3,
    codEditora: 3,
    titulo: "Core Java for the Impatient",
    resumo:
      "Readers familiar witnh Horstmann's original, two-volume 'Core Java' books who are looking for a comprehensive, but condensed guide to all of the new features and functions of Java SE 9 will learn hot these new features impact the language and core libraries.",
    autores: ["Cay Horstmann"],
    }
  ];

  obterLivros(): Array<Livro> {
    return this.livros;
  }

  incluir(livro: Livro): void {
    const maxCodigo = Math.max(...this.livros.map((l) => l.codigo || 0), 0);
    livro.codigo = maxCodigo + 1;
    this.livros.push(livro);
  }

  excluir(codigo: number): void {
    const index = this.livros.findIndex((l) => l.codigo === codigo);
    if (index !== -1) {
      this.livros.splice(index, 1);
    }
  }
}