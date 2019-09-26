package model;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

    BufferedWriter writer;
    private final String FILE_PATH = "registry.txt";


    public FileHandler (){

    }

    public void saveFile(String s) throws IOException {
        new FileWriter(FILE_PATH, false).close();
        writer = new BufferedWriter(new FileWriter(FILE_PATH));
        writer.write(s);
        writer.close();
    }

    public String loadFile() {
        File inFile = new File(FILE_PATH);
        StringBuilder sbText = new StringBuilder();
        String text;
        try (Scanner scan = new Scanner(inFile);) {
            while(scan.hasNext()) {
                text = scan.nextLine();
                sbText.append(text + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();

          }
        return sbText.toString();
    }

}

