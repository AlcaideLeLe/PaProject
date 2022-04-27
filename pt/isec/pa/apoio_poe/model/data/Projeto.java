package pt.isec.pa.apoio_poe.model.data;

public class Projeto extends Proposta{
    private String areaDestino;
    private String docenteProponente;
    private long nrAlunoProposto;
    public Projeto(String tipoDeProposta, String idProposta, long nrAluno, String titulo, String areaDestino, String docenteProponente) {
        super(tipoDeProposta,idProposta, nrAluno, titulo);
        this.areaDestino = areaDestino;
        this.docenteProponente = docenteProponente;
        this.nrAlunoProposto = nrAlunoProposto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo de Proposta: ").append(getTipoDeProposta()).append(System.lineSeparator());
        sb.append("ID Proposta: ").append(getIdProposta()).append(System.lineSeparator());
        sb.append("Titulo: ").append(getTitulo()).append(System.lineSeparator());
        sb.append("Docente proponente: ").append(docenteProponente).append(System.lineSeparator());
        sb.append("nrAluno proposto: ").append(getNrAluno()).append(System.lineSeparator());
        sb.append(System.lineSeparator());

        return sb.toString();
    }


    public String getAreaDestino() {
        return areaDestino;
    }

    public void setAreaDestino(String areaDestino) {
        this.areaDestino = areaDestino;
    }

    public String getDocenteProponente() {
        return docenteProponente;
    }

    public void setDocenteProponente(String docenteProponente) {
        this.docenteProponente = docenteProponente;
    }
}
