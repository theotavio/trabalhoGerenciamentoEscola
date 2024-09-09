package trabalhoGerenciamentoEscola.example;

import java.io.*;
import java.util.ArrayList;

public class ArquivoInfo {

    public static void salvarInfoEscolas(ArrayList<Escola> escolas, String dados) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dados))) {
            writer.println(escolas.size());
            for (Escola e : escolas)
                salvarEscola(writer, e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void salvarEscola(PrintWriter writer, Escola escola) {
        writer.println(escola.getNome());
        writer.println(escola.getEndereco());
        salvarProfessores(writer, escola.getProfessores());
        salvarAlunos(writer, escola.getAlunos());
        salvarSalas(writer, escola.getSalas());
        salvarTurmas(writer, escola.getTurmas());
    }

    private static void salvarProfessores(PrintWriter writer, ArrayList<Professor> professores) {
        writer.println(professores.size());
        for (Professor p : professores) {
            writer.println(p.getNome());
            writer.println(p.getCpf());
            writer.println(p.getNumeroAulasMinistradas());
            writer.println(p.getNumeroProfessores());
        }
    }

    private static void salvarAlunos(PrintWriter writer, ArrayList<Aluno> alunos) {
        writer.println(alunos.size());
        for (Aluno a : alunos) {
            writer.println(a.getNome());
            writer.println(a.getCpf());
            writer.println(a.getMatricula());
            writer.println(a.getIdade());
            writer.println(a.getNumeroAlunos());
        }
    }

    private static void salvarSalas(PrintWriter writer, ArrayList<Sala> salas) {
        writer.println(salas.size());
        for (Sala s : salas) {
            writer.println(s.getNumero());
            writer.println(s.getCapacidadeSala());
            writer.println(s.getNumeroDeTurmas());
            writer.println(s.getNumeroSalas());
        }
    }

    private static void salvarTurmas(PrintWriter writer, ArrayList<Turma> turmas) {
        writer.println(turmas.size());
        for (Turma t : turmas) {
            writer.println(t.getCurso());
            writer.println(t.getAnoTurma());
            writer.println(t.getNumeroAlunos());

            Sala sala = t.getSala();
            if (sala != null) {
                writer.println(sala.getNumero());
            } else {
                writer.println("Nenhuma");
            }

            Professor professor = t.getProfessor();
            if (professor != null) {
                writer.println(professor.getNome());
            } else {
                writer.println("Nenhum");
            }

            ArrayList<Aluno> alunos = t.getAlunos();
            writer.println(alunos.size());
            for (Aluno a : alunos) {
                writer.println(a.getNome());
            }

            ArrayList<Horario> horarios = t.getHorarios();
            writer.println(horarios.size());
            for (Horario h : horarios) {
                writer.println(h.getHoraInicio());
                writer.println(h.getHoraFim());
                writer.println(h.getDiaDaSemana());
            }
        }
    }

    public static ArrayList<Escola> carregarInfoEscolas(String dados) {
        ArrayList<Escola> escolas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(dados))) {
            int qtdeEscolas = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < qtdeEscolas; i++) {
                Escola escola = carregarEscola(reader);
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

    private static Escola carregarEscola(BufferedReader reader) throws IOException {
        String nome = reader.readLine().trim();
        String endereco = reader.readLine().trim();
        Escola escola = new Escola(nome, endereco);

        escola.setProfessores(carregarProfessores(reader));
        escola.setAlunos(carregarAlunos(reader));
        escola.setSalas(carregarSalas(reader));
        escola.setTurmas(carregarTurmas(reader, escola));

        return escola;
    }

    private static ArrayList<Professor> carregarProfessores(BufferedReader reader) throws IOException {
        ArrayList<Professor> professores = new ArrayList<>();
        int qtdeProfessores = Integer.parseInt(reader.readLine().trim());
        for (int j = 0; j < qtdeProfessores; j++) {
            String nome = reader.readLine().trim();
            String cpf = reader.readLine().trim();
            int numAulas = Integer.parseInt(reader.readLine().trim());
            int numeroProfessores = Integer.parseInt(reader.readLine().trim());

            Professor professor = new Professor(nome, cpf);
            professor.setNumeroAulasMinistradas(numAulas);
            professor.setNumeroProfessores(numeroProfessores);
            professores.add(professor);
        }
        return professores;
    }

    private static ArrayList<Aluno> carregarAlunos(BufferedReader reader) throws IOException {
        ArrayList<Aluno> alunos = new ArrayList<>();
        int qtdeAlunos = Integer.parseInt(reader.readLine().trim());
        for (int j = 0; j < qtdeAlunos; j++) {
            String nome = reader.readLine().trim();
            String cpf = reader.readLine().trim();
            int matricula = Integer.parseInt(reader.readLine().trim());
            int idade = Integer.parseInt(reader.readLine().trim());
            int numeroAlunos = Integer.parseInt(reader.readLine().trim());

            Aluno aluno = new Aluno(nome, cpf, matricula, idade);
            aluno.setNumeroAlunos(numeroAlunos);
            alunos.add(aluno);
        }
        return alunos;
    }

    private static ArrayList<Sala> carregarSalas(BufferedReader reader) throws IOException {
        ArrayList<Sala> salas = new ArrayList<>();
        int qtdeSalas = Integer.parseInt(reader.readLine().trim());
        for (int j = 0; j < qtdeSalas; j++) {
            int numero = Integer.parseInt(reader.readLine().trim());
            int capacidade = Integer.parseInt(reader.readLine().trim());
            int numeroDeTurmas = Integer.parseInt(reader.readLine().trim());
            int numeroSalas = Integer.parseInt(reader.readLine().trim());

            Sala sala = new Sala(numero, capacidade);
            sala.setNumeroSalas(numeroSalas);
            sala.setNumeroDeTurmas(numeroDeTurmas);
            salas.add(sala);
        }
        return salas;
    }

    private static ArrayList<Turma> carregarTurmas(BufferedReader reader, Escola escola) throws IOException {
        ArrayList<Turma> turmas = new ArrayList<>();
        int qtdeTurmas = Integer.parseInt(reader.readLine().trim());
        for (int j = 0; j < qtdeTurmas; j++) {
            String curso = reader.readLine().trim();
            int anoTurma = Integer.parseInt(reader.readLine().trim());
            int numeroAlunos = Integer.parseInt(reader.readLine().trim());

            Turma turma = new Turma(curso, anoTurma);
            turma.setNumeroAlunos(numeroAlunos);

            String salaNumeroStr = reader.readLine().trim();
            if (!salaNumeroStr.equals("Nenhuma")) {
                try {
                    int salaNumero = Integer.parseInt(salaNumeroStr);
                    Sala sala = escola.getSalas().stream()
                            .filter(s -> s.getNumero() == salaNumero)
                            .findFirst()
                            .orElse(null);
                    turma.setSala(sala);
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao carregar número da sala: " + e.getMessage());
                }
            }

            String nomeProfessor = reader.readLine().trim();
            if (!nomeProfessor.equals("Nenhum")) {
                Professor professor = escola.getProfessores().stream()
                        .filter(p -> p.getNome().equals(nomeProfessor))
                        .findFirst()
                        .orElse(null);
                turma.setProfessor(professor);
            }

            int qtdeAlunos = Integer.parseInt(reader.readLine().trim());
            ArrayList<Aluno> alunos = new ArrayList<>();
            for (int i = 0; i < qtdeAlunos; i++) {
                String nomeAluno = reader.readLine().trim();
                Aluno aluno = escola.getAlunos().stream()
                        .filter(a -> a.getNome().equals(nomeAluno))
                        .findFirst()
                        .orElse(null);
                if (aluno != null) {
                    alunos.add(aluno);
                }
            }
            turma.setAlunos(alunos);

            int qtdeHorarios = Integer.parseInt(reader.readLine().trim());
            ArrayList<Horario> horarios = new ArrayList<>();
            for (int i = 0; i < qtdeHorarios; i++) {
                int horaInicio = Integer.parseInt(reader.readLine().trim());
                int horaFim = Integer.parseInt(reader.readLine().trim());
                String diaDaSemana = reader.readLine().trim();

                Horario horario = escola.getHorarios().stream()
                        .filter(h -> h.getHoraInicio() == horaInicio &&
                                h.getHoraFim() == horaFim &&
                                h.getDiaDaSemana().equals(diaDaSemana))
                        .findFirst()
                        .orElse(null);
                if (horario != null) {
                    horarios.add(horario);
                }
            }
            turma.setHorarios(horarios);

            turmas.add(turma);
        }
        return turmas;
    }
}
