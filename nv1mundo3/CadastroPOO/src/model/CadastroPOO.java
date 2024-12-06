package model;

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
                System.out.println("Escolha uma Opção:");
                System.out.println("1 - Incluir Pessoa");
                System.out.println("2 - Alterar Pessoa");
                System.out.println("3 - Excluir Pessoa");
                System.out.println("4 - Buscar pelo Id");
                System.out.println("5 - Exibir todos");
                System.out.println("6 - Salvar dados");
                System.out.println("7 - Recuperar dados");
                System.out.println("0 - Finalizar Programa");
                System.out.println("======================");
                opcao = scanner.nextInt();
                String nextLine = scanner.nextLine();

                //switch p manipular as ops do user
                switch (opcao) {
                    case 1 -> {
                        System.out.println("Escolha (PF para Pessoa Fisica e PJ para Pessoa Juridica)");
                        String tipo = scanner.nextLine();
                        switch (tipo) {
                            case "PF" -> {
                                PessoaFisica pessoaFisica = lerDadosPessoaFisica(scanner);
                                pessoaFisicaRepo.inserir(pessoaFisica);
                            }
                            case "PJ" -> {
                                PessoaJuridica pessoaJuridica = lerDadosPessoaJuridica(scanner);
                                pessoaJuridicaRepo.inserir(pessoaJuridica);
                            }
                            default -> System.out.println("Opção inválida");
                        }
                    }

                    case 2 -> {
                        System.out.println("Escolha (PF para Pessoa Fisica e PJ para Pessoa Juridica)");
                        String tipoAlterar = scanner.nextLine();
                        switch (tipoAlterar) {
                            case "PF" -> {
                                System.out.println("Insira o ID da Pessoa Fisica que deseja alterar");
                                int idAlterar = scanner.nextInt();
                                scanner.nextLine();
                                PessoaFisica pessoaFisicaAlterar = lerDadosPessoaFisica(scanner);
                                pessoaFisicaAlterar.setId(idAlterar);
                                pessoaFisicaRepo.alterar(pessoaFisicaAlterar);
                            }
                            case "PJ" -> {
                                System.out.println("Insira o ID da Pessoa Juridica que deseja alterar");
                                int idAlterar = scanner.nextInt();
                                scanner.nextLine();
                                PessoaJuridica pessoaJuridicaAlterar = lerDadosPessoaJuridica(scanner);
                                pessoaJuridicaAlterar.setId(idAlterar);
                                pessoaJuridicaRepo.alterar(pessoaJuridicaAlterar);
                            }
                            default -> System.out.println("Opção inválida");
                        }
                    }

                    case 3 -> {
                        System.out.println("Escolha (PF para Pessoa Fisica e PJ para Pessoa Juridica)");
                        String tipoExcluir = scanner.nextLine();
                        switch (tipoExcluir) {
                            case "PF" -> {
                                System.out.println("Insira o ID da Pessoa Fisica que deseja excluir");
                                int idExcluir = scanner.nextInt();
                                scanner.nextLine();
                                pessoaFisicaRepo.excluir(idExcluir);
                            }
                            case "PJ" -> {
                                System.out.println("Insira o ID da Pessoa Juridica que deseja excluir");
                                int idExcluir = scanner.nextInt();
                                scanner.nextLine();
                                pessoaJuridicaRepo.excluir(idExcluir);
                            }
                            default -> System.out.println("Opção inválida.");
                        }
                    }

                    case 4 -> {
                        System.out.println("Escolha (PF para Pessoa Fisica e PJ para Pessoa Juridica)");
                        String tipoExibir = scanner.nextLine();
                        switch (tipoExibir) {
                            case "PF" -> {
                                System.out.println("Insira o ID da Pessoa Fisica que deseja");
                                int idExibir = scanner.nextInt();
                                scanner.nextLine();
                                PessoaFisica pessoaFisicaExibir = pessoaFisicaRepo.obterPorId(idExibir);
                                if (pessoaFisicaExibir != null) {
                                    pessoaFisicaExibir.exibir();
                                } else {
                                    System.out.println("Pessoa Fisica não encontrada");
                                }
                            }
                            case "PJ" -> {
                                System.out.println("Insira o id da Pessoa Juridica que deseja");
                                int idExibir = scanner.nextInt();
                                scanner.nextLine();
                                PessoaJuridica pessoaJuridicaExibir = pessoaJuridicaRepo.obterPorId(idExibir);
                                if (pessoaJuridicaExibir != null) {
                                    pessoaJuridicaExibir.exibir();
                                } else {
                                    System.out.println("Pessoa Juridica não encontrada");
                                }
                            }
                            default -> System.out.println("Opção inválida");
                        }
                    }

                    case 5 -> {
                        System.out.println("Escolha (PF para Pessoa Fisica e PJ para Pessoa Juridica)");
                        String tipoExibirTodos = scanner.nextLine();
                        switch (tipoExibirTodos) {
                            case "PF" -> {
                                List<PessoaFisica> todasPessoasFisicas = pessoaFisicaRepo.obterTodos();
                                for (PessoaFisica pf : todasPessoasFisicas) {
                                    pf.exibir();
                                    System.out.println();
                                }
                            }
                            case "PJ" -> {
                                List<PessoaJuridica> todasPessoasJuridicas = pessoaJuridicaRepo.obterTodos();
                                for (PessoaJuridica pj : todasPessoasJuridicas) {
                                    pj.exibir();
                                    System.out.println();
                                }
                            }
                            default -> System.out.println("Opção inválida");
                        }
                    }

                    case 6 -> {
                        System.out.println("Digite o prefixo para os arquivos ('cadastro')");
                        String prefixoSalvar = scanner.nextLine();

                        try {
                            pessoaFisicaRepo.persistir(prefixoSalvar + ".fisica.bin");
                            pessoaJuridicaRepo.persistir(prefixoSalvar + ".juridica.bin");
                            System.out.println("Dados salvos");
                        } catch (IOException e) {
                            System.out.println("Erro" + e.getMessage());
                        }
                    }

                    case 7 -> {
                        System.out.println("Digite o prefixo para os arquivos ('cadastro')");
                        String prefixoRecuperar = scanner.nextLine();

                        try {
                            pessoaFisicaRepo.recuperar(prefixoRecuperar + ".fisica.bin");
                            pessoaJuridicaRepo.recuperar(prefixoRecuperar + ".juridica.bin");
                            System.out.println("Dados recuperados com sucesso");
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println("Erro ao recuperar os dados" + e.getMessage());
                        }
                    }

                    case 0 -> System.out.println("Finalizando programa");
                    default -> System.out.println("Opção inválida. Tente novamente");
                }
            } while (opcao != 0);
        }
    }

    private static PessoaFisica lerDadosPessoaFisica(Scanner scanner) {
        System.out.println("Digite o nome da Pessoa Fisica");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF da Pessoa Fisica");
        String cpf = scanner.nextLine();

        System.out.println("Digite a idade da Pessoa Fisica");
        int idade = scanner.nextInt();

        scanner.nextLine();

        return new PessoaFisica(0, nome, cpf, idade);
    }

    private static PessoaJuridica lerDadosPessoaJuridica(Scanner scanner) {
        System.out.println("Digite o nome da Pessoa Juridica");
        String nome = scanner.nextLine();

        System.out.println("Digite o CNPJ da Pessoa Juridica");
        String cnpj = scanner.nextLine();

        //corrigir a ordem dos parâmetros no const
        return new PessoaJuridica(0, nome, cnpj);
    }
}