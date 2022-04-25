package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

import java.io.FileNotFoundException;

public class GESTAO_PROPState extends apoio_poeAdapter{
    public GESTAO_PROPState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.GESTAO_PROP;
    }

    @Override
    public boolean changeFromGestaoPROPtoBase() {
        changeState(apoio_poeState.FASE1);
        return false;
    }
    @Override
    public void addProposta(){
        context.addProposta();
    }
    @Override
    public String consultaProposta(String email){return context.consultaProposta(email);}
    public String consultaPropostas(){return context.consultaPropostas();}

}
