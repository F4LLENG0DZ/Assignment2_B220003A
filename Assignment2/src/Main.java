import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File diploma = new File("diploma.csv");

        int index = 0;

        ArrayList<DiplomaData> diplomaData = new ArrayList<>();
        ArrayList<DiplomaData> diplomaLanjutan = new ArrayList<>();
        ArrayList<DiplomaData> khususPengkhususan = new ArrayList<>();

        if(diploma.exists()) {
            System.out.println("File exists");

            if(diploma.canRead()) {
                System.out.println("File is readable");
            }
            else {
                System.out.println("File is unreadable");
            }

            try(Scanner reader = new Scanner(diploma)) {
                while (reader.hasNext()) {
                    String line = reader.nextLine();
                    if(index > 0) {
                        String[] items = line.split(",");

                        DiplomaData data = new DiplomaData(items[0], items[1], items[2], items[3], items[4], items[5], items[6], items[7], items[8]);

                        if (" Diploma Lanjutan".equals(items[1]))
                        {
                            diplomaLanjutan.add(data);
                        }
                        if ("Kursus Pengkhususan".equals(items[1]))
                        {
                            khususPengkhususan.add(data);
                        }

                        try(PrintWriter writer = new PrintWriter(new File("diplomaLanjutan.txt"))){
                            for(DiplomaData row: diplomaLanjutan) {
                                writer.println(row);
                            }
                        } catch (FileNotFoundException exception) {
                            System.out.println(exception.getMessage());
                        }
                        try(PrintWriter writer = new PrintWriter(new File("khususPengkhususan.txt"))){
                            for(DiplomaData row: khususPengkhususan) {
                                writer.println(row);
                            }
                        } catch (FileNotFoundException exception) {
                            System.out.println(exception.getMessage());
                        }

                    }
                    index++;
                }
            }
            catch (FileNotFoundException exception) {
                System.out.println(exception.getMessage());
            }


        }
        else {
            System.out.println("File does not exists");
        }
    }
}