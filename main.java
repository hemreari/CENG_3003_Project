import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class main {
        public static void main(String[] args){
            HashMap<String, String> emailMap = new HashMap<String, String>();

            try {
            Scanner scanner = new Scanner(new File("file.txt"));
            
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitted = line.split("\\s+");

                String name = splitted[0] + " " + splitted[1];
                String mail = splitted[splitted.length - 1];

                emailMap.put(name, mail);
            }
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner2 = new Scanner(System.in);
        while(true) {

        System.out.print("Enter name: ");
        String givenName = scanner2.nextLine();
        givenName = givenName.replace("\n", "");

        System.out.println("Your mail address is: " + emailMap.get(givenName));
    }
}
}