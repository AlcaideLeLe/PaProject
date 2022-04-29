package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE3BlockState extends apoio_poeAdapter{
    public FASE3BlockState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE3BLOCKSTATE;
    }

    //aqui só vai dar para consultar, mas não alterar
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE4);
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
