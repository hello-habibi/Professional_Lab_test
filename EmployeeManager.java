//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static String readFile(String fileName){
        String readedString ="";
        try {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
           readedString = bufferedReader.readLine();
           bufferedReader.close();
            
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
        Constants constants = new Constants();
        // Check arguments
        while(isNotValidArg)
        {
            isNotValidArg = false;

        
            if (args[0].equals("l")) 
            {
                System.out.println(constants.LOADING_MESSAGE);  
                    String employeeList[] = readFile(constants.EMPLOYEE_FILE_LOCATION).split(",");
                    for (String emp : employeeList) 
                    {
                        System.out.println(emp);
                    }
                System.out.println(constants.LOADED_MESSAGE);
            } 
            else if (args[0].equals("s")) 
            {
                    System.out.println(constants.LOADING_MESSAGE);
                    String inputString = readFile(constants.EMPLOYEE_FILE_LOCATION);
                    System.out.println(inputString);
                    String wordList[] = inputString.split(",");
                    Random random = new Random();
                    int idx = random.nextInt(wordList.length);
                    System.out.println(wordList[idx]);

                System.out.println(constants.LOADED_MESSAGE);
            } 
            else if (args[0].contains("+")) 
            {
                String nameString = args[0].substring(1);
                System.out.println(constants.LOADING_MESSAGE);
                writeInFile(constants.EMPLOYEE_FILE_LOCATION, nameString);

                System.out.println(constants.LOADED_MESSAGE);
            } 
            else if (args[0].contains("?")) 
            {
                System.out.println(constants.LOADING_MESSAGE);

                    String inputString = readFile(constants.EMPLOYEE_FILE_LOCATION);
                    String wordList[] = inputString.split(",");
                    String nameString = args[0].substring(1);
                    for(String name:wordList){
                        if(name.equals(nameString));
                        System.out.println("Employee found! := " + nameString);
                        break;
                    }
                System.out.println(constants.LOADED_MESSAGE);
            } 
            else if (args[0].contains("c")) 
            {
                System.out.println(constants.LOADING_MESSAGE);
                try 
                {
                    String inputString = readFile(constants.EMPLOYEE_FILE_LOCATION);
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
                System.out.println(constants.LOADED_MESSAGE);
            } 
            else if (args[0].contains("u")) 
            {
                System.out.println(constants.LOADING_MESSAGE);
                try 
                {
                    String inpuString = readFile(constants.EMPLOYEE_FILE_LOCATION);
                    String wordList[] = inpuString.split(",");
                    String nameString = args[0].substring(1);
                    for (int i = 0; i < wordList.length; i++) 
                    {
                        if (wordList[i].equals(nameString)) 
                        {
                            wordList[i] = "Updated";
                        }
                    }
                    BufferedWriter w = new BufferedWriter(new FileWriter(constants.EMPLOYEE_FILE_LOCATION));
                    w.write(String.join(",", wordList));
                    w.close();
                } 
                catch (Exception e) 
                {}
                System.out.println(constants.LOADED_MESSAGE);
            } 
            else if (args[0].contains("d")) 
            {
            System.out.println(constants.LOADING_MESSAGE);
            try 
            
            {
                String inputString = readFile(constants.EMPLOYEE_FILE_LOCATION);
                String wordList[] = inputString.split(",");
                String nameString = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(wordList));
                list.remove(nameString);
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter(constants.EMPLOYEE_FILE_LOCATION));
                bufferedWriter.write(String.join(",", list));
                bufferedWriter.close();
            } 
            catch (Exception e) 
            {}
            System.out.println(constants.DELETED_MESSAGE);
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
