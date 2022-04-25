package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE3BlockState extends apoio_poeAdapter{
    public FASE3BlockState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE3BLOCKSTATE;
    }

    //aqui só vai dar para consultar, mas não alterar
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE4);
        return true;
    }
}
