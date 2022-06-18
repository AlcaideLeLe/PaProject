package pt.isec.pa.apoio_poe.ui.gui.estados;

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
import pt.isec.pa.apoio_poe.ui.gui.graficos.GraficoEmpresas;
import pt.isec.pa.apoio_poe.ui.gui.graficos.GraficoOrientadores;
import pt.isec.pa.apoio_poe.ui.gui.graficos.GraficoPropostasAtribuidas;
import pt.isec.pa.apoio_poe.ui.gui.graficos.GraficoPropostasRamos;
import pt.isec.pa.apoio_poe.ui.gui.questiona.QuestionaFicheiroAluno;
import pt.isec.pa.apoio_poe.ui.gui.WindowToolBar;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class FASE5 extends BorderPane {
    GridPane gridButtons;

    Button ButtonConsultarAlunosComPropostaAtribuida;
    Button ButtonConsultarComCandidaturaESemProposta;
    Button ButtonConsultarPropostasDisponiveis;
    Button ButtonConsultarPropostasAtribuidas;
    Button ButtonConsultarDocentesComMenosOrientacoes;
    Button ButtonConsultarDocentesComMaisOrientacoes;
    Button ButtonConsultarMediaDeOrientacoesDocentes;
    Button ButtonExportarAlunosCSV;
    Button ButtonVerGraficosRamos;
    Button ButtonVerGraficosPercAtribuicao;
    Button ButtonVerGraficosOrientadores;
    Button ButtonVerGraficosEmpresas;

    Button ButtonSair;



    Label mensagemBoasVindas;
    Label state;
    apoio_poeContext context;
    WindowToolBar toolBar;

    public FASE5(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){
        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonVerGraficosRamos.setOnAction(ev->{
            Stage stage = new Stage();
            Stage owner = (Stage) this.getScene().getWindow();
            GraficoPropostasRamos root = new GraficoPropostasRamos(context);
            Scene scene = new Scene(root,250,400);
            stage.initModality(Modality.NONE);
            stage.initOwner(owner);
            stage.setWidth(300);
            stage.setX(owner.getX() - stage.getWidth());
            stage.setY(owner.getY());
            stage.setScene(scene);
            stage.setTitle("Grafico");
            stage.setMinWidth(400);
            stage.setMinHeight(400);
            stage.show();
        });

        ButtonVerGraficosPercAtribuicao.setOnAction(ev->{
            Stage stage = new Stage();
            Stage owner = (Stage) this.getScene().getWindow();
            GraficoPropostasAtribuidas root = new GraficoPropostasAtribuidas(context);
            Scene scene = new Scene(root,250,250);
            stage.initModality(Modality.NONE);
            stage.initOwner(owner);
            stage.setWidth(300);
            stage.setX(owner.getX() - stage.getWidth());
            stage.setY(owner.getY());
            stage.setScene(scene);
            stage.setTitle("Grafico");
            stage.setMinWidth(200);
            stage.setMinHeight(200);
            stage.show();
        });
        ButtonVerGraficosOrientadores.setOnAction(ev->{
            Stage stage = new Stage();
            Stage owner = (Stage) this.getScene().getWindow();
            GraficoOrientadores root = new GraficoOrientadores(context);
            Scene scene = new Scene(root,250,250);
            stage.initModality(Modality.NONE);
            stage.initOwner(owner);
            stage.setWidth(300);
            stage.setX(owner.getX() - stage.getWidth());
            stage.setY(owner.getY());
            stage.setScene(scene);
            stage.setTitle("Grafico");
            stage.setMinWidth(250);
            stage.setMinHeight(250);
            stage.show();
        });

        ButtonVerGraficosEmpresas.setOnAction(ev->{
            Stage stage = new Stage();
            Stage owner = (Stage) this.getScene().getWindow();
            GraficoEmpresas root = new GraficoEmpresas(context);
            Scene scene = new Scene(root,250,250);
            stage.initModality(Modality.NONE);
            stage.initOwner(owner);
            stage.setWidth(300);
            stage.setX(owner.getX() - stage.getWidth());
            stage.setY(owner.getY());
            stage.setScene(scene);
            stage.setTitle("Grafico");
            stage.setMinWidth(250);
            stage.setMinHeight(250);
            stage.show();
        });
        ButtonConsultarAlunosComPropostaAtribuida.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosComPropostaAtribuida root = new MostraAlunosComPropostaAtribuida(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Alunos Com Proposta Atribuida");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarComCandidaturaESemProposta.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosComCandidaturaESemProposta root = new MostraAlunosComCandidaturaESemProposta(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Alunos Com Candidatura e Sem Proposta");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarPropostasDisponiveis.setOnAction(ev->{
            Stage stage = new Stage();
            MostraPropostasDisponiveis root = new MostraPropostasDisponiveis(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Consultar Propostas Disponiveis");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarPropostasAtribuidas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraPropostasAtribuidas root = new MostraPropostasAtribuidas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Consultar Propostas Atribuidas");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarDocentesComMenosOrientacoes.setOnAction(ev->{
            Stage stage = new Stage();
            MostraDocentesComMenosOrientacoes root = new MostraDocentesComMenosOrientacoes(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
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
            stage.initModality(Modality.NONE);
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
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Consultar media de Orientacoes");
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
            stage.setTitle("Aluno");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
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
        if(context.getState() == apoio_poeState.FASE5){
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
        state.setText("FASE 5");

        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Escolha uma das opcoes: ");

        ButtonVerGraficosRamos = new Button();
        ButtonVerGraficosRamos.setText("Ver grafico de divisao de ramos");
        ButtonVerGraficosRamos.getStyleClass().add("buttonFase2");

        ButtonVerGraficosPercAtribuicao = new Button();
        ButtonVerGraficosPercAtribuicao.setText("Ver grafico de percentagem de atribuicoes");
        ButtonVerGraficosPercAtribuicao.getStyleClass().add("buttonFase2");

        ButtonVerGraficosEmpresas = new Button();
        ButtonVerGraficosEmpresas.setText("Ver grafico relacionado com o numero de estagios por empresa");
        ButtonVerGraficosEmpresas.getStyleClass().add("buttonFase2");

        ButtonVerGraficosOrientadores = new Button();
        ButtonVerGraficosOrientadores.setText("Ver grafico de docentes");
        ButtonVerGraficosOrientadores.getStyleClass().add("buttonFase2");

        ButtonConsultarAlunosComPropostaAtribuida = new Button();
        ButtonConsultarAlunosComPropostaAtribuida.setText("Consultar Alunos Com Proposta Atribuida");
        ButtonConsultarAlunosComPropostaAtribuida.getStyleClass().add("buttonFase2");

        ButtonConsultarComCandidaturaESemProposta = new Button();
        ButtonConsultarComCandidaturaESemProposta.setText("Consultar Alunos Com Candidatura E Sem Proposta");
        ButtonConsultarComCandidaturaESemProposta.getStyleClass().add("buttonFase2");

        ButtonConsultarPropostasDisponiveis = new Button();
        ButtonConsultarPropostasDisponiveis.setText("Consultar Propostas Disponiveis");
        ButtonConsultarPropostasDisponiveis.getStyleClass().add("buttonFase2");

        ButtonConsultarPropostasAtribuidas = new Button();
        ButtonConsultarPropostasAtribuidas.setText("Consultar Propostas Atribuidas");
        ButtonConsultarPropostasAtribuidas.getStyleClass().add("buttonFase2");

        ButtonConsultarDocentesComMenosOrientacoes = new Button();
        ButtonConsultarDocentesComMenosOrientacoes.setText("Consultar docentes com menos orientacoes");
        ButtonConsultarDocentesComMenosOrientacoes.getStyleClass().add("buttonFase2");

        ButtonConsultarDocentesComMaisOrientacoes = new Button();
        ButtonConsultarDocentesComMaisOrientacoes.setText("Consultar docentes com mais orientacoes");
        ButtonConsultarDocentesComMaisOrientacoes.getStyleClass().add("buttonFase2");

        ButtonConsultarMediaDeOrientacoesDocentes = new Button();
        ButtonConsultarMediaDeOrientacoesDocentes.setText("Consultar media de orientacoes de docentes");
        ButtonConsultarMediaDeOrientacoesDocentes.getStyleClass().add("buttonFase2");

        ButtonExportarAlunosCSV = new Button();
        ButtonExportarAlunosCSV.setText("Exportar Alunos para CSV");
        ButtonExportarAlunosCSV.getStyleClass().add("buttonFase2");



        ButtonSair = new Button();
        ButtonSair.setText("Sair");
        ButtonSair.getStyleClass().add("buttonSair");

        //organizar coordenadas
        gridButtons.add(state, 0, 0);
        gridButtons.add(mensagemBoasVindas, 0, 2);
        gridButtons.add(ButtonConsultarAlunosComPropostaAtribuida, 0, 6);
        gridButtons.add(ButtonConsultarComCandidaturaESemProposta, 0, 4);
        gridButtons.add(ButtonConsultarPropostasDisponiveis, 0, 8);
        gridButtons.add(ButtonConsultarPropostasAtribuidas, 0, 10);
        gridButtons.add(ButtonConsultarDocentesComMenosOrientacoes, 0, 12);
        gridButtons.add(ButtonConsultarDocentesComMaisOrientacoes, 0, 14);
        gridButtons.add(ButtonConsultarMediaDeOrientacoesDocentes, 0, 16);
        gridButtons.add(ButtonExportarAlunosCSV, 0, 18);
        gridButtons.add(ButtonVerGraficosRamos, 0, 20);
        gridButtons.add(ButtonVerGraficosPercAtribuicao, 0, 22);
        gridButtons.add(ButtonVerGraficosOrientadores, 0, 24);
        gridButtons.add(ButtonVerGraficosEmpresas, 0, 26);
        gridButtons.add(ButtonSair, 0, 28);



        this.setCenter(gridButtons);
    }






}

