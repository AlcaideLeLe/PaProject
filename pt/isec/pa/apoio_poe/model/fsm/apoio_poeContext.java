package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class apoio_poeContext {
    private PoE data;
    private IApoio_poeState state;

    public apoio_poeContext(){
        this.data = new PoE();
        this.state = apoio_poeState.FASE1.createState(this, data);
    }

}
