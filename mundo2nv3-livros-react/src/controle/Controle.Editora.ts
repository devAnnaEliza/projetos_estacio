import { Editora } from "../modelo/Editora"; 

let editoras: Array<Editora> = [
    new Editora(1, 'Intrínseca'), 
    new Editora(2, 'Record'), 
    new Editora(3, 'Rocco'), 
    new Editora(4, 'Companhia das Letras')
]; 

export  class ControleEditora {
    getEditoras(): Array<Editora> {
        return editoras;
    } 

    getNomeEditora(codEditora: number): string | null {
        let editora = editoras.find(editora => editora.codEditora === codEditora);

        if (editora) {
            return editora.nome; 
        } else {
            return null;
        }
    }
}