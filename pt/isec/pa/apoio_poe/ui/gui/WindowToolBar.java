package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;

import java.util.Collection;

public class WindowToolBar extends ToolBar {
    apoio_poeContext context;
    private static final int TOGGLE_SIZE = 40;
    private static final int TOGGLE_IMG_SIZE = TOGGLE_SIZE - 10;
    Menu mnFile;
    MenuItem mnNew, mnOpen, mnSave, mnExit;
    Menu mnEdit;
    MenuItem mnUndo, mnRedo;

    public WindowToolBar(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void createViews(){

        //create menu
        mnFile= new Menu("File");
        //create menu items
        mnNew = new MenuItem("New");
        mnOpen = new MenuItem("Open");
        mnSave = new MenuItem("Save");
        mnExit = new MenuItem("Exit");
        //adding items to the menu
        mnFile.getItems().addAll(mnNew, mnOpen, mnSave, new SeparatorMenuItem());

        MenuBar menuBar = new MenuBar(mnFile);
        menuBar.setTranslateX(200);
        menuBar.setTranslateY(20);


        //create menu
        mnEdit = new Menu("Edit");
        //create menu items
        mnUndo = new MenuItem("Undo");
        mnRedo = new MenuItem("Redo");
        //adding items to the menu
        mnEdit.getItems().addAll(mnUndo, mnRedo, new SeparatorMenuItem());
        //mnEdit.getM */
        menuBar.getMenus().addAll(mnFile, mnEdit);

        menuBar.setUseSystemMenuBar(true);
    }

    private void registerHandlers() {


        context.addPropertyChangeListener(apoio_poeContext.PROP_FASE, evt -> update());

        mnFile.setOnAction(actionEvent -> {
            System.out.println("OLA registerHandler\n");
//            update();
        });

        mnFile.fire();
    }

    public void update(){
        if(context.getState() == apoio_poeState.InicioState){
            //System.out.println(context.getState());
            this.setVisible(true);
        }
        else{
            this.setVisible(false);
        }
    }




}
