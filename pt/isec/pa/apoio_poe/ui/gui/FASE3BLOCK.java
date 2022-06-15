package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class FASE3BLOCK extends BorderPane {


    GridPane gridButtons;

    Button ButtonConsultaAlunosComAutoPropostaAtribuida;
    Button ButtonConsultaAlunosSemAutoPropostaAtribuida;
    Button ButtonConsultaAlunosComCandidatura;
    Button ButtonConsultaAlunosSemCandidatura;
    Button ButtonConsultaListaDeAutoPropostas;
    Button ButtonConsultaPropostasDeDocentes;
    Button ButtonConsultarPropostasDisponiveis;
    Button ButtonPropostasAtribuidas;

    Button ButtonSair;
    Button ButtonAvancar;
    Label mensagemBoasVindas;
    apoio_poeContext context;
    WindowToolBar toolBar;

    public FASE3BLOCK(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonConsultaAlunosComAutoPropostaAtribuida.setOnAction(ev->context.consultarAlunosComPropostaAtribuida());
        ButtonConsultaAlunosSemAutoPropostaAtribuida.setOnAction(ev->context.consultarAlunosSemPropostaAtribuida());
        ButtonConsultaAlunosComCandidatura.setOnAction(ev->context.consultarAlunosComCandidatura());
        ButtonConsultaAlunosSemCandidatura.setOnAction(ev->context.consultarAlunosSemCandidatura());
        ButtonConsultaListaDeAutoPropostas.setOnAction(ev->context.consultarListaDeAutopropostas());
        ButtonConsultaPropostasDeDocentes.setOnAction(ev->context.consultarPropostasDocentes());
        ButtonConsultarPropostasDisponiveis.setOnAction(ev->context.consultarPropostasDisponiveis());
        ButtonPropostasAtribuidas.setOnAction(ev->context.consultarPropostasAtribuidas());
        ButtonAvancar.setOnAction(ev->context.avancarFase());
        ButtonSair.setOnAction(ev->System.exit(0));


    }

    public void createViews(){
        CSSManager.applyCSS(this,"mystyles.css");
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
        mensagemBoasVindas.getStyleClass().add("labelEscolha");


        Button ButtonConsultaAlunosSemAutoPropostaAtribuida;
        Button ButtonConsultarPropostasDisponiveis;
        Button ButtonPropostasAtribuidas;

        ButtonConsultaAlunosComAutoPropostaAtribuida = new Button();
        ButtonConsultaAlunosComAutoPropostaAtribuida.setText("Consultar Alunos com candidatura");
        ButtonConsultaAlunosComAutoPropostaAtribuida.getStyleClass().add("buttonFase1");

        ButtonConsultaAlunosComAutoPropostaAtribuida = new Button();
        ButtonConsultaAlunosComAutoPropostaAtribuida.setText("Consultar Alunos com candidatura");
        ButtonConsultaAlunosComAutoPropostaAtribuida.getStyleClass().add("buttonFase1");

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

        ButtonSair = new Button();
        ButtonSair.setText("Sair");
        ButtonSair.getStyleClass().add("buttonFase1");

        ButtonAvancar = new Button();
        ButtonAvancar.setText("Avancar para a proxima fase");
        ButtonAvancar.getStyleClass().add("buttonFase1");


        //organizar coordenadas
        gridButtons.add(mensagemBoasVindas, 0, 0);
        gridButtons.add(ButtonConsultaAlunosComAutoProposta, 0, 2);
        gridButtons.add(ButtonConsultaAlunosComCandidatura, 0, 4);
        gridButtons.add(ButtonConsultaAlunosSemCandidatura, 0, 6);
        gridButtons.add(ButtonConsultaListaDeAutoPropostas, 0, 8);
        gridButtons.add(ButtonConsultaPropostasDeDocentes, 0, 10);
        gridButtons.add(ButtonConsultaPropostasComCandidaturas, 0, 12);
        gridButtons.add(ButtonConsultaPropostasSemCandidaturas, 0, 14);
        gridButtons.add(ButtonConsultaCandidatura, 0, 16);
        gridButtons.add(ButtonAvancar, 0, 16);
        this.setCenter(gridButtons);
    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE3BLOCKSTATE){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }




}
