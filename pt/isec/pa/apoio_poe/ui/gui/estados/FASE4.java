package pt.isec.pa.apoio_poe.ui.gui.estados;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.ConfirmarSaida;
import pt.isec.pa.apoio_poe.ui.gui.consultas.*;
import pt.isec.pa.apoio_poe.ui.gui.questiona.QuestionaDocente;
import pt.isec.pa.apoio_poe.ui.gui.questiona.QuestionaFicheiroAluno;
import pt.isec.pa.apoio_poe.ui.gui.WindowToolBar;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class FASE4 extends BorderPane {
    GridPane gridButtons;

    Button ButtonChangeToGestaoManualOri;
    Button ButtonChangeToGestaoDocentes;
    Button ButtonConsultarAlunosComPropostaEOrientador;
    Button ButtonConsultarAlunosComPropostaESemOrientador;
    Button ButtonConsultarDocentesComMenosOrientacoes;
    Button ButtonConsultarDocentesComMaisOrientacoes;
    Button ButtonConsultarMediaDeOrientacoesDocentes;
    Button ButtonConsultarOrientacoesDocente;
    Button ButtonExportarAlunosCSV;



    Button ButtonAvancarFase;
    Button ButtonRecuarFase;
    Button ButtonFecharFase;
    Button ButtonSair;


    Label state;
    Label mensagemBoasVindas;
    apoio_poeContext context;
    WindowToolBar toolBar;

    public FASE4(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){
        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonChangeToGestaoManualOri.setOnAction(ev->context.changeToGestaoManualOrientState());
        ButtonChangeToGestaoDocentes.setOnAction(ev->context.changeToGestaoDeDocentesState());
        ButtonConsultarAlunosComPropostaEOrientador.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosComPropostaEOrientador root = new MostraAlunosComPropostaEOrientador(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Consultar Alunos com Proposta e com Orientador");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarAlunosComPropostaESemOrientador.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosComPropostaESemOrientador root = new MostraAlunosComPropostaESemOrientador(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Consultar Alunos com Proposta e sem Orientador");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarDocentesComMenosOrientacoes.setOnAction(ev->{
            Stage stage = new Stage();
            MostraDocentesComMenosOrientacoes root = new MostraDocentesComMenosOrientacoes(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Consultar Docentes com menos Orientacoes");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarDocentesComMaisOrientacoes.setOnAction(ev->{
            Stage stage = new Stage();
            MostraDocentesComMaisOrientacoes root = new MostraDocentesComMaisOrientacoes(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Consultar Docentes com mais Orientacoes");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarMediaDeOrientacoesDocentes.setOnAction(ev->{
            Stage stage = new Stage();
            MostraMediaDeOrientacoes root = new MostraMediaDeOrientacoes(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Consultar media de Orientacoes");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarOrientacoesDocente.setOnAction(ev->{
            Stage stage = new Stage();
            QuestionaDocente root = new QuestionaDocente(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Consultar Orientacoes de Docente");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonExportarAlunosCSV.setOnAction(ev->{
            Stage stage = new Stage();
            QuestionaFicheiroAluno root = new QuestionaFicheiroAluno(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Exportar Alunos");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });


        ButtonAvancarFase.setOnAction(ev->context.avancarFase());
        ButtonRecuarFase.setOnAction(ev->context.recuarFase());
        ButtonFecharFase.setOnAction(ev->context.fecharFase());

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




    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE4){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
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
        state.setText("FASE 4");

        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Escolha uma das opcoes: ");

        ButtonChangeToGestaoManualOri = new Button();
        ButtonChangeToGestaoManualOri.setText("Gestao manual de orientadores");
        ButtonChangeToGestaoManualOri.getStyleClass().add("buttonFase2");

        ButtonChangeToGestaoDocentes = new Button();
        ButtonChangeToGestaoDocentes.setText("Gestao de docentes");
        ButtonChangeToGestaoDocentes.getStyleClass().add("buttonFase2");

        ButtonConsultarAlunosComPropostaEOrientador = new Button();
        ButtonConsultarAlunosComPropostaEOrientador.setText("Consultar alunos com proposta e orientador");
        ButtonConsultarAlunosComPropostaEOrientador.getStyleClass().add("buttonFase2");

        ButtonConsultarAlunosComPropostaESemOrientador = new Button();
        ButtonConsultarAlunosComPropostaESemOrientador.setText("Consultar alunos com proposta e sem orientador");
        ButtonConsultarAlunosComPropostaESemOrientador.getStyleClass().add("buttonFase2");

        ButtonConsultarDocentesComMenosOrientacoes = new Button();
        ButtonConsultarDocentesComMenosOrientacoes.setText("Consultar docentes com menos orientacoes");
        ButtonConsultarDocentesComMenosOrientacoes.getStyleClass().add("buttonFase2");

        ButtonConsultarDocentesComMaisOrientacoes = new Button();
        ButtonConsultarDocentesComMaisOrientacoes.setText("Consultar docentes com mais orientacoes");
        ButtonConsultarDocentesComMaisOrientacoes.getStyleClass().add("buttonFase2");

        ButtonConsultarMediaDeOrientacoesDocentes = new Button();
        ButtonConsultarMediaDeOrientacoesDocentes.setText("Consultar media de orientacoes de docentes");
        ButtonConsultarMediaDeOrientacoesDocentes.getStyleClass().add("buttonFase2");

        ButtonConsultarOrientacoesDocente = new Button();
        ButtonConsultarOrientacoesDocente.setText("Consultar orientacoes de docente");
        ButtonConsultarOrientacoesDocente.getStyleClass().add("buttonFase2");

        ButtonExportarAlunosCSV = new Button();
        ButtonExportarAlunosCSV.setText("Exportar Alunos para CSV");
        ButtonExportarAlunosCSV.getStyleClass().add("buttonFase2");

        ButtonAvancarFase = new Button();
        ButtonAvancarFase.setText("Avancar fase");
        ButtonAvancarFase.getStyleClass().add("buttonFase2");

        ButtonRecuarFase= new Button();
        ButtonRecuarFase.setText("Recuar Fase");
        ButtonRecuarFase.getStyleClass().add("buttonFase2");

        ButtonFecharFase = new Button();
        ButtonFecharFase.setText("Fechar Fase");
        ButtonFecharFase.getStyleClass().add("buttonFase2");

        ButtonSair = new Button();
        ButtonSair.setText("Sair");
        ButtonSair.getStyleClass().add("buttonSair");

        //organizar coordenadas
        gridButtons.add(state, 0, 0);
        gridButtons.add(mensagemBoasVindas, 0, 0);
        gridButtons.add(ButtonChangeToGestaoManualOri, 0, 4);
        gridButtons.add(ButtonChangeToGestaoDocentes, 0, 6);
        gridButtons.add(ButtonConsultarAlunosComPropostaEOrientador, 0, 8);
        gridButtons.add(ButtonConsultarAlunosComPropostaESemOrientador, 0, 10);
        gridButtons.add(ButtonConsultarDocentesComMenosOrientacoes, 0, 12);
        gridButtons.add(ButtonConsultarDocentesComMaisOrientacoes, 0, 14);
        gridButtons.add(ButtonConsultarMediaDeOrientacoesDocentes, 0, 16);
        gridButtons.add(ButtonConsultarOrientacoesDocente, 0, 18);
        gridButtons.add(ButtonExportarAlunosCSV, 0, 20);


        gridButtons.add(ButtonAvancarFase, 0, 22);
        gridButtons.add(ButtonRecuarFase, 0, 24);
        gridButtons.add(ButtonFecharFase, 0, 26);
        gridButtons.add(ButtonSair, 0, 28);


        this.setCenter(gridButtons);
    }






}
