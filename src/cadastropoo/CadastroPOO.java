package cadastropoo;

import cadastropoo.model.*;
import java.util.Scanner;

/**
 *
 * @author Cleyton
 */
public class CadastroPOO {

    public CadastroPOO() {
        
    }
    
    private void run() {
        pfTest();
        pjTest();
    }
    
    private void pfTest() {
        PessoaFisica pf1 = new PessoaFisica(1, "Ana", "11111111111", 25);
        PessoaFisica pf2 = new PessoaFisica(2, "Carlos", "22222222222", 52);
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        repo1.inserir(pf1);
        repo1.inserir(pf2);
        repo1.persistir("pf.dat");
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        repo2.recuperar("pf.dat");
        for (PessoaFisica pf : repo2.obterTodos()) {
            pf.exibir();
        }
    }
    
    private void pjTest() {
        PessoaJuridica pj1 = new PessoaJuridica(3, "XPTO Sales", "333333333333");
        PessoaJuridica pj2 = new PessoaJuridica(4, "XPTO Solutions", "444444444444");
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(pj1);
        repo3.inserir(pj2);
        repo3.persistir("pj.dat");
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        repo4.recuperar("pj.dat");
        for (PessoaJuridica pj : repo4.obterTodos()) {
            pj.exibir();
        }
    }
    
    private void runMenuMode() {
        Scanner in = new Scanner(System.in);
        String opcao = "";
        while (!opcao.equals("0")) {
            menu();
            opcao = in.nextLine();
            switch (opcao) {
                case "1": {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    System.out.print("ESCOLHA: ");
                    String escolhaIncluir = in.nextLine();
                    if (escolhaIncluir.equals("F")) {
                        System.out.print("Informe o id da pessoa: ");
                        int id = Integer.valueOf(in.nextLine());
                        System.out.print("Informe o nome da pessoa: ");
                        String nome = in.nextLine();
                        System.out.print("Informe o CPF da pessoa: ");
                        String cpf = in.nextLine();
                        System.out.print("Informe o idade da pessoa: ");
                        int idade = Integer.valueOf(in.nextLine());
                        PessoaFisica pf = new PessoaFisica(id, nome, cpf, idade);
                        PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
                        repoPF.recuperar("pf.dat");
                        repoPF.inserir(pf);
                        repoPF.persistir("pf.dat");
                    }
                    else if (escolhaIncluir.equals("J")) {
                        System.out.print("Informe o id da pessoa: ");
                        int id = Integer.valueOf(in.nextLine());
                        System.out.print("Informe o nome da pessoa: ");
                        String nome = in.nextLine();
                        System.out.print("Informe o CNPJ da pessoa: ");
                        String cnpj = in.nextLine();
                        PessoaJuridica pj = new PessoaJuridica(id, nome, cnpj);
                        PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();
                        repoPJ.recuperar("pj.dat");
                        repoPJ.inserir(pj);
                        repoPJ.persistir("pj.dat");
                    }
                    else {
                        System.out.println("Erro: Escolha Invalida!");
                    }
                }; break;
                case "2": break;
                case "3": break;
                case "4": break;
                case "5": break;
                case "6": break;
                case "7": break;
                default: break;
            }
        }
    }
    
    private void menu() {
        System.out.println("\n==============================");
        System.out.println("1 - Incluir Pessoa");
        System.out.println("2 - Alterar Pessoa");
        System.out.println("3 - Excluir Pessoa");
        System.out.println("4 - Buscar pelo ID");
        System.out.println("5 - Exibir Todos");
        System.out.println("6 - Persistir Dados");
        System.out.println("7 - Recuperar Todos");
        System.out.println("0 - Finalizar Programa");
        System.out.println("==============================");
        System.out.print("ESCOLHA: ");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CadastroPOO obj = new CadastroPOO();
        obj.run();
        obj.runMenuMode();
    }
    
}
