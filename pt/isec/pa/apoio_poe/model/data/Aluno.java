package pt.isec.pa.apoio_poe.model.data;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Aluno implements Comparable<Aluno>{

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Numero de Aluno: ").append(numero).append(System.lineSeparator());
        sb.append("Nome: ").append(nome).append(System.lineSeparator());
        sb.append("E-mail: ").append(email).append(System.lineSeparator());
        sb.append("Sigla Curso: ").append(siglaCurso).append(System.lineSeparator());
        sb.append("Sigla Ramo: ").append(siglaRamo).append(System.lineSeparator());
        sb.append("Classificacao: ").append(classificacao).append(System.lineSeparator());
        sb.append("Acesso estagio: ").append(acessoEstagio).append(System.lineSeparator());
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public int compareTo(Aluno o) {
        return Long.compare(numero, o.numero);
    }
}


