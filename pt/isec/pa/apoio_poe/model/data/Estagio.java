package pt.isec.pa.apoio_poe.model.data;

public class Estagio extends Proposta{
    private String idEntidadeAcolhimento;
    private String areaDestino;
    public Estagio(String idProposta, long nrAluno, String titulo, String idEntidadeAcolhimento, String areaDestino) {
        super(idProposta, nrAluno, titulo);
        this.idEntidadeAcolhimento = idEntidadeAcolhimento;
        this.areaDestino = areaDestino;
    }

    public String getIdEntidadeAcolhimento() {
        return idEntidadeAcolhimento;
    }

    public String getAreaDestino() {
        return areaDestino;
    }

    public void setAreaDestino(String areaDestino) {
        this.areaDestino = areaDestino;
    }
}
