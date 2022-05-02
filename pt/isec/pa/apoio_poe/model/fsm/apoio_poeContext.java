package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

import java.io.*;

public class apoio_poeContext {
    private PoE data;
    private IApoio_poeState state;

    public apoio_poeContext(){
        this.data = new PoE();
        this.state = apoio_poeState.InicioState.createState(this, data);
    }

    public void changeState(IApoio_poeState state){
        this.state = state;
    }

    public void fecharFase() {state.fecharFase();};
    public boolean avancarFase() {return state.avancarFase();}
    public boolean recuarFase() {return state.recuarFase();}
    public boolean changeToGestaoAL() {return state.changeToGestaoAL();}
    public boolean changeToGestaoCAND(){return state.changeToGestaoCAND();}
    public boolean changeToGestaoDOC(){return state.changeToGestaoDOC();}
    public boolean changeToGestaoORI(){return state.changeToGestaoORI();}
    public boolean changeToTratamentoProp() {return state.changeToTratamentoProp();}
    public boolean changeFromGestaoPROPtoBase() {return state.changeFromGestaoPROPtoBase();}
    public boolean changeFromGestaoALtoBase() {return state.changeFromGestaoALtoBase();}
    public boolean changeFromGestaoDOCtoBase() {return state.changeFromGestaoDOCtoBase();}
    public boolean changeFromGestaoCANDtoBase() {return state.changeFromGestaoCANDtoBase();}
    public boolean changeFromGestaoORItoBase() {return state.changeFromGestaoORItoBase();}
    public boolean changeToGestaoManualAtribuicoesState() {return state.changeToGestaoManualAtribuicoesState();}
    public boolean changeToGestaoDeDocentesState(){return state.changeToGestaoDeDocentesState();}
    public boolean changeFromGestaoManualAtribToFase3(){return state.changeFromGestaoManualAtribToFase3();}
    public boolean changeFromGestaoManualOrientToFase4(){return state.changeFromGestaoManualOrientToFase4();}
    public boolean changeToPropState(){return state.changeToPropState();}
    public boolean changeFromTratamentoPropToBase(){return state.changeFromTratamentoPropToBase();}
    public boolean changeFromF3MasF2AbertaToBase(){return state.changeFromF3MasF2AbertaToBase();}
    public boolean changeToF3MasF2Aberta(){return state.changeToF3MasF2Aberta();}
    public boolean changeToFase1State(){return state.changeToFase1State();}
    public boolean loadState(){return state.loadState();}
    public boolean changeToFaseBloqueadaAnterior(){return state.changeToFaseBloqueadaAnterior();}
    public boolean changeToGestaoManualOrientState(){return state.changeToGestaoManualOrientState();}

    public void addAluno(){state.addAluno();}
    public String consultaAluno(long nrAluno){return state.consultaAluno(nrAluno);}
    public String consultarAlunos(){return state.consultarAlunos();}
    public void addDocente(){state.addDocente();}
    public String consultaDocente(String email){return state.consultaDocente(email);}
    public String consultaDocentes(){return state.consultaDocentes();}
    public void addProposta(){state.addProposta();}
    public String consultaProposta(String idProposta){return state.consultaProposta(idProposta);}
    public String consultaPropostas(){return state.consultaPropostas();}
    public void addCandidatura(){state.addCandidatura();}
    public String consultaCandidatura(long nrAluno){return state.consultaCandidatura(nrAluno);}
    public String consultaCandidaturas(){return state.consultaCandidaturas();}
    public String consultaAlunosComAutoproposta(){return state.consultarListaDeAutopropostas();}
    public String consultarAlunosComCandidatura(){return state.consultarAlunosComCandidatura();}
    public String consultarListaDeAutopropostas(){return state.consultarListaDeAutopropostas();}
    public String consultarPropostasDocentes(){return state.consultarPropostasDeDocentes();};
    //public String consultarPropostasComCadidaturas(){return state.consultarPropostasComCadidaturas();}
    //public String consultarPropostasSemCadidaturas(){return state.consultarPropostasSemCadidaturas();}
    public void atribuirAutoproposta(){state.atribuirAutoproposta();}
    public void atribuirPropostaDeDocente(){state.atribuirPropostaDeDocente();}
    public void atruibuicaoDeAlunosSemPropostasDefinidas(){state.atribuicaoDeAlunosSemPropostasDefinidas();}
    public void atribuirPropostaManualmente(long nrAluno, String idProposta){state.atribuirPropostaManualmente(nrAluno,idProposta);}
    public void removerPropostaManualmente(long nrAluno){state.removerPropostaManualmente(nrAluno);}
    public String consultarAlunosComPropostaAtribuida(){return state.consultarAlunosComPropostaAtribuida();}
    public String consultarAlunosSemPropostaAtribuida(){return state.consultarAlunosSemPropostaAtribuida();}
    public String consultarPropostasDisponiveis(){return state.consultarPropostasDisponiveis();}
    public String consultarPropostasAtribuidas(){return state.consultarPropostasAtribuidas();}
    public void atribuirPropostaADocenteProponenteAutomaticamente(){state.atribuirPropostaADocenteProponenteAutomaticamente();}
    public void atribuirManulamenteOrientadorAAlunosComProposta(long nrAluno, String emailProf){state.atribuirManulamenteOrientadorAAlunosComProposta(nrAluno,emailProf);}
    public String consultarOrientadorDeProposta(String idProposta){return state.consultarOrientadorDeProposta(idProposta);}
    public void editarOrientadorDeProposta(String idProposta, String emailNovoOrientador){state.editarOrientadorDeProposta(idProposta, emailNovoOrientador);}
    public void removerOrientadorDeProposta(String idProposta){state.removerOrientadorDeProposta(idProposta);}
    public String consultarAlunosComPropostaEComOrientador(){return state.consultarAlunosComPropostaEComOrientador();}
    public String consultarAlunosComPropostaESemOrientador(){return state.consultarAlunosComPropostaESemOrientador();}
    public String consultarDocenteComMenosOrientacoes(){return state.consultarDocenteComMenosOrientacoes();}
    public String consultarDocenteComMaisOrientacoes(){return state.consultarDocenteComMaisOrientacoes();}
    public String consultarMediaDeOrientacoesDosDocentes(){return state.consultarMediaDeOrientacoesDosDocentes();}
    public String consultarAlunosComCandidaturaESemProposta(){return state.consultarAlunosComCandidaturaESemProposta();}
    public String consultarAlunosSemCandidatura(){return state.consultarAlunosSemCandidatura();}
    public String consultarPropostasComCandidaturas(){return state.consultarPropostasComCandidaturas();}
    public String consultarPropostasSemCandidaturas(){return state.consultarPropostasSemCandidaturas();}
    public void atribuirManualmenteOrientadorAAlunosComPropostas(long nrAluno, String emailProf){state.atribuirManulamenteOrientadorAAlunosComProposta(nrAluno,emailProf);}
    public void removerTodasAsAtribuicoes(){state.removerTodasAsAtribuicoes();}
    public void exportarAlunosParaCSV(String nomeFicheiro){state.exportarAlunosParaCSV(nomeFicheiro);};
    public void exportarDocentesParaCSV(String nomeFicheiro){state.exportarDocentesParaCSV(nomeFicheiro);}
    public void exportarPropostasParaCSV(String nomeFicheiro){state.exportarPropostasParaCSV(nomeFicheiro);};
    public void exportarCandidaturasParaCSV(String nomeFicheiro){state.exportarCandidaturasParaCSV(nomeFicheiro);};
    public apoio_poeState getState(){
        return state.getState();
    }
    public String consultarPropostas(){return state.consultaPropostas();}
    public String consultarOrientacoesDocente(String email){return state.consultarOrientacoesDocente(email);}

    public boolean carregar(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save"))){

            data = (PoE) ois.readObject();
            state = ((apoio_poeState) ois.readObject()).createState(this, data);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean save(){
        try(ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("save"))){

            oos.writeObject(data);
            oos.writeObject(state.getState());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }









}
