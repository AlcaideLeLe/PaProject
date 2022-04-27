package pt.isec.pa.apoio_poe.model.data;

public class Autoproposto extends Proposta{

    public Autoproposto(String tipoDeProposta, String idProposta, long nrAluno, String titulo) {
        super(tipoDeProposta, idProposta, nrAluno, titulo);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo de Proposta: ").append(getTipoDeProposta()).append(System.lineSeparator());
        sb.append("ID Proposta: ").append(getIdProposta()).append(System.lineSeparator());
        sb.append("nrAluno: ").append(getNrAluno()).append(System.lineSeparator());
        sb.append("Titulo: ").append(getTitulo()).append(System.lineSeparator());
        sb.append(System.lineSeparator());

        return sb.toString();
    }
}
