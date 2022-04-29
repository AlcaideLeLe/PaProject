package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE2State extends apoio_poeAdapter{

    public FASE2State(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE2;
    }

    @Override
    public boolean recuarFase() {
        if(data.faseFechada <= 0) {
            changeState(apoio_poeState.FASE1);
            return true;
        }
        changeState(apoio_poeState.FASE1BLOCKSTATE) ;
        return false;
    }
    @Override
    public void fecharFase() {
        data.faseFechada = 2;
    }
    @Override
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE3);
        return true;
    }
    @Override
    public boolean changeToGestaoCAND() {
        changeState(apoio_poeState.GESTAO_CAND);
        return true;
    }
}