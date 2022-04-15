package pt.isec.pa.apoio_poe.model.data;

public class Docente implements Comparable<Docente>{

    private String nome;
    private final String email;
    private String funcaoProjeto;


    public Docente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {return nome;}
    public String getEmail() {return email;}
    public String getFuncaoProjeto() {return funcaoProjeto;}
    public void setNome(String nome) {this.nome = nome;}
    public void setFuncaoProjeto(String funcaoProjeto) {this.funcaoProjeto = funcaoProjeto;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: ").append(nome).append(System.lineSeparator());
        sb.append("E-mail: ").append(email).append(System.lineSeparator());
        sb.append("Funcao Projeto: ").append(funcaoProjeto).append(System.lineSeparator());
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public int compareTo(Docente o) {
        return email.compareTo(o.email);
    }
}