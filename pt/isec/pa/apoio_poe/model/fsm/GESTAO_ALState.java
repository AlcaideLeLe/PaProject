package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.PoE;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GESTAO_ALState extends apoio_poeAdapter{
    public GESTAO_ALState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.GESTAO_AL;
    }

    @Override
    public boolean changeFromGestaoALtoBase() {
        changeState(apoio_poeState.FASE1);
        return true;
    }
    @Override
    public void addAluno(){data.addAluno();}
    @Override
    public void addAlunoSingular(Aluno a){data.addAlunoSingular(a);}
    @Override
    public String consultaAluno(long nrAluno){return data.consultarAluno(nrAluno);}
    @Override
    public ArrayList<Aluno> consultarAlunos(){return data.consultarAlunos();}
    @Override
    public void exportarAlunosParaCSV(String nomeFicheiro){data.exportarAlunosParaCSV(nomeFicheiro);};




}
