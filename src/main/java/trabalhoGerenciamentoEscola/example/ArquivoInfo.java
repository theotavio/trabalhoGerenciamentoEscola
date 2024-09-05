package trabalhoGerenciamentoEscola.example;
import java.io.*;
import java.util.ArrayList;

public class ArquivoInfo{
    public static void salvarInfoEscolas(ArrayList<Escola> escolas, String dados){
        try(PrintWriter writer = new PrintWriter(new FileWriter(dados))) {
            writer.println(escolas.size());
            for(Escola e : escolas){
                writer.println(e.getNome());
                writer.println(e.getEndereco());

                ArrayList<Professor> professores = e.getProfessores();
                writer.println(professores.size());
                for (Professor p : professores) {
                    writer.println(p.getNome());
                    writer.println(p.getCpf());
                    writer.println(p.getNumeroAulasMinistradas());
                    writer.println(p.getNumeroProfessores());
                }

                ArrayList<Aluno> alunos = e.getAlunos();
                writer.println(alunos.size());
                for (Aluno a : alunos) {
                    writer.println(a.getNome());
                    writer.println(a.getCpf());
                    writer.println(a.getMatricula());
                    writer.println(a.getIdade());
                    writer.println(a.getNumeroAlunos());
                }

                ArrayList<Sala> salas = e.getSalas();
                writer.println(salas.size());
                for (Sala s : salas) {
                    writer.println(s.getNumero());
                    writer.println(s.getCapacidadeSala());
                    writer.println(s.getNumeroDeTurmas());
                    writer.println(s.getNumeroSalas());
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Escola> carregarInfoEscolas(String dados) {
        ArrayList<Escola> escolas = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(dados))) {
            int qtdeEscolas = Integer.parseInt(reader.readLine());

            for(int i = 0; i < qtdeEscolas; i++){
                String nome = reader.readLine();
                String endereco = reader.readLine();
                Escola escola = new Escola(nome, endereco);

                int qtdeProfessores = Integer.parseInt(reader.readLine());
                for(int j = 0; j < qtdeProfessores; j++){
                    String nomeProfessor = reader.readLine();
                    String cpf = reader.readLine();
                    int numAulas = Integer.parseInt(reader.readLine());
                    int numeroProfessores = Integer.parseInt(reader.readLine());

                    Professor professor = new Professor(nomeProfessor, cpf);
                    professor.setNumeroProfessores(numeroProfessores);
                    escola.getProfessores().add(professor);
                }

                int qtdeAlunos = Integer.parseInt(reader.readLine());
                for(int j = 0; j < qtdeAlunos; j++){
                    String nomeAluno = reader.readLine();
                    String cpf = reader.readLine();
                    int matricula = Integer.parseInt(reader.readLine());
                    int idade = Integer.parseInt(reader.readLine());
                    int numeroAlunos = Integer.parseInt(reader.readLine());

                    Aluno aluno = new Aluno(nomeAluno, cpf,  matricula, idade);
                    aluno.setNumeroAlunos(numeroAlunos);
                    escola.getAlunos().add(aluno);
                }

                int qtdeSalas = Integer.parseInt(reader.readLine());
                for(int j = 0; j < qtdeSalas; j++){
                    int numero = Integer.parseInt(reader.readLine());
                    int capacidade = Integer.parseInt(reader.readLine());
                    int numeroDeTurmas = Integer.parseInt(reader.readLine());
                    int numeroSalas = Integer.parseInt(reader.readLine());

                    Sala sala = new Sala(numero, capacidade);
                    sala.setNumeroSalas(numeroSalas);
                    sala.setNumeroDeTurmas(numeroDeTurmas);
                    escola.getSalas().add(sala);
                }
                escolas.add(escola);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return escolas;
    }
}
