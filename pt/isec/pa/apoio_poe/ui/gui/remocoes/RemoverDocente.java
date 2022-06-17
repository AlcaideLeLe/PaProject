package pt.isec.pa.apoio_poe.ui.gui.remocoes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class RemoverDocente extends BorderPane {
    apoio_poeContext context;

    TextField textMail;

    Label labelMail;

    Button buttonConfirm;

    GridPane grid;

    public RemoverDocente(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev->{
            context.removerDocente(textMail.getText());
            System.out.println("O docente foi removido");

            Stage stage = (Stage) this.getScene().getWindow();
            stage.close();
        });
    }

    private void createViews() {
        CSSManager.applyCSS(this, "mystyles.css");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        labelMail = new Label("");
        labelMail.setText("Insira o email do docente que pretende retirar");
        grid.add(labelMail, 0, 0);

        textMail = new TextField("");
        grid.add(textMail, 0, 1);

        buttonConfirm = new Button("Remover docente");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}

