package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE3State extends apoio_poeAdapter{
    public FASE3State(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE3;
    }

    @Override
    public boolean recuarFase() {
        if(data.faseFechada <= 1) {
            changeState(apoio_poeState.FASE2);
            return true;
        }
        changeState(apoio_poeState.FASE2BLOCKSTATE) ;
        return false;
    }
    @Override
    public void fecharFase() {
        data.faseFechada = 3;
    }
    @Override
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE4);
        return true;
    }
    @Override
    public boolean changeToTratamentoProp(){
        changeState(apoio_poeState.TRATAMENTO_PROP);
        return true;
    }
    @Override
    public boolean changeToGestaoManualAtribuicoesState(){
        changeState(apoio_poeState.GESTAO_MANUAL_ATRIBSTATE);
        return true;
    }
    @Override
    public String consultaAlunosComAutoproposta(){return data.consultarAlunosComAutoproposta();};
    @Override
    public String consultarAlunosComCandidatura(){return data.consultarAlunosComCandidatura();};
    @Override
    public String consultarAlunosComPropostaAtribuida(){return data.consultarAlunosComPropostaAtribuida();};
    @Override
    public String consultarAlunosSemPropostaAtribuida(){return data.consultarAlunosSemPropostaAtribuida();};
    @Override
    public String consultarListaDeAutopropostas(){return data.consultarListaDeAutopropostas();};
    @Override
    public String consultarPropostasDeDocentes(){return data.consultarPropostasDocentes();};
    @Override
    public String consultarPropostasDisponiveis(){return data.consultarPropostasDisponiveis();};
    @Override
    public String consultarPropostasAtribuidas(){return data.consultarPropostasAtribuidas();};


}
