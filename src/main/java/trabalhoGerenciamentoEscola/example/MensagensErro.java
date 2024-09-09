package trabalhoGerenciamentoEscola.example;
import java.util.ArrayList;
import java.util.List;

public final class MensagensErro{
    // Array criado para armazenar os erros
    private static final List<String> erros = new ArrayList<>();

    // Mensagens de erro
    public static final String CPF_INVALIDO = "CPF precisa conter 11 dígitos.";
    public static final String IDADE_INVALIDA = "Idade não pode ser negativa.";
    public static final String MATRICULA_INVALIDA = "Matricula não pode ser menor ou igual a zero.";
    public static final String NOME_VAZIO = "O campo nome precisa ser preenchido.";
    public static final String CPF_VAZIO = "O campo CPF precisa ser preenchido.";
    public static final String ENDERECO_VAZIO = "O campo endereço precisa ser preenchido.";
    public static final String NUM_SALA = "O número da sala não pode ser menor ou igual a zero";
    public static final String NUM_CAPACIDADE_SALA = "A capacidade da sala não pode ser menor que zero";
    public static final String ANO_TURMA = "O ano da turma não pode ser menor ou igual a zero";
    public static final String CURSO_VAZIO = "O campo curso precisa ser preenchido.";
    public static final String CAPACIDADE_SALA = "A capacidade da sala excedida.";

    // Construtor privado para garantir que nenhuma instância seja criada
    private MensagensErro(){}

    // Metodo para adicionar as mensagens de erro no Array
    public static void adicionarErro(String mensagem){
        erros.add(mensagem);
    }

    // Metodo para mostrar a mensagem de erro
    public static List<String> getErros(){
        return new ArrayList<>(erros);
    }

    // Metodo para limpar o Array
    public static void limparErros(){
        erros.clear();
    }
}