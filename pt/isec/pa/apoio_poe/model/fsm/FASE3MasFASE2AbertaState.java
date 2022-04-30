package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE3MasFASE2AbertaState extends apoio_poeAdapter{
    public FASE3MasFASE2AbertaState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return null;
    }

    @Override
    public boolean changeFromF3MasF2AbertaToBase(){
        changeState(apoio_poeState.FASE3);
        return true;
    }
}
