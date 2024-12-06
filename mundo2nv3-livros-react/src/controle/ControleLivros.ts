import { Livro } from '../modelo/Livro';

let livros: Array<Livro> = [
  new Livro(1, 1, 'A Garota no Trem', 'Rachel, uma mulher desiludida e alcoólatra, observa diariamente um casal pela janela do trem. Quando a mulher desaparece misteriosamente, Rachel se vê envolvida em um intricado enredo de segredos e mentiras. Este thriller psicológico de tirar o fôlego mantém os leitores no limite, questionando a confiabilidade dos narradores e desvendando uma história cheia de reviravoltas.', ['Paula Hawkins']),
  new Livro(2, 2, 'O Morro dos Ventos Uivantes', 'Ambientado nas charnecas sombrias e isoladas de Yorkshire, na Inglaterra, este clássico da literatura inglesa conta a história de paixões arrebatadoras entre Catherine e Heathcliff. Com uma trama intensa e cheia de emoções tumultuadas, o livro explora temas como amor, vingança e obsessão, deixando uma marca indelével nos leitores.', ['Emily Brontë']),
  new Livro(3, 3, 'Grande Sertão: Veredas', 'Uma obra-prima da literatura brasileira, "Grande Sertão: Veredas" narra a história de Riobaldo, um jagunço que se aventura pelo sertão em busca de seu grande amor e enfrenta desafios existenciais e conflitos políticos. Com uma linguagem única e poética, o livro é uma reflexão profunda sobre a vida e a condição humana.', ['João Guimarães Rosa']),
  new Livro(4, 4, '1984', '1984 é uma distopia clássica que descreve um mundo totalitário onde o Estado controla todos os aspectos da vida das pessoas. O protagonista, Winston Smith, trava uma batalha contra o sistema opressor, lutando pela liberdade individual e resistindo à manipulação do governo. Uma obra visionária que continua relevante até os dias de hoje, alertando sobre questões de vigilância, manipulação da informação e perda de privacidade.', ['George Orwell'])
];

export class ControleLivros {
  obterLivros(): Array<Livro> {
    return livros;
  }

  incluir(livro: Livro): void {
    let maxCodigo = Math.max(...livros.map(livro => livro.codigo));
    livro.codigo = maxCodigo + 1;
    livros.push(livro);
  }

  excluir(codigo: number): void {
    let index = livros.findIndex(livro => livro.codigo === codigo);
    if (index !== -1) {
      livros.splice(index, 1);
    }
  }
}