package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class FASE1BLOCK extends BorderPane {


    GridPane gridButtons;

    Button ButtonConsultaAluno;
    Button ButtonConsultarAlunos;
    Button ButtonConsultarDocente;
    Button ButtonConsultarDocentes;
    Button ButtonConsultarProposta;
    Button ButtonConsultarPropostas;

    Button ButtonSair;
    Button ButtonAvancar;
    Label mensagemBoasVindas;
    apoio_poeContext context;
    WindowToolBar toolBar;




    public FASE1BLOCK(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        //ButtonConsultaAluno.setOnAction(ev->context.consultaAluno());
        ButtonConsultarAlunos.setOnAction(ev->context.consultarAlunos());
        //ButtonConsultarDocente.setOnAction(ev->context.consultaDocente());
        ButtonConsultarDocentes.setOnAction(ev->context.consultaDocentes());
        //ButtonConsultarProposta.setOnAction(ev->context.consultaProposta());
        ButtonConsultarPropostas.setOnAction(ev->context.consultarPropostas());
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

        ButtonConsultaAluno = new Button();
        ButtonConsultaAluno.setText("Consultar Aluno");
        ButtonConsultaAluno.getStyleClass().add("buttonFase1");

        ButtonConsultarAlunos = new Button();
        ButtonConsultarAlunos.setText("Consultar Alunos");
        ButtonConsultarAlunos.getStyleClass().add("buttonFase1");

        ButtonConsultarDocente = new Button();
        ButtonConsultarDocente.setText("Consultar Docente");
        ButtonConsultarDocente.getStyleClass().add("buttonFase1");

        ButtonConsultarDocentes = new Button();
        ButtonConsultarDocentes.setText("Consultar Docentes");
        ButtonConsultarDocentes.getStyleClass().add("buttonFase1");

        ButtonConsultarProposta = new Button();
        ButtonConsultarProposta.setText("Consultar Proposta");
        ButtonConsultarProposta.getStyleClass().add("buttonFase1");

        ButtonConsultarPropostas = new Button();
        ButtonConsultarPropostas.setText("Consultar Propostas");
        ButtonConsultarPropostas.getStyleClass().add("buttonFase1");

        ButtonSair = new Button();
        ButtonSair.setText("Sair");
        ButtonSair.getStyleClass().add("buttonFase1");

        ButtonAvancar = new Button();
        ButtonAvancar.setText("Avancar para a proxima fase");
        ButtonAvancar.getStyleClass().add("buttonFase1");


        //organizar coordenadas
        gridButtons.add(mensagemBoasVindas, 0, 0);
        gridButtons.add(ButtonConsultaAluno, 0, 2);
        gridButtons.add(ButtonConsultarAlunos, 0, 4);
        gridButtons.add(ButtonConsultarDocente, 0, 6);
        gridButtons.add(ButtonConsultarDocentes, 0, 8);
        gridButtons.add(ButtonConsultarProposta, 0, 10);
        gridButtons.add(ButtonConsultarPropostas, 0, 12);
        gridButtons.add(ButtonAvancar, 0, 16);
        this.setCenter(gridButtons);
    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE1BLOCKSTATE){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }




}
