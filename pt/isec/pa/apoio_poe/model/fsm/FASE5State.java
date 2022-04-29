package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE5State extends apoio_poeAdapter{
    public FASE5State(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE5;
    }

    public String consultarAlunosComPropostaAtribuida(){return data.consultarAlunosComPropostaAtribuida();};
    @Override
    public String consultarAlunosComCandidaturaESemProposta(){return data.consultarAlunosComCandidaturaESemProposta();};
    @Override
    public String consultarPropostasDisponiveis(){return data.consultarPropostasDisponiveis();};
    @Override
    public String consultarPropostasAtribuidas(){return data.consultarPropostasAtribuidas();};
    @Override
    public String consultarDocenteComMenosOrientacoes(){return data.consultarDocenteComMenosOrientacoes();};
    @Override
    public String consultarDocenteComMaisOrientacoes(){return data.consultarDocenteComMaisOrientacoes();};
    @Override
    public String consultarMediaDeOrientacoesDosDocentes(){return data.consultarMediaDeOrientacoesDosDocentes();};


}
