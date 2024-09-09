package trabalhoGerenciamentoEscola.example;
import java.util.Scanner;
import java.util.ArrayList;

public class Escola{
    // Atributos
    private String nome;
    private String endereco;
    private ArrayList<Professor> professores = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Sala> salas = new ArrayList<>();
    private ArrayList<Turma> turmas = new ArrayList<>();
    private ArrayList<Horario> horarios = new ArrayList<>();

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
        criarHorarios();
    }

    // Metodo toString
    @Override
    public String toString(){
        return "Nome: " + nome + "\nEndereço: " + endereco;
    }

    // Gets e sets dos Arrays
    public ArrayList<Professor> getProfessores(){
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public ArrayList<Sala> getSalas(){
        return salas;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }

    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Turma> getTurmas(){
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }

    public ArrayList<Horario> getHorarios(){
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios){
        this.horarios = horarios;
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

        int i = 0, aux = 0;
        while(!valido){
            try{
                MensagensErro.limparErros();

                for(i = aux; i < qtde; i++){
                    System.out.print("\nDigite o nome do professor: ");
                    String nome = input.nextLine();

                    System.out.print("Digite o CPF do professor(apenas números): ");
                    String cpf = input.nextLine();
                    System.out.println();

                    professores.add(new Professor(nome, cpf));
                    atualizarNumeroProfessores();
                    Main.salvarEscolas();
                    aux++;
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

        int i = 0, aux = 0;
        while(!valido){
            try {
                MensagensErro.limparErros();

                for(i = aux; i < qtde; i++){
                    System.out.print("\nDigite o numero da sala: ");
                    int numero = input.nextInt();

                    System.out.print("Digite a capacidade da sala: ");
                    int capacidade = input.nextInt();

                    salas.add(new Sala(numero, capacidade));
                    atualizarNumeroSalas();
                    Main.salvarEscolas();
                    aux++;
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

        int i = 0, aux = 0;
        while(!valido){
            try{
                MensagensErro.limparErros();

                for(i = aux; i < qtde; i++){
                    System.out.print("\nDigite o nome do aluno: ");
                    String nome = input.nextLine();

                    System.out.print("Digite o CPF do aluno(apenas números): ");
                    String cpf = input.nextLine();

                    System.out.print("Digite o número de matrícula do aluno: ");
                    int matricula = input.nextInt();

                    System.out.print("Digite a idade do aluno: ");
                    int idade = input.nextInt();
                    System.out.println();

                    input.nextLine();

                    alunos.add(new Aluno(nome, cpf, matricula, idade));
                    atualizarNumeroAlunos();
                    Main.salvarEscolas();
                    aux++;
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

    //  Metodo para adicionar turmas na escola
    public void adicionarTurmas(){
        Scanner input = new Scanner(System.in);
        boolean valido = false;

        System.out.print("\nQuantas turmas você quer adicionar?: ");
        int qtde = input.nextInt();

        if(qtde < 0){
            System.out.println("Opção inválida!");
            return;
        }

        input.nextLine();

        int i = 0, aux = 0;
        while(!valido){
            try{
                MensagensErro.limparErros();

                for(i = aux; i < qtde; i++){
                    System.out.print("\nDigite o curso da turma: ");
                    String curso = input.nextLine();

                    System.out.print("Digite o ano da turma: ");
                    int ano = input.nextInt();
                    System.out.println();

                    input.nextLine();

                    turmas.add(new Turma(curso, ano));
                    Main.salvarEscolas();
                    aux++;
                }
                valido = true;
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    // Metodo para listar todas as salas da escola
    public void listarTurmas(){
        int indice = 1;

        System.out.println("\nLista de Turmas:");

        if (turmas.isEmpty())
            System.out.println("Nenhuma turma foi adicionada.");
        else
            for (Turma turma : turmas) {
                System.out.println("\nTurma" + " [" + indice + "]\n" + turma);
                indice++;
            }
    }

    // Metodo para alocar turma em sala
    public void alocarTurmaEmSala(){
        Scanner input = new Scanner(System.in);
        int opcao;

        System.out.println("\n\tAlocação de Turmas em Salas");

        listarTurmas();
        System.out.print("\nEscolha a turma para alocar (Insira o número): ");
        int turmaId = input.nextInt() - 1;

        if (turmaId < 0 || turmaId >= turmas.size()){
            System.out.println("Opção Inválida!");
            return;
        }
        Turma turmaSelecionada = turmas.get(turmaId);

        if (turmaSelecionada.getSala() != null){
            System.out.println("\nA turma já está alocada em uma sala.");
            return;
        }

        listarSalas();
        System.out.print("\nEscolha a sala para alocar a turma (Insira o número): ");
        int salaId = input.nextInt() - 1;

        // Verificar se a sala escolhida é válida
        if (salaId < 0 || salaId >= salas.size()){
            System.out.println("Opção Inválida!");
            return;
        }
        Sala salaSelecionada = salas.get(salaId);

        turmaSelecionada.setSala(salaSelecionada);
        salaSelecionada.setNumeroDeTurmas(salaSelecionada.getNumeroDeTurmas() + 1);

        System.out.println("\nTurma alocada!");
        Main.salvarEscolas();
    }

    // Metodo para alocar aluno em turma
    public void alocarAlunoEmTurma(){
        Scanner input = new Scanner(System.in);

        System.out.println("\n\tAlocação de Alunos em Turmas");

        listarAlunos();
        System.out.print("\nEscolha o aluno para alocar (Insira o número): ");
        int alunoId = input.nextInt() - 1;

        if (alunoId < 0 || alunoId >= alunos.size()){
            System.out.println("Opção Inválida!");
            return;
        }
        Aluno alunoSelecionado = alunos.get(alunoId);

        if (alunoSelecionado.getTurmas().size() > 0){
            System.out.println("\nO aluno já está alocado em uma turma.");
            return;
        }

        listarTurmas();
        System.out.print("\nEscolha a turma para alocar o aluno (Insira o número): ");
        int turmaId = input.nextInt() - 1;

        if(turmaId < 0 || turmaId >= turmas.size()){
            System.out.println("Opção Inválida!");
            return;
        }
        Turma turmaSelecionada = turmas.get(turmaId);

        Sala salaDaTurma = turmaSelecionada.getSala();
        if(salaDaTurma == null){
            System.out.println("\nA turma selecionada não está alocada em nenhuma sala.");
            return;
        }

        int capacidadeAtual = turmaSelecionada.getAlunos().size();
        if(capacidadeAtual >= salaDaTurma.getCapacidadeSala()){
            System.out.println("\nA sala da turma não tem capacidade suficiente.");
            return;
        }

        turmaSelecionada.adicionarAluno(alunoSelecionado);
        alunoSelecionado.adicionarTurma(turmaSelecionada);
        turmaSelecionada.setNumeroAlunos(turmaSelecionada.getNumeroAlunos() + 1);

        System.out.println("\nAluno alocado com sucesso!");
        Main.salvarEscolas();
    }

    // Metodo para alocar professor em turma
    public void alocarProfessorEmTurma(){
        Scanner input = new Scanner(System.in);
        int opcao;

        System.out.println("\n\tAlocação de Professores em Turmas");

        listarProfessores();
        System.out.print("\nEscolha o professor para alocar (Insira o número): ");
        int professorId = input.nextInt() - 1;

        if (professorId < 0 || professorId >= professores.size()){
            System.out.println("Opção Inválida!");
            return;
        }
        Professor professorSelecionado = professores.get(professorId);

        listarTurmas();
        System.out.print("\nEscolha a turma para alocar o professor (Insira o número): ");
        int turmaId = input.nextInt() - 1;

        if (turmaId < 0 || turmaId >= turmas.size()) {
            System.out.println("Opção Inválida!");
            return;
        }
        Turma turmaSelecionada = turmas.get(turmaId);

        if (turmaSelecionada.getProfessor() != null){
            System.out.println("\nA turma já tem um professor alocado.");
            return;
        }

        turmaSelecionada.setProfessor(professorSelecionado);
        professorSelecionado.setNumeroAulasMinistradas(professorSelecionado.getNumeroAulasMinistradas() + 1);

        System.out.println("\nProfessor alocado com sucesso!");
        Main.salvarEscolas();
    }

    // Metodo para listar as alocacoes
    public void listarAlocacoes(){
        System.out.println("\n\tListagem de Alocações");

        if (turmas.isEmpty()){
            System.out.println("Nenhuma turma foi criada.");
            return;
        }

        for (Turma turma : turmas){
            System.out.println("\nTurma: " + turma.getCurso() + " Ano: " + turma.getAnoTurma());

            Sala salaAlocada = turma.getSala();
            if (salaAlocada != null)
                System.out.println("Sala: " + salaAlocada.getNumero() + " (Capacidade: " + salaAlocada.getCapacidadeSala() + ")");
            else
                System.out.println("Sala: Não alocada");

            Professor professorAlocado = turma.getProfessor();
            if (professorAlocado != null)
                System.out.println("Professor: " + professorAlocado.getNome());
            else
                System.out.println("Professor: Não alocado");

            ArrayList<Aluno> alunosAlocados = turma.getAlunos();
            if (!alunosAlocados.isEmpty()){
                System.out.println("Alunos:");
                for (Aluno aluno : alunosAlocados)
                    System.out.println("Nome: " + aluno.getNome());
            }
            else
                System.out.println("Alunos: Nenhum aluno alocado");

            ArrayList<Horario> horariosAlocados = turma.getHorarios();
            if (horariosAlocados != null && !horariosAlocados.isEmpty()) {
                System.out.println("Horários:");
                for (Horario horario : horariosAlocados){
                    System.out.println(horario);
                }
            } else {
                System.out.println("Horários: Nenhum horário alocado");
            }
        }
    }

    // Metodo para alocar horário a turma
    public void alocarHorarioTurma(){
        Scanner input = new Scanner(System.in);

        listarTurmas();
        System.out.print("\nEscolha a turma para alocar horários (Insira o número): ");
        int turmaId = input.nextInt() - 1;

        if (turmaId < 0 || turmaId >= turmas.size()) {
            System.out.println("Opção inválida!");
            return;
        }
        Turma turmaSelecionada = turmas.get(turmaId);

        listarHorariosDisponiveis();
        System.out.print("\nEscolha o horário para alocar à turma (Insira o número): ");
        int horarioId = input.nextInt() - 1;

        if (horarioId < 0 || horarioId >= horarios.size()) {
            System.out.println("Opção inválida!");
            return;
        }
        Horario horarioSelecionado = horarios.get(horarioId);

        if (turmaSelecionada.getHorarios().contains(horarioSelecionado)) {
            System.out.println("\nEsse horário já está alocado para essa turma.");
            return;
        }

        turmaSelecionada.getHorarios().add(horarioSelecionado);
        System.out.println("\nHorário alocado com sucesso!");

        Main.salvarEscolas();
    }


    // Metodo para listar horários
    public void listarHorariosDisponiveis() {
        System.out.println("\nHorários Disponíveis:");

        boolean todosAlocados = true;
        int count = 1;

        // Cria um conjunto para armazenar os horários alocados e verificar se estão disponíveis
        ArrayList<Horario> horariosAlocados = new ArrayList<>();
        for (Turma turma : turmas) {
            horariosAlocados.addAll(turma.getHorarios());
        }

        // Lista todos os horários e verifica se estão alocados
        for (Horario horario : horarios) {
            boolean horarioAlocado = horariosAlocados.contains(horario);

            if (!horarioAlocado) {
                System.out.println(count + ". " + horario.getDiaDaSemana() + " - " + horario.getHoraInicio() + " às " + horario.getHoraFim());
                count++;
                todosAlocados = false;
            }
        }

        if (todosAlocados) {
            System.out.println("\nTodos os horários já foram alocados.");
        }
    }

    public void criarHorarios() {
        String[] diasDaSemana = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};
        int horaInicioMin = 7;
        int horaFimMax = 24;
        int intervalo = 2; // Intervalo de tempo entre os horários

        for (String dia : diasDaSemana) {
            for (int horaInicio = horaInicioMin; horaInicio < horaFimMax; horaInicio += intervalo) {
                int horaFim = horaInicio + intervalo;

                if (horaFim > horaFimMax)
                    continue;

                if (horaFim <= horaInicio) {
                    System.out.println("Hora de fim deve ser maior que hora de início.");
                    continue;
                }
                Horario horario = new Horario(horaInicio, horaFim, dia);
                horarios.add(horario);
            }
        }

        Main.salvarEscolas();
    }



    //  Metodo para remover turma
    public void removerTurma(){
        Scanner input = new Scanner(System.in);

        listarTurmas();
        System.out.print("\nEscolha a turma para deletar (Insira o número): ");
        int turmaId = input.nextInt() - 1;

        if (turmaId < 0 || turmaId >= turmas.size()) {
            System.out.println("Opção Inválida!");
            return;
        }

        Turma turmaRemover = turmas.get(turmaId);

        Professor professor = turmaRemover.getProfessor();
        if (professor != null) {
            professor.setNumeroAulasMinistradas(professor.getNumeroAulasMinistradas() - 1);
            turmaRemover.setProfessor(null);
        }

        ArrayList<Aluno> alunosTurma = turmaRemover.getAlunos();
        for (Aluno aluno : alunosTurma){
            aluno.getTurmas().remove(turmaRemover);
            aluno.setNumeroAlunos(alunos.size());
        }

        Sala sala = turmaRemover.getSala();
        if (sala != null){
            sala.setNumeroDeTurmas(sala.getNumeroDeTurmas() - 1);
            turmaRemover.setSala(null);
        }

        turmas.remove(turmaId);
        System.out.println("\nTurma removida com sucesso!");

        Main.salvarEscolas();
    }

    // Metodo para remover aluno
    public void removerAluno(){
        Scanner input = new Scanner(System.in);

        listarAlunos();
        System.out.print("\nEscolha o aluno para deletar (Insira o número): ");
        int alunoId = input.nextInt() - 1;

        if (alunoId < 0 || alunoId >= turmas.size()) {
            System.out.println("Opção Inválida!");
            return;
        }

        Aluno alunoRemover = alunos.get(alunoId);

        ArrayList<Turma> turmasAluno = alunoRemover.getTurmas();
        for (Turma turma : turmasAluno) {
            turma.getAlunos().remove(alunoRemover);
            turma.setNumeroAlunos(turma.getNumeroAlunos() - 1);
        }

        alunos.remove(alunoId);
        System.out.println("\nAluno removido com sucesso!");

        Main.salvarEscolas();
    }

    // Metodo para remover professor
    public void removerProfessor(){
        Scanner input = new Scanner(System.in);

        listarProfessores();
        System.out.print("\nEscolha o professor para deletar (Insira o número): ");
        int professorId = input.nextInt() - 1;

        if (professorId < 0 || professorId >= turmas.size()) {
            System.out.println("Opção Inválida!");
            return;
        }
        Professor professorRemover = professores.get(professorId);

        for (Turma turma : turmas) {
            if (turma.getProfessor() == professorRemover) {
                turma.setProfessor(null);
            }
        }

        professores.remove(professorId);
        System.out.println("\nProfessor removido com sucesso!");

        Main.salvarEscolas();
    }

    // Metodo para remover sala
    public void removerSala(){
        Scanner input = new Scanner(System.in);

        listarSalas();
        System.out.print("\nEscolha a sala para deletar (Insira o número): ");
        int salaId = input.nextInt() - 1;

        if (salaId < 0 || salaId >= turmas.size()){
            System.out.println("Opção Inválida!");
            return;
        }
        Sala salaRemover = salas.get(salaId);

        for (Turma turma : turmas){
            if (turma.getSala() == salaRemover) {
                turma.setSala(null);
                salaRemover.setNumeroDeTurmas(salaRemover.getNumeroDeTurmas() - 1);
            }
        }

        salas.remove(salaId);
        System.out.println("\nSala removida com sucesso!");

        Main.salvarEscolas();
    }
}