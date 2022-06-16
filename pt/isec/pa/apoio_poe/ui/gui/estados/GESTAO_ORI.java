package pt.isec.pa.apoio_poe.ui.gui.estados;

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
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class GESTAO_ORI extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;


    Button ButtonAtribuirManualOrientadorAAlunosComProposta;
    Button ButtonConsultarOrientadorDeProjetos;
    Button ButtonEditarOrientadorDeProposta;
    Button ButtonRemoverOrientadorDeProposta;
    Button ButtonChangeParaFase4;

    Label mensagemEscolha;
    Label listaDeAlunos;


    public GESTAO_ORI(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        //ButtonAtribuirManualOrientadorAAlunosComProposta.setOnAction(ev->context.atribuirManulamenteOrientadorAAlunosComProposta(long nrAluno, String emailProf));
        //ButtonConsultarOrientadorDeProjetos.setOnAction(ev->context.consultarOrientadorDeProposta(String idProposta));
        //ButtonEditarOrientadorDeProposta.setOnAction(ev->context.editarOrientadorDeProposta(String idProposta, String emailNovoOrientador));
        ButtonChangeParaFase4.setOnAction(ev->context.changeFromGestaoManualOrientToFase4());

    }

    public void update(){
        if(context.getState() == apoio_poeState.GESTAO_MANUAL_ORIENTSTATE){
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
        mensagemEscolha = new Label();
        mensagemEscolha.setText("Escolha uma das opcoes: ");


        ButtonAtribuirManualOrientadorAAlunosComProposta = new Button();
        ButtonAtribuirManualOrientadorAAlunosComProposta.setText("Atribuir Manualmente orientador a alunos com proposta");
        ButtonAtribuirManualOrientadorAAlunosComProposta.getStyleClass().add("buttonFase2");

        ButtonConsultarOrientadorDeProjetos = new Button();
        ButtonConsultarOrientadorDeProjetos.setText("Consultar orientador de projetos");
        ButtonConsultarOrientadorDeProjetos.getStyleClass().add("buttonFase2");

        ButtonEditarOrientadorDeProposta = new Button();
        ButtonEditarOrientadorDeProposta.setText("Editar Orientador de proposta");
        ButtonEditarOrientadorDeProposta.getStyleClass().add("buttonFase2");

        ButtonRemoverOrientadorDeProposta = new Button();
        ButtonRemoverOrientadorDeProposta.setText("Remover orientador de proposta");
        ButtonRemoverOrientadorDeProposta.getStyleClass().add("buttonFase2");


        ButtonChangeParaFase4 = new Button();
        ButtonChangeParaFase4.setText("Voltar");
        ButtonChangeParaFase4.getStyleClass().add("buttonFase2");

        listaDeAlunos = new Label();


        //organizar coordenadas

        gridButtons.add(mensagemEscolha, 0, 0);
        gridButtons.add(ButtonAtribuirManualOrientadorAAlunosComProposta, 0, 2);
        gridButtons.add(ButtonConsultarOrientadorDeProjetos, 0, 4);
        gridButtons.add(ButtonEditarOrientadorDeProposta, 0, 6);
        gridButtons.add(ButtonRemoverOrientadorDeProposta, 0, 8);
        gridButtons.add(ButtonChangeParaFase4, 0, 12);

        this.setCenter(gridButtons);
    }

}
