import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso implements Dominio{

    private LocalDate dataHora;

    private String empresa;

    private String local;

    private int numeroIdentificador;

    private List<Concursado> participantes = new ArrayList<>();

    public Concurso(LocalDate dataHora, String empresa, String local, int numeroIdentificador ) {
        this.dataHora = dataHora;
        this.empresa = empresa;
        this.local = local;
        this.numeroIdentificador = numeroIdentificador;
        validarID();
    }
    public void inscreverParticipante(Concursado novoParticipante) {
        for (Concursado inscrito : participantes) {
            if (inscrito.getCpf().equals(novoParticipante.getCpf())) {
                throw new IllegalArgumentException("participante ja cadastrado");
            }
        }
        this.participantes.add(novoParticipante);
    }
    public void validarID(){
        if (numeroIdentificador < 0){
            throw new IllegalArgumentException("numero identificador n aceito");
        }
    }

    public int getNumeroIdentificador() {
        return numeroIdentificador;
    }

    public void setNumeroIdentificador(int numeroIdentificador) {
        if (numeroIdentificador > 0) {
            this.numeroIdentificador = numeroIdentificador;
        } else {
            throw new IllegalArgumentException("numero identificador n aceito");
        }
    }

    public String getLocal() {
        return local;
    }

    public String getEmpresa() {
        return empresa;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public List<Concursado> getParticipantes() {
        return participantes;
    }

    public void setParticipante(List<Concursado> participante) {
        this.participantes = participante;
    }

    @Override
    public Object getIid() {
        return numeroIdentificador;
    }
}
