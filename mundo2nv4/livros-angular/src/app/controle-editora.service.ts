import { Injectable } from '@angular/core';
import { Editora } from "src/app/editora"; 

@Injectable({
  providedIn: 'root'
})

/* reutilizado do nv3*/
export class ControleEditoraService {
  editoras: Array<Editora> = [
    { codEditora: 1, nome: "Alta Books" },
    { codEditora: 2, nome: "Pearson" },
    { codEditora: 3, nome: "Addison Wesley" },
  ];


  getEditoras(): Array<Editora> {
    return this.editoras;
  }

  getNomeEditora(codEditora: number): string {
    const editora = this.editoras.filter((e) => e.codEditora === codEditora)[0];
    return editora ? editora.nome : "";
  }
} 
