package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE3State extends apoio_poeAdapter{
    public FASE3State(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE3;
    }

    @Override
    public boolean recuarFase() {
        if(data.faseFechada <= 1) {
            changeState(apoio_poeState.FASE2);
            return true;
        }
        changeState(apoio_poeState.FASE2BLOCKSTATE) ;
        return false;
    }
    @Override
    public void fecharFase() {
        data.faseFechada = 3;
    }
    @Override
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE4);
        return true;
    }
    @Override
    public boolean changeToTratamentoProp(){
        changeState(apoio_poeState.TRATAMENTO_PROP);
        return true;
    }
    @Override
    public boolean changeToGestaoManualAtribuicoesState(){
        changeState(apoio_poeState.GESTAO_MANUAL_ATRIBSTATE);
        return true;
    }


}
