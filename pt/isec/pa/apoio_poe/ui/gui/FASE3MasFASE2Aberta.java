package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class FASE3MasFASE2Aberta extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;

    Button ButtonRecuarFase;
    Button ButtonChangeToBase;

    Button ButtonVoltar;

    Label mensagemEscolha;
    Label listaDeDocentes;

    public FASE3MasFASE2Aberta(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonChangeToBase.setOnAction(ev->context.changeFromF3MasF2AbertaToBase());
        ButtonRecuarFase.setOnAction(ev->context.recuarFase());

    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE3MasFASE2AbertaState){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }

    public void createViews(){
        CSSManager.applyCSS(this,"mystyles.css");
        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);

        gridButtons.setHgap(0);
        gridButtons.setVgap(10);

        mensagemEscolha = new Label();
        mensagemEscolha.setText("Escolha uma das opcoes: ");

        ButtonRecuarFase = new Button();
        ButtonRecuarFase.setText("Recuar Fase");
        ButtonRecuarFase.getStyleClass().add("buttonFase2");

        ButtonChangeToBase = new Button();
        ButtonChangeToBase.setText("Voltar a Base");
        ButtonChangeToBase.getStyleClass().add("buttonFase2");

        listaDeDocentes = new Label();


        //organizar coordenadas

        gridButtons.add(mensagemEscolha, 0, 0);
        gridButtons.add(ButtonRecuarFase, 0, 2);
        gridButtons.add(ButtonChangeToBase, 0, 4);

        this.setCenter(gridButtons);
    }

}
