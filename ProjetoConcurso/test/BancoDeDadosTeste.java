//import org.junit.Assert;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//
//import java.time.LocalDate;
//import java.util.List;
//
//public class BancoDeDadosTeste {
//
//    @Rule
//    public ExpectedException expectedException = ExpectedException.none();
//
//    @Test
//    public void deveCadastrarUmConcursoComSucesso(){
//
//        LocalDate dataConcurso = LocalDate.now();
//
//        Concurso procempa = new Concurso(dataConcurso , "procempa", "av ipiranga", 1);
//
//
//        BancoDeDados bancoDeDados = new BancoDeDados();
//        bancoDeDados.salvarConcurso(procempa);
//
//        Assert.assertEquals(1 ,bancoDeDados.getConcursos().size());
//    }
//
//    @Test
//    public void deveValidarCadastroDeUmconcursoPorIdentificador(){
//
//        expectedException.expect(IllegalArgumentException.class);
//        expectedException.expectMessage("Concurso já cadastrado.");
//
//        LocalDate dataConcurso = LocalDate.now();
//
//        Concurso procempa = new Concurso(dataConcurso , "procempa", "av ipiranga", 1);
//
//        BancoDeDados bancoDeDados = new BancoDeDados();
//        bancoDeDados.salvarConcurso(procempa);
//        bancoDeDados.salvarConcurso(procempa);
//    }
//
//    @Test
//    public void deveCriarUmConcursadoComSucesso() {
//
//        BancoDeDados bancoDeDados = new BancoDeDados();
//
//        LocalDate dataConcurso = LocalDate.now();
//
//        Concurso procempa = new Concurso(dataConcurso , "procempa", "av ipiranga", 1);
//
//        bancoDeDados.salvarConcurso(procempa);
//
//        Pessoa joao = new Pessoa("Joao da Silva", 42, "13312312312" , "joaoDaSilva@hotmail.com");
//
//        bancoDeDados.salvarConcursado(joao, procempa.getNumeroIdentificador());
//        Concurso concurso = bancoDeDados.filtrarConcursoPorIdentificador(procempa.getNumeroIdentificador());
//
//        Assert.assertEquals(1, concurso.getParticipantes().size());
//    }
//
//    @Test
//    public void deveValidarConcursadoRepetido() {
//
//        expectedException.expect(IllegalArgumentException.class);
//        expectedException.expectMessage("Concursado já cadastrado.");
//
//        BancoDeDados bancoDeDados = new BancoDeDados();
//
//        LocalDate dataConcurso = LocalDate.now();
//
//        Concurso procempa = new Concurso(dataConcurso , "procempa", "av ipiranga", 1);
//
//        bancoDeDados.salvarConcurso(procempa);
//
//        Pessoa joao = new Pessoa("Joao da Silva", 42, "13312312312" , "joaoDaSilva@hotmail.com");
//
//
//        bancoDeDados.salvarConcursado(joao, procempa.getNumeroIdentificador());
//        bancoDeDados.salvarConcursado(joao, procempa.getNumeroIdentificador());
//    }
//
//    @Test
//    public void deveFiltrarPorPeriodo(){
//
//        LocalDate dataConcurso = LocalDate.of(2021, 9, 1);
//        Concurso procempa = new Concurso(dataConcurso , "procempa", "av ipiranga", 1);
//
//
//        LocalDate dataConcursoProcergs = LocalDate.of(2021, 9, 10);
//        Concurso procergs = new Concurso(dataConcursoProcergs , "procempa", "av ipiranga", 2);
//
//        LocalDate dataConcursoEptc = LocalDate.of(2021, 9, 20);
//        Concurso eptc = new Concurso(dataConcursoEptc,"eptc" , "av ipiranga" , 3 );
//
//        BancoDeDados bancoDeDados = new BancoDeDados();
//        bancoDeDados.salvarConcurso(procempa);
//        bancoDeDados.salvarConcurso(procergs);
//        bancoDeDados.salvarConcurso(eptc);
//
//        LocalDate dataInicial = LocalDate.of(2021 , 9, 9);
//        LocalDate dataFinal = LocalDate.of(2021 , 9 , 25);
//        List<Concurso> concursos = bancoDeDados.filtrarPorData(dataInicial , dataFinal);
//
//        Assert.assertEquals(2, concursos.size());
//    }
//
//    @Test
//    public void naoADeveFiltrarComSucessoPorPeriodo(){
//
//        LocalDate dataConcurso = LocalDate.of(2021, 9, 1);
//        Concurso procempa = new Concurso(dataConcurso , "procempa", "av ipiranga", 1);
//
//        LocalDate dataConcursoProcergs = LocalDate.of(2021, 9, 10);
//        Concurso procergs = new Concurso(dataConcurso , "procergs", "av ipiranga", 2);
//
//        LocalDate dataConcursoEptc = LocalDate.of(2021, 9, 20);
//        Concurso eptc = new Concurso(dataConcursoEptc , "procergs", "av ipiranga", 3);
//
//
//        BancoDeDados bancoDeDados = new BancoDeDados();
//        bancoDeDados.salvarConcurso(procempa);
//        bancoDeDados.salvarConcurso(procergs);
//        bancoDeDados.salvarConcurso(eptc);
//
//        LocalDate dataInicial = LocalDate.of(2021 , 9, 21);
//        LocalDate dataFinal = LocalDate.of(2021 , 9 , 30);
//        List<Concurso> concursos = bancoDeDados.filtrarPorData(dataInicial , dataFinal);
//
//        Assert.assertEquals(0, concursos.size());
//    }
//
//    @Test
//    public void deveFiltrarConcursosComParticipantesReprovador(){
//
//        BancoDeDados bancoDeDados = new BancoDeDados();
//
//        LocalDate dataConcurso = LocalDate.now();
//        Concurso procempa = new Concurso(dataConcurso , "procempa", "av ipiranga", 1);
//
//        bancoDeDados.salvarConcurso(procempa);
//
//        Pessoa joao = new Pessoa("Joao da Silva", 42, "13312312312" , "joaoDaSilva@hotmail.com");
//
//        bancoDeDados.salvarConcursado(joao, procempa.getNumeroIdentificador());
//
//        List<Concurso> concursos = bancoDeDados.filtrarPorNotaAbaixoDaMedia();
//
//        Assert.assertEquals(1 ,concursos.size());
//    }
//
//    @Test
//    public void naoDeveFiltrarConcursosComParticipantesReprovados(){
//
//        BancoDeDados bancoDeDados = new BancoDeDados();
//
//        LocalDate dataConcurso = LocalDate.now();
//        Concurso procempa = new Concurso(dataConcurso , "procempa", "av ipiranga", 1);
//
//
//        bancoDeDados.salvarConcurso(procempa);
//
//        Pessoa joao = new Pessoa("Joao da Silva", 42, "13312312312" , "joaoDaSilva@hotmail.com");
//
//        bancoDeDados.salvarConcursado(joao, procempa.getNumeroIdentificador());
//
//        List<Concurso> concursos = bancoDeDados.filtrarPorNotaAbaixoDaMedia();
//
//        Assert.assertEquals(0, concursos.size());
//    }
//
//    @Test
//    public void deveFiltrarPorCidade(){
//
//        LocalDate dataConcurso = LocalDate.now();
//        Concurso procempa = new Concurso(dataConcurso , "procempa", "av ipiranga", 1);
//
//        LocalDate dataConcursoProcergs = LocalDate.now();
//        Concurso procergs = new Concurso(dataConcursoProcergs , "procergs", "av ipiranga", 2);
//
//        BancoDeDados bancoDeDados = new BancoDeDados();
//        bancoDeDados.salvarConcurso(procempa);
//        bancoDeDados.salvarConcurso(procergs);
//
//        List<Concurso> concursos = bancoDeDados.filtrarConcursoPorCidade("Porto Alegre");
//        Assert.assertEquals(1, concursos.size());
//
//    }
//
//    @Test
//    public void naoDeveFiltrarPorCidade(){
//
//        LocalDate dataConcurso = LocalDate.now();
//        Concurso procempa = new Concurso(dataConcurso , "procempa", "av ipiranga", 1);
//
//        LocalDate dataConcursoProcergs = LocalDate.now();
//        Concurso procergs = new Concurso(dataConcursoProcergs , "procergs", "av ipiranga", 2);
//
//        BancoDeDados bancoDeDados = new BancoDeDados();
//        bancoDeDados.salvarConcurso(procempa);
//        bancoDeDados.salvarConcurso(procergs);
//
//        List<Concurso> concursos = bancoDeDados.filtrarConcursoPorCidade("Cruz Alta");
//        Assert.assertEquals(0, concursos.size());
//    }
//
//    @Test
//    public void deveFiltrarConcursosPorNumeroParticipantes(){
//
//        LocalDate dataConcurso = LocalDate.now();
//        Concurso procempa = new Concurso(dataConcurso , "procempa", "av ipiranga", 1);
//
//        LocalDate dataConcursoProcergs = LocalDate.now();
//        Concurso procergs = new Concurso(dataConcursoProcergs , "procergs", "av ipiranga", 2);
//
//        BancoDeDados bancoDeDados = new BancoDeDados();
//        bancoDeDados.salvarConcurso(procempa);
//        bancoDeDados.salvarConcurso(procergs);
//
//        Pessoa joao = new Pessoa("joao da silva" , 42 , "13312312312" , "joaoDaSilva@hotmail.com");
//
//        Pessoa raul = new Pessoa("Raul da Silva" , 25 , "12345678911" , "rauldasilva@gmail.com");
//
//        Pessoa jose = new Pessoa("Jose da Silva", 42 , "12345678910" , "joseDaSilva@hotmail.com");
//
//        Pessoa maria = new Pessoa("Maria da Silva" , 25 , "12345678917" , "mariadasilva@gmail.com");
//
//
//        bancoDeDados.salvarConcursado(joao, 1);
//        bancoDeDados.salvarConcursado(raul, 1);
//        bancoDeDados.salvarConcursado(jose, 2);
//        bancoDeDados.salvarConcursado(maria, 2);
//
//        List<Concurso> concursos = bancoDeDados.filtrarPorNumeroParticipantes(2);
//        Assert.assertEquals(2, concursos.size());
//    }
//
//    @Test
//    public void naoDeveFiltrarConcursosPorNumeroParticipantes(){
//
//        LocalDate dataConcurso = LocalDate.now();
//        Concurso procempa = new Concurso(dataConcurso , "procempa", "av ipiranga", 1);
//
//        LocalDate dataConcursoProcergs = LocalDate.now();
//        Concurso procergs = new Concurso(dataConcursoProcergs , "procergs", "av ipiranga", 2);
//
//        BancoDeDados bancoDeDados = new BancoDeDados();
//        bancoDeDados.salvarConcurso(procempa);
//        bancoDeDados.salvarConcurso(procergs);
//
//        Pessoa joao = new Pessoa("joao da silva" , 42 , "13312312312" , "joaoDaSilva@hotmail.com");
//
//        Pessoa raul = new Pessoa("Raul da Silva" , 25 , "12345678911" , "rauldasilva@gmail.com");
//
//        Pessoa jose = new Pessoa("Jose da Silva", 42 , "12345678910" , "joseDaSilva@hotmail.com");
//
//        Pessoa maria = new Pessoa("Maria da Silva" , 25 , "12345678917" , "mariadasilva@gmail.com");
//
//        bancoDeDados.salvarConcursado(joao, 1);
//        bancoDeDados.salvarConcursado(raul, 1);
//        bancoDeDados.salvarConcursado(jose, 2);
//        bancoDeDados.salvarConcursado(maria, 2);
//
//        List<Concurso> concursos = bancoDeDados.filtrarPorNumeroParticipantes(20);
//        Assert.assertEquals(0, concursos.size());
//    }
//
//    @Test
//    public void deveFiltrarPorEmpresa(){
//
//        LocalDate dataConcurso = LocalDate.now();
//        Concurso procempa = new Concurso(dataConcurso , "procempa", "av ipiranga", 1);
//
//        LocalDate dataConcursoProcergs = LocalDate.now();
//        Concurso procergs = new Concurso(dataConcursoProcergs , "procergs", "av ipiranga", 2);
//
//        BancoDeDados bancoDeDados = new BancoDeDados();
//        bancoDeDados.salvarConcurso(procempa);
//        bancoDeDados.salvarConcurso(procergs);
//
//        List<Concurso> deveFiltrarEmpresa = bancoDeDados.filtrarConcursoPorEmpresa("procempa");
//        Assert.assertEquals(1, deveFiltrarEmpresa.size());
//    }
//
//    @Test
//    public void naoDeveFiltrarPorEmpresa(){
//
//        LocalDate dataConcurso = LocalDate.now();
//        Concurso procempa = new Concurso(dataConcurso , "procempa", "av ipiranga", 1);
//
//        LocalDate dataConcursoProcergs = LocalDate.now();
//        Concurso procergs = new Concurso(dataConcursoProcergs , "procergs", "av ipiranga", 2);
//
//        BancoDeDados bancoDeDados = new BancoDeDados();
//        bancoDeDados.salvarConcurso(procempa);
//        bancoDeDados.salvarConcurso(procergs);
//
//        List<Concurso> concursos = bancoDeDados.filtrarConcursoPorEmpresa("FGV");
//        Assert.assertEquals(0, concursos.size());
//    }
//
//}
