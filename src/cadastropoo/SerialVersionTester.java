package cadastropoo;

import cadastropoo.model.*;
/**
 *
 * @author Cleyton
 */
public class SerialVersionTester {
    
    public SerialVersionTester() {
        Pessoa pessoa = new Pessoa();
        PessoaFisica pf = new PessoaFisica();
        PessoaJuridica pj = new PessoaJuridica();
        PessoaFisicaRepo pfr = new PessoaFisicaRepo();
        PessoaJuridicaRepo pjr = new PessoaJuridicaRepo();
        System.out.println(pessoa.getSerialVersionUID());
        System.out.println(pf.getSerialVersionUID());
        System.out.println(pj.getSerialVersionUID());
        System.out.println(pfr.getSerialVersionUID());
        System.out.println(pjr.getSerialVersionUID());
    }
    
    private void run() {
        
    }
    
    public static void main(String[] args) {
        new SerialVersionTester().run();
    }
    
}
