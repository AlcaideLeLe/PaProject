package pt.isec.pa.apoio_poe.model.data;

import java.io. * ;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class UI {
    private int opcao;

    public UI(){}
    PoE poe = new PoE();

    public int getOpcao() {
        return opcao;
    }
    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }



    public void mostraMenuIncial() {
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Opcoes para alunos");
        System.out.println("2 - Opcoes para docentes");
        System.out.println("3 - Opcoes para propostas");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                mostraMenuOperacoesAlunos1Fase();
            }
            case 2 -> {
                mostraMenuOperacoesDocentes1Fase();
                ;}
            case 3 -> {
                mostraMenuOperacoesPropostas1Fase();
                ;
            }
        }
    }

    public void mostraMenuOperacoesAlunos1Fase() {
        Scanner sc = new Scanner(System.in);
        int opcaoAlunos;

        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Adicionar todos os alunos a partir de ficheiro");
        System.out.println("2 - Regressar ao menu anterior");
        System.out.println("3 - Avancar para a fase seguinte");
        System.out.println("---------------");

        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                poe.addAluno();
                System.out.println(poe.consultarAlunos());
            }
            case 2 -> {
                mostraMenuIncial();
            }
            case 3 -> {
                mostraMenuSegundaFase();
            }
        }

    }
    public void mostraMenuOperacoesDocentes1Fase() {
        Scanner sc = new Scanner(System.in);
        int opcaoAlunos;

        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Adicionar todos os decentes a partir de ficheiro");
        System.out.println("2 - Regressar ao menu anterior");
        System.out.println("3 - Avancar para a fase seguinte");
        System.out.println("---------------");

        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                poe.addDocente();
                System.out.println(poe.consultarDocentes());
            }
            case 2 -> {
                mostraMenuIncial();
            }
            case 3 -> {
                mostraMenuSegundaFase();
            }
        }
    }
    public void mostraMenuOperacoesPropostas1Fase() {
            Scanner sc = new Scanner(System.in);
            int opcaoAlunos;

            System.out.println("---------------");
            System.out.println("O que pretende fazer?");
            System.out.println("1 - Adicionar todos as propostas a partir de ficheiro");
            System.out.println("2 - Regressar ao menu anterior");
            System.out.println("3 - Avancar para a fase seguinte");
            System.out.println("---------------");

            int opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> {
                    poe.addProposta();
                    System.out.println(poe.consultarPropostas());
                }
                case 2 -> {
                    mostraMenuIncial();
                }
                case 3 -> {
                    mostraMenuSegundaFase();
                }
            }

        }
    public void mostraMenuSegundaFase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Opcoes para candidaturas");
        System.out.println("2 - Opcoes para alunos");
        System.out.println("3 - Opcoes para propostas");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                mostraMenuOperacoesCandidaturas2Fase();
            }
            case 2 -> {
                mostraMenuOperacoesAlunos2Fase();
                ;}
            case 3 -> {
                mostraMenuOperacoesPropostas2Fase();
                ;
            }
        }

    }
    public void mostraMenuOperacoesCandidaturas2Fase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Inserir candidaturas a partir de ficheiro");
        System.out.println("2 - Consultar candidaturas");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                poe.addCandidatura();
            }
            case 2 -> {
                System.out.println(poe.consultarCandidaturas());;
                ;}
        }
    }
    public void mostraMenuOperacoesAlunos2Fase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar alunos com autoproposta");
        System.out.println("2 - Consultar alunos com candidatura registada");
        System.out.println("3 - Consultar alunos sem candidatura registada");
        System.out.println("---------------");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                System.out.println(poe.consultarListaDeAutopropostas());
            }
            case 2 -> {
                System.out.println(poe.consultarAlunosComCandidatura());
                ;}
            case 3 -> {
                System.out.println(poe.consultarAlunosSemCandidatura());
                ;
            }
        }
    }
    public void mostraMenuOperacoesPropostas2Fase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar propostas com autoproposta");
        System.out.println("2 - Consultar propostas de docentes"); //FALTA FAZER ISTO
        System.out.println("3 - Consultar propostas que ja tem candidaturas");
        System.out.println("4 - Consultar propostas que nao tem candidaturas");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.println(poe.consultarListaDeAutopropostas());
            }
            case 2 -> {
                System.out.println("FALTA FAZER ISTO");
                ;}
            case 3 -> {
                System.out.println(poe.consultaPropostasComCandidaturas());
                ;
            }
            case 4 -> {
                System.out.println(poe.consultaPropostasSemCandidaturas());
                ;
            }
        }
    }
}






