package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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

    }


    private void createViews() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        labelNome = new Label("");
        labelNome.setText("Insira o nome do novo docente");
        grid.add(labelNome, 0, 0);

        labelEmail = new Label("");
        labelEmail.setText("Insira o email do novo docente");
        grid.add(labelEmail, 0, 3);

        textNome = new TextField("");
        grid.add(textNome, 0, 1);

        textEmai = new TextField("");
        grid.add(textEmai, 0, 4);


        buttonClose = new Button("Fechar");
        grid.add(buttonClose, 2, 2);

        buttonConfirm = new Button("Confirmar novo docente");
        grid.add(buttonConfirm, 2, 3);

        this.setCenter(grid);

    }
}
