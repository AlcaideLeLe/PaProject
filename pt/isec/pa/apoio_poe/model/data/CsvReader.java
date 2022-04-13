package pt.isec.pa.apoio_poe.model.data;

import java.io. * ;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class CsvReader {
    public static void main(String[] args) throws Exception {
        long linhasAlunos = 0;
        Path caminho = Paths.get("pt/isec/pa/apoio_poe/model/data/Aluno.csv");
        linhasAlunos = Files.lines(caminho).count();
        ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
        ArrayList<String> arrayAluno = new ArrayList<>();
        ArrayList<String> arrayDocente = new ArrayList<>();
        Scanner scAluno = new Scanner(new File("pt/isec/pa/apoio_poe/model/data/Aluno.csv"));
        Scanner scDocente = new Scanner(new File("pt/isec/pa/apoio_poe/model/data/Docentes.csv"));
        //parsing a CSV file into the constructor of Scanner class
        scAluno.useDelimiter(";");
        scDocente.useDelimiter(";");
        //setting comma as delimiter pattern
        while (scAluno.hasNext()) {
            arrayAluno.add(scAluno.nextLine());
        }
        while (scDocente.hasNext()) {
            arrayDocente.add(scDocente.nextLine());
        }
        System.out.println(arrayAluno);
        System.out.println(arrayDocente);

        Aluno aluno = null;
        String[] dadosAluno;
        for(int i=0; i < arrayAluno.size() ; i++){
            dadosAluno = arrayAluno.get(i).split(";");
            listaDeAlunos.add(new Aluno(Long.parseLong(dadosAluno[0]), dadosAluno[1], dadosAluno[2],
                    dadosAluno[3], dadosAluno[4], Double.parseDouble(dadosAluno[5]),
                    Boolean.parseBoolean(dadosAluno[6])));
        }

        scAluno.close();
        //closes the scanner
    }
}