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
public class PessoaJuridicaRepoTest {
    
    public PessoaJuridicaRepoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of inserir method, of class PessoaJuridicaRepo.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        PessoaJuridica pj = null;
        PessoaJuridicaRepo instance = new PessoaJuridicaRepo();
        instance.inserir(pj);
    }

    /**
     * Test of alterar method, of class PessoaJuridicaRepo.
     */
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        PessoaJuridica pj = null;
        PessoaJuridicaRepo instance = new PessoaJuridicaRepo();
        boolean expResult = false;
        boolean result = instance.alterar(pj);
        assertEquals(expResult, result);
    }

    /**
     * Test of excluir method, of class PessoaJuridicaRepo.
     */
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        int id = 0;
        PessoaJuridicaRepo instance = new PessoaJuridicaRepo();
        boolean expResult = false;
        boolean result = instance.excluir(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of obter method, of class PessoaJuridicaRepo.
     */
    @Test
    public void testObter() {
        System.out.println("obter");
        int id = 0;
        PessoaJuridicaRepo instance = new PessoaJuridicaRepo();
        PessoaJuridica expResult = null;
        PessoaJuridica result = instance.obter(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of obterTodos method, of class PessoaJuridicaRepo.
     */
    @Test
    public void testObterTodos() {
        System.out.println("obterTodos");
        PessoaJuridicaRepo instance = new PessoaJuridicaRepo();
        ArrayList<PessoaJuridica> expResult = instance.obterTodos();
        ArrayList<PessoaJuridica> result = instance.obterTodos();
        assertEquals(expResult, result);
    }

    /**
     * Test of persistir method, of class PessoaJuridicaRepo.
     */
    @Test
    public void testPersistir() {
        System.out.println("persistir");
        String filename = "";
        PessoaJuridicaRepo instance = new PessoaJuridicaRepo();
        instance.persistir(filename);
    }

    /**
     * Test of recuperar method, of class PessoaJuridicaRepo.
     */
    @Test
    public void testRecuperar() {
        System.out.println("recuperar");
        String filename = "";
        PessoaJuridicaRepo instance = new PessoaJuridicaRepo();
        instance.recuperar(filename);
    }

    /**
     * Test of getSerialVersionUID method, of class PessoaJuridicaRepo.
     */
    @Test
    public void testGetSerialVersionUID() {
        System.out.println("getSerialVersionUID");
        PessoaJuridicaRepo instance = new PessoaJuridicaRepo();
        long expResult = instance.getSerialVersionUID();
        long result = instance.getSerialVersionUID();
        assertEquals(expResult, result);
    }
    
}
