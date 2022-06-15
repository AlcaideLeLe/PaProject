package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.fsm.FASE1State;
import pt.isec.pa.apoio_poe.model.fsm.IApoio_poeState;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;

import javax.swing.border.Border;


public class Inicio extends BorderPane {
    GridPane gridButtons;
    Button ButtonCreateNew;
    Button ButtonLoad;
    Button ButtonSair;
    Label mensagemBoasVindas;
    apoio_poeContext context;
    WindowToolBar toolBar;
    Font font = Font.font("Times New Roman", FontWeight.BOLD, 14);
    public Inicio(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonCreateNew.setOnAction(ev->{
            if(context.avancarFase() == true);
        });
        ButtonLoad.setOnAction(ev->context.loadState());
        ButtonSair.setOnAction(ev->System.exit(0));
    }

    public void createViews(){
        toolBar = new WindowToolBar(context);
        toolBar.createViews();
        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);
        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);
        //create buttons
        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Ola DUROES ESCOLHE AI UMA OPCAO");
        ButtonCreateNew = new Button();
        ButtonCreateNew.setText("Começa novo");
        ButtonLoad= new Button();
        ButtonLoad.setText("Carregar save");
        ButtonSair = new Button();
        ButtonSair.setText("Sair");

        ButtonCreateNew.setFont(font);
        ButtonCreateNew.setStyle("-fx-background-color: white; -fx-text-fill: black;-fx-border-width: 5px;");
        ButtonLoad.setFont(font);
        ButtonLoad.setStyle("-fx-background-color: white; -fx-text-fill: black;-fx-border-width: 5px;");
        ButtonSair.setFont(font);
        ButtonSair.setStyle("-fx-background-color: white; -fx-text-fill: black;-fx-border-width: 5px;");

        //organizar coordenadas
        gridButtons.add(mensagemBoasVindas, 0, 0);
        gridButtons.add(ButtonCreateNew, 0, 2);
        gridButtons.add(ButtonLoad, 0, 4);
        gridButtons.add(ButtonSair, 0, 6);
        this.setCenter(gridButtons);
    }

    public void update(){
        if(context.getState() == apoio_poeState.InicioState){
            this.setVisible(true);
        }
        else{
            this.setVisible(false);
        }
    }




}
