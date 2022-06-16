package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE3MasFASE2AbertaState extends apoio_poeAdapter{
    public FASE3MasFASE2AbertaState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE3MasFASE2AbertaState;
    }

    @Override
    public boolean changeFromF3MasF2AbertaToBase(){
        changeState(apoio_poeState.FASE3);
        return true;
    }
    @Override
    public void atribuirAutoproposta(){data.atribuirAutoproposta();};
    @Override
    public void atribuirPropostaDeDocente(){data.atribuirPropostaDeDocente();};

    @Override
    public boolean recuarFase() {
        changeState(apoio_poeState.FASE2) ;
        return true;
    }





}
