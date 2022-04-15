package pt.isec.pa.apoio_poe.model.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class PoE {
    ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
    ArrayList<Docente> listaDeDocentes = new ArrayList<>();
    ArrayList<Proposta> listaDePropostas = new ArrayList<>();

    public void addAluno() throws FileNotFoundException {
        ArrayList<String> arrayAluno = new ArrayList<>();
        Scanner scAluno = new Scanner(new File("pt/isec/pa/apoio_poe/model/data/Aluno.csv"));
        scAluno.useDelimiter(";");
        while (scAluno.hasNext()) {
            arrayAluno.add(scAluno.nextLine());
        }
        String[] dadosAluno;

        for(int i=0; i < arrayAluno.size() ; i++){
            dadosAluno = arrayAluno.get(i).split(";");
            listaDeAlunos.add(new Aluno(Long.parseLong(dadosAluno[0]), dadosAluno[1], dadosAluno[2],
                    dadosAluno[3], dadosAluno[4], Double.parseDouble(dadosAluno[5]),
                    Boolean.parseBoolean(dadosAluno[6])));
        }
    }

    public void addDocente() throws FileNotFoundException {
        ArrayList<String> arrayDocente = new ArrayList<>();
        Scanner scDocente = new Scanner(new File("pt/isec/pa/apoio_poe/model/data/Docentes.csv"));
        //parsing a CSV file into the constructor of Scanner class

        scDocente.useDelimiter(",");
        //setting comma as delimiter pattern

        while (scDocente.hasNext()) {
            arrayDocente.add(scDocente.nextLine());
        }

        String[] dadosDocente;

        for(int i=0; i < arrayDocente.size() ; i++){
            dadosDocente = arrayDocente.get(i).split(",");
            listaDeDocentes.add(new Docente(dadosDocente[0], dadosDocente[1]));
        }
    }

    public void addProposta() throws FileNotFoundException {
        ArrayList<String> arrayProposta = new ArrayList<>();
        Scanner scProposta = new Scanner(new File("pt/isec/pa/apoio_poe/model/data/Propostas.csv"));
        //parsing a CSV file into the constructor of Scanner class

        scProposta.useDelimiter(",");
        //setting comma as delimiter pattern

        while (scProposta.hasNext()) {
            arrayProposta.add(scProposta.nextLine());
        }

        String[] dadosProposta;

        for(int i=0; i < arrayProposta.size() ; i++){
            dadosProposta = arrayProposta.get(i).split(",");
            if(dadosProposta[0].equals("T1")){
                if(dadosProposta.length == 6) {
                    listaDePropostas.add(new Estagio(dadosProposta[1], Long.parseLong(dadosProposta[5]), dadosProposta[3],
                            dadosProposta[4], dadosProposta[2]));
                }
                else{
                    listaDePropostas.add(new Estagio(dadosProposta[1], 0, dadosProposta[3],
                            dadosProposta[4], dadosProposta[2]));
                }
            }
            else if(dadosProposta[0].equals("T2")){
                if(dadosProposta.length == 6){
                    listaDePropostas.add(new Projeto(dadosProposta[1], Long.parseLong(dadosProposta[5]), dadosProposta[3],
                            dadosProposta[2], dadosProposta[4]));
                }
                else{
                    listaDePropostas.add(new Projeto(dadosProposta[1], 0, dadosProposta[3],
                            dadosProposta[2], dadosProposta[4]));
                }

            }
            else if(dadosProposta[0].equals("T3")){
                listaDePropostas.add(new Autoproposto(dadosProposta[1], Long.parseLong(dadosProposta[3]), dadosProposta[2]));
            }

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
