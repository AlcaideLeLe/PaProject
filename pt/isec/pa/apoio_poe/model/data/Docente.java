package pt.isec.pa.apoio_poe.model.data;

public class Docente {

    private String nome;
    private final String email;
    private String funcaoProjeto;


    public Docente(String nome, String email, String funcaoProjeto) {
        this.nome = nome;
        this.email = email;
        this.funcaoProjeto = funcaoProjeto;
    }

    public String getNome() {return nome;}
    public String getEmail() {return email;}
    public String getFuncaoProjeto() {return funcaoProjeto;}
    public void setNome(String nome) {this.nome = nome;}
    public void setFuncaoProjeto(String funcaoProjeto) {this.funcaoProjeto = funcaoProjeto;}
}