package pt.isec.pa.apoio_poe.ui.text;

import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;

import java.io. * ;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class UI {
    private int opcao;
    private apoio_poeContext fsm;
    private boolean finish = false;
    public UI(apoio_poeContext fsm){
        this.fsm = fsm;
    }


    public int getOpcao() {
        return opcao;
    }
    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }
    public void start(){
        while(!finish){
            switch(fsm.getState()){
                case FASE1:
                    mostraMenuIncial();
                    break;
                case FASE1BLOCKSTATE:
                    mostraMenuFase1Bloqueada();
                    break;
                case FASE2:
                    mostraMenuSegundaFase();
                    break;
                case FASE2BLOCKSTATE:
                    mostraMenuFase2Bloqueada();
                    break;
                case FASE3:
                    mostraMenuTerceiraFase();
                    break;
                case FASE3BLOCKSTATE:
                    mostraMenuFase3Bloqueada();
                    break;
                case FASE4:
                    mostraMenuQuartaFase();
                    break;
                case FASE5:
                    mostraMenuQuintaFase();
                    break;
                case GESTAO_PROP:
                    mostraMenuOperacoesPropostas1Fase();
                    break;
                case GESTAO_DOC:
                    mostraMenuOperacoesDocentes1Fase();
                    break;
                case GESTAO_AL:
                    mostraMenuOperacoesAlunos1Fase();
                    break;
                case GESTAO_CAND:
                    mostraMenuOperacoesCandidaturas2Fase();
                    break;
                case TRATAMENTO_PROP:
                    mostraMenuOperacoesPropostas3Fase();
                    break;
                case GESTAO_ORI:
                    mostraMenuOperacoesDocentes4Fase();
                    break;
                case GESTAO_MANUAL_ATRIBSTATE:
                    mostraMenuOperacoesAlunos3Fase();
                    break;

                case GESTAO_MANUAL_ORIENTSTATE:
                    mostraMenuOrientadores4Fase();
                    break;
            }
        }
    }

    public void mostraMenuFase1Bloqueada(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar um aluno");
        System.out.println("2 - Consultar todos os alunos");
        System.out.println("3 - Consultar um docente");
        System.out.println("4 - Consultar todos os docentes");
        System.out.println("5 - Consultar uma proposta");
        System.out.println("6 - Consultar todas as propostas");
        System.out.println("7 - Avancar para a fase seguinte");
        System.out.println("8 - Sair da aplicacao");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.println("Insira o numero de aluno");
                Long nrAluno = sc.nextLong();
                fsm.consultaAluno(nrAluno);
            }
            case 2 -> {
                fsm.consultaAlunos();
            }
            case 3 -> {
                System.out.println("Insira o e-mail do docente");
                String emailProf = sc.nextLine();
                fsm.consultaDocente(emailProf);
            }
            case 4 -> {
                fsm.consultaDocentes();
            }
            case 5 -> {
                System.out.println("Insira o id da proposta");
                String idProposta = sc.nextLine();
                fsm.consultaProposta(idProposta);
                ;}
            case 6 -> {
                fsm.consultaDocentes();
                ;
            }
            case 7 -> {
                mostraMenuSegundaFase();
            }
            case 8 -> {
                finish = true;
            }
        }
    }

    public void mostraMenuFase2Bloqueada(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar alunos com autoproposta");
        System.out.println("2 - Consultar alunos com candidatura");
        System.out.println("3 - Consultar alunos sem candidatura");
        System.out.println("4 - Consultar a lista de autoproposta");
        System.out.println("5 - Consultar propostas de docentes");
        System.out.println("6 - Consultar propostas com candidaturas");
        System.out.println("7 - Consultar propostas sem candidaturas");
        System.out.println("8 - Consultar uma candidatura");
        System.out.println("9 - Avancar Fase");
        System.out.println("10 - Sair da aplicacao");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                fsm.consultaAlunosComAutoproposta();
            }
            case 2 -> {
                fsm.consultarAlunosComCandidatura();
            }
            case 3 -> {
                fsm.consultarAlunosSemCandidatura();
            }
            case 4 -> {
                fsm.consultarListaDeAutopropostas();
            }
            case 5 -> {
                fsm.consultarPropostasDocentes();
            }
            case 6 -> {
                fsm.consultarPropostasComCandidaturas();
                ;
            }
            case 7 -> {
                fsm.consultarPropostasSemCandidaturas();
            }
            case 8-> {
                System.out.println("Insira o numero de aluno");
                Long nrAluno = sc.nextLong();
                fsm.consultaCandidatura(nrAluno);
            }
            case 9 -> {
                mostraMenuTerceiraFase();
            }
            case 10 -> {
                finish = true;
            }
        }
    }

    public void mostraMenuFase3Bloqueada(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar alunos com autoproposta");
        System.out.println("2 - Consultar alunos com candidatura");
        System.out.println("3 - Consultar alunos com proposta atribuida");
        System.out.println("4 - Consultar alunos sem proposta atribuida");
        System.out.println("5 - Consultar lista de autopropostas");
        System.out.println("6 - Consultar propostas de docentes");
        System.out.println("7 - Consultar propostas disponiveis");
        System.out.println("8 - Consultar propostas atribuidas");
        System.out.println("9 - Avancar Fase");
        System.out.println("10 - Sair da aplicacao");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                fsm.consultaAlunosComAutoproposta();
            }
            case 2 -> {
                fsm.consultarAlunosComCandidatura();
            }
            case 3 -> {
                fsm.consultarAlunosComPropostaAtribuida();
            }
            case 4 -> {
                fsm.consultarAlunosSemPropostaAtribuida();
            }
            case 5 -> {
                fsm.consultarListaDeAutopropostas();
            }
            case 6 -> {
                fsm.consultarPropostasDocentes();
                ;
            }
            case 7 -> {
                fsm.consultarPropostasDisponiveis();
            }
            case 8-> {
                fsm.consultarPropostasAtribuidas();
            }
            case 9 -> {
                mostraMenuQuartaFase();
            }
            case 10 -> {
                finish = true;
            }
        }
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
        System.out.println("4 - Exportar alunos para ficheiro csv");
        System.out.println("---------------");

        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                fsm.addAluno();
                System.out.println(fsm.consultaAlunos());
            }
            case 2 -> {
                mostraMenuIncial();
            }
            case 3 -> {
                mostraMenuSegundaFase();
            }
            case 4 -> {
                System.out.println("Insira o nome do ficheiro");
                String nomeFicheiro = sc.nextLine();
                fsm.exportarAlunosParaCSV(nomeFicheiro);

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
        System.out.println("4 - Exportar docentes para ficheiro csv");

        System.out.println("---------------");

        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                fsm.addDocente();
                System.out.println(fsm.consultaDocentes());
            }
            case 2 -> {
                mostraMenuIncial();
            }
            case 3 -> {
                mostraMenuSegundaFase();
            }
            case 4 -> {
                System.out.println("Insira o nome do ficheiro");
                String nomeFicheiro = sc.nextLine();
                fsm.exportarDocentesParaCSV(nomeFicheiro);


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
            System.out.println("4 - Exportar propostas para ficheiro csv");
            System.out.println("---------------");

            int opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> {
                    fsm.addProposta();
                    System.out.println(fsm.consultaPropostas());
                }
                case 2 -> {
                    mostraMenuIncial();
                }
                case 3 -> {
                    mostraMenuSegundaFase();
                }
                case 4 -> {
                    System.out.println("Insira o nome do ficheiro");
                    String nomeFicheiro = sc.nextLine();
                    fsm.exportarPropostasParaCSV(nomeFicheiro);

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
        System.out.println("3 - Exportar candidaturas para ficheiro csv");
        System.out.println("4 - Regressar ao menu anterior");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                fsm.addCandidatura();
            }
            case 2 -> {
                System.out.println(fsm.consultaCandidaturas());;
                ;}
            case 3 -> {
                System.out.println("Insira o nome do ficheiro");
                String nomeFicheiro = sc.nextLine();
                fsm.exportarCandidaturasParaCSV(nomeFicheiro);

            }
            case 4 -> {
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
                System.out.println(fsm.consultarListaDeAutopropostas());
            }
            case 2 -> {
                System.out.println(fsm.consultarAlunosComCandidatura());
                ;}
            case 3 -> {
                System.out.println(fsm.consultarAlunosSemCandidatura());
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
                System.out.println(fsm.consultarListaDeAutopropostas());
            }
            case 2 -> {
                System.out.println(fsm.consultarPropostasDocentes());
                ;}
            case 3 -> {
                System.out.println(fsm.consultarPropostasComCandidaturas());
                ;
            }
            case 4 -> {
                System.out.println(fsm.consultarPropostasSemCandidaturas());
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
        System.out.println("5 - Exportar alunos para ficheiro csv");
        System.out.println("6 - Avancar para a proxima fase");
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
            case 5 -> {
                System.out.println("Insira o nome do ficheiro");
                String nomeFicheiro = sc.nextLine();
                fsm.exportarAlunosParaCSV(nomeFicheiro);
            }
            case 6 -> {
                mostraMenuQuartaFase();
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
                fsm.atribuirAutoproposta();
                ;
            }
            case 2 -> {
                fsm.atruibuicaoDeAlunosSemPropostasDefinidas();
                ;
            }
            case 3 -> {
                System.out.println("Insira o nr de aluno ao qual a proposta vai ser atribuida");
                long nraluno = sc.nextLong();
                System.out.println("Insira o ID da proposta que vai ser atribuida");
                String propostaASerAtribuida = sc.nextLine();
                fsm.atribuirPropostaManualmente(nraluno, propostaASerAtribuida);
            }
            case 4 -> {
                System.out.println("Insira o nr de aluno ao qual a proposta vai ser retirada");
                long nraluno = sc.nextLong();
                fsm.removerPropostaManualmente(nraluno);
                ;
            }
            case 5 -> {
                fsm.removerTodasAsAtribuicoes();
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
                System.out.println(fsm.consultarListaDeAutopropostas());
            }
            case 2 -> {
                System.out.println(fsm.consultarPropostasDocentes());
                ;}
            case 3 -> {
                System.out.println(fsm.consultarPropostasDisponiveis());
                ;
            }
            case 4 -> {
                System.out.println(fsm.consultarPropostasAtribuidas());
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
                System.out.println(fsm.consultarListaDeAutopropostas());
            }
            case 2 -> {
                System.out.println(fsm.consultarAlunosComCandidatura());
                ;}
            case 3 -> {
                System.out.println(fsm.consultarAlunosComPropostaAtribuida());
            }
            case 4 -> {
                System.out.println(fsm.consultarAlunosSemPropostaAtribuida());
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
        System.out.println("5 - Exportar alunos para ficheiro csv");
        System.out.println("6 - Avancar para a proxima fase");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                mostraMenuOperacoesDocentes4Fase();
            }
            case 2 -> {
                mostraMenuOrientadores4Fase();
                ;}
            case 3 -> {
                mostraMenuSobreDadosDosOrientadores();
                ;
            }
            case 4 -> {
                mostraMenuTerceiraFase();
            }
            case 5 -> {
                System.out.println("Insira o nome do ficheiro");
                String nomeFicheiro = sc.nextLine();
                fsm.exportarAlunosParaCSV(nomeFicheiro);
            }
            case 6 -> {
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
                fsm.atribuirPropostaADocenteProponenteAutomaticamente();
            }
            case 2 -> {
                mostraMenuOrientadores4Fase();
                ;}
            case 3 -> {
                mostraMenuSobreDadosDosOrientadores();
            }

        }
    }
    public void mostraMenuOrientadores4Fase(){
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
                fsm.atribuirManualmenteOrientadorAAlunosComPropostas(nraluno, emailOrientador);
            }
            case 2 -> {
                System.out.println("Insira o ID da proposta");
                String IDProposta = sc.nextLine();
                System.out.println(fsm.consultarOrientadorDeProposta(IDProposta));
                ;}
            case 3 -> {
                System.out.println("Insira o ID da proposta");
                String IDProposta = sc.nextLine();
                System.out.println("Insira o email do orientador");
                String emailOrientador = sc.nextLine();
                fsm.editarOrientadorDeProposta(IDProposta, emailOrientador);
            }
            case 4 -> {
                System.out.println("Insira o ID da proposta");
                String IDProposta = sc.nextLine();
                fsm.removerOrientadorDeProposta(IDProposta);
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
                System.out.println(fsm.consultarAlunosComPropostaEComOrientador());
            }
            case 2 -> {
                System.out.println(fsm.consultarAlunosComPropostaESemOrientador());
                ;}
            case 3 -> {
                System.out.println(fsm.consultarDocenteComMaisOrientacoes());
                System.out.println(fsm.consultarDocenteComMenosOrientacoes());
                System.out.println(fsm.consultarMediaDeOrientacoesDosDocentes());
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
        System.out.println("5 - Exportar alunos para ficheiro csv");
        System.out.println("6 - Ver dados sobre docentes");
        System.out.println("---------------");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                System.out.println(fsm.consultarAlunosComPropostaAtribuida());
            }
            case 2 -> {
                System.out.println(fsm.consultarAlunosComCandidaturaESemProposta());
                ;}
            case 3 ->{
                System.out.println(fsm.consultarPropostasDisponiveis());
                }
            case 4 ->{
                System.out.println(fsm.consultarPropostasAtribuidas());
            }
            case 5 -> {
                System.out.println("Insira o nome do ficheiro");
                String nomeFicheiro = sc.nextLine();
                fsm.exportarAlunosParaCSV(nomeFicheiro);
            }
            case 6 -> {
                System.out.println(fsm.consultarDocenteComMaisOrientacoes());
                System.out.println(fsm.consultarDocenteComMenosOrientacoes());
                System.out.println(fsm.consultarMediaDeOrientacoesDosDocentes());
            }

        }
    }





}








