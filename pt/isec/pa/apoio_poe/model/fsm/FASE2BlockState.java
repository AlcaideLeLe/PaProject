package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE2BlockState extends apoio_poeAdapter{
    public FASE2BlockState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE2BLOCKSTATE;
    }

    //aqui só vai dar para consultar, mas não alterar
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE3);
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
    public String consultarPropostasComCadidaturas(){return data.consultarPropostasComCandidaturas();};
    @Override
    public String consultarPropostasSemCadidaturas(){return data.consultarPropostasSemCandidaturas();};
    @Override
    public String consultaCandidatura(long nrAluno){return data.consultarCandidatura(nrAluno);}
    @Override
    public String consultaAlunos(){return data.consultarAlunos();}
}
