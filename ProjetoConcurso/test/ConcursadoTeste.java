import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

public class ConcursadoTeste {

    @Test
    public void deveCriarUmConcursadoComSucesso() {
        LocalDate dataConcurso = LocalDate.now();
        Concurso concurso = new Concurso(dataConcurso, "procempa", "av ipiranga", 1);
        SituacaoConcurso aaa = new SituacaoConcurso(concurso);
        Concursado joao = new Concursado("Joao da Silva", 42, "13312312312", "joaoDaSilva@hotmail.com", aaa);

        Assert.assertEquals("Joao da Silva", joao.getNome());
        Assert.assertEquals("13312312312", joao.getCpf());
        Assert.assertEquals(42, joao.getIdade());
        Assert.assertEquals("joaoDaSilva@hotmail.com", joao.getEmail());
    }

    @Test
    public void deveValidarCpfDoConcursado() {

        LocalDate dataConcurso = LocalDate.now();
        Concurso concurso = new Concurso(dataConcurso, "procempa", "av ipiranga", 1);
        SituacaoConcurso aaa = new SituacaoConcurso(concurso);

        try {
            Concursado joao = new Concursado("Joao da Silva", 42, null, "joaoDaSilva@hotmail.com", aaa);
        } catch (IllegalArgumentException exception) {
            Assert.assertEquals("[informe um cpf]", exception.getMessage());
        }
    }

    @Test
    public void deveValidarEmailDoConcursado() {

        LocalDate dataConcurso = LocalDate.now();
        Concurso concurso = new Concurso(dataConcurso, "procempa", "av ipiranga", 1);
        SituacaoConcurso aaa = new SituacaoConcurso(concurso);

        try {
            Concursado joao = new Concursado("Joao da Silva", 42, "13312312312", "joaoDaSilva", aaa);
        } catch (IllegalArgumentException exception) {
            Assert.assertEquals("[informe um email]", exception.getMessage());
        }
    }
    @Test
    public void deveValidarIdadeDoConcursado() {

        LocalDate dataConcurso = LocalDate.now();
        Concurso concurso = new Concurso(dataConcurso, "procempa", "av ipiranga", 1);
        SituacaoConcurso aaa = new SituacaoConcurso(concurso);

        try {
            Concursado joao = new Concursado("Joao da Silva", 0, "13312312312", "joaoDaSilva@gmail.com", aaa);
        } catch (IllegalArgumentException exception) {
            Assert.assertEquals("[informe uma idade]", exception.getMessage());
        }
    }
    @Test
    public void deveValidarNomeDoConcursado() {

        LocalDate dataConcurso = LocalDate.now();
        Concurso concurso = new Concurso(dataConcurso, "procempa", "av ipiranga", 1);
        SituacaoConcurso aaa = new SituacaoConcurso(concurso);

        try {
            Concursado joao = new Concursado(null, 42, "13312312312", "joaoDaSilva@gmail.com", aaa);
        } catch (IllegalArgumentException exception) {
            Assert.assertEquals("[informe um nome]", exception.getMessage());
        }
    }
}
