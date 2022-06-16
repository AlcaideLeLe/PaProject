package pt.isec.pa.apoio_poe.ui.gui.estados;

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
import pt.isec.pa.apoio_poe.ui.gui.WindowToolBar;
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
    Button ButtonRecuarFaseBlockAnterior;

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
        ButtonRecuarFaseBlockAnterior.setOnAction(ev->context.changeToFaseBloqueadaAnterior());
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

        ButtonPropostasAtribuidas = new Button();
        ButtonPropostasAtribuidas.setText("Consultar Propostas Atribuidas");
        ButtonPropostasAtribuidas.getStyleClass().add("buttonFase1");

        ButtonConsultarPropostasDisponiveis = new Button();
        ButtonConsultarPropostasDisponiveis.setText("Consultar Propostas Disponiveis");
        ButtonConsultarPropostasDisponiveis.getStyleClass().add("buttonFase1");

        ButtonConsultaAlunosSemAutoPropostaAtribuida = new Button();
        ButtonConsultaAlunosSemAutoPropostaAtribuida.setText("Consultar Alunos sem Auto-proposta Atribuida");
        ButtonConsultaAlunosSemAutoPropostaAtribuida.getStyleClass().add("buttonFase1");

        ButtonConsultaAlunosComAutoPropostaAtribuida = new Button();
        ButtonConsultaAlunosComAutoPropostaAtribuida.setText("Consultar Alunos com Auto-proposta Atribuida");
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

        ButtonRecuarFaseBlockAnterior = new Button();
        ButtonRecuarFaseBlockAnterior.setText("Recuar para fase bloqueada anterior");
        ButtonRecuarFaseBlockAnterior.getStyleClass().add("buttonFase1");

        ButtonSair = new Button();
        ButtonSair.setText("Sair");
        ButtonSair.getStyleClass().add("buttonFase1");

        ButtonAvancar = new Button();
        ButtonAvancar.setText("Avancar para a proxima fase");
        ButtonAvancar.getStyleClass().add("buttonFase1");


        //organizar coordenadas
        gridButtons.add(mensagemBoasVindas, 0, 0);
        gridButtons.add(ButtonPropostasAtribuidas, 0, 2);
        gridButtons.add(ButtonConsultarPropostasDisponiveis, 0, 4);
        gridButtons.add(ButtonConsultaAlunosSemAutoPropostaAtribuida, 0, 6);
        gridButtons.add(ButtonConsultaAlunosComAutoPropostaAtribuida, 0, 8);
        gridButtons.add(ButtonConsultaAlunosComCandidatura, 0, 10);
        gridButtons.add(ButtonConsultaAlunosSemCandidatura, 0, 12);
        gridButtons.add(ButtonConsultaListaDeAutoPropostas, 0, 14);
        gridButtons.add(ButtonConsultaPropostasDeDocentes, 0, 16);
        gridButtons.add(ButtonAvancar, 0, 18);
        gridButtons.add(ButtonRecuarFaseBlockAnterior, 0, 20);

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
