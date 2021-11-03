import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConcursoDAO implements GenericDAO <Concurso , Integer>{
    private List<Concurso> concursos = new ArrayList<>();

    public void salvarConcurso(Concurso novoConcurso) {
        for (Concurso concursoCadastrado : concursos) {
            if (concursoCadastrado.getNumeroIdentificador() == novoConcurso.getNumeroIdentificador()) {
                throw new IllegalArgumentException("Concurso já cadastrado.");
            }
        }
        this.concursos.add(novoConcurso);
    }

    public List<Concurso> filtrarConcursoPorCidade(String cidade){

        List<Concurso> concursoFiltrado = new ArrayList<>();

        for (Concurso concurso : concursos) {
            if(concurso.getLocal().contains(cidade)){
                concursoFiltrado.add(concurso);
            }
        }
        return concursoFiltrado;
    }
    public List<Concurso> filtrarConcursoPorEmpresa (String empresa) {

        List<Concurso> concursoFiltradoPorEmpresa = new ArrayList<>();

        for (Concurso concursoJaFiltradoPorEmpresa : concursos) {

            if (concursoJaFiltradoPorEmpresa.getEmpresa().contains(empresa)) {
                concursoFiltradoPorEmpresa.add(concursoJaFiltradoPorEmpresa);
            }
        }
        return concursoFiltradoPorEmpresa;
    }
    public List<Concurso> filtrarPorData (LocalDate dataInicial, LocalDate dataFinal){

        List<Concurso> concursoFiltradoPorData = new ArrayList<>();

        for (Concurso concurso : concursos){
            if (concurso.getDataHora().isBefore(dataFinal) && concurso.getDataHora().isAfter(dataInicial) ){
                concursoFiltradoPorData.add(concurso);
            }
        }
        return concursoFiltradoPorData;
    }
    public Concurso filtrarConcursoPorIdentificador(int numeroIdentificador) {

        for (Concurso concurso : concursos) {
            if (concurso.getNumeroIdentificador() == numeroIdentificador) {
                return concurso;
            }
        }
        return null;
    }
    public List<Concurso> filtrarPorNumeroParticipantes(int numeroParticipantes) {

        List<Concurso> concursoList = new ArrayList<>();

        for (Concurso concurso : concursos) {
            if (concurso.getParticipantes().size() == numeroParticipantes) {
                concursoList.add(concurso);
            }
        }

        return concursoList;
    }

    @Override
    public void add(Concurso model) {
        this.concursos.add(model);
    }

    @Override
    public List<Concurso> buscar() {
        return concursos;
    }

    @Override
    public Concurso filtrarPorId(Integer id) {
        for (Concurso concurso : concursos){
            if (concurso.getNumeroIdentificador() == id){
                return concurso;
            }
        }
        return null;
    }
}
