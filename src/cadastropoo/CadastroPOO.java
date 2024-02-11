package cadastropoo;

import cadastropoo.model.*;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Cleyton
 */
public class CadastroPOO {
    
    private static final Logger LOGGER = Logger.getLogger(CadastroPOO.class.getName());
    private final String FILE1;
    private final String FILE2;
    private Scanner in;
    
    public CadastroPOO() {
        FILE1 = "resources/pf.dat";
        FILE2 = "resources/pj.dat";
        in = new Scanner(System.in);
    }
    
    private void runTestMode() {
        pfTest();
        pjTest();
    }
    
    private void pfTest() {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaFisica pf1 = new PessoaFisica(1, "Ana", "11111111111", 25);
        PessoaFisica pf2 = new PessoaFisica(2, "Carlos", "22222222222", 52);
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
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        PessoaJuridica pj1 = new PessoaJuridica(3, "XPTO Sales", "333333333333");
        PessoaJuridica pj2 = new PessoaJuridica(4, "XPTO Solutions", "444444444444");
        repo3.inserir(pj1);
        repo3.inserir(pj2);
        repo3.persistir(FILE2);
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        repo4.recuperar(FILE2);
        for (PessoaJuridica pj : repo4.obterTodos()) {
            pj.exibir();
        }
    }
    
    private String strAnswerQuestion(String question) {
        System.out.print(question);
        return in.nextLine();
    }
    
    private int intAnswerQuestion(String question) {
        System.out.print(question);
        String strValue = in.nextLine();
        int intValue = 0;
        try {
            intValue = Integer.valueOf(strValue);
        }
        catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return intValue;
    }
    
    private void runMenuMode() {
        String opcao = "";
        while (!opcao.equals("0")) {
            printMenu();
            opcao = strAnswerQuestion("ESCOLHA: ");
            switch (opcao) {
                case "1": {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String escolhaIncluir = strAnswerQuestion("TIPO DE PESSOA: ").toUpperCase();
                    if (escolhaIncluir.equals("F")) {
                        int id = intAnswerQuestion("Informe o ID da Pessoa Fisica: ");
                        String nome = strAnswerQuestion("Informe o nome da Pessoa Fisica: ");
                        String cpf = strAnswerQuestion("Informe o CPF da Pessoa Fisica: ");
                        int idade = intAnswerQuestion("Informe o idade da Pessoa Fisica: ");
                        PessoaFisica pf = new PessoaFisica(id, nome, cpf, idade);
                        PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
                        repoPF.inserir(FILE1, pf);
                    }
                    else if (escolhaIncluir.equals("J")) {
                        int id = intAnswerQuestion("Informe o ID da Pessoa Juridica: ");
                        String nome = strAnswerQuestion("Informe o nome da Pessoa Juridica: ");
                        String cnpj = strAnswerQuestion("Informe o CNPJ da Pessoa Juridica: ");
                        PessoaJuridica pj = new PessoaJuridica(id, nome, cnpj);
                        PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();
                        repoPJ.inserir(FILE2, pj);
                    }
                    else {
                        System.out.println("Erro: Escolha Invalida!");
                    }
                }; break;
                case "2": {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String escolhaAlterar = strAnswerQuestion("TIPO DE PESSOA: ").toUpperCase();
                    if (escolhaAlterar.equals("F")) {
                        int id = intAnswerQuestion("Informe o ID da Pessoa Fisica: ");
                        String nome = strAnswerQuestion("Informe o nome da Pessoa Fisica: ");
                        String cpf = strAnswerQuestion("Informe o CPF da Pessoa Fisica: ");
                        int idade = intAnswerQuestion("Informe o idade da Pessoa Fisica: ");
                        PessoaFisica pf = new PessoaFisica(id, nome, cpf, idade);
                        PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
                        repoPF.alterar(FILE1, pf);
                    }
                    else if (escolhaAlterar.equals("J")) {
                        int id = intAnswerQuestion("Informe o ID da Pessoa Juridica: ");
                        String nome = strAnswerQuestion("Informe o nome da Pessoa Juridica: ");
                        String cnpj = strAnswerQuestion("Informe o CNPJ da Pessoa Juridica: ");
                        PessoaJuridica pj = new PessoaJuridica(id, nome, cnpj);
                        PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();
                        repoPJ.alterar(FILE2, pj);
                    }
                    else {
                        System.out.println("Erro: Escolha Invalida!");
                    }
                }; break;
                case "3": {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String escolhaExcluir = strAnswerQuestion("TIPO DE PESSOA: ").toUpperCase();
                    if (escolhaExcluir.equals("F")) {
                        PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
                        repoPF.excluir(FILE1, intAnswerQuestion("Informe o ID da Pessoa Fisica: "));
                    }
                    else if (escolhaExcluir.equals("J")) {
                        PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();
                        repoPJ.excluir(FILE2, intAnswerQuestion("Informe o ID da Pessoa Juridica: "));
                    }
                    else {
                        System.out.println("Erro: Escolha Invalida!");
                    }
                }; break;
                case "4": {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String escolhaExibir = strAnswerQuestion("TIPO DE PESSOA: ").toUpperCase();
                    if (escolhaExibir.equals("F")) {
                        PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
                        repoPF.recuperar(FILE1);
                        repoPF.obter(intAnswerQuestion("Informe o ID da Pessoa Fisica: ")).exibir();
                        repoPF.persistir(FILE1);
                    }
                    else if (escolhaExibir.equals("J")) {
                        PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();
                        repoPJ.recuperar(FILE2);
                        repoPJ.obter(intAnswerQuestion("Informe o ID da Pessoa Juridica: ")).exibir();
                        repoPJ.persistir(FILE2);
                    }
                    else {
                        System.out.println("Erro: Escolha Invalida!");
                    }
                }; break;
                case "5": {
                    PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
                    repoPF.recuperar(FILE1);
                    PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();
                    repoPJ.recuperar(FILE2);
                    for (PessoaFisica pf : repoPF.obterTodos()) {
                        pf.exibir();
                    }
                    for (PessoaJuridica pj : repoPJ.obterTodos()) {
                        pj.exibir();
                    }
                }; break;
                case "6": break;
                case "7": break;
                default: {
                    System.out.println("Escolha invalida!");
                }; break;
            }
        }
    }
    
    private void printMenu() {
        System.out.println("\nMENU:");
        System.out.println("==============================");
        System.out.println("1 - Incluir Pessoa");
        System.out.println("2 - Alterar Pessoa");
        System.out.println("3 - Excluir Pessoa");
        System.out.println("4 - Buscar pelo ID");
        System.out.println("5 - Exibir Todos");
        System.out.println("6 - Salvar Dados");
        System.out.println("7 - Recuperar Todos");
        System.out.println("0 - Sair");
        System.out.println("==============================");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CadastroPOO obj = new CadastroPOO();
        obj.runTestMode();
        obj.runMenuMode();
    }
    
}
