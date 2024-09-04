package trabalhoGerenciamentoEscola.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Main{
    private static final ArrayList <Escola> escolas = new ArrayList<>();
    private static final String ARQUIVO_ESCOLAS = "escolas.txt";

    public static void main(String[] args){
        carregarEscolas();
        menuPrincipal();
        salvarEscolas();
    }

    public static void menuPrincipal(){
        Scanner input = new Scanner(System.in);
        int opcao = 0;

        while(opcao != 4){
            System.out.println("\n\tBem vindo ao sistema de gerenciamento de escolas\n");
            System.out.println("1 - Criar uma escola.");
            System.out.println("2 - Gerenciar uma escola existente.");
            System.out.println("3 - Remover uma escola.");
            System.out.println("4 - Sair\n");

            System.out.print("Escolha uma opção:  " );
            opcao = input.nextInt();

            switch(opcao){
                case 1:
                    System.out.println("\n\tMenu de criação de escolas.");

                    System.out.print("\nQuantas escolas você quer criar?: ");
                    int qtde = input.nextInt();

                    if(qtde < 0)
                        System.out.println("Opção inválida!");

                    for(int i = 0; i < qtde; i++)
                        escolas.add(criarEscola());
                    ArquivoInfo.salvarInfoEscolas(escolas, ARQUIVO_ESCOLAS);

                    break;
                case 2:
                    System.out.println("\n\tMenu de gerenciamento de escolas criadas.");
                    listarEscolas(escolas);

                    System.out.print("\nEscolha qual escola você quer gerenciar: ");
                    int opcao2 = input.nextInt();

                    if(opcao2 >= 1 && opcao2 <= escolas.size())
                        menuGerenciamentoEscola(escolas.get(opcao2 - 1));
                    else if(opcao2 == 0)
                        menuPrincipal();
                    else
                        System.out.println("Opção Inválida!");
                    break;
                case 3:
                    System.out.println("\n\tMenu de remoção de escolas.");
                    listarEscolas(escolas);

                    System.out.print("\nEscolha a escola para remover: ");
                    int opcao3 = input.nextInt();

                    if(opcao3 >= 1 && opcao3 <= escolas.size()) {
                        escolas.remove(opcao3 - 1);
                        System.out.println("\nEscola removida.");

                        ArquivoInfo.salvarInfoEscolas(escolas, ARQUIVO_ESCOLAS);
                    }
                    else if(opcao3 == 0){
                        menuPrincipal();
                    }
                    else
                        System.out.println("Opção Inválida!");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção Inválida\n");
                    break;
            }

        }
    }

    public static Escola criarEscola(){
        Scanner input = new Scanner(System.in);
        Escola escola = null;
        boolean valido = false;

        while(!valido){
            try{
                MensagensErro.limparErros();

                System.out.print("\nDigite o nome da sua escola: ");
                String nome = input.nextLine();
                System.out.print("Digite o endereço da sua escola: ");
                String endereco = input.nextLine();

                escola = new Escola(nome, endereco);
                valido = true;
            }
            catch (IllegalArgumentException e){
                System.out.println("\n" + e.getMessage());
            }
        }
        return escola;
    }

    public static void listarEscolas(ArrayList<Escola> escolas) {
        int indice = 1;
        System.out.println("\nLista de escolas criadas:");

        if(escolas.isEmpty())
            System.out.println("Nenhuma escola foi criada.");
        else
            for(Escola escola : escolas){
                System.out.println("Escola" + " [" +  indice + "] " + escola);
                indice++;
            }
    }

    public static void menuGerenciamentoEscola(Escola escola){
        Scanner input = new Scanner(System.in);
        int opcao = 0;

        System.out.println("\nGerenciamento da escola: " + escola.getNome());
        System.out.println("Endereço: " + escola.getEndereco());
        System.out.println();

        while(opcao != 8){
            System.out.println( "\n1 - Adicionar professores.");
            System.out.println("2 - Listar professores.");
            System.out.println("3 - Adicionar sala.");
            System.out.println("4 - Adicionar alunos");
            System.out.println("5 - Listar alunos");
            System.out.println("6 - Remover algo da escola.");
            System.out.println("7 - Voltar ao menu anterior.");
            System.out.println("8 - Sair");

            System.out.print("\nEscolha uma opção:  " );
            opcao = input.nextInt();

            switch(opcao){
                case 1:
                    escola.adicionarProfessores();
                    break;
                case 2:
                    escola.listarProfessores();
                    break;
                case 3:
                    escola.adicionarSala();
                    break;
                case 4:
                    escola.adicionarAlunos();
                    break;
                case 5:
                    escola.listarAlunos();
                    break;
                case 6:
                    int opcao2 = 0;

                    while(opcao2 != 5){
                        System.out.println("\n\tMenu de remoção.");
                        System.out.println("\n\tAqui você pode remover um aluno, professor, ou sala específica.");
                        System.out.println("\n1 - Remover professor");
                        System.out.println("2 - Remover sala");
                        System.out.println("3 - Remover aluno");
                        System.out.println("4 - Voltar ao menu anterior");
                        System.out.println("5 - Sair");

                        System.out.print("\n Escolha uma opção: ");
                        opcao2 = input.nextInt();

                        switch(opcao2){
                            case 1:
                                escola.listarProfessores();

                                System.out.print("\nEscolha o professor para remover: ");
                                int opcao3 = input.nextInt();

                                if(opcao3 >= 1 && opcao3 <= escola.getProfessores().size()) {
                                    escola.getProfessores().remove(opcao3 - 1);
                                    System.out.println("\nProfessor removido.");

                                    ArquivoInfo.salvarInfoEscolas(escolas, ARQUIVO_ESCOLAS);
                                }
                                else
                                    System.out.println("Opção Inválida!");
                                break;
                            case 2:
                                escola.listarSalas();

                                System.out.print("\nEscolha a sala para remover: ");
                                int opcao4 = input.nextInt();

                                if(opcao4 >= 1 && opcao4 <= escola.getSalas().size()) {
                                    escola.getSalas().remove(opcao4 - 1);
                                    System.out.println("\nSala removida.");

                                    ArquivoInfo.salvarInfoEscolas(escolas, ARQUIVO_ESCOLAS);
                                }
                                else
                                    System.out.println("Opção Inválida!");
                                break;
                            case 3:
                                escola.listarAlunos();

                                System.out.print("\nEscolha o aluno para remover: ");
                                int opcao5 = input.nextInt();

                                if(opcao5 >= 1 && opcao5 <= escola.getAlunos().size()) {
                                    escola.getAlunos().remove(opcao5 - 1);
                                    System.out.println("\nAluno removido.");

                                    ArquivoInfo.salvarInfoEscolas(escolas, ARQUIVO_ESCOLAS);
                                }
                                else
                                    System.out.println("Opção Inválida!");
                                break;
                            case 4:
                                menuGerenciamentoEscola(escola);
                            case 5:
                                System.out.println("Saindo...");
                                System.exit(0);
                            default:
                                System.out.println("\nOpcão Inválida!\n");
                        }
                    }
                    break;
                case 7:
                    menuPrincipal();
                case 8:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("\nOpção Inválida\n");
            }
        }
    }

    //Get do array Escola
    public static ArrayList<Escola> getEscolas(){
        return escolas;
    }

    // Métodos de arquivo
    private static void salvarEscolas(){
        ArquivoInfo.salvarInfoEscolas(escolas, ARQUIVO_ESCOLAS);
    }

    private static void carregarEscolas() {
        File file = new File(ARQUIVO_ESCOLAS);
        if (file.exists()) {
            escolas.addAll(ArquivoInfo.carregarInfoEscolas(ARQUIVO_ESCOLAS));
        }
    }
}