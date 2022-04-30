package pt.isec.pa.apoio_poe.model.data;


import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.text.UI;

import java.io. * ;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class CsvReader {
    public static void main(String[] args) throws Exception {
        
        apoio_poeContext fsm = new apoio_poeContext();
        UI ui = new UI(fsm);
        ui.start();


    }
}