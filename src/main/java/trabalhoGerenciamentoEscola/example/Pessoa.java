package trabalhoGerenciamentoEscola.example;

public abstract class Pessoa{
    // Atributos
    private String nome;
    private String cpf;

    // Construtor com as devidas verificações
    public Pessoa(String nome, String cpf){
        if(nome.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.NOME_VAZIO);
        if (cpf.length() != 11)
            MensagensErro.adicionarErro(MensagensErro.CPF_INVALIDO);
        if(cpf.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.CPF_VAZIO);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
        this.nome = nome;
        this.cpf = cpf;
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

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
        this.cpf = cpf;
    }
}