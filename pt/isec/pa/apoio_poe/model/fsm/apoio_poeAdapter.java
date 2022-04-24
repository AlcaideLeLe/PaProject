package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

abstract class apoio_poeAdapter implements IApoio_poeState{
    apoio_poeContext context;
    PoE data;

    public apoio_poeAdapter(apoio_poeContext context, PoE data){
        this.context = context;
        this.data = data;
    }

}
