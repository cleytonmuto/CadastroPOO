package cadastropoo.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cleyton
 */
public class PessoaJuridicaTest {
    
    public PessoaJuridicaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getCnpj method, of class PessoaJuridica.
     */
    @Test
    public void testGetCnpj() {
        System.out.println("getCnpj");
        PessoaJuridica instance = new PessoaJuridica();
        String expResult = "";
        String result = instance.getCnpj();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCnpj method, of class PessoaJuridica.
     */
    @Test
    public void testSetCnpj() {
        System.out.println("setCnpj");
        String cnpj = "";
        PessoaJuridica instance = new PessoaJuridica();
        instance.setCnpj(cnpj);
    }

    /**
     * Test of exibir method, of class PessoaJuridica.
     */
    @Test
    public void testExibir() {
        System.out.println("exibir");
        PessoaJuridica instance = new PessoaJuridica();
        instance.exibir();
    }

    /**
     * Test of getSerialVersionUID method, of class PessoaJuridica.
     */
    @Test
    public void testGetSerialVersionUID() {
        System.out.println("getSerialVersionUID");
        PessoaJuridica instance = new PessoaJuridica();
        long expResult = instance.getSerialVersionUID();
        long result = instance.getSerialVersionUID();
        assertEquals(expResult, result);
    }
    
}
