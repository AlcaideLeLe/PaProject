package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class GESTAO_MANUAL_ATRIBSTATE extends apoio_poeAdapter{
    public GESTAO_MANUAL_ATRIBSTATE(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return null;
    }
    @Override
    public void atribuicaoDeAlunosSemPropostasDefinidas(){};
    @Override
    public void atribuirAutoproposta(){};
    @Override
    public void atribuirPropostaDeDocente(){};
}
