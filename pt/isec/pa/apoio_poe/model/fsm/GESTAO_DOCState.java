package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.PoE;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GESTAO_DOCState extends apoio_poeAdapter{
    public GESTAO_DOCState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.GESTAO_DOC;
    }

    @Override
    public boolean changeFromGestaoDOCtoBase() {
        changeState(apoio_poeState.FASE1);
        return true;
    }
    @Override
    public void addDocente(){data.addDocente();}
    @Override
    public void addDocenteSingular(Docente d){data.addDocenteSingular(d);};
    @Override
    public String consultaDocente(String email){return data.consultarDocente(email);}
    @Override
    public ArrayList<Docente> consultaDocentes(){return data.consultarDocentes();}
    @Override
    public void atribuirPropostaADocenteProponenteAutomaticamente(){data.atribuirPropostaADocenteProponenteAutomaticamente();}
    @Override
    public void exportarDocentesParaCSV(String nomeFicheiro){data.exportarAlunosParaCSV(nomeFicheiro);};

}
