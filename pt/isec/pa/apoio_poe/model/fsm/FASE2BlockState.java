package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE2BlockState extends apoio_poeAdapter{
    public FASE2BlockState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE2BLOCKSTATE;
    }

    //aqui só vai dar para consultar, mas não alterar
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE3);
        return true;
    }
}
