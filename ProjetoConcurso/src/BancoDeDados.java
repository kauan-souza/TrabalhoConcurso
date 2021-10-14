import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private List<Pessoa> concursados = new ArrayList<>();

    private List<Concurso> concursos = new ArrayList<>();

    public void salvarConcurso(Concurso novoConcurso) {
        for (Concurso concursoCadastrado : concursos) {
            if (concursoCadastrado.getNumeroIdentificador() == novoConcurso.getNumeroIdentificador()) {
                throw new IllegalArgumentException("Concurso já cadastrado.");
            }
        }
        this.concursos.add(novoConcurso);
    }

//    public void salvarConcursado(Pessoa novoConcursado, int numeroIdentificador) {
//
//        Concurso concursoFiltrado = filtrarConcursoPorIdentificador(numeroIdentificador);
//
//        for (Pessoa concursado : concursoFiltrado.getParticipantes()) {
//            if (novoConcursado.getCpf().equals(concursado.getCpf())) {
//                throw new IllegalArgumentException("Concursado já cadastrado.");
//            }
//        }
//
//        for (Concurso concurso : concursos) {
//            if (concursoFiltrado.getNumeroIdentificador() == concurso.getNumeroIdentificador()) {
//                concurso.add(novoConcursado);
//            }
//        }
//    }

    public List<Concurso> filtrarConcursoPorCidade(String cidade){

        List<Concurso> concursoFiltrado = new ArrayList<>();

        for (Concurso concurso : concursos) {
            if(concurso.getLocal().contains(cidade)){
                concursoFiltrado.add(concurso);
            }
        }
        return concursoFiltrado;
    }

    public List<Concurso> filtrarConcursoPorEmpresa (String empresa){

        List<Concurso> concursoFiltradoPorEmpresa = new ArrayList<>();

        for (Concurso concursoJaFiltradoPorEmpresa : concursos){

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

//    public List<Concurso> filtrarPorNotaAbaixoDaMedia() {
//
//        List<Concurso> concursosComParticipantesAbaixodaMedia = new ArrayList<>();
//
//        for (Concurso concurso : concursos) {
//
//            for (Pessoa concursado : concurso.getParticipantes()) {
//                if (concursado.getNota() < 7) {
//                    concursosComParticipantesAbaixodaMedia.add(concurso);
//                }
//            }
//        }
//
//        return concursosComParticipantesAbaixodaMedia;
//    }

    public List<Concurso> filtrarPorNumeroParticipantes(int numeroParticipantes) {

        List<Concurso> concursoList = new ArrayList<>();

        for (Concurso concurso : concursos) {
            if (concurso.getParticipantes().size() == numeroParticipantes) {
                concursoList.add(concurso);
            }
        }

        return concursoList;
    }

    public List<Concurso> getConcursos(){
        return concursos;
    }

    public List<Pessoa> getConcursados(){
        return concursados;
    }

}