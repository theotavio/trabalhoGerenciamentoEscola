package trabalhoGerenciamentoEscola.example;
import java.util.HashSet;
import java.util.Set;

public abstract class Pessoa{
    // Atributos
    private String nome;
    private String cpf;

    // Conjunto para armazenar os CPFs registrados
    private static Set<String>  cpfsRegistrados = new HashSet<>();

    // Construtor
    public Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;

        if(nome.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.NOME_VAZIO);

        if (cpf.length() != 11)
            MensagensErro.adicionarErro(MensagensErro.CPF_INVALIDO);
        else if(cpf.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.CPF_VAZIO);

        if(cpfsRegistrados.contains(cpf))
            MensagensErro.adicionarErro(MensagensErro.CPF_REGISTRADO);
        else
            cpfsRegistrados.add(cpf);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;

        if(nome.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.NOME_VAZIO);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;

        if (cpf.length() != 11)
            MensagensErro.adicionarErro(MensagensErro.CPF_INVALIDO);
        else if(cpf.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.CPF_VAZIO);

        if(cpfsRegistrados.contains(cpf))
            MensagensErro.adicionarErro(MensagensErro.CPF_REGISTRADO);
        else
            cpfsRegistrados.add(cpf);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
    }
}