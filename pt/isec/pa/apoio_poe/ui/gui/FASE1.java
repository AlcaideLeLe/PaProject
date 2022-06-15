package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;

public class FASE1 extends BorderPane {
    private static final String button = "draggable" ;

    GridPane gridButtons;
    Button ButtonGestaoAlunos;
    Button ButtonGestaoPropostas;
    Button ButtonGestaoDocentes;
    Button ButtonSair;
    Button ButtonAvancar;
    Label mensagemBoasVindas;
    apoio_poeContext context;
    WindowToolBar toolBar;
    Font font = Font.font("Times New Roman", FontWeight.BOLD, 14);
    Font FontLabel = Font.font("Garamond", 18);



    public FASE1(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonGestaoAlunos.setOnAction(ev->context.changeToGestaoAL());
        ButtonGestaoPropostas.setOnAction(ev->context.changeToPropState());
        ButtonGestaoDocentes.setOnAction(ev->context.changeToGestaoDOC());
        ButtonSair.setOnAction(ev->System.exit(0));


    }

    public void createViews(){
        toolBar = new WindowToolBar(context);
        toolBar.createViews();
        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);
        //gridButtons.setStyle("-fx-background-color: #b8c4b7;");

        CSSManager.applyCSS(gridButtons, "Styling.css");



        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);

        //create buttons
        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Escolha uma das opcoes: ");
        mensagemBoasVindas.setFont(FontLabel);

        ButtonGestaoAlunos = new Button();
        ButtonGestaoAlunos.setText("Gestao de Alunos");
        ButtonGestaoAlunos.setFont(font);
        ButtonGestaoAlunos.setStyle("-fx-background-color: white; -fx-text-fill: black;-fx-border-width: 5px;");



        ButtonGestaoPropostas= new Button();
        ButtonGestaoPropostas.setText("Gestao de Propostas");
        ButtonGestaoPropostas.setFont(font);
        ButtonGestaoPropostas.setStyle("-fx-background-color: white; -fx-text-fill: black;-fx-border-width: 5px;");

        ButtonGestaoDocentes = new Button();
        ButtonGestaoDocentes.setText("Gestao de Docentes");
        ButtonGestaoDocentes.setFont(font);
        ButtonGestaoDocentes.setStyle("-fx-background-color: white; -fx-text-fill: black;-fx-border-width: 5px;");

        ButtonSair = new Button();
        ButtonSair.setText("Sair");
        ButtonSair.setFont(font);
        ButtonSair.setStyle("-fx-background-color: white; -fx-text-fill: black;-fx-border-width: 5px;");

        ButtonAvancar = new Button();
        ButtonAvancar.setText("Avancar para a proxima fase");
        ButtonAvancar.setFont(font);
        ButtonAvancar.setStyle("-fx-background-color: white; -fx-text-fill: black;-fx-border-width: 5px;");

        //organizar coordenadas
        gridButtons.add(mensagemBoasVindas, 0, 0);
        gridButtons.add(ButtonGestaoAlunos, 0, 2);
        gridButtons.add(ButtonGestaoPropostas, 0, 4);
        gridButtons.add(ButtonGestaoDocentes, 0, 6);
        gridButtons.add(ButtonAvancar, 4, 10);
        this.setCenter(gridButtons);
    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE1){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }




}
