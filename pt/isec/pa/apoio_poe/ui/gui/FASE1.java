package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;

public class FASE1 extends BorderPane {
    GridPane gridButtons;
    Button ButtonGestaoAlunos;
    Button ButtonGestaoPropostas;
    Button ButtonGestaoDocentes;
    Button ButtonSair;
    Label mensagemBoasVindas;
    apoio_poeContext context;
    WindowToolBar toolBar;

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
        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);
        //create buttons
        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Escolha uma das opcoes: ");
        ButtonGestaoAlunos = new Button();
        ButtonGestaoAlunos.setText("Gestao de Alunos");
        ButtonGestaoPropostas= new Button();
        ButtonGestaoPropostas.setText("Gestao de Propostas");
        ButtonGestaoDocentes = new Button();
        ButtonGestaoDocentes.setText("Gestao de Docentes");
        ButtonGestaoDocentes = new Button();
        ButtonGestaoDocentes.setText("Gestao de Docentes");
        ButtonSair = new Button();
        ButtonSair.setText("Sair");
        //organizar coordenadas
        gridButtons.add(mensagemBoasVindas, 0, 0);
        gridButtons.add(ButtonGestaoAlunos, 0, 2);
        gridButtons.add(ButtonGestaoPropostas, 0, 4);
        gridButtons.add(ButtonGestaoDocentes, 0, 6);
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
