import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {

    protected List<String> mensagens = new ArrayList<>();

    private String nome;

    private int idade;

    private String cpf;

    private String email;

    public Pessoa(String nome, int idade, String cpf, String email) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        validar();
    }

    protected void validar() {
        if (nome == null || nome.isBlank()) {
            mensagens.add("informe um nome");
        }
        if (idade == 0) {
            mensagens.add("informe uma idade");
        }
        if (cpf == null || cpf.isBlank()) {
            mensagens.add("informe um cpf");
        }
        if (!email.contains("@") || !email.contains(".com")) {
            mensagens.add("informe um email");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

}
