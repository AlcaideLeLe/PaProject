package pt.isec.pa.apoio_poe.model.data;

public class Projeto extends Proposta{
    private String areaDestino;
    private String docenteProponente;
    public Projeto(String tipoDeProposta, String idProposta, long nrAluno, String titulo, String areaDestino, String docenteProponente) {
        super(tipoDeProposta,idProposta, nrAluno, titulo);
        this.areaDestino = areaDestino;
        this.docenteProponente = docenteProponente;
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
