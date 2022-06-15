package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.util.ArrayList;

public interface IApoio_poeState {
    //operações de todas as fases
    public apoio_poeState getState();
    void fecharFase();
    boolean avancarFase();
    boolean recuarFase();
    boolean changeToGestaoAL();
    boolean changeToGestaoCAND();
    boolean changeToGestaoDOC();
    boolean changeToGestaoORI();
    boolean changeToTratamentoProp();
    boolean changeFromGestaoPROPtoBase();
    boolean changeFromGestaoALtoBase();
    boolean changeFromGestaoDOCtoBase();
    boolean changeFromGestaoCANDtoBase();
    boolean changeFromGestaoORItoBase();
    boolean changeToGestaoManualAtribuicoesState();
    boolean changeToGestaoDeDocentesState();
    boolean changeFromGestaoManualAtribToFase3();
    boolean changeFromGestaoManualOrientToFase4();
    boolean changeToPropState();
    boolean changeFromTratamentoPropToBase();
    boolean changeFromF3MasF2AbertaToBase();
    boolean changeToF3MasF2Aberta();
    boolean changeToFase1State();
    boolean loadState();
    boolean changeToFaseBloqueadaAnterior();
    boolean changeToGestaoManualOrientState();


    //Fase 1
    void addAluno();
    void addAlunoSingular(Aluno a);
    String consultaAluno(long nr);
    ArrayList<Aluno> consultarAlunos();
    void addDocente();
    void addDocenteSingular(Docente d);
    String consultaDocente(String email);
    ArrayList<Docente> consultaDocentes();
    void addProposta();
    void addPropostaSingular(Proposta p);
    String consultaProposta(String idProposta);
    ArrayList<Proposta> consultaPropostas();
    void exportarDocentesParaCSV(String nomeFicheiro);
    void exportarAlunosParaCSV(String nomeFicheiro);
    void exportarPropostasParaCSV(String nomeFicheiro);
    void exportarCandidaturasParaCSV(String nomeFicheiro);

    //Fase 2
    void addCandidatura();
    Candidatura consultaCandidatura(long nrAluno);
    ArrayList<Candidatura> consultaCandidaturas();
    ArrayList<Aluno> consultaAlunosComAutoproposta();
    ArrayList<Aluno> consultarAlunosComCandidatura();
    ArrayList<Aluno> consultarAlunosSemCandidatura();
    ArrayList<Proposta> consultarListaDeAutopropostas();
    ArrayList<Proposta> consultarPropostasDeDocentes();
    String consultarPropostasComCandidaturas();
    String consultarPropostasSemCandidaturas();

    //Fase 3
    void atribuirAutoproposta();
    void atribuirPropostaDeDocente();
    void atribuicaoDeAlunosSemPropostasDefinidas();
    void atribuirPropostaManualmente(long nrAluno, String idProposta);
    void removerPropostaManualmente(long nrAluno);
    //String consultaAlunosComAutoproposta(); mesma função da linha 36
    //String consultarAlunosComCandidatura(); mesma função da linha 37
    String consultarAlunosComPropostaAtribuida();
    String consultarAlunosSemPropostaAtribuida();
    //String consultarListaDeAutopropostas(); mesma função da linha 39
    //String consultarPropostasDeDocentes(); mesma função da linha 40
    String consultarPropostasDisponiveis();
    String consultarPropostasAtribuidas();

    //Fase 4
    void atribuirPropostaADocenteProponenteAutomaticamente();
    void atribuirManulamenteOrientadorAAlunosComProposta(long nrAluno, String emailProf);
    String consultarOrientadorDeProposta(String idProposta);
    void editarOrientadorDeProposta(String idProposta, String emailNovoOrientador);
    void removerOrientadorDeProposta(String idProposta);
    String consultarAlunosComPropostaEComOrientador();
    String consultarAlunosComPropostaESemOrientador();
    String consultarDocenteComMenosOrientacoes();
    String consultarDocenteComMaisOrientacoes();
    String consultarMediaDeOrientacoesDosDocentes();
    void removerTodasAsAtribuicoes();
    String consultarPropostas();
    String consultarOrientacoesDocente(String email);

    //Fase 5
    //String consultarAlunosComPropostaAtribuida(); mesma linha 52
    String consultarAlunosComCandidaturaESemProposta();
    //String consultarPropostasDisponiveis(); 56
    //String consultarPropostasAtribuidas(); 57
    //String consultarDocenteComMenosOrientacoes();
    //String consultarDocenteComMaisOrientacoes();
    //String consultarMediaDeOrientacoesDosDocentes();













}


