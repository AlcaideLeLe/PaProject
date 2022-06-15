package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;


public class Apoio_poeGUI extends BorderPane {

    private apoio_poeContext fsm;
    private WindowToolBar toolBar;

    public Apoio_poeGUI(apoio_poeContext fsm) {
        this.fsm = fsm;
        createViews();
    }



    public void createViews(){
        StackPane stackPane = new StackPane(new Inicio(fsm), new FASE1(fsm), new GestaoAL(fsm), new GestaoDOC(fsm), new GestaoPROP(fsm));
        this.setTop(new WindowToolBar(fsm));
        this.setCenter(stackPane);
    }
}
