package pt.isec.pa.apoio_poe.model.data;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PoE {
    ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
    ArrayList<Docente> listaDeDocentes = new ArrayList<>();
    ArrayList<Proposta> listaDePropostas = new ArrayList<>();
    ArrayList<Candidatura> listaDeCandidaturas = new ArrayList<>();

    public int faseFechada=0;

    public void addAluno() {
        try {
            ArrayList<String> arrayAluno = new ArrayList<>();
            Scanner scAluno = new Scanner(new File("pt/isec/pa/apoio_poe/model/data/Aluno.csv"));
            scAluno.useDelimiter(";");
            while (scAluno.hasNext()) {
                arrayAluno.add(scAluno.nextLine());
            }
            String[] dadosAluno;

            for (int i = 0; i < arrayAluno.size(); i++) {
                dadosAluno = arrayAluno.get(i).split(";");
                listaDeAlunos.add(new Aluno(Long.parseLong(dadosAluno[0]), dadosAluno[1], dadosAluno[2],
                        dadosAluno[3], dadosAluno[4], Double.parseDouble(dadosAluno[5]),
                        Boolean.parseBoolean(dadosAluno[6]), null));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addDocente() {
        try {
            ArrayList<String> arrayDocente = new ArrayList<>();
            Scanner scDocente = new Scanner(new File("pt/isec/pa/apoio_poe/model/data/Docentes.csv"));
            //parsing a CSV file into the constructor of Scanner class

            scDocente.useDelimiter(",");
            //setting comma as delimiter pattern

            while (scDocente.hasNext()) {
                arrayDocente.add(scDocente.nextLine());
            }

            String[] dadosDocente;

            for (int i = 0; i < arrayDocente.size(); i++) {
                dadosDocente = arrayDocente.get(i).split(",");
                listaDeDocentes.add(new Docente(dadosDocente[0], dadosDocente[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addProposta(){
        try {
            ArrayList<String> arrayProposta = new ArrayList<>();
            Scanner scProposta = new Scanner(new File("pt/isec/pa/apoio_poe/model/data/Propostas.csv"));

            scProposta.useDelimiter(",");

            while (scProposta.hasNext()) {
                arrayProposta.add(scProposta.nextLine());
            }

            String[] dadosProposta;

            for (int i = 0; i < arrayProposta.size(); i++) {
                dadosProposta = arrayProposta.get(i).split(",");
                    if (dadosProposta[0].equals("T1")) {
                        if (dadosProposta.length == 6) {
                            listaDePropostas.add(new Estagio(dadosProposta[0], dadosProposta[1], Long.parseLong(dadosProposta[5]), dadosProposta[3],
                                    dadosProposta[4], dadosProposta[2], false));
                        } else {
                            listaDePropostas.add(new Estagio(dadosProposta[0], dadosProposta[1], 0, dadosProposta[3],
                                    dadosProposta[4], dadosProposta[2], false));
                        }
                    } else if (dadosProposta[0].equals("T2")) {
                        if (dadosProposta.length == 6) {
                            listaDePropostas.add(new Projeto(dadosProposta[0], dadosProposta[1], Long.parseLong(dadosProposta[5]), dadosProposta[3],
                                    dadosProposta[2], dadosProposta[4], false) );
                        } else {
                            listaDePropostas.add(new Projeto(dadosProposta[0], dadosProposta[1], 0, dadosProposta[3],
                                    dadosProposta[2], dadosProposta[4], false) );
                        }

                    } else if (dadosProposta[0].equals("T3")) {
                        listaDePropostas.add(new Autoproposto(dadosProposta[0], dadosProposta[1], Long.parseLong(dadosProposta[3]), dadosProposta[2], false) );
                    }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String consultarAluno(long numero){
        for(int i=0; i<listaDeAlunos.size(); i++){
            if(listaDeAlunos.get(i).getNumero() == numero){
                return listaDeAlunos.get(i).toString();
            }

        }
        return null;
    }

    public String consultarAlunos(){
        Collections.sort(listaDeAlunos);
        return listaDeAlunos.toString();
    }

    public String consultarDocente(String email){
        for(int i=0; i<listaDeDocentes.size(); i++){
            if(listaDeDocentes.get(i).getEmail().equals(email)){
                return listaDeDocentes.get(i).toString();
            }

        }
        return null;
    }

    public String consultarDocentes(){
        Collections.sort(listaDeDocentes);
        return listaDeDocentes.toString();
    }

    public String consultarProposta(String idProposta){
        for(int i=0; i<listaDePropostas.size(); i++){
            if(listaDePropostas.get(i).getIdProposta().equals(idProposta)){
                return listaDePropostas.get(i).toString();
            }
        }
        return null;
    }

    public String consultarPropostas(){
        Collections.sort(listaDePropostas);
        return listaDePropostas.toString();
    }

    public void addCandidatura(){
        try {
            ArrayList<String> arrayCandidatura = new ArrayList<>();
            Scanner scCandidatura = new Scanner(new File("pt/isec/pa/apoio_poe/model/data/Candidatura.csv"));
            scCandidatura.useDelimiter(",");
            while (scCandidatura.hasNext()) {
                arrayCandidatura.add(scCandidatura.nextLine());
            }
            String[] dadosCandidatura;

            for (int i = 0; i < arrayCandidatura.size(); i++) {
                boolean exists = false;
                dadosCandidatura = arrayCandidatura.get(i).split(",");
                for(Candidatura c : listaDeCandidaturas){
                    if (c.getNumero() == Long.parseLong(dadosCandidatura[0])){
                        exists = true;
                    }
                }
                if(!exists){
                    listaDeCandidaturas.add(new Candidatura(Long.parseLong(dadosCandidatura[0]), new ArrayList<>(List.of(Arrays.copyOfRange(dadosCandidatura,1,dadosCandidatura.length)))));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String consultarCandidatura(long nrAluno){
        for(int i=0; i<listaDeCandidaturas.size(); i++){
            if(listaDeCandidaturas.get(i).getNumero() == nrAluno){
                return listaDeCandidaturas.get(i).toString();
            }
        }
        return null;
    }
    public String consultarCandidaturas(){
        Collections.sort(listaDeCandidaturas);
        return listaDeCandidaturas.toString();
    }

    public String consultarAlunosComCandidatura(){
        StringBuilder sb = new StringBuilder();
        ArrayList<Long> alunosComCandidatura = new ArrayList<>();
        for (var c : listaDeCandidaturas) {
            alunosComCandidatura.add(c.getNumero());
        }
        for(var a : listaDeAlunos){
            if(alunosComCandidatura.contains(a.getNumero())) {
                sb.append("Numero de Aluno: ").append(a.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
    public String consultarAlunosSemCandidatura(){
        StringBuilder sb = new StringBuilder();
        ArrayList<Long> alunosSemCandidatura = new ArrayList<>();
        for (var c : listaDeCandidaturas) {
            alunosSemCandidatura.add(c.getNumero());
        }
        for(var a : listaDeAlunos){
            if(!alunosSemCandidatura.contains(a.getNumero())) {
                sb.append("Numero de Aluno: ").append(a.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String consultaAlunosComAutoproposta(){ //Filtro Alunos com Autoproposta
        StringBuilder sb = new StringBuilder();
        ArrayList<Long> alunosComAutoProposta = new ArrayList<>();
        for (var p : listaDePropostas) {
            if(p instanceof Autoproposto) {
                alunosComAutoProposta.add(p.getNrAluno());
            }
        }
        for(var a : listaDeAlunos){
            if(alunosComAutoProposta.contains(a.getNumero())) {
                sb.append("Numero de Aluno Autoproposto: ").append(a.toString()).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
    public String consultarListaDeAutopropostas(){
        StringBuilder sb = new StringBuilder();
        ArrayList<Long> listaDeAutoProposta = new ArrayList<>();
        for (var p : listaDePropostas) {
            if(p instanceof Autoproposto){
                sb.append("Proposta ").append(p.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public void atribuirAutoproposta(){
        ArrayList<Long> listaDeAlunosComAutoProposta = new ArrayList<>();
        for (var p : listaDePropostas) {
            if(p instanceof Autoproposto){
                listaDeAlunosComAutoProposta.add(p.getNrAluno());
                for(var a : listaDeAlunos){
                    if(listaDeAlunosComAutoProposta.contains(a.getNumero())) {
                        a.setIdPropostaAssociada(p.getIdProposta());
                        p.setAtribuida(true);
                    }
                }
            }
        }
    }

    public void atribuirPropostaDeDocente(){
        ArrayList<Long> listaDeAlunosPropostaDeDocente = new ArrayList<>();
        for (var p : listaDePropostas) {
            if(p instanceof Projeto){
                if(p.getNrAluno() != 0){
                    listaDeAlunosPropostaDeDocente.add(p.getNrAluno());
                    for(var a : listaDeAlunos){
                        if(a.getNumero() == p.getNrAluno()) {
                            a.setIdPropostaAssociada(p.getIdProposta());
                            p.setAtribuida(true);
                        }
                    }
                }
            }
        }
    }

    public void atribuirPropostaManualmente(long nralunoQueVaiTerNovaProposta, String IDproposta) {
        //System.out.println(nralunoQueVaiTerNovaProposta + " 1 " + IDproposta);
        for (var pr : listaDePropostas) {
            if (Objects.equals(pr.getIdProposta(), IDproposta)) {
                if (!pr.isAtribuida()) {
                    for (var a : listaDeAlunos) {
                        if (a.getNumero() == nralunoQueVaiTerNovaProposta) {
                            if (a.getIdPropostaAssociada() == null) {
                                a.setIdPropostaAssociada(IDproposta);
                                for (var p : listaDePropostas) {
                                    if (Objects.equals(p.getIdProposta(), IDproposta)) {
                                        p.setNrAluno(nralunoQueVaiTerNovaProposta);
                                        p.setAtribuida(true);
                                    }/*
                                    for(var d : listaDeDocentes){
                                        if(Objects.equals(d.getEmail(), emailProf)){
                                            d.setPropostaAssociada(IDproposta);
                                        }
                                    }*/
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void removerPropostaManualmente(long nralunoQueVaiFicarSemProposta){
        for(var a : listaDeAlunos){
            if(a.getNumero() == nralunoQueVaiFicarSemProposta){
                for(var p : listaDePropostas){
                    if(Objects.equals(p.getIdProposta(), a.getIdPropostaAssociada())){
                        p.setAtribuida(false);
                        p.setNrAluno(0);
                        a.setIdPropostaAssociada(null);
                    }
                }
            }
        }
    }

    public String consultaPropostasComCandidaturas(){ //Filtro Proposta Com candidatura
        StringBuilder sb = new StringBuilder();
        HashSet<String> propostasComCandidaturas = new HashSet<>();
        for(var c : listaDeCandidaturas){
            propostasComCandidaturas.addAll(c.getPropostas());
        }
        for(var p : listaDePropostas){
            if(propostasComCandidaturas.contains(p.getIdProposta())){
                sb.append("Proposta com candidatura").append(p.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String consultaPropostasSemCandidaturas(){ //Filtro Proposta Sem candidatura
        StringBuilder sb = new StringBuilder();
        HashSet<String> propostasSemCandidaturas = new HashSet<>();
        for(var c : listaDeCandidaturas){
            propostasSemCandidaturas.addAll(c.getPropostas());
        }
        for(var p : listaDePropostas){
            if(!propostasSemCandidaturas.contains(p.getIdProposta())){
                sb.append("Proposta com candidatura").append(p.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String consultaAlunosComPropostasDeDocentes(){ //filtro Autopropostas de alunos
        StringBuilder sb = new StringBuilder();
        ArrayList<Long> listaDeAlunosComPropostaDeDocente = new ArrayList<>();
        for(var a : listaDePropostas){
            if(Objects.equals(a.getTipoDeProposta(), "T2")){
                sb.append("Alunos com Proposta de Docentes").append(a.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public void atruibuicaoDeAlunosSemPropostasDefinidas(){
        ArrayList<Proposta> propostasNaoAtribuidas = new ArrayList<>();
        ArrayList<Aluno> alunosSemProposta = new ArrayList<>();
        for(var p : listaDePropostas){
            if(p.getNrAluno() == 0 && !p.isAtribuida()){
               propostasNaoAtribuidas.add(p);
            }
        }
        for(var a : listaDeAlunos) {
            if (a.getIdPropostaAssociada() == null) {
                alunosSemProposta.add(a);
            }
        }

        Collections.sort(alunosSemProposta, new Comparator<Aluno>() {
            @Override
            public int compare(Aluno a1, Aluno a2) {
                return Double.compare(a1.getClassificacao(), a2.getClassificacao());
            }
        });

        
        for(var asp : alunosSemProposta){
            Proposta p = null;
            for(var pna : propostasNaoAtribuidas){
                asp.setIdPropostaAssociada(pna.getIdProposta());
                pna.setAtribuida(true);
                p = pna;
                break;
            }
            propostasNaoAtribuidas.remove(p);
        }
    }

    public String consultarAlunosSemPropostaAtribuida(){
        StringBuilder sb = new StringBuilder();
        for(var a : listaDeAlunos){
            if(a.getIdPropostaAssociada() == null){
                sb.append("Numero de Aluno: ").append(a.toString()).append(System.lineSeparator());
            }
        }

        return sb.toString();
    } //FEITO HOJE E TESTADO

    public String consultaPropostasDisponiveis(){
        StringBuilder sb = new StringBuilder();
        for(var p : listaDePropostas){
            if(!p.isAtribuida()){
                sb.append("Proposta nao atribuida \n").append(p.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    } //FEITO HOJE E TESTADO

    public String consultaPropostasAtribuidas(){
        StringBuilder sb = new StringBuilder();
        for(var p : listaDePropostas){
            if(p.isAtribuida()){
                sb.append("Proposta atribuida \n").append(p.toString()).append(System.lineSeparator());

            }
        }
        return sb.toString();

    } //FEITO HOJE E TESTADO

    public void atribuirPropostaADocenteProponenteAutomaticamente(){
        for(var p : listaDePropostas){
            if(p instanceof Projeto){
                for(var d : listaDeDocentes){
                    if(Objects.equals(((Projeto) p).getDocenteProponente(), d.getEmail())){
                            d.setPropostaAssociada(p.getIdProposta());
                            p.setAtribuida(true);
                            d.incrementaNrDeOrientacoes();
                    }
                }
            }
        }
    } //FEITO HOJE, TESTADO, MAS FALTA VERIFICAR PQ FICAM VARIOS PROFS COM A MESMA PROPOSTA

    public void atribuirManualmenteOrientadorAAlunosComPropostas(long nrAlunoDaProposta, String emailProf){
        for(var p : listaDePropostas){
            if(p.isAtribuida()) {
                if (p.getNrAluno() == nrAlunoDaProposta) {
                    for(var d : listaDeDocentes){
                        if(Objects.equals(d.getEmail(), emailProf)){
                            p.setOrientador(emailProf);
                            d.incrementaNrDeOrientacoes();
                        }
                    }
                }
            }
        }
    }

    public String consultarOrientadorDeProposta(String nrProposta){
        StringBuilder sb = new StringBuilder();
        for(var p : listaDePropostas){
            if(Objects.equals(p.getIdProposta(), nrProposta)){
                if(p.isAtribuida()){
                    sb.append("Orientador \n").append(p.getOrientador()).append(System.lineSeparator());
                }
            }
        }

        return sb.toString();
    }
    public void editarOrientadorDeProposta(String nrProposta, String novoOrientador){
        StringBuilder sb = new StringBuilder();
        for(var p : listaDePropostas){
            for(var d : listaDeDocentes){
                if(Objects.equals(d.getEmail(), novoOrientador)){
                    if(Objects.equals(p.getIdProposta(), nrProposta)){
                        if(p.isAtribuida()){
                            p.setOrientador(novoOrientador);
                            d.incrementaNrDeOrientacoes();
                        }
                    }
                }
            }
        }
    } //FALTA DECREMENTAR
    public void removerOrientadorDeProposta(String nrProposta){
        StringBuilder sb = new StringBuilder();
        for(var p : listaDePropostas){
            if(Objects.equals(p.getIdProposta(), nrProposta)){
                if(p.isAtribuida()){
                    p.setOrientador(null);
                }
            }
        }
    }

    public String consultaAlunosComPropostaEComOrientador(){
        StringBuilder sb = new StringBuilder();
        for(var a : listaDeAlunos){
            if(a.getIdPropostaAssociada() != null){
                for(var p : listaDePropostas){
                   if(p.isAtribuida()){
                        if(p.getOrientador() != null){
                            sb.append("Alunos com Proposta e com orientador   ").append(a.getNumero()).append(System.lineSeparator());
                        }
                   }
                }
            }
        }

        return sb.toString();
    } //IMPRIME DUAS VEZES
    public String consultaAlunosComPropostaESemOrientador(){
        StringBuilder sb = new StringBuilder();
        for(var a : listaDeAlunos){
            if(a.getIdPropostaAssociada() != null){
                for(var p : listaDePropostas){
                    if(p.isAtribuida()){
                        if(p.getOrientador() == null){
                            sb.append("Alunos com Proposta e com orientador   ").append(a.getNumero()).append(System.lineSeparator());
                        }
                    }
                }
            }
        }

        return sb.toString();
    } //IMPRIME DUAS VEZES


    public String consultarDocenteComMenosOrientacoes(){
        int menor = 0;
        String DocenteMenor = null;
        for(int i=0; i<listaDeDocentes.size(); i++){
            if(i==0){
                DocenteMenor = listaDeDocentes.get(i).getEmail();
                menor = listaDeDocentes.get(i).getNrDeOrientacoes();
            }
            if(listaDeDocentes.get(i).getNrDeOrientacoes() < menor){
                menor = listaDeDocentes.get(i).getNrDeOrientacoes();
                DocenteMenor = listaDeDocentes.get(i).getEmail();
            }
        }
        return DocenteMenor;
    }
    public String consultarDocenteComMaisOrientacoes(){
        int maior = 0;
        String DocenteMaior = null;
        for(int i=0; i<listaDeDocentes.size(); i++){
            if(i==0){
                DocenteMaior = listaDeDocentes.get(i).getEmail();
                maior = listaDeDocentes.get(i).getNrDeOrientacoes();
            }
            if(listaDeDocentes.get(i).getNrDeOrientacoes() > maior){
                maior = listaDeDocentes.get(i).getNrDeOrientacoes();
                DocenteMaior = listaDeDocentes.get(i).getEmail();
            }
        }
        return DocenteMaior;
    }

    public String consultarMediaDeOrientacoesDosDocentess(){
        float media = 0;

        for(int i=0; i<listaDeDocentes.size(); i++){
            listaDeDocentes.get(i).getNrDeOrientacoes();
            media += listaDeDocentes.get(i).getNrDeOrientacoes();
        }
        media /= listaDeDocentes.size();
        return "A media dos orientador e: "+media;
    }



    public void removeAluno(){}
    public void removeDocente(){}


    /*public void editAluno(ArrayList<Aluno> arrayAlunos){
        Scanner resposta, nomeNovo, novaSiglaCurso;
        String nome, siglaCurso, siglaAtualCurso;
        int aluno = 0;
        resposta = new Scanner(System.in);
        nomeNovo = new Scanner(System.in);
        novaSiglaCurso = new Scanner(System.in);


        System.out.println("O que pretende alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - Sigla Curso");
        System.out.println("3 - E-amil");
        System.out.println("4 - Sigla Ramo");
        System.out.println("5 - Classificacao");
        System.out.println("6 - Possibilidade de aceder ao estagio");

        for(int i=0; i< arrayAlunos.size() ; i++){

            if(arrayAlunos.get(i).getNumero() == numero){
                aluno = i;
                break;
            }
        }

        switch(resposta.nextInt()) {
            case 1:
                System.out.println("Que nome quer meter?");
                nome = nomeNovo.nextLine();
                arrayAlunos.get(aluno).setNome(nome);
            case 2:
                siglaAtualCurso = arrayAlunos.get(aluno).getSiglaCurso();
                do{
                    System.out.println("Qual a sigla do novo curso?");
                    siglaCurso = novaSiglaCurso.nextLine();
                    arrayAlunos.get(aluno).setSiglaCurso(siglaCurso);
                }while(!Objects.equals(siglaCurso, "LEI") || !siglaCurso.equals("LEI-PL") && siglaAtualCurso.equals(siglaCurso));
            default:
                // code block
        }
        return arrayAlunos;
    }*/

}
