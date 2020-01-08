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
                String mail = "";
                    
                for(String element : splitted) {
                    if (element.contains("@")) {
                        mail = element;
                        break;
                    }
                }
                emailMap.put(name, mail);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        Scanner scanner2 = new Scanner(System.in);

        while(true) {
            System.out.print("Enter Name: ");
            
            String givenName = scanner2.nextLine();
            givenName = givenName.replace("\n", "");
            
            String userMail = emailMap.get(givenName);
            if (!emailMap.containsKey(givenName)) {
                System.out.println(givenName + "'s mail couldn't find.");
                continue;
            }
            System.out.println("User's Email: " + emailMap.get(givenName));
        }
    }
}