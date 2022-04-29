package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class GESTAO_MANUAL_ORIENTSTATE extends apoio_poeAdapter{
    public GESTAO_MANUAL_ORIENTSTATE(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return null;
    }
}
