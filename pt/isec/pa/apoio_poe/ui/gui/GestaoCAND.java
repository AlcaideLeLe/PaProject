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

import java.util.ArrayList;

public class GestaoCAND extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;

    Button ButtonAddCandidatura;
    Button ButtonConsultaCandidaturas;
    Button ButtonConsultaCandidatura;
    Button ButtonConsultarAlunos;
    Button ButtonExportarCandidaturasParaCsv;

    Button ButtonVoltar;

    Label mensagemEscolha;
    Label listaDeDocentes;

    public GestaoCAND(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonAddCandidatura.setOnAction(ev->context.addCandidatura());
        ButtonConsultaCandidaturas.setOnAction(ev->context.consultaCandidaturas());
        //ButtonConsultaCandidatura.setOnAction(ev->context.consultaCandidatura());
        ButtonConsultarAlunos.setOnAction(ev->context.consultarAlunos());
        ButtonVoltar.setOnAction(ev->context.changeFromGestaoCANDtoBase());
        //ButtonExportarCandidaturasParaCsv.setOnAction(ev->context.exportarCandidaturasParaCSV());

    }

    public void update(){
        if(context.getState() == apoio_poeState.GESTAO_CAND){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }

    public void createViews(){
        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);

        gridButtons.setHgap(0);
        gridButtons.setVgap(10);

        mensagemEscolha = new Label();
        mensagemEscolha.setText("Escolha uma das opcoes: ");
        ButtonAddCandidatura = new Button();
        ButtonAddCandidatura.setText("Adicionar candidatura");
        ButtonConsultaCandidaturas = new Button();
        ButtonConsultaCandidaturas.setText("Consultar candidaturas");
        ButtonConsultaCandidatura = new Button();
        ButtonConsultaCandidatura.setText("Consultar candidatura");
        ButtonConsultarAlunos = new Button();
        ButtonConsultarAlunos.setText("Consultar Alunos");
        ButtonExportarCandidaturasParaCsv = new Button();
        ButtonExportarCandidaturasParaCsv.setText("Exportar Candidaturas");
        ButtonVoltar = new Button();
        ButtonVoltar.setText("Voltar");
        listaDeDocentes = new Label();


        //organizar coordenadas

        gridButtons.add(mensagemEscolha, 0, 0);
        gridButtons.add(ButtonAddCandidatura, 0, 2);
        gridButtons.add(ButtonConsultaCandidaturas, 0, 4);
        gridButtons.add(ButtonConsultaCandidatura, 0, 6);
        gridButtons.add(ButtonConsultarAlunos, 0, 8);
        gridButtons.add(ButtonExportarCandidaturasParaCsv, 0, 10);
        gridButtons.add(ButtonVoltar, 0, 14);

        this.setCenter(gridButtons);
    }

}
