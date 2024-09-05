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
        if(nome.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.NOME_VAZIO);
        if(endereco.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.ENDERECO_VAZIO);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
        this.nome = nome;
        this.endereco = endereco;
    }

    // Metodo toString
    @Override
    public String toString(){
        return "Nome: " + nome + "\nEndereço: " + endereco;
    }

    // Getts dos Arrays
    public ArrayList<Professor> getProfessores(){
        return professores;
    }

    public ArrayList<Sala> getSalas(){
        return salas;
    }

    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }

    // Get e set de nome com as devidas verificações
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        if(nome.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.NOME_VAZIO);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
        this.nome = nome;
    }

    // Get e Set de Endereco com as devidas verificações
    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        if(endereco.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.ENDERECO_VAZIO);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
        this.endereco = endereco;
    }

    //  Metodo para adicionar professores na escola
    public void adicionarProfessores(){
        Scanner input = new Scanner(System.in);
        boolean valido = false;
        int totalProfessores = 0;

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

                for(int i = 0; i < qtde; i++){
                    System.out.print("\nDigite o nome do professor: ");
                    String nome = input.nextLine();

                    System.out.print("Digite o CPF do professor(apenas números): ");
                    String cpf = input.nextLine();
                    System.out.println();

                    professores.add(new Professor(nome, cpf));
                    atualizarNumeroProfessores();
                    Main.salvarEscolas();
                }
                valido = true;
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    // Metodo para atualizar o numero de professores de uma escola
    public void atualizarNumeroProfessores(){
        for (Professor professor : professores)
            professor.setNumeroProfessores(professores.size());
    }

    // Metodo para listar todos os professores da escola
    public void listarProfessores(){
        int indice = 1;

        System.out.println("\nLista de Professores:");

        if(professores.isEmpty())
            System.out.println("Nenhum professor foi adicionado.");
        else
            for(Professor professor : professores){
                System.out.println("\nProfessor" + " [" + indice + "]\n" +  professor);
                System.out.println("Numero de professores: " + professor.getNumeroProfessores());
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

                for(int i = 0; i < qtde; i++){
                    System.out.print("\nDigite o numero da sala: ");
                    int numero = input.nextInt();

                    System.out.print("Digite a capacidade da sala: ");
                    int capacidade = input.nextInt();

                    salas.add(new Sala(numero, capacidade));
                    Main.salvarEscolas();
                }
                valido = true;
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    // Metodo para atualizar o numero de salas de uma escola
    public void atualizarNumeroSalas(){
        for(Sala sala : salas)
            sala.setNumeroSalas(salas.size());
    }

    // Metodo para listar todas as salas da escola
    public void listarSalas(){
        int indice = 1;

        System.out.println("\nLista de Salas:");

        if(salas.isEmpty())
            System.out.println("Nenhuma sala foi adicionada.");
        else
            for(Sala sala : salas){
                System.out.println("\nSala" + " [" + indice + "]\n" +  sala);
                System.out.println("Quantidade de salas: " + sala.getNumeroSalas());
                indice++;
            }
    }

    // Metodo para adicionar alunos na escola
    public void adicionarAlunos(){
        Scanner input = new Scanner(System.in);
        boolean valido = false;

        System.out.print("\nQuantos alunos você quer adicionar?: ");
        int qtde = input.nextInt();

        if(qtde < 0){
            System.out.println("Opção inválida!");
            return;
        }

        input.nextLine();

        while(!valido){
            try{
                MensagensErro.limparErros();

                for(int i = 0; i < qtde; i++){
                    System.out.print("\nDigite o nome do aluno: ");
                    String nome = input.nextLine();

                    System.out.print("Digite o CPF do aluno(apenas números): ");
                    String cpf = input.nextLine();

                    System.out.print("Digite o número de matrícula do aluno: ");
                    int matricula = input.nextInt();

                    System.out.print("Digite a idade do aluno: ");
                    int idade = input.nextInt();
                    System.out.println();

                    alunos.add(new Aluno(nome, cpf, matricula, idade));
                    atualizarNumeroAlunos();
                    Main.salvarEscolas();
                }
                valido = true;
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    // Metodo para atualizar o numero de alunos de uma escola
    public void atualizarNumeroAlunos(){
        for (Aluno aluno : alunos)
            aluno.setNumeroAlunos(alunos.size());
    }

    // Metodo para listar todos os alunos da escola
    public void listarAlunos(){
        int indice = 1;

        System.out.println("\nLista de Alunos:");

        if(alunos.isEmpty())
            System.out.println("Nenhum aluno foi adicionado.");
        else
            for(Aluno aluno : alunos){
                System.out.println("\nAluno" + " [" + indice + "]\n" +  aluno);
                System.out.println("Número de alunos: " + aluno.getNumeroAlunos());
                indice++;
            }
    }
}