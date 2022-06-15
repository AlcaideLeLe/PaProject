package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class GESTAO_ORI extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;
    Button ButtonVoltarBase;
    Label mensagemEscolha;
    Label listaDeAlunos;


    public GESTAO_ORI(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonVoltarBase.setOnAction(ev->context.changeFromGestaoORItoBase());

    }

    public void update(){
        if(context.getState() == apoio_poeState.GESTAO_ORI){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }

    public void createViews(){

        //toolBar = new WindowToolBar(context);
        //toolBar.createViews();
        CSSManager.applyCSS(this,"mystyles.css");

        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);
        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);

        //create buttons
        mensagemEscolha = new Label();
        mensagemEscolha.setText("Escolha uma das opcoes: ");



        ButtonVoltarBase = new Button();
        ButtonVoltarBase.setText("Voltar");
        ButtonVoltarBase.getStyleClass().add("buttonFase2");

        listaDeAlunos = new Label();


        //organizar coordenadas

        gridButtons.add(mensagemEscolha, 0, 0);
        gridButtons.add(ButtonVoltarBase, 0, 2);

        this.setCenter(gridButtons);
    }

}
