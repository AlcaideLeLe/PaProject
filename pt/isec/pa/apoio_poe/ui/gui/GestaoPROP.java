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
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class GestaoPROP extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;
    Button ButtonInserirUmaProposta;
    Button ButtonInserirPropostas;
    Button ButtonRemoverProposta;
    Button ButtonEditarProposta;
    Button ButtonConsultarPropostas;
    Button ButtonConsultarUmaProposta;
    Button ButtonVoltar;
    Label mensagemEscolha;
    Label listaDePropostas;

    public GestaoPROP(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonInserirPropostas.setOnAction(ev->context.addProposta());
        ButtonInserirUmaProposta.setOnAction(ev->{
            Stage stage = new Stage();
            InserirProposta root = new InserirProposta(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Inserir aluno");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarPropostas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraPropostas root = new MostraPropostas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Inserir aluno");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarUmaProposta.setOnAction(ev->{
            Stage stage = new Stage();
            ConsultarProposta root = new ConsultarProposta(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Inserir aluno");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonRemoverProposta.setOnAction(ev->{
            Stage stage = new Stage();
            RemoverProposta root = new RemoverProposta(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de alunos");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonEditarProposta.setOnAction(ev->{
            Stage stage = new Stage();
            QuestionaPropostaEditar root = new QuestionaPropostaEditar(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de alunos");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonVoltar.setOnAction(ev->context.changeFromGestaoPROPtoBase());

    }

    public void update(){
        if(context.getState() == apoio_poeState.GESTAO_PROP){
            this.setVisible(true);
            System.out.println(context.getState() + "LALALALALA");
        }
        else{
            this.setVisible(false);
        }
    }

    public void createViews(){
        CSSManager.applyCSS(this,"mystyles.css");
        //toolBar = new WindowToolBar(context);
        //toolBar.createViews();
        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);
        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);
        //create buttons
        mensagemEscolha = new Label();
        mensagemEscolha.setText("Escolha uma das opcoes: ");

        ButtonInserirPropostas = new Button();
        ButtonInserirPropostas.setText("Inserir propostas a partir de um ficheiro");
        ButtonInserirPropostas.getStyleClass().add("buttonGestaoPROP");


        ButtonInserirUmaProposta = new Button();
        ButtonInserirUmaProposta.setText("Inserir uma proposta");
        ButtonInserirUmaProposta.getStyleClass().add("buttonGestaoPROP");


        ButtonConsultarUmaProposta = new Button();
        ButtonConsultarUmaProposta.setText("Consultar uma proposta");
        ButtonConsultarUmaProposta.getStyleClass().add("buttonGestaoPROP");


        ButtonConsultarPropostas = new Button();
        ButtonConsultarPropostas.setText("Consultar todas as propostas");
        ButtonConsultarPropostas.getStyleClass().add("buttonGestaoPROP");


        ButtonRemoverProposta = new Button();
        ButtonRemoverProposta.setText("Remover proposta");
        ButtonRemoverProposta.getStyleClass().add("buttonGestaoPROP");


        ButtonEditarProposta = new Button();
        ButtonEditarProposta.setText("Editar proposta");
        ButtonEditarProposta.getStyleClass().add("buttonGestaoPROP");


        ButtonVoltar = new Button();
        ButtonVoltar.setText("Voltar");
        ButtonVoltar.getStyleClass().add("buttonVoltar");


        listaDePropostas = new Label();

        //organizar coordenadas

        gridButtons.add(mensagemEscolha, 0, 0);
        gridButtons.add(ButtonInserirPropostas, 0, 2);
        gridButtons.add(ButtonInserirUmaProposta, 0, 4);
        gridButtons.add(ButtonConsultarUmaProposta, 0, 6);
        gridButtons.add(ButtonConsultarPropostas, 0, 8);
        gridButtons.add(ButtonRemoverProposta, 0, 10);
        gridButtons.add(ButtonEditarProposta, 0, 12);
        gridButtons.add(ButtonVoltar, 0, 14);
        gridButtons.add(listaDePropostas, 0, 16);

        this.setCenter(gridButtons);
    }

}
