package pt.isec.pa.apoio_poe.ui.gui;

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

public class EditarProposta extends BorderPane {
    apoio_poeContext context;

    TextField textNrAluno;
    TextField textTipoProposta;
    TextField textTitulo;



    CheckBox isAtribuida;
    Button buttonConfirm;
    Button buttonClose;

    Label labelTipoProposta;
    Label labelNrAluno;
    Label labelTitulo;
    Label labelAtribuida;

    GridPane grid;

    String ID;


    public EditarProposta(apoio_poeContext context, String ID) {
        super();
        this.context = context;
        this.ID = ID;
        createViews();
        registerHandlers();


    }

    private void registerHandlers() {

        buttonConfirm.setOnAction(ev -> {
            context.editarProposta(ID, Long.parseLong(textNrAluno.getText()),
                    textTitulo.getText(), textTipoProposta.getText(), isAtribuida.isSelected());

        });

    }

    private void createViews() {
        
        System.out.println("Estou aqui a editar");
        CSSManager.applyCSS(this, "mystyles.css");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        labelTipoProposta = new Label("");
        labelTipoProposta.setText("Insira o tipo de proposta da nova Proposta");
        grid.add(labelTipoProposta, 0, 3);
        labelTipoProposta.getStyleClass().add("labelInsereAluno");

        labelNrAluno = new Label("");
        labelNrAluno.setText("Insira o nr de aluno associado a esta proposta");
        grid.add(labelNrAluno, 0, 6);
        labelNrAluno.getStyleClass().add("labelInsereAluno");

        labelTitulo = new Label("");
        labelTitulo.setText("Insira o titulo desta proposta");
        grid.add(labelTitulo, 0, 9);
        labelTitulo.getStyleClass().add("labelInsereAluno");

        labelAtribuida = new Label("");
        labelAtribuida.setText("A proposta esta atribuida= ");
        grid.add(labelAtribuida, 0, 12);
        labelAtribuida.getStyleClass().add("labelInsereAluno");




        textNrAluno = new TextField("");
        grid.add(textNrAluno, 0, 7);

        textTitulo = new TextField("");
        grid.add(textTitulo, 0, 10);

        textTipoProposta = new TextField("");
        grid.add(textTipoProposta, 0, 4);

        isAtribuida = new CheckBox("");
        grid.add(isAtribuida, 0, 13);

        buttonConfirm = new Button("Confirmar edicao de proposta");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}