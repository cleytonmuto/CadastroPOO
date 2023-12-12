package cadastropoo.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Cleyton
 */
public class PessoaJuridicaRepo implements Serializable{
    
    private static final long serialVersionUID = (long) (Long.MAX_VALUE * Math.random());
    private static final Logger LOGGER = Logger.getLogger(PessoaJuridicaRepo.class.getName());
    
    private ArrayList<PessoaJuridica> pessoasJuridicas;
    
    public PessoaJuridicaRepo() {
        pessoasJuridicas = new ArrayList<>();
    }
    
    public void inserir(PessoaJuridica pj) {
        pessoasJuridicas.add(pj);
    }
    
    public boolean alterar(PessoaJuridica pj) {
        int position = pessoasJuridicas.indexOf(pj);
        if (position != -1) {
            pessoasJuridicas.set(position, pj);
            return true;
        }
        return false;
    }
    
    public boolean excluir(int id) {
        return pessoasJuridicas.remove(obter(id));
    }
    
    public PessoaJuridica obter(int id) {
        return pessoasJuridicas.stream()
            .filter(pj -> pj.getId() == id)
            .findFirst()
            .orElse(null);
    }
    
    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoasJuridicas;
    }
    
    public void persistir(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(pessoasJuridicas);
        }
        catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        System.out.println("Dados de Pessoa Juridica Armazenados.");
    }
    
    public void recuperar(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            pessoasJuridicas = (ArrayList<PessoaJuridica>) ois.readObject();
        }
        catch (ClassNotFoundException e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        System.out.println("Dados de Pessoa Juridica Recuperados.");
    }
    
    public long getSerialVersionUID() {
        return serialVersionUID;
    }
}
