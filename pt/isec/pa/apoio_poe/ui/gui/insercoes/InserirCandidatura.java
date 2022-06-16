package pt.isec.pa.apoio_poe.ui.gui.insercoes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class InserirCandidatura extends BorderPane {
    apoio_poeContext context;

    TextField textNrAluno;
    Label labelnr;
    TextField textPropostas;
    Label labelPropostas;
    Button buttonConfirm;
    GridPane grid;
    ArrayList<String> propostasAssociadas = new ArrayList<String>();

    public InserirCandidatura(apoio_poeContext context){
        super();
        this.context = context;
        createViews();
        registerHandlers();
    }

    private void registerHandlers(){

        buttonConfirm.setOnAction(ev->{
            for(String s : textPropostas.getText().split(",")){
                propostasAssociadas.add(s);
            }
            context.addCandidaturaIndividual(new Candidatura(Long.parseLong(textNrAluno.getText()), propostasAssociadas));
        });
    }

    private void createViews(){
        CSSManager.applyCSS(this,"mystyles.css");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        labelnr = new Label("");
        labelnr.setText("Insira o numero do aluno associado a esta candidatura");
        grid.add(labelnr, 0, 0);
        labelnr.getStyleClass().add("labelInsereAluno");

        textNrAluno = new TextField(" ");
        grid.add(textNrAluno, 0, 2);

        labelPropostas = new Label("");
        labelPropostas.setText("Insira as propostas associadas a esta candidatura, separadas por virgulas");

        grid.add(labelPropostas, 0, 4);
        labelPropostas.getStyleClass().add("labelInsereAluno");

        textPropostas = new TextField(" ");
        grid.add(textPropostas, 0, 6);

        buttonConfirm = new Button("Confirmar candidatura");
        grid.add(buttonConfirm, 2, 6);

        buttonConfirm.getStyleClass().add("buttonConfirm");

        setCenter(grid);


    }
}
