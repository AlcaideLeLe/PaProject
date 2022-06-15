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

public class TRATAMENTO_PROP extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;


    Button ButtonChangeToBase;
    Button ButtonChangeToGestaoManualAtribuicoes;
    Button ButtonAtribuirAutoProposta;
    Button ButtonAtribuirPropostaDeDocente;
    Button ButtonRemoverTodasAsAtribuicoes;
    Button ButtonVoltar;
    Label mensagemEscolha;
    Label listaDeAlunos;


    public TRATAMENTO_PROP(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonChangeToBase.setOnAction(ev->context.changeFromTratamentoPropToBase());
        ButtonChangeToGestaoManualAtribuicoes.setOnAction(ev->context.changeToGestaoManualAtribuicoesState());
        ButtonAtribuirAutoProposta.setOnAction(ev->context.atribuirAutoproposta());
        ButtonAtribuirPropostaDeDocente.setOnAction(ev->context.atribuirPropostaDeDocente());
        ButtonRemoverTodasAsAtribuicoes.setOnAction(ev->context.removerTodasAsAtribuicoes());
        ButtonVoltar.setOnAction(ev->context.changeFromGestaoALtoBase());

    }

    public void update(){
        if(context.getState() == apoio_poeState.TRATAMENTO_PROP){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }

    public void createViews(){
        CSSManager.applyCSS(this,"mystyles.css");
        CSSManager.applyCSS(this,"mystyles.css");

        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);
        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);

        //create buttons
        mensagemEscolha = new Label();
        mensagemEscolha.setText("Escolha uma das opcoes: ");

        ButtonChangeToBase = new Button();
        ButtonChangeToBase.setText("Voltar a base");
        ButtonChangeToBase.getStyleClass().add("buttonFase2");

        ButtonChangeToGestaoManualAtribuicoes = new Button();
        ButtonChangeToGestaoManualAtribuicoes.setText("Gestao Manual de Atribuicoes");
        ButtonChangeToGestaoManualAtribuicoes.getStyleClass().add("buttonFase2");

        ButtonAtribuirAutoProposta = new Button();
        ButtonAtribuirAutoProposta.setText("Atribuir Auto-proposta");
        ButtonAtribuirAutoProposta.getStyleClass().add("buttonFase2");

        ButtonAtribuirPropostaDeDocente = new Button();
        ButtonAtribuirPropostaDeDocente.setText("Atribuir Proposta de Docente");
        ButtonAtribuirPropostaDeDocente.getStyleClass().add("buttonFase2");

        ButtonRemoverTodasAsAtribuicoes = new Button();
        ButtonRemoverTodasAsAtribuicoes.setText("Remover todas as atribuicoes");
        ButtonRemoverTodasAsAtribuicoes.getStyleClass().add("buttonFase2");

        ButtonVoltar = new Button();
        ButtonVoltar.setText("Voltar");
        ButtonVoltar.getStyleClass().add("buttonVoltar");

        listaDeAlunos = new Label();


        //organizar coordenadas

        gridButtons.add(mensagemEscolha, 0, 0);
        gridButtons.add(ButtonChangeToBase, 0, 2);
        gridButtons.add(ButtonChangeToGestaoManualAtribuicoes, 0, 4);
        gridButtons.add(ButtonAtribuirAutoProposta, 0, 6);
        gridButtons.add(ButtonAtribuirPropostaDeDocente, 0, 8);
        gridButtons.add(ButtonRemoverTodasAsAtribuicoes, 0, 10);
        gridButtons.add(ButtonVoltar, 0, 12);
        gridButtons.add(listaDeAlunos, 0, 14);

        this.setCenter(gridButtons);
    }

}
