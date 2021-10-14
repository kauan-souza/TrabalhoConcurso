import java.util.List;

public class SituacaoConcurso {

    List<Concurso> concursoRealizado;

    private Concurso concurso;

    private Situacao situacao;

    private int nota;

    private String statusPagamento;

    public SituacaoConcurso(Concurso concurso) {
        this.concurso = concurso;
        this.situacao = Situacao.EM_AVALIACAO;
        this.nota = nota;
        this.statusPagamento = "PENDENTE";
    }
    public void aprovar(){
        this.situacao = Situacao.APROVADO;
    }

    public void avaliar(int nota){
        if(!this.statusPagamento.equals("PAGO")){
            throw new IllegalArgumentException("nao pode avaliar pois foi pago a inscricao");
        }
        this.nota = nota;
        if (nota < 7){
            this.situacao = Situacao.REPROVADO;
        }else{
            this.situacao = Situacao.APROVADO;
        }
    }
    public void pagar(){
        this.statusPagamento = "PAGO";
    }
    public void validar(){
        if(situacao == null){
            throw new IllegalArgumentException("situacao obrigatoria");
        }
    }

    public List<Concurso> getConcursoRealizado() {
        return concursoRealizado;
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public int getNota() {
        return nota;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }
}

