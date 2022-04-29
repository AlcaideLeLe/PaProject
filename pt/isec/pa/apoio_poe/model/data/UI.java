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
        System.out.println("4 - Recuar para menu inicial");
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
            case 4 -> {
                mostraMenuIncial();
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
        System.out.println("4 - Recuar para menu inicial");
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
            case 4 -> {
                mostraMenuIncial();
            }
        }

    }
    public void mostraMenuOperacoesCandidaturas2Fase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Inserir candidaturas a partir de ficheiro");
        System.out.println("2 - Consultar candidaturas");
        System.out.println("3 - Regressar ao menu anterior");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                poe.addCandidatura();
            }
            case 2 -> {
                System.out.println(poe.consultarCandidaturas());;
                ;}
            case 3 -> {
                mostraMenuSegundaFase();
            }
        }
    }
    public void mostraMenuOperacoesAlunos2Fase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar alunos com autoproposta");
        System.out.println("2 - Consultar alunos com candidatura registada");
        System.out.println("3 - Consultar alunos sem candidatura registada");
        System.out.println("4 - Recuar para menu anterior");

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
            case 4 -> {
                mostraMenuSegundaFase();
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
        System.out.println("5 - Recuar para menu anterior");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.println(poe.consultarListaDeAutopropostas());
            }
            case 2 -> {
                System.out.println(poe.consultarPropostasDocentes());
                ;}
            case 3 -> {
                System.out.println(poe.consultaPropostasComCandidaturas());
                ;
            }
            case 4 -> {
                System.out.println(poe.consultaPropostasSemCandidaturas());
                ;
            }
            case 5 -> {
                mostraMenuSegundaFase();
            }
        }
    }
    public void mostraMenuTerceiraFase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Fazer alteracoes nas propostas");
        System.out.println("2 - Consulta de propostas");
        System.out.println("3 - Consulta de alunos");
        System.out.println("4 - Recuar para segunda fase");
        System.out.println("5 - Avancar para a proxima fase");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                mostraMenuOperacoesPropostas3Fase();
            }
            case 2 -> {
                mostraMenuComConsultasDePropostas3Fase();
                ;}
            case 3 -> {
                mostraMenuOperacoesAlunos3Fase();
                ;
            }
            case 4 -> {
                mostraMenuSegundaFase();
            }
        }
    }
    public void mostraMenuOperacoesPropostas3Fase() {
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Atribuir autopropostas a alunos");
        System.out.println("2 - Atribuir propostas disponiveis a alunos"); //FALTA FAZER ISTO
        System.out.println("3 - Atribuir uma proposta manualmente");
        System.out.println("4 - Remover uma proposta manualmente");
        System.out.println("5 - Remover todas as atribuicoes (exceto as autopropostas e as propostas de docentes com aluno associado");
        System.out.println("6 - Recuar para fase anterior");
        System.out.println("---------------");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                poe.atribuirAutoproposta();
                ;
            }
            case 2 -> {
                poe.atruibuicaoDeAlunosSemPropostasDefinidas();
                ;
            }
            case 3 -> {
                System.out.println("Insira o nr de aluno ao qual a proposta vai ser atribuida");
                long nraluno = sc.nextLong();
                System.out.println("Insira o ID da proposta que vai ser atribuida");
                String propostaASerAtribuida = sc.nextLine();
                poe.atribuirPropostaManualmente(nraluno, propostaASerAtribuida);
            }
            case 4 -> {
                System.out.println("Insira o nr de aluno ao qual a proposta vai ser retirada");
                long nraluno = sc.nextLong();
                poe.removerPropostaManualmente(nraluno);
                ;
            }
            case 5 -> {
                poe.removerTodasAsAtribuicoes();
                ;
            }
            case 6 -> {
                mostraMenuSegundaFase();
                ;
            }
        }
    }
    public void mostraMenuComConsultasDePropostas3Fase(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar propostas com autoproposta");
        System.out.println("2 - Consultar propostas de docentes"); //FALTA FAZER ISTO
        System.out.println("3 - Consultar propostas disponiveis");
        System.out.println("4 - Consultar propostas atribuidas");
        System.out.println("5 - Regressar a menu anterior");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.println(poe.consultarListaDeAutopropostas());
            }
            case 2 -> {
                System.out.println(poe.consultarPropostasDocentes());
                ;}
            case 3 -> {
                System.out.println(poe.consultaPropostasDisponiveis());
                ;
            }
            case 4 -> {
                System.out.println(poe.consultaPropostasAtribuidas());
                ;
            }
            case 5 -> {
                mostraMenuOperacoesPropostas3Fase();
                ;
            }

        }
    }
    public void mostraMenuOperacoesAlunos3Fase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar alunos com autoproposta");
        System.out.println("2 - Consultar alunos com candidatura registada");
        System.out.println("3 - Consultar alunos com proposta atribuida");
        System.out.println("4 - Consultar alunos sem proposta atribuida");

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
                System.out.println(poe.consultarAlunosComPropostaAtribuida());
            }
            case 4 -> {
                System.out.println(poe.consultarAlunosSemPropostaAtribuida());
                ;
            }
        }
    }
    public void mostraMenuQuartaFase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Atribuir docentes automaticamente");
        System.out.println("2 - Operacoes manuais a docentes");
        System.out.println("3 - Consulta dados sobre docentes");
        System.out.println("4 - Recuar para terceira fase");
        System.out.println("5 - Avancar para a proxima fase");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                mostraMenuOperacoesDocentes4Fase();
            }
            case 2 -> {
                mostraMenuAtribuicoesDeDocentes4Fase();
                ;}
            case 3 -> {
                mostraMenuSobreDadosDosOrientadores();
                ;
            }
            case 4 -> {
                mostraMenuTerceiraFase();
            }
            case 5 -> {
                mostraMenuQuintaFase();
            }
        }
    }
    public void mostraMenuOperacoesDocentes4Fase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Associar os docentes proponentes as respetivas propostas");
        System.out.println("2 - Realizar operacoes de docentes");
        System.out.println("3 - Obter dados sobre os docentes");
        System.out.println("---------------");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                poe.atribuirPropostaADocenteProponenteAutomaticamente();
            }
            case 2 -> {
                mostraMenuAtribuicoesDeDocentes4Fase();
                ;}
            case 3 -> {
                mostraMenuSobreDadosDosOrientadores();
            }

        }
    }
    public void mostraMenuAtribuicoesDeDocentes4Fase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Atribuir orientador a uma proposta");
        System.out.println("2 - Consultar orientador de uma proposta");
        System.out.println("3 - Editar orientador de uma proposta");
        System.out.println("4 - Remover orientador de uma proposta");
        System.out.println("---------------");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                System.out.println("Insira o nr de aluno ao qual a proposta vai ser atribuida");
                long nraluno = sc.nextLong();
                System.out.println("Insira o email do orientador");
                String emailOrientador = sc.nextLine();
                poe.atribuirManualmenteOrientadorAAlunosComPropostas(nraluno, emailOrientador);
            }
            case 2 -> {
                System.out.println("Insira o ID da proposta");
                String IDProposta = sc.nextLine();
                System.out.println(poe.consultarOrientadorDeProposta(IDProposta));
                ;}
            case 3 -> {
                System.out.println("Insira o ID da proposta");
                String IDProposta = sc.nextLine();
                System.out.println("Insira o email do orientador");
                String emailOrientador = sc.nextLine();
                poe.editarOrientadorDeProposta(IDProposta, emailOrientador);
            }
            case 4 -> {
                System.out.println("Insira o ID da proposta");
                String IDProposta = sc.nextLine();
                poe.removerOrientadorDeProposta(IDProposta);
                ;
            }
        }
    }
    public void mostraMenuSobreDadosDosOrientadores(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar lista de estudantes com proposta atribuida e com orientador");
        System.out.println("2 - Consultar lista de estudantes com proposta atribuida e sem orientador");
        System.out.println("3 - Obter dados sobre os docentes");
        System.out.println("---------------");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                System.out.println(poe.consultaAlunosComPropostaEComOrientador());
            }
            case 2 -> {
                System.out.println(poe.consultaAlunosComPropostaESemOrientador());
                ;}
            case 3 -> {
                System.out.println(poe.consultarDocenteComMaisOrientacoes());
                System.out.println(poe.consultarDocenteComMenosOrientacoes());
                System.out.println(poe.consultarMediaDeOrientacoesDosDocentess());
            }

        }
    }
    public void mostraMenuQuintaFase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar lista de estudantes com proposta atribuida");
        System.out.println("2 - Consultar lista de estudantes sem proposta atribuida e com opcoes de candidatura");
        System.out.println("3 - Consultar propostas disponiveis");
        System.out.println("4 - Consultar propostas atribuidas");
        System.out.println("5 - Ver dados sobre docentes");
        System.out.println("---------------");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                System.out.println(poe.consultarAlunosComPropostaAtribuida());
            }
            case 2 -> {
                System.out.println(poe.consultaAlunosComCandidaturaESemProposta());
                ;}
            case 3 ->{
                System.out.println(poe.consultaPropostasDisponiveis());
                }
            case 4 ->{
                System.out.println(poe.consultaPropostasAtribuidas());
            }
            case 5 -> {
                System.out.println(poe.consultarDocenteComMaisOrientacoes());
                System.out.println(poe.consultarDocenteComMenosOrientacoes());
                System.out.println(poe.consultarMediaDeOrientacoesDosDocentess());
            }

        }
    }





}








