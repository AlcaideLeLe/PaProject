package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class GESTAO_CANDState extends apoio_poeAdapter{
    public GESTAO_CANDState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.GESTAO_CAND;
    }

    @Override
    public boolean changeFromGestaoCANDtoBase() {
        changeState(apoio_poeState.FASE2);
        return false;
    }
    @Override
    public void addCandidatura(){data.addCandidatura();}
    @Override
    public String consultaCandidaturas(){return data.consultarCandidaturas();}
    @Override
    public String consultaCandidatura(long nrAluno){return data.consultarCandidatura(nrAluno);}
    @Override
    public String consultaAlunos(){return data.consultarAlunos();}
}
