import java.util.ArrayList;
import java.util.List;

public class ConcursadoDAO implements GenericDAO <Concursado , Integer>{

    private List<Concursado> concursados = new ArrayList<>();

    public void salvarConcursado(Concursado novoConcursado) {

        for (Concursado concursado : concursados) {
            if (novoConcursado.getCpf().equals(concursado.getCpf())) {
                throw new IllegalArgumentException("Concursado já cadastrado.");
            }
        }
        this.concursados.add(novoConcursado);
    }

    @Override
    public void add(Concursado model) {
        this.concursados.add(model);
    }
    @Override
    public List<Concursado> buscar() {
        return concursados;
    }

    @Override
    public Concursado filtrarPorId(Integer id) {
        for (Concursado concursado : concursados){
                if (concursado.getCpf().equals(id)){
                    return concursado;
                }
            }
        return null;
    }

    public List<SituacaoConcurso> filtrarPorNotaAbaixoDaMedia() {
        List<SituacaoConcurso> concursadosAbaixodaMedia = new ArrayList<>();
            for (Concursado concursado : concursados) {
               concursadosAbaixodaMedia.addAll(concursado.reprovados());
            }
        return concursadosAbaixodaMedia;
    }
}