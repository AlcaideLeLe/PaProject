package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class TRATAMENTO_PROPState extends apoio_poeAdapter{
    public TRATAMENTO_PROPState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.TRATAMENTO_PROP;
    }

    @Override
    public boolean changeFromTratamentoPropToBase() {
        changeState(apoio_poeState.FASE3);
        return true;
    }

    @Override
    public boolean changeToGestaoManualAtribuicoesState(){
        changeState(apoio_poeState.GESTAO_MANUAL_ATRIBSTATE);
        return true;
    }

    @Override
    public void atribuicaoDeAlunosSemPropostasDefinidas(){}

    @Override
    public void atribuirAutoproposta(){data.atribuirAutoproposta();}

    @Override
    public void atribuirPropostaDeDocente(){data.atribuirPropostaDeDocente();}

    @Override
    public void removerTodasAsAtribuicoes(){data.removerTodasAsAtribuicoes();}


}
