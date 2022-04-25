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
        changeState(apoio_poeState.FASE2);
        return true;
    }
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE3);
        return true;
    }
}
