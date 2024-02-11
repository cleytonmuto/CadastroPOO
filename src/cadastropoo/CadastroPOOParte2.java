package cadastropoo;

import cadastropoo.model.*;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.File;

/**
 *
 * @author Cleyton
 */
public class CadastroPOOParte2 {
    
    private static final Logger LOGGER = Logger.getLogger(CadastroPOOParte1.class.getName());
    private Scanner in;
    private PessoaFisicaRepo repoPF;
    private PessoaJuridicaRepo repoPJ;
    
    public CadastroPOOParte2() {
        in = new Scanner(System.in);
        repoPF = new PessoaFisicaRepo();
        repoPJ = new PessoaJuridicaRepo();
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
    
    private void run() {
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
                        repoPF.inserir(new PessoaFisica(id, nome, cpf, idade));
                    }
                    else if (escolhaIncluir.equals("J")) {
                        int id = intAnswerQuestion("Informe o ID da Pessoa Juridica: ");
                        String nome = strAnswerQuestion("Informe o nome da Pessoa Juridica: ");
                        String cnpj = strAnswerQuestion("Informe o CNPJ da Pessoa Juridica: ");
                        repoPJ.inserir(new PessoaJuridica(id, nome, cnpj));
                    }
                    else {
                        System.out.println("Erro: Escolha Invalida!");
                    }
                }; break;
                case "2": {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String escolhaAlterar = strAnswerQuestion("TIPO DE PESSOA: ").toUpperCase();
                    if (escolhaAlterar.equals("F")) {
                        try {
                            int id = intAnswerQuestion("Informe o ID da Pessoa Fisica: ");
                            repoPF.obter(id);
                            String nome = strAnswerQuestion("Informe o nome da Pessoa Fisica: ");
                            String cpf = strAnswerQuestion("Informe o CPF da Pessoa Fisica: ");
                            int idade = intAnswerQuestion("Informe o idade da Pessoa Fisica: ");
                            repoPF.alterar(new PessoaFisica(id, nome, cpf, idade));
                        }
                        catch (NullPointerException e){
                            System.err.println("ID nao encontrado!");
                            LOGGER.log(Level.SEVERE, e.toString(), e);
                        }
                    }
                    else if (escolhaAlterar.equals("J")) {
                        try {
                            int id = intAnswerQuestion("Informe o ID da Pessoa Juridica: ");
                            String nome = strAnswerQuestion("Informe o nome da Pessoa Juridica: ");
                            String cnpj = strAnswerQuestion("Informe o CNPJ da Pessoa Juridica: ");
                            repoPJ.alterar(new PessoaJuridica(id, nome, cnpj));
                        }
                        catch (NullPointerException e){
                            System.err.println("ID nao encontrado!");
                            LOGGER.log(Level.SEVERE, e.toString(), e);
                        }
                    }
                    else {
                        System.out.println("Erro: Escolha Invalida!");
                    }
                }; break;
                case "3": {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String escolhaExcluir = strAnswerQuestion("TIPO DE PESSOA: ").toUpperCase();
                    if (escolhaExcluir.equals("F")) {
                        System.out.println(repoPF.excluir(intAnswerQuestion("Informe o ID da Pessoa Fisica: ")) ?
                            "Excluido com sucesso." : "ID nao encontrado." );
                    }
                    else if (escolhaExcluir.equals("J")) {
                        System.out.println(repoPJ.excluir(intAnswerQuestion("Informe o ID da Pessoa Juridica: ")) ?
                            "Excluido com sucesso." : "ID nao encontrado." );
                    }
                    else {
                        System.out.println("Erro: Escolha Invalida!");
                    }
                }; break;
                case "4": {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String escolhaExibir = strAnswerQuestion("TIPO DE PESSOA: ").toUpperCase();
                    if (escolhaExibir.equals("F")) {
                        try {
                            repoPF.obter(intAnswerQuestion("Informe o ID da Pessoa Fisica: ")).exibir();
                        }
                        catch (NullPointerException e){
                            System.err.println("Pessoa nao encontrada!");
                            LOGGER.log(Level.SEVERE, e.toString(), e);
                        }
                    }
                    else if (escolhaExibir.equals("J")) {
                        try {
                            repoPJ.obter(intAnswerQuestion("Informe o ID da Pessoa Juridica: ")).exibir();
                        }
                        catch (NullPointerException e){
                            System.err.println("Pessoa nao encontrada!");
                            LOGGER.log(Level.SEVERE, e.toString(), e);
                        }
                    }
                    else {
                        System.out.println("Erro: Escolha Invalida!");
                    }
                }; break;
                case "5": {
                    System.out.println();
                    for (PessoaFisica pf : repoPF.obterTodos()) {
                        pf.exibir();
                    }
                    for (PessoaJuridica pj : repoPJ.obterTodos()) {
                        pj.exibir();
                    }
                }; break;
                case "6": {
                    String prefixo = strAnswerQuestion("Informe o prefixo do arquivo: ");
                    String pfFilename = "resources/".concat(prefixo.concat(".fisica.bin"));
                    String pjFilename = "resources/".concat(prefixo.concat(".juridica.bin"));
                    repoPF.persistir(pfFilename);
                    repoPJ.persistir(pjFilename);
                    System.out.println("Dados persistidos com sucesso.");
                };break;
                case "7": {
                    String prefixo = strAnswerQuestion("Informe o prefixo do arquivo: ");
                    String pfFilename = "resources/".concat(prefixo.concat(".fisica.bin"));
                    String pjFilename = "resources/".concat(prefixo.concat(".juridica.bin"));
                    File pfFile = new File(pfFilename);
                    File pjFile = new File(pjFilename);
                    if (pfFile.exists() && pjFile.exists()) {
                        repoPF.recuperar(pfFilename);
                        repoPJ.recuperar(pjFilename);
                        System.out.println("Dados recuperados com sucesso.");
                    }
                    else {
                        System.out.println("Prefixo invalido. Arquivo nao encontrado.");
                    }
                }; break;
                default: {
                    System.out.println("Escolha invalida!");
                }; break;
            }
        }
    }
    
    private void printMenu() {
        System.out.println("\n==============================");
        System.out.println("1 - Incluir Pessoa");
        System.out.println("2 - Alterar Pessoa");
        System.out.println("3 - Excluir Pessoa");
        System.out.println("4 - Buscar pelo Id");
        System.out.println("5 - Exibir Todos");
        System.out.println("6 - Persistir Dados");
        System.out.println("7 - Recuperar Todos");
        System.out.println("0 - Finalizar Programa");
        System.out.println("==============================");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new CadastroPOOParte2().run();
    }
    
}
