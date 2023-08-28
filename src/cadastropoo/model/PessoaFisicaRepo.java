/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Cleyton
 */
public class PessoaFisicaRepo implements Serializable {
    
    private ArrayList<PessoaFisica> pessoasFisicas;
    
    public PessoaFisicaRepo() {
        pessoasFisicas = new ArrayList<PessoaFisica>();
    }
    
    public void inserir(PessoaFisica pf) {
        pessoasFisicas.add(pf);
    }
    
    public void alterar(PessoaFisica pf, int position) {
        pessoasFisicas.set(position, pf);
    }
    
    public void excluir(PessoaFisica pf) {
        pessoasFisicas.remove(pf);
    }
    
    public PessoaFisica obter(int position) {
        return pessoasFisicas.get(position);
    }
    
    public ArrayList<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }
    
    public void persistir(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pessoasFisicas);
            oos.close();
            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Dados de Pessoa Fisica Armazenados.");
    }
    
    public void recuperar(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            pessoasFisicas = (ArrayList<PessoaFisica>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Dados de Pessoa Fisica Recuperados.");
    }
    
}
