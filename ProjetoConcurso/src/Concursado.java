import java.util.ArrayList;
import java.util.List;

public class Concursado extends Pessoa implements Dominio {

    List<SituacaoConcurso> concursos;

    public Concursado(String nome, int idade, String cpf, String email , SituacaoConcurso concurso) {
        super(nome, idade, cpf, email);
        concursos = new ArrayList<>();
        addConcurso(concurso);
        validar();
    }
    public List<SituacaoConcurso> reprovados(){

        List <SituacaoConcurso> reprovados = new ArrayList<>();
        for (SituacaoConcurso situacao : concursos){
            if (situacao.getSituacao() == Situacao.REPROVADO){
                reprovados.add(situacao);
            }
        }
        return reprovados;
    }

    public void addConcurso(SituacaoConcurso novoConcurso){
        this.concursos.add(novoConcurso);
    }
    public void aprovarConcurso(int concursoId , int nota){
        for (SituacaoConcurso situacaoConcurso : concursos){
            if(situacaoConcurso.getConcurso().getNumeroIdentificador() == concursoId){
                situacaoConcurso.avaliar(nota);
            }
        }
    }
    public void pagarInscricao(int concursoId){
        for (SituacaoConcurso situacaoConcurso : concursos){
            if(situacaoConcurso.getConcurso().getNumeroIdentificador() == concursoId){
                situacaoConcurso.pagar();
            }
        }
    }
    @Override
    public void validar() {
        super.validar();
        if (!mensagens.isEmpty()) {
            throw new IllegalArgumentException(mensagens.toString());
        }
    }
    public List<SituacaoConcurso> getConcursos() {
        return concursos;
    }

    @Override
    public Object getIid() {
        return getCpf();
    }
}



