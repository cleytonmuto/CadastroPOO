package cadastropoo.model;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cleyton
 */
public class PessoaFisicaRepoTest {
    
    public PessoaFisicaRepoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of inserir method, of class PessoaFisicaRepo.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        PessoaFisica pf = null;
        PessoaFisicaRepo instance = new PessoaFisicaRepo();
        instance.inserir(pf);
    }

    /**
     * Test of alterar method, of class PessoaFisicaRepo.
     */
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        PessoaFisica pf = null;
        PessoaFisicaRepo instance = new PessoaFisicaRepo();
        boolean expResult = false;
        boolean result = instance.alterar(pf);
        assertEquals(expResult, result);
    }

    /**
     * Test of excluir method, of class PessoaFisicaRepo.
     */
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        int id = 0;
        PessoaFisicaRepo instance = new PessoaFisicaRepo();
        boolean expResult = false;
        boolean result = instance.excluir(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of obter method, of class PessoaFisicaRepo.
     */
    @Test
    public void testObter() {
        System.out.println("obter");
        int id = 0;
        PessoaFisicaRepo instance = new PessoaFisicaRepo();
        PessoaFisica expResult = null;
        PessoaFisica result = instance.obter(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of obterTodos method, of class PessoaFisicaRepo.
     */
    @Test
    public void testObterTodos() {
        System.out.println("obterTodos");
        PessoaFisicaRepo instance = new PessoaFisicaRepo();
        ArrayList<PessoaFisica> expResult = instance.obterTodos();
        ArrayList<PessoaFisica> result = instance.obterTodos();
        assertEquals(expResult, result);
    }

    /**
     * Test of persistir method, of class PessoaFisicaRepo.
     */
    @Test
    public void testPersistir() {
        System.out.println("persistir");
        String filename = "";
        PessoaFisicaRepo instance = new PessoaFisicaRepo();
        instance.persistir(filename);
    }

    /**
     * Test of recuperar method, of class PessoaFisicaRepo.
     */
    @Test
    public void testRecuperar() {
        System.out.println("recuperar");
        String filename = "";
        PessoaFisicaRepo instance = new PessoaFisicaRepo();
        instance.recuperar(filename);
    }

    /**
     * Test of getSerialVersionUID method, of class PessoaFisicaRepo.
     */
    @Test
    public void testGetSerialVersionUID() {
        System.out.println("getSerialVersionUID");
        PessoaFisicaRepo instance = new PessoaFisicaRepo();
        long expResult = instance.getSerialVersionUID();
        long result = instance.getSerialVersionUID();
        assertEquals(expResult, result);
    }
    
}
