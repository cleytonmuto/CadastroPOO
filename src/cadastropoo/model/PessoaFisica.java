package cadastropoo.model;

import java.io.Serializable;

/**
 *
 * @author Cleyton
 */
public class PessoaFisica extends Pessoa implements Serializable {
    
    private static final long serialVersionUID = (long) (Long.MAX_VALUE * Math.random());
    
    private String cpf;
    private int idade;
    
    public PessoaFisica() {
        cpf = "";
        idade = 0;
    }
    
    public PessoaFisica(String cpf, int idade) {
        this.cpf = cpf;
        this.idade = idade;
    }
    
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        setId(id);
        setNome(nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    @Override
    /**
     * overriden method exibir()
     */
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + getCpf());
        System.out.println("Idade: " + getIdade());
    }
    
    @Override
    /**
     * overriden method getSerialVersionUID()
     */
    public long getSerialVersionUID() {
        return serialVersionUID;
    }
    
}
