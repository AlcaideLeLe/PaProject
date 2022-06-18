package pt.isec.pa.apoio_poe.ui.gui.estados;

import javafx.application.Platform;
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
import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.ConfirmarSaida;
import pt.isec.pa.apoio_poe.ui.gui.WindowToolBar;
import pt.isec.pa.apoio_poe.ui.gui.consultas.*;
import pt.isec.pa.apoio_poe.ui.gui.questiona.QuestionaCandidaturaAConsultar;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class FASE2BLOCK extends BorderPane {


    GridPane gridButtons;


    Button ButtonConsultaAlunosComAutoProposta;
    Button ButtonConsultaAlunosComCandidatura;
    Button ButtonConsultaAlunosSemCandidatura;
    Button ButtonConsultaListaDeAutoPropostas;
    Button ButtonConsultaPropostasDeDocentes;
    Button ButtonConsultaPropostasComCandidaturas;
    Button ButtonConsultaPropostasSemCandidaturas;
    Button ButtonConsultaCandidatura;
    Button ButtonRecuarFaseBlockAnterior;

    Button ButtonSair;
    Button ButtonAvancar;
    Label mensagemBoasVindas;
    Label state;
    apoio_poeContext context;
    WindowToolBar toolBar;

    public FASE2BLOCK(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonConsultaAlunosComAutoProposta.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosComAutoproposta root = new MostraAlunosComAutoproposta(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Lista de alunos com autoproposta");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaAlunosComCandidatura.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosComCandidatura root = new MostraAlunosComCandidatura(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Lista de alunos sem candidatura");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaAlunosSemCandidatura.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosSemCandidatura root = new MostraAlunosSemCandidatura(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Lista de alunos com candidatura");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaListaDeAutoPropostas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraListaDeAutopropostas root = new MostraListaDeAutopropostas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Lista de autoproposta");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaPropostasDeDocentes.setOnAction(ev->{
            Stage stage = new Stage();
            MostraListaPropostasDocentes root = new MostraListaPropostasDocentes(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Lista de propostas de docentes");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaPropostasComCandidaturas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraPropostasComCandidaturas root = new MostraPropostasComCandidaturas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Lista de propostas com candidaturas");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaPropostasSemCandidaturas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraPropostasSemCandidaturas root = new MostraPropostasSemCandidaturas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Lista de propostas sem candidaturas");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaCandidatura.setOnAction(ev->{
            Stage stage = new Stage();
            QuestionaCandidaturaAConsultar root = new QuestionaCandidaturaAConsultar(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Candidatura a consultar");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });

        ButtonAvancar.setOnAction(ev->context.avancarFase());
        ButtonSair.setOnAction(ev-> {
            Stage stage = new Stage();
            ConfirmarSaida root = new ConfirmarSaida(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Confirmar Saida");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonRecuarFaseBlockAnterior.setOnAction(ev->context.changeToFaseBloqueadaAnterior());


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
        state.setText("FASE 2 BLOCK");

        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Escolha uma das opcoes: ");
        mensagemBoasVindas.getStyleClass().add("labelEscolha");

        ButtonConsultaAlunosComAutoProposta = new Button();
        ButtonConsultaAlunosComAutoProposta.setText("Consultar Alunos com Auto-proposta");
        ButtonConsultaAlunosComAutoProposta.getStyleClass().add("buttonFase1");

        ButtonConsultaAlunosComCandidatura = new Button();
        ButtonConsultaAlunosComCandidatura.setText("Consultar Alunos com candidatura");
        ButtonConsultaAlunosComCandidatura.getStyleClass().add("buttonFase1");

        ButtonConsultaAlunosSemCandidatura = new Button();
        ButtonConsultaAlunosSemCandidatura.setText("Consultar Alunos sem candidatura");
        ButtonConsultaAlunosSemCandidatura.getStyleClass().add("buttonFase1");

        ButtonConsultaListaDeAutoPropostas = new Button();
        ButtonConsultaListaDeAutoPropostas.setText("Consultar Auto-propostas");
        ButtonConsultaListaDeAutoPropostas.getStyleClass().add("buttonFase1");

        ButtonConsultaPropostasDeDocentes = new Button();
        ButtonConsultaPropostasDeDocentes.setText("Consultar Propostas de docentes");
        ButtonConsultaPropostasDeDocentes.getStyleClass().add("buttonFase1");

        ButtonConsultaPropostasComCandidaturas = new Button();
        ButtonConsultaPropostasComCandidaturas.setText("Consultar Propostas com candidatura");
        ButtonConsultaPropostasComCandidaturas.getStyleClass().add("buttonFase1");

        ButtonConsultaPropostasSemCandidaturas = new Button();
        ButtonConsultaPropostasSemCandidaturas.setText("Consultar Propostas sem candidatura");
        ButtonConsultaPropostasSemCandidaturas.getStyleClass().add("buttonFase1");

        ButtonConsultaCandidatura = new Button();
        ButtonConsultaCandidatura.setText("Consultar Candidatura");
        ButtonConsultaCandidatura.getStyleClass().add("buttonFase1");

        ButtonRecuarFaseBlockAnterior = new Button();
        ButtonRecuarFaseBlockAnterior.setText("Recuar para fase bloqueada anterior");
        ButtonRecuarFaseBlockAnterior.getStyleClass().add("buttonFase2");

        ButtonSair = new Button();
        ButtonSair.setText("Sair");
        ButtonSair.getStyleClass().add("buttonSair");

        ButtonAvancar = new Button();
        ButtonAvancar.setText("Avancar para a proxima fase");
        ButtonAvancar.getStyleClass().add("buttonFase1");


        //organizar coordenadas
        gridButtons.add(state, 0, 0);
        gridButtons.add(mensagemBoasVindas, 0, 2);
        gridButtons.add(ButtonConsultaAlunosComAutoProposta, 0, 4);
        gridButtons.add(ButtonConsultaAlunosComCandidatura, 0, 6);
        gridButtons.add(ButtonConsultaAlunosSemCandidatura, 0, 8);
        gridButtons.add(ButtonConsultaListaDeAutoPropostas, 0, 10);
        gridButtons.add(ButtonConsultaPropostasDeDocentes, 0, 12);
        gridButtons.add(ButtonConsultaPropostasComCandidaturas, 0, 14);
        gridButtons.add(ButtonConsultaPropostasSemCandidaturas, 0, 16);
        gridButtons.add(ButtonConsultaCandidatura, 0, 18);
        gridButtons.add(ButtonAvancar, 0, 20);
        gridButtons.add(ButtonRecuarFaseBlockAnterior, 0, 22);
        gridButtons.add(ButtonSair, 0, 24);
        this.setCenter(gridButtons);
    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE2BLOCKSTATE){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }




}
