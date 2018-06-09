/**
 * This class will iterate over the data in a file and extract the least
 * significant bit from each byte
 * It will then string those bits together and examine them.
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Extractor {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String filename;

        System.out.println("Enter name of image file to examine:");
        filename = keyboard.nextLine();

        File imageFile = new File(filename);

        if (!imageFile.exists()) {
            System.err.println("Specified file does not exist. Exiting..");
            System.exit(-1);
        }

        FileInputStream byteReader = null;
        ArrayList<String> listOfBytes = null;
        try {
            byteReader = new FileInputStream(filename);
            listOfBytes = new ArrayList<String>();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int bits;

        
        try {

            byteReader.skip(54);
            while ((bits = byteReader.read()) != -1) {
                listOfBytes.add(Integer.toBinaryString(bits));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder messageBinary = new StringBuilder();

        for (String s: listOfBytes) {
            messageBinary.append(s.charAt(s.length() - 1));
        }

//        System.out.println(messageBinary.toString);

        String[] split = messageBinary.toString().split("(?<=\\G.{8})");

        StringBuilder sb = new StringBuilder();



        for (String s: split) {
            sb.append((char)Integer.parseInt(s, 2));
        }

        String message = sb.toString();

        System.out.println(message);
    }
}
