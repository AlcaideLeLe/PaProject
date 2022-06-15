package pt.isec.pa.apoio_poe.model.data;

import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import java.io.*;
import java.util.*;

public class PoE implements Serializable{
    ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
    ArrayList<Docente> listaDeDocentes = new ArrayList<>();
    ArrayList<Proposta> listaDePropostas = new ArrayList<>();
    ArrayList<Candidatura> listaDeCandidaturas = new ArrayList<>();
    public int faseFechada;
    public PoE(){
        faseFechada = 0;
    }




    public void addAluno() {
        try {
            System.out.println("Estou a inserir alunos");
            ArrayList<String> arrayAluno = new ArrayList<>();
            Scanner scAluno = new Scanner(new File("pt/isec/pa/apoio_poe/model/data/Aluno.csv"));
            scAluno.useDelimiter(";");
            while (scAluno.hasNext()) {
                arrayAluno.add(scAluno.nextLine());
            }
            String[] dadosAluno;
            boolean exist;
            for (int i = 0; i < arrayAluno.size(); i++) {
                exist = false;
                dadosAluno = arrayAluno.get(i).split(";");
                for(var a: listaDeAlunos){
                    if(a.getNumero() == Long.parseLong(dadosAluno[0])){
                        exist = true;
                        break;
                    }
                }
                if(exist){
                    continue;
                }
                listaDeAlunos.add(new Aluno(Long.parseLong(dadosAluno[0]), dadosAluno[1], dadosAluno[2],
                        dadosAluno[3], dadosAluno[4], Double.parseDouble(dadosAluno[5]),
                        Boolean.parseBoolean(dadosAluno[6]), null));
                System.out.println("Inseri alunos");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } //FALTA VERIFICAR

    public void addAlunoSingular(Aluno a){
            listaDeAlunos.add(a);
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
            boolean exist;
            for (int i = 0; i < arrayDocente.size(); i++) {
                exist = false;
                dadosDocente = arrayDocente.get(i).split(",");
                for(var d : listaDeDocentes){
                    if(Objects.equals(d.getEmail(), dadosDocente[1])){
                        exist = true;
                        break;
                    }
                }
                if(exist){
                    continue;
                }
                listaDeDocentes.add(new Docente(dadosDocente[0], dadosDocente[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } //FALTA VERIFICAR

    public void addDocenteSingular(Docente d){
        listaDeDocentes.add(d);
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
            boolean exist;
            for (int i = 0; i < arrayProposta.size(); i++) {
                exist = false;
                dadosProposta = arrayProposta.get(i).split(",");

                for (var p : listaDePropostas) {
                    if (p.getIdProposta().equals(dadosProposta[1])) {
                        exist = true;
                        break;
                    }
                }
                if (exist) {
                    continue;
                }

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
                                dadosProposta[2], dadosProposta[4], false));
                    } else {
                        listaDePropostas.add(new Projeto(dadosProposta[0], dadosProposta[1], 0, dadosProposta[3],
                                dadosProposta[2], dadosProposta[4], false));
                    }

                } else if (dadosProposta[0].equals("T3")) {
                    listaDePropostas.add(new Autoproposto(dadosProposta[0], dadosProposta[1], Long.parseLong(dadosProposta[3]), dadosProposta[2], false));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } //FALTA VERIFICAR

    public void addPropostaSingular(Proposta p){
        listaDePropostas.add(p);
    }

    public String consultarAluno(long numero){
        for(int i=0; i<listaDeAlunos.size(); i++){
            if(listaDeAlunos.get(i).getNumero() == numero){
                return listaDeAlunos.get(i).toString();
            }

        }
        return null;
    }

    public ArrayList<Aluno> consultarAlunos(){
        Collections.sort(listaDeAlunos);
        if(listaDeAlunos.isEmpty()){
            System.out.println("Ainda não foram adicionados Alunos");
        }
        return listaDeAlunos;
    }

    public String consultarDocente(String email){
        for(int i=0; i<listaDeDocentes.size(); i++){
            if(listaDeDocentes.get(i).getEmail().equals(email)){
                return listaDeDocentes.get(i).toString();
            }

        }
        return null;
    }

    public ArrayList<Docente> consultarDocentes(){
        Collections.sort(listaDeDocentes);
        if(listaDeDocentes.isEmpty()){
            System.out.println("Ainda não foram adicionados docentes");
        }
        return listaDeDocentes;
    }

    public String consultarProposta(String idProposta){
        for(int i=0; i<listaDePropostas.size(); i++){
            if(listaDePropostas.get(i).getIdProposta().equals(idProposta)){
                return listaDePropostas.get(i).toString();
            }
        }
        return null;
    }

    public ArrayList<Proposta> consultarPropostas(){
        Collections.sort(listaDePropostas);
        if(listaDePropostas.isEmpty()){
            System.out.println("Ainda não foram adicionadas propostas");
        }
        return listaDePropostas;
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
            boolean exist;
            for (int i = 0; i < arrayCandidatura.size(); i++) {
                exist = false;
                dadosCandidatura = arrayCandidatura.get(i).split(",");
                for (var c : listaDeCandidaturas) {
                    if (c.getNumero() == Long.parseLong(dadosCandidatura[0])) {
                        exist = true;
                        break;
                    }
                }
                if (exist) {
                    continue;
                }

                listaDeCandidaturas.add(new Candidatura(Long.parseLong(dadosCandidatura[0]), new ArrayList<>(List.of(Arrays.copyOfRange(dadosCandidatura,1,dadosCandidatura.length)))));

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
    public ArrayList<Candidatura> consultarCandidaturas(){
        Collections.sort(listaDeCandidaturas);
        return listaDeCandidaturas;
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

    public String consultarAlunosComAutoproposta(){ //Filtro Alunos com Autoproposta
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
                    if(a.getIdPropostaAssociada() == null) {
                        if (listaDeAlunosComAutoProposta.contains(a.getNumero())) {
                            a.setIdPropostaAssociada(p.getIdProposta());
                            p.setAtribuida(true);
                        }
                    }
                }
            }
        }
    } //JA VERIFICADA

    public void atribuirPropostaDeDocente(){
        ArrayList<Long> listaDeAlunosPropostaDeDocente = new ArrayList<>();
        for (var p : listaDePropostas) {
            if(p instanceof Projeto){
                if(p.getNrAluno() != 0){
                    listaDeAlunosPropostaDeDocente.add(p.getNrAluno());
                    for(var a : listaDeAlunos){
                        if(a.getIdPropostaAssociada() == null) {
                            if (a.getNumero() == p.getNrAluno()) {
                                a.setIdPropostaAssociada(p.getIdProposta());
                                p.setAtribuida(true);

                            }
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
                                    }
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
    } //JA VERIFICADA

    public String consultarPropostasComCandidaturas(){ //Filtro Proposta Com candidatura
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

    public String consultarPropostasSemCandidaturas(){ //Filtro Proposta Sem candidatura
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

    public String consultarAlunosComPropostasDeDocentes(){ //filtro Autopropostas de alunos
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
                pna.setNrAluno(asp.getNumero());
                p = pna;
                    for(var pr : listaDePropostas){
                        if(Objects.equals(pr.getIdProposta(), p.getIdProposta())){
                            pr.setAtribuida(true);
                            pr.setNrAluno(pna.getNrAluno());
                        }
                    }
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

    public String consultarAlunosComPropostaAtribuida(){
        StringBuilder sb = new StringBuilder();
        for(var a : listaDeAlunos){
            if(a.getIdPropostaAssociada() != null){
                sb.append("Numero de Aluno: ").append(a.toString()).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }

    public String consultarPropostasDisponiveis(){
        StringBuilder sb = new StringBuilder();
        for(var p : listaDePropostas){
            if(!p.isAtribuida()){
                sb.append("Proposta nao atribuida \n").append(p.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    } //FEITO HOJE E TESTADO

    public String consultarPropostasAtribuidas(){
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
    } //FEITO HOJE, TESTADO, QUANDO SE FIZER VERIFICACOES A DOCENTES FICA RESOLVIDO

    public void atribuirManualmenteOrientadorAAlunosComPropostas(long nrAlunoDaProposta, String emailProf){
        for(var p : listaDePropostas){
            if(p.getOrientador() == null) {
                if (p.isAtribuida()) {
                    if (p.getNrAluno() == nrAlunoDaProposta) {
                        for (var d : listaDeDocentes) {
                            if (Objects.equals(d.getEmail(), emailProf)) {
                                p.setOrientador(emailProf);
                                d.incrementaNrDeOrientacoes();
                            }
                        }
                    }
                }
            }
        }
    } //JA VERIFICADA

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

    public String consultarAlunosComPropostaEComOrientador(){
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
    public String consultarAlunosComPropostaESemOrientador(){
        StringBuilder sb = new StringBuilder();
        for(var a : listaDeAlunos){
            if(a.getIdPropostaAssociada() != null){
                for(var p : listaDePropostas){
                    if(p.isAtribuida()){
                        if(p.getOrientador() == null){
                            sb.append("Alunos com Proposta e sem orientador   ").append(a.getNumero()).append(System.lineSeparator());
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

    public String consultarMediaDeOrientacoesDosDocentes(){
        float media = 0;

        for(int i=0; i<listaDeDocentes.size(); i++){
            listaDeDocentes.get(i).getNrDeOrientacoes();
            media += listaDeDocentes.get(i).getNrDeOrientacoes();
        }
        media /= listaDeDocentes.size();
        return "A media dos orientador e: "+media;
    }



    public String consultarAlunosComCandidaturaESemProposta(){
        StringBuilder sb = new StringBuilder();

        for(var c : listaDeCandidaturas){
            for(var a : listaDeAlunos){
                if(a.getIdPropostaAssociada() == null){
                    if(c.getNumero() == a.getNumero()){
                        sb.append("Alunos sem proposta e com candidatura   ").append(a.getNumero()).append(System.lineSeparator());
                    }
                }
            }
        }


        return sb.toString();
    }

    public void removerTodasAsAtribuicoes(){
        for(var p : listaDePropostas){
            if(p instanceof Estagio) {
                for (var a : listaDeAlunos) {
                    if(Objects.equals(p.getIdProposta(), a.getIdPropostaAssociada())){
                        a.setIdPropostaAssociada(null);
                        p.setAtribuida(false);
                        p.setNrAluno(0);
                    }
                }
            }
        }
    }

    public String consultarPropostasDocentes(){
        StringBuilder sb = new StringBuilder();
        for(var p : listaDePropostas){
            if(p instanceof Projeto){
                sb.append("Proposta ").append(p).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }

    public void exportarDocentesParaCSV(String nomeFicheiro){
        StringBuilder sb = new StringBuilder();

        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nomeFicheiro)))) {
            for(var d :listaDeDocentes){
                sb.append(d.getNome()).append(",").append(d.getEmail()).append(System.lineSeparator());
            }
            pw.println(sb.toString().trim());
        }catch (IOException e) {
            return;
        }
    }
    public void exportarAlunosParaCSV(String nomeFicheiro){
        StringBuilder sb = new StringBuilder();

        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nomeFicheiro)))) {
            for(var a : listaDeAlunos){
                sb.append(a.getNumero()).append(",").append(a.getNome()).append(",").append(a.getEmail()).append("").append(a.getSiglaCurso()).append(",").
                        append(a.getSiglaRamo()).append(",").append(a.getClassificacao()).append(",").append(a.isAcessoEstagio()).append(System.lineSeparator());
            }
            pw.println(sb.toString().trim());
        }catch (IOException e) {
            return;
        }
    }
    public void exportarPropostaParaCSV(String nomeFicheiro){
        StringBuilder sb = new StringBuilder();

        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nomeFicheiro)))) {
            for(var pr : listaDePropostas){
                if(pr instanceof Estagio e) {
                    sb.append(e.getTipoDeProposta()).append(",").append(e.getIdProposta()).append(",").append(e.getAreaDestino()).append(",").append(e.getIdEntidadeAcolhimento()).append(System.lineSeparator());
                }
                else if(pr instanceof Projeto p){
                    sb.append(p.getTipoDeProposta()).append(",").append(p.getIdProposta()).append(",").append(p.getAreaDestino()).append(",").append(p.getTitulo()).append(",").append(p.getDocenteProponente()).append(",").append(p.getNrAluno()).append(System.lineSeparator());

                }
                else if(pr instanceof Autoproposto a){
                    sb.append(a.getTipoDeProposta()).append(",").append(a.getIdProposta()).append(",").append(a.getTitulo()).append(",").append(a.getNrAluno()).append(System.lineSeparator());
                }
            }
            pw.println(sb.toString().trim());
        }catch (IOException e) {
            return;
        }

    }
    public void exportarCandidaturasParaCSV(String nomeFicheiro){
        StringBuilder sb = new StringBuilder();

        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nomeFicheiro)))) {
            for(var c :listaDeCandidaturas){
                sb.append(c.getNumero());
                for(var p : c.getPropostas()){
                    sb.append(",").append(p);
                }
                sb.append(System.lineSeparator());
            }
            pw.println(sb.toString().trim());
        }catch (IOException e) {
            return;
        }
    }


    public String consultarOrientacoesDocente(String email){
        StringBuilder sb = new StringBuilder();
        for(var d : listaDeDocentes){
            if(d.getEmail().equals(email)) {
                sb.append("Numero de orientacoes ").append(d.getNrDeOrientacoes()).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }


}




