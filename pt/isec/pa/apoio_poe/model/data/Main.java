package pt.isec.pa.apoio_poe.model.data;


import javafx.application.Application;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.MainJX;
import pt.isec.pa.apoio_poe.ui.text.UI;

import static javafx.application.Application.launch;

public class Main {
    public static void main(String[] args) throws Exception {
        
        apoio_poeContext fsm = new apoio_poeContext();
        UI ui = new UI(fsm);
        //ui.start();
        Application.launch(MainJX.class, args);
        //PoE poe = new PoE();
        //poe.addAluno();
        //poe.addProposta();
        //poe.addDocente();
        //poe.atribuirPropostaDeDocente();
        //System.out.println(poe.consultarPropostasDocentes());




    }
}