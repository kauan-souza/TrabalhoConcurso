import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FiscalTeste {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deveValidarPix() {
        Fiscal fiscal = new Fiscal("joao", 20, "1234567891", "aaa@gmail.com", "12345677");

        Assert.assertEquals("joao", fiscal.getNome());
        Assert.assertEquals(20, fiscal.getIdade());
        Assert.assertEquals("1234567891", fiscal.getCpf());
        Assert.assertEquals("aaa@gmail.com", fiscal.getEmail());
        Assert.assertEquals("12345677", fiscal.getPix());
    }

    @Test
    public void deveValidarAgenciaConta() {
        Fiscal fiscal = new Fiscal("joao", 20, "1234567891", "aaa@gmail.com", "12345678", "324923423");

        Assert.assertEquals("joao", fiscal.getNome());
        Assert.assertEquals(20, fiscal.getIdade());
        Assert.assertEquals("1234567891", fiscal.getCpf());
        Assert.assertEquals("aaa@gmail.com", fiscal.getEmail());
        Assert.assertEquals("12345678", fiscal.getAgencia());
        Assert.assertEquals("324923423", fiscal.getConta());
    }

    @Test
    public void naoDeveValidarPix() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("informe o pix");

        new Fiscal("joao", 20, "1234567891", "aaa@gmail.com", null);

    }
}

