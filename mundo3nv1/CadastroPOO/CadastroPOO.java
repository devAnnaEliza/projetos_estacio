import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class CadastroPOO {
    public static void main(String[] args) {
        //start dos reps PessoaFisica PessoaJuridica
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();

        //prefixo para os arquivos de persistência
        String prefixoArquivos = "cadastro";

        //scan entrada do user
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            do {
                //menu
                System.out.println("======================");
                System.out.println("Escolha uma Opcao:");
                System.out.println("1 - Incluir");
                System.out.println("2 - Alterar");
                System.out.println("3 - Excluir");
                System.out.println("4 - Exibir pelo ID");
                System.out.println("5 - Exibir todos");
                System.out.println("6 - Salvar dados");
                System.out.println("7 - Recuperar dados");
                System.out.println("0 - Sair");
                System.out.println("======================");
                opcao = scanner.nextInt();
                scanner.nextLine();

                //switch p manipular as ops do user
                switch (opcao) {
                    case 1 -> {
                        System.out.println("Escolha o tipo (F - Pessoa Fisica, J - Pessoa Juridica):");
                        String tipo = scanner.nextLine();
                        switch (tipo) {
                            case "F" -> {
                                PessoaFisica pessoaFisica = lerDadosPessoaFisica(scanner);
                                pessoaFisicaRepo.inserir(pessoaFisica);
                            }
                            case "J" -> {
                                PessoaJuridica pessoaJuridica = lerDadosPessoaJuridica(scanner);
                                pessoaJuridicaRepo.inserir(pessoaJuridica);
                            }
                            default -> System.out.println("Opção inválida.");
                        }
                    }

                    case 2 -> {
                        System.out.println("Escolha o tipo (F - Pessoa Fisica, J - Pessoa Juridica):");
                        String tipoAlterar = scanner.nextLine();
                        switch (tipoAlterar) {
                            case "F" -> {
                                System.out.println("Informe o ID da Pessoa Fisica que deseja alterar:");
                                int idAlterar = scanner.nextInt();
                                scanner.nextLine();
                                PessoaFisica pessoaFisicaAlterar = lerDadosPessoaFisica(scanner);
                                pessoaFisicaAlterar.setId(idAlterar);
                                pessoaFisicaRepo.alterar(pessoaFisicaAlterar);
                            }
                            case "J" -> {
                                System.out.println("Informe o ID da Pessoa Juridica que deseja alterar:");
                                int idAlterar = scanner.nextInt();
                                scanner.nextLine();
                                PessoaJuridica pessoaJuridicaAlterar = lerDadosPessoaJuridica(scanner);
                                pessoaJuridicaAlterar.setId(idAlterar);
                                pessoaJuridicaRepo.alterar(pessoaJuridicaAlterar);
                            }
                            default -> System.out.println("Opção inválida.");
                        }
                    }

                    case 3 -> {
                        System.out.println("Escolha o tipo (F - Pessoa Fisica, J - Pessoa Juridica):");
                        String tipoExcluir = scanner.nextLine();
                        switch (tipoExcluir) {
                            case "F" -> {
                                System.out.println("Informe o ID da Pessoa Fisica que deseja excluir:");
                                int idExcluir = scanner.nextInt();
                                scanner.nextLine();
                                pessoaFisicaRepo.excluir(idExcluir);
                            }
                            case "J" -> {
                                System.out.println("Informe o ID da Pessoa Juridica que deseja excluir:");
                                int idExcluir = scanner.nextInt();
                                scanner.nextLine();
                                pessoaJuridicaRepo.excluir(idExcluir);
                            }
                            default -> System.out.println("Opção inválida.");
                        }
                    }

                    case 4 -> {
                        System.out.println("Escolha o tipo (F - Pessoa Fisica, J - Pessoa Juridica):");
                        String tipoExibir = scanner.nextLine();
                        switch (tipoExibir) {
                            case "F" -> {
                                System.out.println("Informe o ID da Pessoa Fisica que deseja exibir:");
                                int idExibir = scanner.nextInt();
                                scanner.nextLine();
                                PessoaFisica pessoaFisicaExibir = pessoaFisicaRepo.obterPorId(idExibir);
                                if (pessoaFisicaExibir != null) {
                                    pessoaFisicaExibir.exibir();
                                } else {
                                    System.out.println("Pessoa Fisica não encontrada.");
                                }
                            }
                            case "J" -> {
                                System.out.println("Informe o ID da Pessoa Juridica que deseja exibir:");
                                int idExibir = scanner.nextInt();
                                scanner.nextLine();
                                PessoaJuridica pessoaJuridicaExibir = pessoaJuridicaRepo.obterPorId(idExibir);
                                if (pessoaJuridicaExibir != null) {
                                    pessoaJuridicaExibir.exibir();
                                } else {
                                    System.out.println("Pessoa Juridica não encontrada.");
                                }
                            }
                            default -> System.out.println("Opção inválida.");
                        }
                    }

                    case 5 -> {
                        System.out.println("Escolha o tipo (F - Pessoa Fisica, J - Pessoa Juridica):");
                        String tipoExibirTodos = scanner.nextLine();
                        switch (tipoExibirTodos) {
                            case "F" -> {
                                List<PessoaFisica> todasPessoasFisicas = pessoaFisicaRepo.obterTodos();
                                for (PessoaFisica pf : todasPessoasFisicas) {
                                    pf.exibir();
                                    System.out.println();
                                }
                            }
                            case "J" -> {
                                List<PessoaJuridica> todasPessoasJuridicas = pessoaJuridicaRepo.obterTodos();
                                for (PessoaJuridica pj : todasPessoasJuridicas) {
                                    pj.exibir();
                                    System.out.println();
                                }
                            }
                            default -> System.out.println("Opção inválida.");
                        }
                    }

                    case 6 -> {
                        System.out.println("Digite o prefixo para os arquivos (por exemplo, 'cadastro'):");
                        String prefixoSalvar = scanner.nextLine();

                        try {
                            pessoaFisicaRepo.persistir(prefixoSalvar + ".fisica.bin");
                            pessoaJuridicaRepo.persistir(prefixoSalvar + ".juridica.bin");
                            System.out.println("Dados salvos com sucesso.");
                        } catch (IOException e) {
                            System.out.println("Erro ao salvar os dados: " + e.getMessage());
                        }
                    }

                    case 7 -> {
                        System.out.println("Digite o prefixo para os arquivos (por exemplo, 'cadastro'):");
                        String prefixoRecuperar = scanner.nextLine();

                        try {
                            pessoaFisicaRepo.recuperar(prefixoRecuperar + ".fisica.bin");
                            pessoaJuridicaRepo.recuperar(prefixoRecuperar + ".juridica.bin");
                            System.out.println("Dados recuperados com sucesso.");
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                        }
                    }

                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }
            } while (opcao != 0);
        }
    }

    private static PessoaFisica lerDadosPessoaFisica(Scanner scanner) {
        System.out.println("Digite o nome da Pessoa Fisica:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF da Pessoa Fisica:");
        String cpf = scanner.nextLine();

        System.out.println("Digite a idade da Pessoa Fisica:");
        int idade = scanner.nextInt();

        scanner.nextLine();

        return new PessoaFisica(0, nome, cpf, idade);
    }

    private static PessoaJuridica lerDadosPessoaJuridica(Scanner scanner) {
        System.out.println("Digite o nome da Pessoa Juridica:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CNPJ da Pessoa Juridica:");
        String cnpj = scanner.nextLine();

        //corrigir a ordem dos parâmetros no const
        return new PessoaJuridica(0, nome, cnpj);
    }
}
