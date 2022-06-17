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

public class EditarAluno extends BorderPane {
    apoio_poeContext context;

    TextField textNome;
    TextField textEmail;
    TextField textSiglaCurso;
    TextField textSiglaRamo;
    TextField textPontuacao;
    TextField textPropostaAssociada;

    CheckBox isAcesso;
    Button buttonConfirm;
    Button buttonClose;


    Label labelNr;
    Label labelNome;
    Label labelEmail;
    Label labelSiglaCurso;
    Label labelSiglaRamo;
    Label labelPontuacao;
    Label labelIDProposta;
    Label labelAcessoEstagio;
    GridPane grid;

    long nr;


    public EditarAluno(apoio_poeContext context, long nr) {
        super();
        this.context = context;
        this.nr = nr;
        createViews();
        registerHandlers();


    }

    private void registerHandlers() {

        buttonConfirm.setOnAction(ev -> {
            context.editarAluno(nr, textNome.getText(), textEmail.getText(),
                    textSiglaCurso.getText(), textSiglaRamo.getText(),
                    Double.parseDouble(textPontuacao.getText()), isAcesso.isSelected(), textPropostaAssociada.getText());
            Stage stage1 = (Stage) this.getScene().getWindow();
            stage1.close();

        });

    }

    private void createViews() {
        System.out.println("Estou aqui a editar");
        CSSManager.applyCSS(this, "mystyles.css");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        labelNome = new Label("");
        labelNome.setText("Insira o nome do novo aluno");
        grid.add(labelNome, 0, 3);
        labelNome.getStyleClass().add("labelInsereAluno");

        labelEmail = new Label("");
        labelEmail.setText("Insira o e-mail do novo aluno");
        grid.add(labelEmail, 0, 6);
        labelEmail.getStyleClass().add("labelInsereAluno");

        labelSiglaCurso = new Label("");
        labelSiglaCurso.setText("Insira a sigla do curso do novo aluno");
        grid.add(labelSiglaCurso, 0, 9);
        labelSiglaCurso.getStyleClass().add("labelInsereAluno");

        labelSiglaRamo = new Label("");
        labelSiglaRamo.setText("Insira a sigla do ramo ");
        grid.add(labelSiglaRamo, 0, 12);
        labelSiglaRamo.getStyleClass().add("labelInsereAluno");

        labelPontuacao = new Label("");
        labelPontuacao.setText("Insira a pontuacao");
        grid.add(labelPontuacao, 0, 15);
        labelPontuacao.getStyleClass().add("labelInsereAluno");

        labelIDProposta = new Label("");
        labelIDProposta.setText("Insira o ID da proposta associado ao aluno");
        grid.add(labelIDProposta, 0, 18);
        labelIDProposta.getStyleClass().add("labelInsereAluno");

        labelAcessoEstagio = new Label("");
        labelAcessoEstagio.setText("Tem acesso a estagio");
        grid.add(labelAcessoEstagio, 0, 21);
        labelAcessoEstagio.getStyleClass().add("labelInsereAluno");


        textNome = new TextField("");
        grid.add(textNome, 0, 4);

        textEmail = new TextField("");
        grid.add(textEmail, 0, 7);

        textSiglaCurso = new TextField("");
        grid.add(textSiglaCurso, 0, 10);

        textSiglaRamo = new TextField("");
        grid.add(textSiglaRamo, 0, 13);

        textPontuacao = new TextField("");
        grid.add(textPontuacao, 0, 16);

        textPropostaAssociada = new TextField("");
        grid.add(textPropostaAssociada, 0, 19);

        isAcesso = new CheckBox("");
        grid.add(isAcesso, 0, 22);

        buttonConfirm = new Button("Confirmar novo aluno");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}