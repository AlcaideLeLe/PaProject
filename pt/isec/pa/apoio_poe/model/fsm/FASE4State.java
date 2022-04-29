package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE4State extends apoio_poeAdapter{

    public FASE4State(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE4;
    }


    @Override
    public boolean recuarFase() {
        if(data.faseFechada <= 2) {
            changeState(apoio_poeState.FASE3);
            return true;
        }
        changeState(apoio_poeState.FASE3BLOCKSTATE) ;
        return false;
    }
    @Override
    public void fecharFase() {
        data.faseFechada = 3;
    }
    @Override
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE5);
        return true;
    }

    @Override
    public boolean changeToGestaoORI() {
        changeState(apoio_poeState.GESTAO_ORI);
        return true;
    }
}