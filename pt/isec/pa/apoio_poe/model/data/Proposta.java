package pt.isec.pa.apoio_poe.model.data;

public class Proposta implements Comparable<Proposta>{
    private final String idProposta;
    private long nrAluno;
    private String titulo;

    public Proposta(String idProposta, long nrAluno, String titulo) {
        this.idProposta = idProposta;
        this.nrAluno = nrAluno;
        this.titulo = titulo;
    }

    public String getIdProposta() {return idProposta;}
    public long getNrAluno() {return nrAluno;}
    public void setNrAluno(long nrAluno) {this.nrAluno = nrAluno;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    @Override
    public String toString() {
        return "Proposta{" +
                "idProposta='" + idProposta + '\'' +
                ", nrAluno=" + nrAluno +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    @Override
    public int compareTo(Proposta o) {
        return idProposta.compareTo(o.idProposta);
    }
}
