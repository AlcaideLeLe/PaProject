package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE2State extends apoio_poeAdapter{

    public FASE2State(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE2;
    }

    @Override
    public boolean recuarFase() {
        if(data.faseFechada <= 0) {
            changeState(apoio_poeState.FASE1);
            return true;
        }
        changeState(apoio_poeState.FASE1BLOCKSTATE) ;
        return false;
    }
    @Override
    public void fecharFase() {
        data.faseFechada = 2;
    }
    @Override
    public boolean avancarFase() {
        if(data.faseFechada <=1){
            changeState(apoio_poeState.FASE3MasFASE2AbertaState);
            return true;
        }
        changeState(apoio_poeState.FASE3);
        return true;
    }
    @Override
    public boolean changeToGestaoCAND() {
        changeState(apoio_poeState.GESTAO_CAND);
        return true;
    }

    @Override
    public String consultaAlunosComAutoproposta(){return data.consultarAlunosComAutoproposta();}
    @Override
    public String consultarAlunosComCandidatura(){return data.consultarAlunosComCandidatura();};
    @Override
    public String consultarAlunosSemCandidatura(){return data.consultarAlunosSemCandidatura();};
    @Override
    public String consultarListaDeAutopropostas(){return data.consultarListaDeAutopropostas();};
    @Override
    public String consultarPropostasDeDocentes(){return data.consultarPropostasDocentes();};
    @Override
    public String consultarPropostasComCandidaturas(){return data.consultarPropostasComCandidaturas();};
    @Override
    public String consultarPropostasSemCandidaturas(){return data.consultarPropostasSemCandidaturas();};
    @Override
    public String consultaPropostas(){return data.consultarPropostas();}
}
