package pt.isec.pa.apoio_poe.ui.gui.estados;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.WindowToolBar;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class FASE1 extends BorderPane {


    GridPane gridButtons;
    Button ButtonGestaoAlunos;
    Button ButtonGestaoPropostas;
    Button ButtonGestaoDocentes;
    Button ButtonSair;
    Button ButtonAvancar;
    Button ButtonFecharFase;
    Label mensagemBoasVindas;

    Label state;
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
        ButtonAvancar.setOnAction(ev->context.avancarFase());
        ButtonFecharFase.setOnAction(ev->context.fecharFase());
        ButtonSair.setOnAction(ev-> {
            context.save();
            Platform.exit();
        });


    }

    public void createViews(){
        CSSManager.applyCSS(this,"mystyles.css");

        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);

        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);

        //create buttons
        state = new Label();
        state.setText("FASE 1");

        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Escolha uma das opcoes: ");
        mensagemBoasVindas.getStyleClass().add("labelEscolha");

        ButtonGestaoAlunos = new Button();
        ButtonGestaoAlunos.setText("Gestao de Alunos");
        ButtonGestaoAlunos.getStyleClass().add("buttonFase1");


        ButtonGestaoPropostas= new Button();
        ButtonGestaoPropostas.setText("Gestao de Propostas");

        ButtonGestaoPropostas.getStyleClass().add("buttonFase1");

        ButtonGestaoDocentes = new Button();
        ButtonGestaoDocentes.setText("Gestao de Docentes");

        ButtonGestaoDocentes.getStyleClass().add("buttonFase1");

        ButtonSair = new Button();
        ButtonSair.setText("Sair");
        ButtonSair.getStyleClass().add("buttonSair");

        ButtonAvancar = new Button();
        ButtonAvancar.setText("Avancar para a proxima fase");

        ButtonAvancar.getStyleClass().add("buttonFase1");

        ButtonFecharFase = new Button();
        ButtonFecharFase.setText("Fechar fase");

        ButtonFecharFase.getStyleClass().add("buttonFecharFase1");

        //organizar coordenadas
        gridButtons.add(state, 0, 0);
        gridButtons.add(mensagemBoasVindas, 0, 2);
        gridButtons.add(ButtonGestaoAlunos, 0, 4);
        gridButtons.add(ButtonGestaoPropostas, 0, 6);
        gridButtons.add(ButtonGestaoDocentes, 0, 8);
        gridButtons.add(ButtonFecharFase, 0, 10);
        gridButtons.add(ButtonAvancar, 0, 12);
        gridButtons.add(ButtonSair, 0, 14);
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
