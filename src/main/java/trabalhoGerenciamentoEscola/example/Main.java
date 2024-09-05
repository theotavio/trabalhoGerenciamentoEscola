package trabalhoGerenciamentoEscola.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Main{
    // Array de escolas e variável "ARQUIVO_ESCOLAS"
    private static final ArrayList<Escola> escolas = new ArrayList<>();
    private static final String ARQUIVO_ESCOLAS = "escolas.txt";

    // Metodo Main
    public static void main(String[] args){
        carregarEscolas();
        menuPrincipal();
        salvarEscolas();
    }

    // Metodo para o menu principal do sistema
    public static void menuPrincipal(){
        Scanner input = new Scanner(System.in);
        int opcao;

        do{
            mostrarMenuPrincipal();
            opcao = input.nextInt();

            switch(opcao){
                case 1:
                    criarEscolas();
                    break;
                case 2:
                    gerenciarEscola();
                    break;
                case 3:
                    removerEscola();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }
        while(opcao != 4);
    }

    // Metodo para mostrar o menu principall
    private static void mostrarMenuPrincipal(){
        System.out.println("\n\tBem-vindo ao sistema de gerenciamento de escolas\n");
        System.out.println("1 - Criar uma escola.");
        System.out.println("2 - Gerenciar uma escola existente.");
        System.out.println("3 - Remover uma escola.");
        System.out.println("4 - Sair\n");
        System.out.print("Escolha uma opção: ");
    }

    // Metodo para mostrar o menu de criação de escolas
    private static void criarEscolas(){
        Scanner input = new Scanner(System.in);

        System.out.println("\n\tMenu de criação de escolas.");

        System.out.print("\nQuantas escolas você quer criar?: ");
        int qtde = input.nextInt();

        if(qtde <= 0){
            System.out.println("Opção inválida!");
            return;
        }

        for(int i = 0; i < qtde; i++)
            escolas.add(criarEscola());
        salvarEscolas();
    }

    // Metodo para criar uma ou mais escolas
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
            catch(IllegalArgumentException e){
                System.out.println("\n" + e.getMessage());
            }
        }
        return escola;
    }

    // Metodo para mostrar o menu de gerenciamento de escolas
    private static void gerenciarEscola(){
        Scanner input = new Scanner(System.in);

        listarEscolas();

        System.out.print("\nEscolha qual escola você quer gerenciar(Insira o número): ");
        int opcao = input.nextInt();

        if(opcao >= 1 && opcao <= escolas.size())
            menuGerenciamentoEscola(escolas.get(opcao - 1));
        else
            System.out.println("Opção Inválida!");
    }

    // Metodo para remover uma escola
    private static void removerEscola(){
        Scanner input = new Scanner(System.in);

        listarEscolas();

        System.out.print("\nEscolha a escola para remover(Insira o número): ");
        int opcao = input.nextInt();

        if(opcao >= 1 && opcao <= escolas.size()){
            escolas.remove(opcao - 1);

            System.out.println("\nEscola removida.");
            salvarEscolas();
        }
        else
            System.out.println("Opção Inválida!");
    }

    // Metodo para listar as escolas existentes
    public static void listarEscolas(){
        System.out.println("\nLista de escolas criadas:");
        if(escolas.isEmpty())
            System.out.println("Nenhuma escola foi criada.");
        else
            for (int i = 0; i < escolas.size(); i++)
                System.out.println("\nEscola [" + (i + 1) + "]\n" + escolas.get(i));
    }

    // Metodo para gerenciar uma escola específica
    public static void menuGerenciamentoEscola(Escola escola){
        Scanner input = new Scanner(System.in);
        int opcao;

        do{
            mostrarMenuGerenciamentoEscola(escola);
            opcao = input.nextInt();
            opcoesGerenciamento(escola, opcao);
        }
        while(opcao != 7 && opcao != 8);
    }

    // Metodo para mostrar o menu de gerenciamento de uma escola especifica
    private static void mostrarMenuGerenciamentoEscola(Escola escola){
        System.out.println("\nGerenciamento da escola: " + escola.getNome());
        System.out.println("Endereço: " + escola.getEndereco());

        System.out.println("\n1 - Adicionar professores.");
        System.out.println("2 - Listar professores.");
        System.out.println("3 - Adicionar sala.");
        System.out.println("4 - Adicionar alunos");
        System.out.println("5 - Listar alunos.");
        System.out.println("6 -Adicionar turmas.");
        System.out.println("7 - Menu alocação.");
        System.out.println("8 - Remover algo da escola.");
        System.out.println("9 - Voltar ao menu anterior.");
        System.out.println("10 - Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    // Metodo para gerenciar as escolhas do menu
    private static void opcoesGerenciamento(Escola escola, int opcao){
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
                escola.adicionarTurmas();
                break;
            case 7:
                menuAlocacao(escola);
                break;
            case 8:
                menuRemocao(escola);
                break;
            case 9:
                menuPrincipal();
                break;
            case 10:
                System.out.println("Saindo...");
                System.exit(0);
            default:
                System.out.println("\nOpção Inválida\n");
                break;
        }
    }

    // Metodo para mostrar o menu de alocação de uma escola especifica
    private static void menuAlocacao(Escola escola){
        Scanner input = new Scanner(System.in);
        int opcao;

        do{
            mostrarMenuAlocacao();
            opcao = input.nextInt();
            opcoesAlocacao(escola, opcao);
        }
        while(opcao != 5 && opcao != 6);
    }

    // Metodo para mostrar o menu de alocação de uma escola específica
    private static void mostrarMenuAlocacao(){
        System.out.println("\n\tMenu de Alocacao.");
        System.out.println("\n1 - Alocar Turma em sala.");
        System.out.println("2 - Alocar Aluno em Turma");
        System.out.println("3 - Alocar Professor em Turma.");
        System.out.println("4 - Listar Alocações");
        System.out.println("5 - Voltar ao menu anterior");
        System.out.println("6 - Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    // Metodo para gerenciar as opções do Menu de alocação
    private static void opcoesAlocacao(Escola escola, int opcao){
        switch(opcao){
            case 1:
                Scanner input = new Scanner(System.in);
                alocarTurmaEmSala(escola);
                break;
            case 2:
                alocarAlunoEmTurma(escola);
                break;
            case 3:
                alocarProfessorEmTurma(escola);
                break;
            case 4:
                break;
            case 5:
                menuGerenciamentoEscola(escola);
                break;
            case 6:
                System.out.println("Saindo...");
                System.exit(0);
            default:
                System.out.println("Opção Inválida!");
                break;
        }
    }

    private static void alocarTurmaEmSala(Escola escola){
        Scanner input = new Scanner(System.in);
        ArrayList<Turma> turmas = escola.getTurmas();

        escola.listarTurmas();

        System.out.print("\nEscolha uma turma para alocar em uma sala:");
        int indiceTurma = input.nextInt() - 1;

        if (indiceTurma < 0 || indiceTurma >= turmas.size()){
            System.out.println("Opção Inválida.");
            return;
        }

        Turma turmaSelecionada = turmas.get(indiceTurma);

        ArrayList<Sala> salas = escola.getSalas();

        escola.listarSalas();

        System.out.print("\nEscolha uma sala para alocar a turma:");
        int indiceSala = input.nextInt();

        if (indiceSala < 0 || indiceSala >= salas.size()){
            System.out.println("Opção Inválida.");
            return;
        }

        Sala salaSelecionada = salas.get(indiceSala);
        escola.alocarTurmaEmSala(turmaSelecionada, salaSelecionada);
    }

    private static void alocarAlunoEmTurma(Escola escola){
        Scanner input = new Scanner(System.in);
        ArrayList<Aluno> alunos = escola.getAlunos();

        escola.listarAlunos();

        System.out.print("\nEscolha um aluno para alocar em uma turma:");
        int indiceAluno = input.nextInt();

        if (indiceAluno < 0 || indiceAluno >= alunos.size()){
            System.out.println("Opção Inválida.");
            return;
        }

        Aluno alunoSelecionado = alunos.get(indiceAluno);

        ArrayList<Turma> turmas = escola.getTurmas();

        escola.listarTurmas();

        if (turmas.isEmpty()){
            System.out.println("Não há turmas cadastradas.");
            return;
        }

        System.out.print("\nEscolha uma turma para alocar o aluno:");
        int indiceTurma = input.nextInt();

        if (indiceTurma < 0 || indiceTurma >= turmas.size()) {
            System.out.println("Opção Inválida.");
            return;
        }

        Turma turmaSelecionada = turmas.get(indiceTurma);
        escola.alocarAlunoEmTurma(alunoSelecionado, turmaSelecionada);
    }

    private static void alocarProfessorEmTurma(Escola escola){
        Scanner input = new Scanner(System.in);
        ArrayList<Professor> professores = escola.getProfessores();

        escola.listarProfessores();

        System.out.print("\nEscolha um professor para alocar em uma turma:");
        int indiceProfessor = input.nextInt();

        if (indiceProfessor < 0 || indiceProfessor >= professores.size()){
            System.out.println("Opção Inválida.");
            return;
        }

        Professor professorSelecionado = professores.get(indiceProfessor);

        ArrayList<Turma> turmas = escola.getTurmas();

        escola.listarTurmas();

        System.out.print("\nEscolha uma turma para alocar o professor:");
        int indiceTurma = input.nextInt();

        if (indiceTurma < 0 || indiceTurma >= turmas.size()){
            System.out.println("Opção Inválida.");
            return;
        }

        Turma turmaSelecionada = turmas.get(indiceTurma);

        // Agora aloca o professor na turma selecionada chamando o método da escola
        escola.alocarProfessorEmTurma(professorSelecionado, turmaSelecionada);
    }


    // Metodo para mostrar o menu de remoção de uma escola específica
    private static void menuRemocao(Escola escola){
        Scanner input = new Scanner(System.in);
        int opcao;

        do{
            mostrarMenuRemocao();
            opcao = input.nextInt();
            opcoesRemocao(escola, opcao);
        }
        while (opcao != 4 && opcao != 5);
    }

    // Metodo para mostrar o menu de remoção de uma escola específica
    private static void mostrarMenuRemocao(){
        System.out.println("\n\tMenu de remoção.");
        System.out.println("\n1 - Remover professor");
        System.out.println("2 - Remover sala");
        System.out.println("3 - Remover aluno");
        System.out.println("4 - Remover turma");
        System.out.println("5 - Voltar ao menu anterior");
        System.out.println("6 - Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    // Metodo para gerenciar as opções do Menu de Remoção
    private static void opcoesRemocao(Escola escola, int opcao){
        switch(opcao){
            case 1:
                removerItem("Professor", escola.getProfessores());
                break;
            case 2:
                removerItem("Sala", escola.getSalas());
                break;
            case 3:
                removerItem("Aluno", escola.getAlunos());
                break;
            case 4:
                removerItem("Turma", escola.getTurmas());
                break;
            case 5:
                menuGerenciamentoEscola(escola);
                break;
            case 6:
                System.out.println("Saindo...");
                System.exit(0);
            default:
                System.out.println("Opção Inválida!");
                break;
        }
    }

    // Metodo para remover um item
    private static <T> void removerItem(String tipo, ArrayList<T> lista){
        Scanner input = new Scanner(System.in);

        listarItens(tipo, lista);

        System.out.print("\nEscolha o " + tipo + " para remover: ");
        int opcao = input.nextInt();

        if(opcao >= 1 && opcao <= lista.size()){
            lista.remove(opcao - 1);
            System.out.println("\n" + tipo + " removido.");
            salvarEscolas();
        }
        else
            System.out.println("Opção Inválida!");
    }

    // Metodo para listar os itens
    private static <T> void listarItens(String tipo, ArrayList<T> lista){
        System.out.println("\nLista de " + tipo + "s:");
        for(int i = 0; i < lista.size(); i++)
            System.out.println("\n" + tipo + "[" + (i + 1) + "]\n" + lista.get(i));
    }

    // Metodoget do array de escolas
    public static ArrayList<Escola> getEscolas(){
        return escolas;
    }

    // Metodos para salvar os dados no arquivo "Escolas.txt"
    protected static void salvarEscolas(){
        ArquivoInfo.salvarInfoEscolas(escolas, ARQUIVO_ESCOLAS);
    }

    private static void carregarEscolas(){
        File file = new File(ARQUIVO_ESCOLAS);
        if(file.exists())
            escolas.addAll(ArquivoInfo.carregarInfoEscolas(ARQUIVO_ESCOLAS));
    }

}
