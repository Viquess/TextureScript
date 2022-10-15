import java.io.*;
import java.util.Scanner;

public class Main {

    public static final String modelsPath = "C:\\Users\\Vincenzo\\Desktop\\tecnoroleplay\\assets\\minecraft\\models";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire nome cartella: ");
        String folder = "\\" + scanner.next();

        File modelsDirectory = new File(modelsPath + folder);

        for (File model : modelsDirectory.listFiles()) {
            replaceText(model);
        }
    }

    public static void replaceText(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = "", oldtext = "";
        while ((line = reader.readLine()) != null) {
            oldtext += line + "\r\n";
        }
        reader.close();

        if (oldtext.contains(".png")) {
            String replacedtext = oldtext.replaceAll(".png", "");

            FileWriter writer = new FileWriter(file);
            writer.write(replacedtext);

            writer.close();

            System.out.println(file.getName() + " modificato con successo!");
        }
    }
}