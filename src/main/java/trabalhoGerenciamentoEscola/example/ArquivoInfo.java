package trabalhoGerenciamentoEscola.example;
import java.io.*;
import java.util.ArrayList;

public class ArquivoInfo {
    public static void salvarInfoEscolas(ArrayList<Escola> escolas, String dados) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dados))) {
            writer.println(escolas.size());
            for (Escola e : escolas) {
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

                ArrayList<Turma> turmas = e.getTurmas();
                writer.println(turmas.size());
                for (Turma t : turmas) {
                    writer.println(t.getCurso());
                    writer.println(t.getAnoTurma());
                    writer.println(t.getNumeroAlunos());

                    Professor professor = t.getProfessor();
                    if (professor != null)
                        writer.println(professor.getNome());
                    else
                        writer.println("Nenhum");

                    ArrayList<Aluno> alunosTurma = t.getAlunos();
                    writer.println(alunosTurma.size());
                    for (Aluno a : alunosTurma)
                        writer.println(a.getNome());

                    ArrayList<Horario> horarios = t.getHorarios();
                    writer.println(horarios.size());
                    for (Horario h : horarios) {
                        writer.println(h.getHoraInicio());
                        writer.println(h.getHoraFim());
                        writer.println(h.getDiaDaSemana());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Escola> carregarInfoEscolas(String dados) {
        ArrayList<Escola> escolas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(dados))) {
            int qtdeEscolas = Integer.parseInt(reader.readLine().trim());
            System.out.println("Quantidade de escolas: " + qtdeEscolas);

            for (int i = 0; i < qtdeEscolas; i++) {
                String nome = reader.readLine().trim();
                String endereco = reader.readLine().trim();
                Escola escola = new Escola(nome, endereco);

                int qtdeProfessores = Integer.parseInt(reader.readLine().trim());
                System.out.println("Quantidade de professores: " + qtdeProfessores);
                for (int j = 0; j < qtdeProfessores; j++) {
                    String nomeProfessor = reader.readLine().trim();
                    String cpf = reader.readLine().trim();
                    int numAulas = Integer.parseInt(reader.readLine().trim());
                    int numeroProfessores = Integer.parseInt(reader.readLine().trim());

                    Professor professor = new Professor(nomeProfessor, cpf);
                    professor.setNumeroAulasMinistradas(numAulas);
                    professor.setNumeroProfessores(numeroProfessores);
                    escola.getProfessores().add(professor);
                }

                int qtdeAlunos = Integer.parseInt(reader.readLine().trim());
                System.out.println("Quantidade de alunos: " + qtdeAlunos);
                for (int j = 0; j < qtdeAlunos; j++) {
                    String nomeAluno = reader.readLine().trim();
                    String cpf = reader.readLine().trim();
                    int matricula = Integer.parseInt(reader.readLine().trim());
                    int idade = Integer.parseInt(reader.readLine().trim());
                    int numeroAlunos = Integer.parseInt(reader.readLine().trim());

                    Aluno aluno = new Aluno(nomeAluno, cpf, matricula, idade);
                    aluno.setNumeroAlunos(numeroAlunos);
                    escola.getAlunos().add(aluno);
                }

                int qtdeSalas = Integer.parseInt(reader.readLine().trim());
                System.out.println("Quantidade de salas: " + qtdeSalas);
                for (int j = 0; j < qtdeSalas; j++) {
                    int numero = Integer.parseInt(reader.readLine().trim());
                    int capacidade = Integer.parseInt(reader.readLine().trim());
                    int numeroDeTurmas = Integer.parseInt(reader.readLine().trim());
                    int numeroSalas = Integer.parseInt(reader.readLine().trim());

                    Sala sala = new Sala(numero, capacidade);
                    sala.setNumeroSalas(numeroSalas);
                    sala.setNumeroDeTurmas(numeroDeTurmas);
                    escola.getSalas().add(sala);
                }

                int qtdeTurmas = Integer.parseInt(reader.readLine().trim());
                System.out.println("Quantidade de turmas: " + qtdeTurmas);
                for (int j = 0; j < qtdeTurmas; j++) {
                    String curso = reader.readLine().trim();
                    int anoTurma = Integer.parseInt(reader.readLine().trim());
                    int numeroAlunos = Integer.parseInt(reader.readLine().trim());

                    Turma turma = new Turma(curso, anoTurma);
                    turma.setNumeroAlunos(numeroAlunos);

                    String nomeProfessor = reader.readLine().trim();
                    if (!nomeProfessor.equals("Nenhum")) {
                        Professor professor = escola.getProfessores().stream()
                                .filter(p -> p.getNome().equals(nomeProfessor))
                                .findFirst()
                                .orElse(null);
                        if (professor != null) {
                            turma.setProfessor(professor);
                        }
                    }

                    int qtdeAlunosTurma = Integer.parseInt(reader.readLine().trim());
                    System.out.println("Quantidade de alunos na turma: " + qtdeAlunosTurma);
                    for (int k = 0; k < qtdeAlunosTurma; k++) {
                        String nomeAluno = reader.readLine().trim();
                        Aluno aluno = escola.getAlunos().stream()
                                .filter(a -> a.getNome().equals(nomeAluno))
                                .findFirst()
                                .orElse(null);
                        if (aluno != null) {
                            turma.getAlunos().add(aluno);
                        }
                    }
                    escola.getTurmas().add(turma);
                }
                escolas.add(escola);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Erro de formato de número: " + e.getMessage());
            e.printStackTrace();
        }
        return escolas;
    }
}
