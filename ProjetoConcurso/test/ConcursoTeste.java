import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

public class ConcursoTeste {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deveCriarUmConcursoValido() {
        LocalDate dataConcurso = LocalDate.now();

        Concurso procempa = new Concurso(dataConcurso, "procempa", "av ipiranga", 1);
    }

    @Test
    public void naoDeveValidarUmConcursoComIdentificadorNegativo() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("numero identificador n aceito");

        LocalDate dataConcurso = LocalDate.now();

        Concurso procempa = new Concurso(dataConcurso, "procempa", "av ipiranga", -1);

    }

    @Test
    public void deveRealizarInscricaoParticipanteComSucesso() {
        LocalDate dataConcurso = LocalDate.now().plusMonths(1);
        Concurso concurso = new Concurso(dataConcurso, "procempa", "av ipiranga", 1);
        SituacaoConcurso aaa = new SituacaoConcurso(concurso);
        Concursado claudio = new Concursado("claudio", 47, "12345678901", "claudinho@gmail.com", aaa);

        concurso.inscreverParticipante(claudio);
    }

    @Test
    public void naoDeveRealizarInscricaodeParticipanteJaInscrito() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("participante ja cadastrado");

        LocalDate dataConcurso = LocalDate.now();
        Concurso concurso = new Concurso(dataConcurso, "procempa", "av ipiranga", 1);

        SituacaoConcurso aaa = new SituacaoConcurso(concurso);
        Concursado dagoberto = new Concursado("dagoberto", 27, "12345678902", "dago.@gmail.com", aaa);
        Concursado claudio = new Concursado("claudio", 47, "12345678901", "claudinho@gmail.com", aaa);

        concurso.inscreverParticipante(claudio);
        concurso.inscreverParticipante(dagoberto);

        Assert.assertEquals(2, concurso.getParticipantes().size());

        concurso.inscreverParticipante(claudio);
    }

}

