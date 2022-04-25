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

    public void addAluno(){data.addAluno();}
    public String consultaAluno(long nrAluno){return data.consultarAluno(nrAluno);}
    public String consultaAlunos(){return data.consultarAlunos();}
    public void addDocente(){data.addDocente();}
    public String consultaDocente(String email){return data.consultarDocente(email);}
    public String consultaDocentes(){return data.consultarDocentes();}
    public void addProposta(){data.addDocente();}
    public String consultaProposta(String idProposta){return data.consultarProposta(idProposta);}
    public String consultaPropostas(){return data.consultarPropostas();}
    public void addCandidatura(){data.addCandidatura();}
    public String consultaCandidatura(long nrAluno){return data.consultarCandidatura(nrAluno);}
    public String consultaCandidaturas(){return data.consultarCandidaturas();}


}
