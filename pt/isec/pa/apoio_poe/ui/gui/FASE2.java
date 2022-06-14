package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;

public class FASE2 extends BorderPane {
    GridPane gridButtons;
    Button ButtonAvancarFase;
    Button ButtonRecuarFase;
    Button ButtonFecharFase;
    Button ButtonConsultarAlunos;
    Button ButtonConsultarPropostas;
    Button ButtonSair;
    Label mensagemBoasVindas;
    apoio_poeContext context;
    WindowToolBar toolBar;

    public FASE2(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){
        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonAvancarFase.setOnAction(ev->context.avancarFase());
        ButtonRecuarFase.setOnAction(ev->context.recuarFase());
        ButtonFecharFase.setOnAction(ev->context.fecharFase());
        ButtonConsultarAlunos.setOnAction(ev->context.fecharFase());
        ButtonConsultarPropostas.setOnAction(ev->context.fecharFase());
        ButtonSair.setOnAction(ev->System.exit(0));


    }

    public void createViews(){
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
        ButtonAvancarFase = new Button();
        ButtonAvancarFase.setText("Avancar fase");
        ButtonRecuarFase= new Button();
        ButtonRecuarFase.setText("Recuar Fase");
        ButtonFecharFase = new Button();
        ButtonFecharFase.setText("Fechar Fase");
        ButtonConsultarAlunos = new Button();
        ButtonConsultarAlunos.setText("Consultar Alunos");
        ButtonConsultarPropostas = new Button();
        ButtonConsultarPropostas.setText("Consultar Propostas");
        ButtonSair = new Button();
        ButtonSair.setText("Sair");
        //organizar coordenadas
        gridButtons.add(mensagemBoasVindas, 0, 0);
        gridButtons.add(ButtonAvancarFase, 0, 2);
        gridButtons.add(ButtonRecuarFase, 0, 4);
        gridButtons.add(ButtonFecharFase, 0, 6);
        gridButtons.add(ButtonConsultarAlunos, 0, 8);
        gridButtons.add(ButtonConsultarPropostas, 0, 10);
        this.setCenter(gridButtons);
    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE1){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }




}
