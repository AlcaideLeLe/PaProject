package pt.isec.pa.apoio_poe.model.data;

public class Proposta implements Comparable<Proposta>{
    private final String idProposta;
    private long nrAluno;
    private String titulo;
    private String tipoDeProposta;

    public Proposta(String tipoDeProposta, String idProposta, long nrAluno, String titulo) {
        this.tipoDeProposta = tipoDeProposta;
        this.idProposta = idProposta;
        this.nrAluno = nrAluno;
        this.titulo = titulo;
    }
    public String getTipoDeProposta() {return tipoDeProposta;}
    public String getIdProposta() {return idProposta;}
    public long getNrAluno() {return nrAluno;}
    public void setNrAluno(long nrAluno) {this.nrAluno = nrAluno;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo de Proposta: ").append(tipoDeProposta).append(System.lineSeparator());
        sb.append("ID Proposta: ").append(idProposta).append(System.lineSeparator());
        sb.append("nrAluno: ").append(nrAluno).append(System.lineSeparator());
        sb.append("Titulo: ").append(titulo).append(System.lineSeparator());
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public int compareTo(Proposta o) {
        return idProposta.compareTo(o.idProposta);
    }
}
