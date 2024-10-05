//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static String readFile(String fileName){
        String readedString ="";
        try {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
           readedString = bufferedReader.readLine();
            
        } catch (Exception e) {

        }
        return readedString;
    }
    public static boolean writeInFile(String fileName , String nameString){
                try 
                {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("employees.txt", true));  
                    bufferedWriter.write(", " + nameString);
                    bufferedWriter.close();
                } 
                catch (Exception e) 
                {}
        return true;
    }
    public static void main(String[] args) {
        boolean isNotValidArg = true;
        // Check arguments
        while(isNotValidArg)
        {
            isNotValidArg = false;

        
            if (args[0].equals("l")) 
            {
                System.out.println("Loading data ...");  
                    String scannedString = readFile("employees.txt");
                    String employeeList[] = scannedString.split(",");
                    for (String emp : employeeList) 
                    {
                        System.out.println(emp);
                    }
                System.out.println("Data Loaded.");
            } 
            else if (args[0].equals("s")) 
            {
                    System.out.println("Loading data ...");
                    String inputString = readFile("employees.txt");
                    System.out.println(inputString);
                    String wordList[] = inputString.split(",");
                    Random random = new Random();
                    int idx = random.nextInt(wordList.length);
                    System.out.println(wordList[idx]);

                System.out.println("Data Loaded.");
            } 
            else if (args[0].contains("+")) 
            {
                String nameString = args[0].substring(1);
                System.out.println("Loading data ...");
                writeInFile("employees.txt", nameString);

                System.out.println("Data Loaded.");
            } 
            else if (args[0].contains("?")) 
            {
                System.out.println("Loading data ...");

                    String inputString = readFile("employees.txt");
                    String wordList[] = inputString.split(",");
                    boolean found = false;
                    String nameString = args[0].substring(1);
                    for (int i = 0; i < wordList.length && !found; i++) 
                    {
                        if (wordList[i].equals(nameString)) 
                        {
                            System.out.println("Employee found!");
                            found = true;
                        }
                    }
                System.out.println("Data Loaded.");
            } 
            else if (args[0].contains("c")) 
            {
                System.out.println("Loading data ...");
                try 
                {
                    String inputString = readFile("employees.txt");
                    char[] charsList = inputString.toCharArray();
                    boolean inWord = false;
                    int count = 0;
                    for (char c : charsList) 
                    {
                        if (c == ' ') 
                        {
                            if (!inWord) 
                            {
                                count++;
                                inWord = true;
                            } else 
                            {
                                inWord = false;
                            }
                        }
                    }
                    System.out.println(count + " word(s) found " + charsList.length);
                } 
                catch (Exception e) 
                {}
                System.out.println("Data Loaded.");
            } 
            else if (args[0].contains("u")) 
            {
                System.out.println("Loading data ...");
                try 
                {
                    String inpuString = readFile("employees.txt");
                    String wordList[] = inpuString.split(",");
                    String nameString = args[0].substring(1);
                    for (int i = 0; i < wordList.length; i++) 
                    {
                        if (wordList[i].equals(nameString)) 
                        {
                            wordList[i] = "Updated";
                        }
                    }
                    BufferedWriter w = new BufferedWriter(new FileWriter("employees.txt"));
                    w.write(String.join(",", wordList));
                    w.close();
                } 
                catch (Exception e) 
                {}
                System.out.println("Data Updated.");
            } 
            else if (args[0].contains("d")) 
            {
            System.out.println("Loading data ...");
            try 
            
            {
                String inputString = readFile("employees.txt");
                String wordList[] = inputString.split(",");
                String nameString = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(wordList));
                list.remove(nameString);
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter("employees.txt"));
                bufferedWriter.write(String.join(",", list));
                bufferedWriter.close();
            } 
            catch (Exception e) 
            {}
            System.out.println("Data Deleted.");
            }
            else{
                System.out.println("You Passed wrong Argumnt . Tray with (l , s ,+sonthing, u , c)");
                Scanner inputScanner = new Scanner(System.in);
            String inputString = inputScanner.nextLine();
            args = inputString.split("//s++");
            isNotValidArg = true;
            }
        }
    }
}
