package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.io.FileNotFoundException;
import java.util.ArrayList;

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
        data.addProposta();
    }
    @Override
    public String consultaProposta(String IDProposta){return data.consultarProposta(IDProposta);}
    @Override
    public ArrayList<Proposta> consultaPropostas(){return data.consultarPropostas();}
    @Override
    public void exportarPropostasParaCSV(String nomeFicheiro){data.exportarAlunosParaCSV(nomeFicheiro);};
}
