package pt.isec.pa.apoio_poe.model.data;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Aluno {

    private final long numero;
    private String nome;
    private String email;
    private String siglaCurso;
    private String siglaRamo;
    private double classificacao;
    private boolean acessoEstagio;


    public Aluno(long numero, String nome, String email, String siglaCurso, String siglaRamo, double classificacao, boolean acessoEstagio) {
        this.numero = numero;
        this.nome = nome;
        this.email = email;
        this.siglaCurso = siglaCurso;
        this.siglaRamo = siglaRamo;
        this.classificacao = classificacao;
        this.acessoEstagio = acessoEstagio;
    }

    public long getNumero() {return numero;}
    public String getNome() {return nome;}
    public String getEmail() {return email;}
    public String getSiglaCurso() {return siglaCurso;}
    public double getClassificacao() {return classificacao;}
    public void setNome(String nome) {this.nome = nome;}
    public void setEmail(String email) {this.email = email;}
    public void setSiglaCurso(String siglaCurso) {this.siglaCurso = siglaCurso;}
    public String getSiglaRamo() {return siglaRamo;}
    public void setSiglaRamo(String siglaRamo) {this.siglaRamo = siglaRamo;}
    public void setClassificacao(double classificacao) {this.classificacao = classificacao;}
    public boolean isAcessoEstagio() {return acessoEstagio;}
    public void setAcessoEstagio(boolean acessoEstagio) {this.acessoEstagio = acessoEstagio;}

    public ArrayList<Aluno> editAluno(ArrayList<Aluno> arrayAlunos){
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
    }
}


