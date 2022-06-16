package pt.isec.pa.apoio_poe.ui.gui.edicoes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class EditarCandidatura extends BorderPane {
    apoio_poeContext context;

    TextField textPropostas;



    Button buttonConfirm;
    Button buttonClose;

    Label labelPropostas;

    GridPane grid;

    long nr;

    ArrayList<String> propostasAssociadas = new ArrayList<String>();

    public EditarCandidatura(apoio_poeContext context, long nr) {
        super();
        this.context = context;
        this.nr = nr;
        createViews();
        registerHandlers();


    }

    private void registerHandlers() {

        buttonConfirm.setOnAction(ev -> {
            for(String s : textPropostas.getText().split(",")){
                propostasAssociadas.add(s);
            }
           context.editarCandidatura(nr, propostasAssociadas);
        });

    }

    private void createViews() {
        System.out.println("Estou aqui a editar candidaturas");
        CSSManager.applyCSS(this, "mystyles.css");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        labelPropostas = new Label("");
        labelPropostas.setText("Insira as propostas que quer adicionar, separadas por virgulas");
        grid.add(labelPropostas, 0, 3);
        labelPropostas.getStyleClass().add("labelInsereAluno");

        textPropostas = new TextField("");
        grid.add(textPropostas, 0, 7);


        buttonConfirm = new Button("Confirmar edicao");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}