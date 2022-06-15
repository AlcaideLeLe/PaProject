package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.util.ArrayList;

public class FASE5State extends apoio_poeAdapter{
    public FASE5State(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE5;
    }

    public ArrayList<Aluno> consultarAlunosComPropostaAtribuida(){return data.consultarAlunosComPropostaAtribuida();};
    @Override
    public String consultarAlunosComCandidaturaESemProposta(){return data.consultarAlunosComCandidaturaESemProposta();};
    @Override
    public ArrayList<Proposta> consultarPropostasDisponiveis(){return data.consultarPropostasDisponiveis();};
    @Override
    public ArrayList<Proposta> consultarPropostasAtribuidas(){return data.consultarPropostasAtribuidas();};
    @Override
    public String consultarDocenteComMenosOrientacoes(){return data.consultarDocenteComMenosOrientacoes();};
    @Override
    public String consultarDocenteComMaisOrientacoes(){return data.consultarDocenteComMaisOrientacoes();};
    @Override
    public String consultarMediaDeOrientacoesDosDocentes(){return data.consultarMediaDeOrientacoesDosDocentes();};
    @Override
    public void exportarAlunosParaCSV(String nomeFicheiro){data.exportarAlunosParaCSV(nomeFicheiro);};

}
