package pt.isec.pa.apoio_poe.model.data;


import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.text.UI;

public class Main {
    public static void main(String[] args) throws Exception {
        
        apoio_poeContext fsm = new apoio_poeContext();
        UI ui = new UI(fsm);
        ui.start();
        //PoE poe = new PoE();
        //poe.addAluno();
        //poe.addProposta();
        //poe.addDocente();
        //poe.atribuirPropostaDeDocente();
        //System.out.println(poe.consultarPropostasDocentes());


    }
}