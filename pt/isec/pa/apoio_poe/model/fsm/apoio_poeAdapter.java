package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

abstract class apoio_poeAdapter implements IApoio_poeState{
    apoio_poeContext context;
    PoE data;

    public apoio_poeAdapter(apoio_poeContext context, PoE data){
        this.context = context;
        this.data = data;
    }

    public void changeState(apoio_poeState state){
            context.changeState(state.createState(context, data));
    }

    @Override
    public void fecharFase() {}
    @Override
    public boolean avancarFase() {return false;}
    @Override
    public boolean recuarFase() {return false;}
    @Override
    public boolean changeToGestaoAL() {return false;}
    @Override
    public boolean changeToGestaoCAND(){return false;}
    @Override
    public boolean changeToGestaoDOC(){return false;}
    @Override
    public boolean changeToGestaoORI(){return false;}
    @Override
    public boolean changeToTratamentoProp() {return false;}
    @Override
    public boolean changeFromGestaoPROPtoBase() {return false;}
    @Override
    public boolean changeFromGestaoALtoBase() {return false;}
    @Override
    public boolean changeFromGestaoDOCtoBase() {return false;}
    @Override
    public boolean changeFromGestaoCANDtoBase() {return false;}
    @Override
    public boolean changeFromGestaoORItoBase() {return false;}

    @Override
    public void addAluno(){};
    @Override
    public String consultaAluno(long nrAluno) {return null;}
    @Override
    public String consultaAlunos() {return null;}
    @Override
    public void addDocente(){};
    @Override
    public String consultaDocente(String email){
        return null;
    }
    @Override
    public String consultaDocentes(){
        return null;
    }
    @Override
    public void addProposta(){};
    @Override
    public String consultaProposta(String idProposta){return null;}
    @Override
    public String consultaPropostas(){return null;}


}
