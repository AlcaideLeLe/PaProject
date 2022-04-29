package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE1BlockState extends apoio_poeAdapter{
    public FASE1BlockState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE1BLOCKSTATE;
    }
    //aqui só vai dar para consultar, mas não alterar
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE2);
        return true;
    }
    @Override
    public String consultaAluno(long nrAluno){return data.consultarAluno(nrAluno);}
    @Override
    public String consultaAlunos(){return data.consultarAlunos();}
    @Override
    public String consultaDocente(String email){return data.consultarDocente(email);}
    @Override
    public String consultaDocentes(){return data.consultarDocentes();}
    @Override
    public String consultaProposta(String IDProposta){return data.consultarProposta(IDProposta);}
    @Override
    public String consultaPropostas(){return data.consultarPropostas();}
}
