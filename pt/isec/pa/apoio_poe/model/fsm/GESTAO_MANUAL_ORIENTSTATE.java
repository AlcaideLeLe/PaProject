package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.PoE;

public class GESTAO_MANUAL_ORIENTSTATE extends apoio_poeAdapter{
    public GESTAO_MANUAL_ORIENTSTATE(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.GESTAO_MANUAL_ORIENTSTATE;
    }
    @Override
    public void atribuirManulamenteOrientadorAAlunosComProposta(long nrAluno, String emailProf, String IDproposta){data.atribuirManualmenteOrientadorAAlunosComPropostas(nrAluno,emailProf, IDproposta);};
    @Override
    public Docente consultarOrientadorDeProposta(String idProposta){return data.consultarOrientadorDeProposta(idProposta);};
    @Override
    public void editarOrientadorDeProposta(String idProposta, String emailNovoOrientador){data.editarOrientadorDeProposta(idProposta, emailNovoOrientador);};
    @Override
    public void removerOrientadorDeProposta(String idProposta){data.removerOrientadorDeProposta(idProposta);};
    @Override
    public boolean changeFromGestaoManualOrientToFase4(){
        changeState(apoio_poeState.FASE4);
        return true;
    }
}
