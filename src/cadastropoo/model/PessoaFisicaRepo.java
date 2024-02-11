package cadastropoo.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Cleyton
 */
public class PessoaFisicaRepo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(PessoaFisicaRepo.class.getName());
    
    private ArrayList<PessoaFisica> pessoasFisicas;
    
    public PessoaFisicaRepo() {
        pessoasFisicas = new ArrayList<>();
    }
    
    public boolean inserir(PessoaFisica pf) {
        return pessoasFisicas.contains(pf) ? false : pessoasFisicas.add(pf);
    }
        
    public boolean alterar(PessoaFisica pf) {
        int position = pessoasFisicas.indexOf(pf);
        if (position != -1) {
            pessoasFisicas.set(position, pf);
            return true;
        }
        return false;
    }
    
    public boolean excluir(int id) {
        return pessoasFisicas.remove(obter(id));
    }
    
    public PessoaFisica obter(int id) {
        return pessoasFisicas.stream()
            .filter(pf -> pf.getId() == id)
            .findFirst()
            .orElse(null);
    }
    
    public ArrayList<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }
    
    public void persistir(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(pessoasFisicas);
        }
        catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }
    
    public void recuperar(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            pessoasFisicas = (ArrayList<PessoaFisica>) ois.readObject();
        }
        catch (ClassNotFoundException e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

}
