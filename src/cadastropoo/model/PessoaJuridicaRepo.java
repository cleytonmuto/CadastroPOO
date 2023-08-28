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
public class PessoaJuridicaRepo implements Serializable{
    
    private ArrayList<PessoaJuridica> pessoasJuridicas;
    
    public PessoaJuridicaRepo() {
        pessoasJuridicas = new ArrayList<PessoaJuridica>();
    }
    
    public void inserir(PessoaJuridica pf) {
        pessoasJuridicas.add(pf);
    }
    
    public void alterar(PessoaJuridica pf, int position) {
        pessoasJuridicas.set(position, pf);
    }
    
    public void excluir(PessoaJuridica pf) {
        pessoasJuridicas.remove(pf);
    }
    
    public PessoaJuridica obter(int position) {
        return pessoasJuridicas.get(position);
    }
    
    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoasJuridicas;
    }
    
    public void persistir(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pessoasJuridicas);
            oos.close();
            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Dados de Pessoa Juridica Armazenados.");
    }
    
    public void recuperar(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            pessoasJuridicas = (ArrayList<PessoaJuridica>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Dados de Pessoa Juridica Recuperados.");
    }
}
