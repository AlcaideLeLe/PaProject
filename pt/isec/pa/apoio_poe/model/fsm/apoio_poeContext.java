package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

import java.io.FileNotFoundException;

public class apoio_poeContext {
    private PoE data;
    private IApoio_poeState state;

    public apoio_poeContext(){
        this.data = new PoE();
        this.state = apoio_poeState.FASE1.createState(this, data);
    }

    public void changeState(IApoio_poeState state){
        this.state = state;
    }

    public void fecharFase() {};
    public boolean avancarFase() {return false;}
    public boolean recuarFase() {return false;}
    public boolean changeToGestaoAL() {return false;}
    public boolean changeToGestaoCAND(){return false;}
    public boolean changeToGestaoDOC(){return false;}
    public boolean changeToGestaoORI(){return false;}
    public boolean changeToTratamentoProp() {return false;}
    public boolean changeFromGestaoPROPtoBase() {return false;}
    public boolean changeFromGestaoALtoBase() {return false;}
    public boolean changeFromGestaoDOCtoBase() {return false;}
    public boolean changeFromGestaoCANDtoBase() {return false;}
    public boolean changeFromGestaoORItoBase() {return false;}
    public boolean changeToGestaoManualAtribuicoesState() {return false;}
    public boolean changeToGestaoDeDocentesState(){return false;}

    public void addAluno(){state.addAluno();}
    public String consultaAluno(long nrAluno){return state.consultaAluno(nrAluno);}
    public String consultaAlunos(){return state.consultaAlunos();}
    public void addDocente(){state.addDocente();}
    public String consultaDocente(String email){return state.consultaDocente(email);}
    public String consultaDocentes(){return state.consultaDocentes();}
    public void addProposta(){state.addDocente();}
    public String consultaProposta(String idProposta){return state.consultaProposta(idProposta);}
    public String consultaPropostas(){return state.consultaPropostas();}
    public void addCandidatura(){state.addCandidatura();}
    public String consultaCandidatura(long nrAluno){return state.consultaCandidatura(nrAluno);}
    public String consultaCandidaturas(){return state.consultaCandidaturas();}
    public String consultaAlunosComAutoproposta(){return state.consultarListaDeAutopropostas();}
    public String consultarAlunosComCandidatura(){return state.consultarAlunosComCandidatura();}
    public String consultarListaDeAutopropostas(){return state.consultarListaDeAutopropostas();}
    public String consultarPropostasDocentes(){return state.consultarPropostasDeDocentes();};
    public String consultarPropostasComCadidaturas(){return state.consultarPropostasComCadidaturas();}
    public String consultarPropostasSemCadidaturas(){return state.consultarPropostasSemCadidaturas();}
    public void atribuirAutoproposta(){}
    public void atribuirPropostaDeDocente(){}
    public void atruibuicaoDeAlunosSemPropostasDefinidas(){}
    public void atribuirPropostaManualmente(long nrAluno, String idProposta){}
    public void removerPropostaManualmente(long nrAluno){}
    public String consultarAlunosComPropostaAtribuida(){return state.consultarAlunosComPropostaAtribuida();}
    public String consultarAlunosSemPropostaAtribuida(){return state.consultarAlunosSemPropostaAtribuida();}
    public String consultarPropostasDisponiveis(){return state.consultarPropostasDisponiveis();}
    public String consultarPropostasAtribuidas(){return state.consultarPropostasAtribuidas();}
    public void atribuirPropostaADocenteProponenteAutomaticamente(){}
    public void atribuirManulamenteOrientadorAAlunosComProposta(long nrAluno, String emailProf){}
    public String consultarOrientadorDeProposta(String idProposta){return state.consultarOrientadorDeProposta(idProposta);}
    public void editarOrientadorDeProposta(String idProposta, String emailNovoOrientador){}
    public void removerOrientadorDeProposta(String idProposta){}
    public String consultarAlunosComPropostaEComOrientador(){return state.consultarAlunosComPropostaEComOrientador();}
    public String consultarAlunosComPropostaESemOrientador(){return state.consultarAlunosComPropostaESemOrientador();}
    public String consultarDocenteComMenosOrientacoes(){return state.consultarDocenteComMenosOrientacoes();}
    public String consultarDocenteComMaisOrientacoes(){return state.consultarDocenteComMaisOrientacoes();}
    public String consultarMediaDeOrientacoesDosDocentes(){return state.consultarMediaDeOrientacoesDosDocentes();}
    public String consultarAlunosComCandidaturaESemProposta(){return state.consultarAlunosComCandidaturaESemProposta();}
    public String consultarAlunosSemCandidatura(){return state.consultarAlunosSemCandidatura();}
    public String consultarPropostasComCandidaturas(){return state.consultarPropostasComCadidaturas();}
    public String consultarPropostasSemCandidaturas(){return state.consultarPropostasSemCadidaturas();}
    public void atribuirManualmenteOrientadorAAlunosComPropostas(long nrAluno, String emailProf){}
    public void removerTodasAsAtribuicoes(){}









}
