package pt.isec.pa.apoio_poe.ui.gui.questiona;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class QuestionaOrientadorARemoverDaProposta extends BorderPane {
    apoio_poeContext context;

    TextField textID;
    TextField textEmail;

    Label labelID;
    Label labelEmail;

    Button buttonConfirm;

    GridPane grid;

    public QuestionaOrientadorARemoverDaProposta(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev->{
            context.removerOrientadorDeProposta(textID.getText());
        });
    }

    private void createViews() {
        CSSManager.applyCSS(this, "mystyles.css");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        labelID = new Label("");
        labelID.setText("Insira ID da proposta a qual vai retirar o orientador");
        grid.add(labelID, 0, 0);

        textID = new TextField("");
        grid.add(textID, 0, 1);


        buttonConfirm = new Button("Editar candidatura");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}
