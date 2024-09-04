package trabalhoGerenciamentoEscola.example;
import java.util.Scanner;
import java.util.ArrayList;

public class Escola{
    // Atributos
    private String nome;
    private String endereco;
    private final ArrayList<Professor> professores = new ArrayList<>();
    private final ArrayList<Aluno> alunos = new ArrayList<>();
    private final ArrayList<Sala> salas = new ArrayList<>();
    private static final String ARQUIVO_ESCOLAS = "escolas.txt";

    // Construtor com as devidas verificações
    public Escola(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;

        if(nome.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.NOME_VAZIO);
        if(endereco.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.ENDERECO_VAZIO);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
    }

    // Metodo toString
    @Override
    public String toString(){
        return "Nome: " + nome + ", Endereço: " + endereco;
    }

    // Getters e Setters com as devidas verificações

    public ArrayList<Professor> getProfessores(){
        return professores;
    }

    public ArrayList<Sala> getSalas(){
        return salas;
    }

    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;

        if(nome.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.NOME_VAZIO);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;

        if(endereco.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.ENDERECO_VAZIO);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
    }

    //  Metodo para adicionar professores na escola
    public void adicionarProfessores(){
        Scanner input = new Scanner(System.in);
        boolean valido = false;

        System.out.print("\nQuantos professores você quer adicionar?: ");
        int qtde = input.nextInt();

        if(qtde < 0){
            System.out.println("Opção inválida!");
            return;
        }

        input.nextLine();

        while(!valido){
            try{
                MensagensErro.limparErros();

                for (int i = 0; i < qtde; i++) {
                    System.out.print("\nDigite o nome do professor: ");
                    String nome = input.nextLine();

                    System.out.print("Digite o CPF do professor: ");
                    String cpf = input.nextLine();

                    System.out.print("Digite o número de aulas que ele vai ministrar: ");
                    int numAulas = input.nextInt();
                    System.out.println();

                    input.nextLine();

                    professores.add(new Professor(nome, cpf, numAulas));
                    ArquivoInfo.salvarInfoEscolas(Main.getEscolas(), ARQUIVO_ESCOLAS);
                }
                valido = true;
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    // Metodo para listar todos os professores da escola
    public void listarProfessores(){
        int indice = 1;

        System.out.println("\nLista de Professores:");

        if(professores.isEmpty())
            System.out.println("Nenhum professor foi adicionado.");
        else
            for(Professor professor : professores){
                System.out.println("Professor" + " [" + indice + "] " +  professor);
                indice++;
            }
    }

    // Metodo para adicionar salas na escola
    public void adicionarSala(){
        Scanner input = new Scanner(System.in);
        boolean valido = false;

        System.out.print("\nQuantas salas você quer adicionar?: ");
        int qtde = input.nextInt();

        if(qtde < 0){
            System.out.println("Opção inválida!");
            return;
        }

        input.nextLine();
        while(!valido){
            try {
                MensagensErro.limparErros();

                for (int i = 0; i < qtde; i++) {
                    System.out.print("\nDigite o numero da sala: ");
                    int numero = input.nextInt();

                    System.out.print("Digite a capacidade da sala: ");
                    int capacidade = input.nextInt();

                    System.out.print("Digite o número de turmas que essa sala vai ter: ");
                    int numTurmas = input.nextInt();
                    System.out.println();

                    input.nextLine();

                    salas.add(new Sala(numero, capacidade, numTurmas));
                    ArquivoInfo.salvarInfoEscolas(Main.getEscolas(), ARQUIVO_ESCOLAS);
                }
                valido = true;
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    // Metodo para listar todas as salas da escola
    public void listarSalas(){
        int indice = 1;

        System.out.println("\nLista de Salas:");

        if(salas.isEmpty())
            System.out.println("Nenhuma sala foi adicionada.");
        else
            for(Sala sala : salas){
                System.out.println("Sala" + " [" + indice + "] " +  sala);
                indice++;
            }
    }

    // Metodo para adicionar alunos na escola
    public void adicionarAlunos(){
        Scanner input = new Scanner(System.in);
        boolean valido = false;

        System.out.print("\nQuantos alunos você quer adicionar?: ");
        int qtde = input.nextInt();

        input.nextLine();

        if(qtde < 0){
            System.out.println("Opção inválida!");
            return;
        }

        while(!valido){
            try {
                MensagensErro.limparErros();

                for (int i = 0; i < qtde; i++) {
                    System.out.print("\nDigite o nome do aluno: ");
                    String nome = input.nextLine();

                    System.out.print("Digite o CPF do aluno: ");
                    String cpf = input.nextLine();

                    System.out.print("Digite o número de matrícula do aluno: ");
                    int matricula = input.nextInt();

                    System.out.print("Digite a idade do aluno: ");
                    int idade = input.nextInt();
                    System.out.println();

                    input.nextLine();

                    alunos.add(new Aluno(nome, cpf, matricula, idade));
                    ArquivoInfo.salvarInfoEscolas(Main.getEscolas(), ARQUIVO_ESCOLAS);
                }
                valido = true;
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    // Metodo para listar todos os alunos da escola
    public void listarAlunos(){
        int indice = 1;

        System.out.println("\nLista de Alunos:");

        if(alunos.isEmpty())
            System.out.println("Nenhum aluno foi adicionado.");
        else
            for(Aluno aluno : alunos){
                System.out.println("Aluno" + " [" + indice + "] " +  aluno);
                indice++;
            }
    }
}