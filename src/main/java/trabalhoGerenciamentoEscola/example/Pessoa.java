package trabalhoGerenciamentoEscola.example;
import java.util.HashSet;
import java.util.Set;

public abstract class Pessoa{
    // Atributos
    private String nome;
    private String cpf;

    // Conjunto para armazenar os CPFs registrados
    private static Set<String>  cpfsRegistrados = new HashSet<>();

    // Construtor com as devidas verificações
    public Pessoa(String nome, String cpf){
        if(nome.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.NOME_VAZIO);
        if (cpf.length() != 11)
            MensagensErro.adicionarErro(MensagensErro.CPF_INVALIDO);
        if(cpf.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.CPF_VAZIO);
        if(cpfsRegistrados.contains(cpf))
            MensagensErro.adicionarErro(MensagensErro.CPF_REGISTRADO);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
        this.nome = nome;
        this.cpf = cpf;
        cpfsRegistrados.add(cpf);
    }

    // Get e set de nome com as devidas verificações
    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        if(nome.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.NOME_VAZIO);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
        this.nome = nome;
    }

    // Get e set de cpf com as devidas verificações
    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        if (cpf.length() != 11)
            MensagensErro.adicionarErro(MensagensErro.CPF_INVALIDO);
        if(cpf.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.CPF_VAZIO);
        if(cpfsRegistrados.contains(cpf))
            MensagensErro.adicionarErro(MensagensErro.CPF_REGISTRADO);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
        this.cpf = cpf;
        cpfsRegistrados.add(cpf);
    }
}