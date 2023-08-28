/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo.model;

import java.io.Serializable;

/**
 *
 * @author Cleyton
 */
public class PessoaFisica extends Pessoa implements Serializable {
    
    private String cpf;
    private int idade;
    
    public PessoaFisica() {
        
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
    
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + getCpf());
        System.out.println("Idade: " + getIdade());
    }
    
}
