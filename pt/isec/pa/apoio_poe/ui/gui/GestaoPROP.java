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
        ButtonConsultarPropostas.setOnAction(ev->{
            ArrayList<Proposta> consultaProposta = new ArrayList<Proposta>();
            consultaProposta = context.consultaPropostas();
            for(Proposta p : consultaProposta){
                listaDePropostas.setText(p.getIdProposta());
            }
        });
        //ButtonConsultarUmAluno.setOnAction(ev->context.consultaAluno());
        //ButtonRemoverAluno.setOnAction(ev->context.removerAluno());
        //ButtonEditarAluno.setOnAction(ev->context.editarAluno());
        ButtonVoltar.setOnAction(ev->context.changeFromGestaoALtoBase());

    }

    public void update(){
        if(context.getState() == apoio_poeState.GESTAO_PROP){
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
        ButtonInserirPropostas = new Button();
        ButtonInserirPropostas.setText("Inserir propostas a partir de um ficheiro");
        ButtonInserirUmaProposta = new Button();
        ButtonInserirUmaProposta.setText("Inserir uma proposta");
        ButtonConsultarUmaProposta = new Button();
        ButtonConsultarUmaProposta.setText("Consultar uma proposta");
        ButtonConsultarPropostas = new Button();
        ButtonConsultarPropostas.setText("Consultar todas as propostas");
        ButtonRemoverProposta = new Button();
        ButtonRemoverProposta.setText("Remover proposta");
        ButtonEditarProposta = new Button();
        ButtonEditarProposta.setText("Editar proposta");
        ButtonVoltar = new Button();
        ButtonVoltar.setText("Voltar");
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
