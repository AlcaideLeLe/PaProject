package pt.isec.pa.apoio_poe.model.data;

import java.io. * ;
import java.util.ArrayList;
import java.util.Scanner;
public class CsvReader {
    public static void main(String[] args) throws Exception {
        ArrayList<String> array = new ArrayList<>();
        Scanner sc = new Scanner(new File("pt/isec/pa/apoio_poe/model/data/Livro1.csv"));
        //parsing a CSV file into the constructor of Scanner class
        sc.useDelimiter(";");
        //setting comma as delimiter pattern
        while (sc.hasNext()) {
            array.add(sc.next());
        }
        System.out.println(array);
        Aluno aluno = new Aluno(Long.parseLong(array.get(0)), array.get(1), array.get(2), array.get(3), array.get(4), Double.parseDouble(array.get(5)), Boolean.parseBoolean(array.get(6)));

        sc.close();
        //closes the scanner
    }
}