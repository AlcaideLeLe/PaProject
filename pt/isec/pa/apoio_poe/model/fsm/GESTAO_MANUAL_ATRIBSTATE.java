package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class GESTAO_MANUAL_ATRIBSTATE extends apoio_poeAdapter{
    public GESTAO_MANUAL_ATRIBSTATE(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.GESTAO_MANUAL_ATRIBSTATE;
    }
    @Override
    public void atribuicaoDeAlunosSemPropostasDefinidas(){};
    @Override
    public void atribuirAutoproposta(){data.atribuirAutoproposta();};
    @Override
    public void atribuirPropostaDeDocente(){data.atribuirPropostaDeDocente();};
    @Override
    public boolean changeFromGestaoManualAtribToFase3() {
        changeState(apoio_poeState.FASE3);
        return false;
    }
    @Override
    public void atribuirPropostaManualmente(long nrAluno, String idProposta){data.atribuirPropostaManualmente(nrAluno,idProposta);};
    @Override
    public void removerPropostaManualmente(long nrAluno){data.removerPropostaManualmente(nrAluno);};
}
