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

    void addAluno();
    String consultaAluno(long nr);
    String consultaAlunos();
    void addDocente();
    String consultaDocente(String email);
    String consultaDocentes();
    void addProposta();
    String consultaProposta(String idProposta);
    String consultaPropostas();
    void addCandidatura();
    String consultaCandidatura(long nrAluno);
    String consultaCandidaturas();
}


