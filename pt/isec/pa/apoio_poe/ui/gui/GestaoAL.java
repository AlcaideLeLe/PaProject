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

import java.util.ArrayList;

public class GestaoAL extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;
    Button ButtonInserirUmAluno;
    Button ButtonInserirAlunos;
    Button ButtonRemoverAluno;
    Button ButtonEditarAluno;
    Button ButtonConsultarAlunos;
    Button ButtonConsultarUmAluno;
    Button ButtonVoltar;
    Label mensagemEscolha;
    Label listaDeAlunos;

    Font FontLabel = Font.font("Garamond", 14);

    public GestaoAL(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonInserirAlunos.setOnAction(ev->context.addAluno());
        ButtonInserirUmAluno.setOnAction(ev->{
            Stage stage = new Stage();
            InserirAluno root = new InserirAluno(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Inserir aluno");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarAlunos.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunos root = new MostraAlunos(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de alunos");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        //ButtonConsultarUmAluno.setOnAction(ev->context.consultaAluno());
        //ButtonRemoverAluno.setOnAction(ev->context.removerAluno());
        //ButtonEditarAluno.setOnAction(ev->context.editarAluno());
        ButtonVoltar.setOnAction(ev->context.changeFromGestaoALtoBase());

    }

    public void update(){
        if(context.getState() == apoio_poeState.GESTAO_AL){
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
        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);
        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);

        //create buttons
        mensagemEscolha = new Label();
        mensagemEscolha.setText("Escolha uma das opcoes: ");

        ButtonInserirAlunos = new Button();
        ButtonInserirAlunos.setText("Inserir alunos a partir de um ficheiro");
        ButtonInserirAlunos.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-border-width: 5px;");

        ButtonInserirUmAluno = new Button();
        ButtonInserirUmAluno.setText("Inserir um aluno");
        ButtonInserirUmAluno.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-border-width: 5px;");

        ButtonConsultarUmAluno = new Button();
        ButtonConsultarUmAluno.setText("Consultar um aluno");
        ButtonConsultarUmAluno.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-border-width: 5px;");

        ButtonConsultarAlunos = new Button();
        ButtonConsultarAlunos.setText("Consultar todos os alunos");
        ButtonConsultarAlunos.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-border-width: 5px;");

        ButtonRemoverAluno = new Button();
        ButtonRemoverAluno.setText("Remover aluno");
        ButtonRemoverAluno.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-border-width: 5px;");

        ButtonEditarAluno = new Button();
        ButtonEditarAluno.setText("Editar aluno");
        ButtonEditarAluno.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-border-width: 5px;");

        ButtonVoltar = new Button();
        ButtonVoltar.setText("Voltar");
        ButtonVoltar.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-border-width: 5px;");

        listaDeAlunos = new Label();


        //organizar coordenadas

        gridButtons.add(mensagemEscolha, 0, 0);
        gridButtons.add(ButtonInserirAlunos, 0, 2);
        gridButtons.add(ButtonInserirUmAluno, 0, 4);
        gridButtons.add(ButtonConsultarUmAluno, 0, 6);
        gridButtons.add(ButtonConsultarAlunos, 0, 8);
        gridButtons.add(ButtonRemoverAluno, 0, 10);
        gridButtons.add(ButtonEditarAluno, 0, 12);
        gridButtons.add(ButtonVoltar, 0, 14);
        gridButtons.add(listaDeAlunos, 0, 16);

        this.setCenter(gridButtons);
    }

}
