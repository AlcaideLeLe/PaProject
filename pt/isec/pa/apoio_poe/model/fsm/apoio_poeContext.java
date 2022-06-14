package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.util.ArrayList;

public class apoio_poeContext {
    private PoE data;
    private IApoio_poeState state;
    public static final String PROP_FASE = "FASE";

    public apoio_poeContext(){
        this.data = new PoE();
        this.state = apoio_poeState.InicioState.createState(this, data);
    }

    PropertyChangeSupport pcs = new PropertyChangeSupport(this);


    public void addPropertyChangeListener(String property, PropertyChangeListener listener){
        pcs.addPropertyChangeListener(property, listener);
    }




    public void changeState(IApoio_poeState state){

        pcs.firePropertyChange(PROP_FASE, null, null);
        this.state = state;
    }

    public void fecharFase() {state.fecharFase();};
    public boolean avancarFase() {
        boolean resultado = state.avancarFase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean recuarFase() {
        boolean resultado = state.recuarFase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToGestaoAL() {
        boolean resultado = state.changeToGestaoAL();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToGestaoCAND(){
        boolean resultado = state.changeToGestaoCAND();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToGestaoDOC(){
        boolean resultado = state.changeToGestaoDOC();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToGestaoORI(){
        boolean resultado = state.changeToGestaoORI();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToTratamentoProp() {
        boolean resultado = state.changeToTratamentoProp();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromGestaoPROPtoBase() {
        boolean resultado = state.changeFromGestaoPROPtoBase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromGestaoALtoBase() {
        boolean resultado = state.changeFromGestaoALtoBase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromGestaoDOCtoBase() {
        boolean resultado = state.changeFromGestaoDOCtoBase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromGestaoCANDtoBase() {
        boolean resultado = state.changeFromGestaoCANDtoBase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromGestaoORItoBase() {
        boolean resultado = state.changeFromGestaoORItoBase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToGestaoManualAtribuicoesState() {
        boolean resultado = state.changeToGestaoManualAtribuicoesState();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToGestaoDeDocentesState(){
        boolean resultado = state.changeToGestaoDeDocentesState();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromGestaoManualAtribToFase3(){
        boolean resultado = state.changeFromGestaoManualAtribToFase3();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromGestaoManualOrientToFase4(){
        boolean resultado = state.changeFromGestaoManualOrientToFase4();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToPropState(){
        boolean resultado = state.changeToPropState();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;

    }
    public boolean changeFromTratamentoPropToBase(){
        boolean resultado = state.changeFromTratamentoPropToBase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromF3MasF2AbertaToBase(){
        boolean resultado = state.changeFromF3MasF2AbertaToBase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToF3MasF2Aberta(){
        boolean resultado = state.changeToF3MasF2Aberta();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToFase1State(){
        boolean resultado = state.changeToFase1State();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean loadState(){
        boolean resultado = state.loadState();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToFaseBloqueadaAnterior(){
        boolean resultado = state.changeToFaseBloqueadaAnterior();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToGestaoManualOrientState(){
        boolean resultado = state.changeToGestaoManualOrientState();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }

    public void addAluno(){state.addAluno();}
    public String consultaAluno(long nrAluno){return state.consultaAluno(nrAluno);}
    public String consultarAlunos(){return state.consultarAlunos();}
    public void addDocente(){state.addDocente();}
    public String consultaDocente(String email){return state.consultaDocente(email);}
    public String consultaDocentes(){return state.consultaDocentes();}
    public void addProposta(){state.addProposta();}
    public String consultaProposta(String idProposta){return state.consultaProposta(idProposta);}
    public ArrayList<Proposta> consultaPropostas(){return state.consultaPropostas();}
    public void addCandidatura(){state.addCandidatura();}
    public String consultaCandidatura(long nrAluno){return state.consultaCandidatura(nrAluno);}
    public ArrayList<Candidatura> consultaCandidaturas(){return state.consultaCandidaturas();}
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
    public ArrayList<Proposta> consultarPropostas(){return state.consultaPropostas();}
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
