package pt.isec.pa.apoio_poe.ui.gui.insercoes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;

public class InserirDocente extends BorderPane {
    apoio_poeContext context;


    TextField textNome;
    TextField textEmai;

    Button buttonConfirm;
    Button buttonClose;

    Label labelNome;
    Label labelEmail;

    Font FontLabel = Font.font("Garamond", 14);



    public InserirDocente(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev->{
            context.addDocenteSingular(new Docente(textNome.getText(), textEmai.getText()));
        });
        Stage stage = (Stage) this.getScene().getWindow();
        stage.close();

    }


    private void createViews() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        labelNome = new Label("");
        labelNome.setText("Insira o nome do novo docente");
        grid.add(labelNome, 0, 0);
        labelNome.setFont(FontLabel);

        labelEmail = new Label("");
        labelEmail.setText("Insira o email do novo docente");
        grid.add(labelEmail, 0, 3);
        labelEmail.setFont(FontLabel);

        textNome = new TextField("");
        grid.add(textNome, 0, 1);
        textNome.setStyle("-fx-control-inner-background: #edfaf8");

        textEmai = new TextField("");
        grid.add(textEmai, 0, 4);
        textEmai.setStyle("-fx-control-inner-background: #edfaf8");



        buttonConfirm = new Button("Confirmar novo docente");
        grid.add(buttonConfirm, 5, 4);
        Font font = Font.font("Times New Roman", FontWeight.BOLD, 14);
        buttonConfirm.setFont(font);
        buttonConfirm.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-border-width: 5px;");

        this.setCenter(grid);

    }
}
