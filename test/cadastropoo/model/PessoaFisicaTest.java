package cadastropoo.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cleyton
 */
public class PessoaFisicaTest {
    
    public PessoaFisicaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getCpf method, of class PessoaFisica.
     */
    @Test
    public void testGetCpf() {
        System.out.println("getCpf");
        PessoaFisica instance = new PessoaFisica();
        String expResult = "";
        String result = instance.getCpf();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCpf method, of class PessoaFisica.
     */
    @Test
    public void testSetCpf() {
        System.out.println("setCpf");
        String cpf = "";
        PessoaFisica instance = new PessoaFisica();
        instance.setCpf(cpf);
    }

    /**
     * Test of getIdade method, of class PessoaFisica.
     */
    @Test
    public void testGetIdade() {
        System.out.println("getIdade");
        PessoaFisica instance = new PessoaFisica();
        int expResult = 0;
        int result = instance.getIdade();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdade method, of class PessoaFisica.
     */
    @Test
    public void testSetIdade() {
        System.out.println("setIdade");
        int idade = 0;
        PessoaFisica instance = new PessoaFisica();
        instance.setIdade(idade);
    }

    /**
     * Test of exibir method, of class PessoaFisica.
     */
    @Test
    public void testExibir() {
        System.out.println("exibir");
        PessoaFisica instance = new PessoaFisica();
        instance.exibir();
    }

    /**
     * Test of getSerialVersionUID method, of class PessoaFisica.
     */
    @Test
    public void testGetSerialVersionUID() {
        System.out.println("getSerialVersionUID");
        PessoaFisica instance = new PessoaFisica();
        long expResult = instance.getSerialVersionUID();
        long result = instance.getSerialVersionUID();
        assertEquals(expResult, result);
    }
    
}
