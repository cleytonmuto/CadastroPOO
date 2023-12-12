package cadastropoo;

import cadastropoo.model.*;
import java.util.Scanner;

/**
 *
 * @author Cleyton
 */
public class CadastroPOO {
    
    private final String FILE1 = "resources/pf.dat";
    private final String FILE2 = "resources/pj.dat";

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
        repo1.persistir(FILE1);
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        repo2.recuperar(FILE1);
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
        repo3.persistir(FILE2);
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        repo4.recuperar(FILE2);
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
                    String escolhaIncluir = in.nextLine().toUpperCase();
                    if (escolhaIncluir.equals("F")) {
                        System.out.print("Informe o ID da Pessoa Fisica: ");
                        int id = Integer.valueOf(in.nextLine());
                        System.out.print("Informe o nome da Pessoa Fisica: ");
                        String nome = in.nextLine();
                        System.out.print("Informe o CPF da Pessoa Fisica: ");
                        String cpf = in.nextLine();
                        System.out.print("Informe o idade da Pessoa Fisica: ");
                        int idade = Integer.valueOf(in.nextLine());
                        PessoaFisica pf = new PessoaFisica(id, nome, cpf, idade);
                        PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
                        repoPF.recuperar(FILE1);
                        repoPF.inserir(pf);
                        repoPF.persistir(FILE1);
                    }
                    else if (escolhaIncluir.equals("J")) {
                        System.out.print("Informe o ID da Pessoa Juridica: ");
                        int id = Integer.valueOf(in.nextLine());
                        System.out.print("Informe o nome da Pessoa Juridica: ");
                        String nome = in.nextLine();
                        System.out.print("Informe o CNPJ da Pessoa Juridica: ");
                        String cnpj = in.nextLine();
                        PessoaJuridica pj = new PessoaJuridica(id, nome, cnpj);
                        PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();
                        repoPJ.recuperar(FILE2);
                        repoPJ.inserir(pj);
                        repoPJ.persistir(FILE2);
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
