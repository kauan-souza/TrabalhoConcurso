public class Fiscal extends Pessoa implements Dominio{

    private String agencia;

    private String conta;

    private String pix;

    public Fiscal(String nome, int idade, String cpf, String email, String agencia, String conta) {
        super(nome, idade, cpf, email);
        this.agencia = agencia;
        this.conta = conta;
        validarContaAgencia();
    }

    public Fiscal(String nome, int idade, String cpf, String email, String pix) {
        super(nome, idade, cpf, email);
        this.pix = pix;
        validarPix();
    }

    public void validarPix() {
        if (pix == null) {
            mensagens.add("informe o pix");
        }
        validar();
    }

    public void validarContaAgencia() {
        validar();
        if (conta == null) {
            mensagens.add("informe a conta");
        }
        if (agencia == null) {
            mensagens.add("informe a agencia");
        }
    }

    @Override
    public void validar() {
        super.validar();
        if (!mensagens.isEmpty()) {
            throw new IllegalArgumentException(mensagens.toString());
        }
    }

    public String getAgencia() {
        return agencia;
    }

    public String getConta() {
        return conta;
    }

    public String getPix() {
        return pix;
    }

    @Override
    public Object getIid() {
        return getCpf();
    }
}
