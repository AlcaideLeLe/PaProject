package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class GESTAO_MANUAL_ORIENTSTATE extends apoio_poeAdapter{
    public GESTAO_MANUAL_ORIENTSTATE(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return null;
    }
    @Override
    public void atribuirManulamenteOrientadorAAlunosComProposta(long nrAluno, String emailProf){};
    @Override
    public String consultarOrientadorDeProposta(String idProposta){return data.consultarOrientadorDeProposta(idProposta);};
    @Override
    public void editarOrientadorDeProposta(String idProposta, String emailNovoOrientador){};
    @Override
    public void removerOrientadorDeProposta(String idProposta){};
}
