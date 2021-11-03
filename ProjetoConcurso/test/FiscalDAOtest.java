import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.List;

public class FiscalDAOtest {

    private FiscalDAO fiscalDAO;

    @Before
    public void iniciar(){
        fiscalDAO = new FiscalDAO();
    }
    @After
    public void limpar(){
        fiscalDAO.deletarTodos();
    }

    @Test
    public void deveAdd(){
        Fiscal fiscalInserido = new Fiscal("joao", 20, "1234567891", "aaa@gmail.com", "12345677");
        fiscalDAO.add(fiscalInserido);
        Fiscal fiscalEncontrado = fiscalDAO.filtrarPorId("1234567891");
        Assert.assertEquals(fiscalInserido.getNome() , fiscalEncontrado.getNome());
        Assert.assertEquals(fiscalInserido.getIdade() , fiscalEncontrado.getIdade());
        Assert.assertEquals(fiscalInserido.getCpf() , fiscalEncontrado.getCpf());
        Assert.assertEquals(fiscalInserido.getEmail() , fiscalEncontrado.getEmail());
        Assert.assertEquals(fiscalInserido.getPix() , fiscalEncontrado.getPix());

    }
    @Test
    public void DeveConectar(){
        FiscalDAO fiscalDAO = new FiscalDAO();
        Fiscal fiscal = new Fiscal("joao", 20, "1234567891", "aaa@gmail.com", "12345677" );

        fiscalDAO.add(fiscal);

    }
}
