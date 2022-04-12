package pt.isec.pa.apoio_poe.model.data;

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
}


