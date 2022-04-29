package pt.isec.pa.apoio_poe.model.fsm;

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


    //Fase 1
    void addAluno();
    String consultaAluno(long nr);
    String consultaAlunos();
    void addDocente();
    String consultaDocente(String email);
    String consultaDocentes();
    void addProposta();
    String consultaProposta(String idProposta);
    String consultaPropostas();
    void exportarDocentesParaCSV(String nomeFicheiro);
    void exportarAlunosParaCSV(String nomeFicheiro);
    void exportarPropostasParaCSV(String nomeFicheiro);

    //Fase 2
    void addCandidatura();
    String consultaCandidatura(long nrAluno);
    String consultaCandidaturas();
    String consultaAlunosComAutoproposta();
    String consultarAlunosComCandidatura();
    String consultarAlunosSemCandidatura();
    String consultarListaDeAutopropostas();
    String consultarPropostasDeDocentes();
    String consultarPropostasComCadidaturas();
    String consultarPropostasSemCadidaturas();

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

    //Fase 5
    //String consultarAlunosComPropostaAtribuida(); mesma linha 52
    String consultarAlunosComCandidaturaESemProposta();
    //String consultarPropostasDisponiveis(); 56
    //String consultarPropostasAtribuidas(); 57
    //String consultarDocenteComMenosOrientacoes();
    //String consultarDocenteComMaisOrientacoes();
    //String consultarMediaDeOrientacoesDosDocentes();













}


