package cadastropoo.model;

import java.io.Serializable;

/**
 *
 * @author Cleyton
 */
public class PessoaJuridica extends Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String cnpj;
    
    public PessoaJuridica() {
        cnpj = "";
    }
    
    public PessoaJuridica(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public PessoaJuridica(int id, String nome, String cnpj) {
        setId(id);
        setNome(nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    /**
     * overriden method exibir()
     */
    public void exibir() {
        super.exibir();
        System.out.println("CNPJ: " + getCnpj());
    }
    
    @Override
    /**
     * overriden method getSerialVersionUID()
     */
    public long getSerialVersionUID() {
        return serialVersionUID;
    }
    
}
