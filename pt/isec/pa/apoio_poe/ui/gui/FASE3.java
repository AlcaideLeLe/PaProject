package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class FASE3 extends BorderPane {
    GridPane gridButtons;

    Button ButtonTratamentoPro;
    Button ButtonF3MasF2Aberta;
    Button ButtonGestaoManualAtribuicoes;
    Button ButtonConsultaAlunosComAutoproposta;
    Button ButtonConsultarAlunosComCandidatura;
    Button ButtonConsultarAlunosComAutoPropostaAtribuida;
    Button ButtonConsultarAlunosSemAutoPropostaAtribuida;
    Button ButtonConsultarListaDeAutopropostas;
    Button ButtonConsultarPropostasDeDocentes;
    Button ButtonConsultarPropostasDisponiveis;
    Button ButtonConsultaPropostasAtribuidas;
    Button ButtonExportarAlunosCSV;

    Button ButtonAvancarFase;
    Button ButtonRecuarFase;
    Button ButtonFecharFase;
    Button ButtonSair;



    Label mensagemBoasVindas;
    apoio_poeContext context;
    WindowToolBar toolBar;

    public FASE3(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){
        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonTratamentoPro.setOnAction(ev->context.changeToTratamentoProp());
        ButtonF3MasF2Aberta.setOnAction(ev->context.changeToF3MasF2Aberta());
        ButtonGestaoManualAtribuicoes.setOnAction(ev->context.changeToGestaoManualAtribuicoesState());
        ButtonConsultaAlunosComAutoproposta.setOnAction(ev->context.consultaAlunosComAutoproposta());
        ButtonConsultarAlunosComCandidatura.setOnAction(ev->context.consultarAlunosComCandidatura());
        ButtonConsultarAlunosComAutoPropostaAtribuida.setOnAction(ev->context.consultarAlunosComPropostaAtribuida());
        ButtonConsultarAlunosSemAutoPropostaAtribuida.setOnAction(ev->context.consultarAlunosSemPropostaAtribuida());
        ButtonConsultarListaDeAutopropostas.setOnAction(ev->context.consultarListaDeAutopropostas());
        ButtonConsultarPropostasDeDocentes.setOnAction(ev->context.consultarPropostasDocentes());
        ButtonConsultarPropostasDisponiveis.setOnAction(ev->context.consultarPropostasDisponiveis());
        ButtonConsultaPropostasAtribuidas.setOnAction(ev->context.consultarPropostasAtribuidas());
        //ButtonExportarAlunosCSV.setOnAction(ev->context.exportarAlunosParaCSV(String nomeFicheiro));


        ButtonAvancarFase.setOnAction(ev->context.avancarFase());
        ButtonRecuarFase.setOnAction(ev->context.recuarFase());
        ButtonFecharFase.setOnAction(ev->context.fecharFase());

        ButtonSair.setOnAction(ev->System.exit(0));




    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE3){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }

    public void createViews(){
        System.out.println("cheguei aqui");
        CSSManager.applyCSS(this,"mystyles.css");
        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);
        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);
        //create buttons
        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Escolha uma das opcoes: ");

        ButtonTratamentoPro = new Button();
        ButtonTratamentoPro.setText("Tratamento de Propostas");
        ButtonTratamentoPro.getStylesheets().add("buttonFase2");

        ButtonF3MasF2Aberta = new Button();
        ButtonF3MasF2Aberta.setText("Fase 3 mas Fase 2 aberta");
        ButtonF3MasF2Aberta.getStylesheets().add("buttonFase2");

        ButtonGestaoManualAtribuicoes = new Button();
        ButtonGestaoManualAtribuicoes.setText("Gestao manual de atribuicoes");
        ButtonGestaoManualAtribuicoes.getStylesheets().add("buttonFase2");

        ButtonConsultarAlunosComAutoPropostaAtribuida = new Button();
        ButtonConsultarAlunosComAutoPropostaAtribuida.setText("Consultar alunos com auto-proposta atribuida");
        ButtonConsultarAlunosComAutoPropostaAtribuida.getStylesheets().add("buttonFase2");

        ButtonConsultarAlunosSemAutoPropostaAtribuida = new Button();
        ButtonConsultarAlunosSemAutoPropostaAtribuida.setText("Consultar alunos sem auto-proposta atribuida");
        ButtonConsultarAlunosSemAutoPropostaAtribuida.getStylesheets().add("buttonFase2");

        ButtonConsultarPropostasDisponiveis = new Button();
        ButtonConsultarPropostasDisponiveis.setText("Consultar Propostas Disponiveis");
        ButtonConsultarPropostasDisponiveis.getStylesheets().add("buttonFase2");

        ButtonConsultaPropostasAtribuidas = new Button();
        ButtonConsultaPropostasAtribuidas.setText("Consultar propostas atribuidas");
        ButtonConsultaPropostasAtribuidas.getStylesheets().add("buttonFase2");

        ButtonExportarAlunosCSV = new Button();
        ButtonExportarAlunosCSV.setText("Exportar Alunos para CSV");
        ButtonExportarAlunosCSV.getStylesheets().add("buttonFase2");

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
        ButtonSair.getStyleClass().add("buttonFase2");



        ButtonConsultaAlunosComAutoproposta = new Button();
        ButtonConsultaAlunosComAutoproposta.setText("Consultar alunos com auto-proposta");
        ButtonConsultaAlunosComAutoproposta.getStyleClass().add("buttonFase2");

        ButtonConsultarAlunosComCandidatura = new Button();
        ButtonConsultarAlunosComCandidatura.setText("Consultar alunos com candidatura");
        ButtonConsultarAlunosComCandidatura.getStyleClass().add("buttonFase2");



        ButtonConsultarListaDeAutopropostas = new Button();
        ButtonConsultarListaDeAutopropostas.setText("Consultar auto-propostas");
        ButtonConsultarListaDeAutopropostas.getStyleClass().add("buttonFase2");

        ButtonConsultarPropostasDeDocentes = new Button();
        ButtonConsultarPropostasDeDocentes.setText("Consultar propostas de docentes");
        ButtonConsultarPropostasDeDocentes.getStyleClass().add("buttonFase2");




        //organizar coordenadas
        gridButtons.add(mensagemBoasVindas, 0, 0);
        gridButtons.add(ButtonTratamentoPro, 0, 2);
        gridButtons.add(ButtonF3MasF2Aberta, 0, 4);
        gridButtons.add(ButtonGestaoManualAtribuicoes, 0, 6);
        gridButtons.add(ButtonConsultarAlunosComAutoPropostaAtribuida, 0, 8);
        gridButtons.add(ButtonConsultarAlunosSemAutoPropostaAtribuida, 0, 10);
        gridButtons.add(ButtonConsultarPropostasDisponiveis, 0, 12);
        gridButtons.add(ButtonConsultaPropostasAtribuidas, 0, 14);
        gridButtons.add(ButtonExportarAlunosCSV, 0, 16);


        gridButtons.add(ButtonAvancarFase, 0, 22);
        gridButtons.add(ButtonRecuarFase, 1, 22);
        gridButtons.add(ButtonFecharFase, 2, 22);

        this.setCenter(gridButtons);
    }






}
