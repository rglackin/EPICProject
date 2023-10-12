package project;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class User {
	public static void main(String[] args) {
		User instance = new User();
		instance.setUserInfo(getUserInfo());
		if (instance.validLogIn(getUserInfo())) {
			System.out.println("Login successful.");
		} else {System.out.println("Invalid login information.");}
		
	}
    public static String[] getUserInfo() {
    	String[] userInfo = new String[2];
    	Scanner userInput = new Scanner(System.in);
    	System.out.println("Enter username: ");
    	userInfo[0] = userInput.nextLine();
    	System.out.println("Enter password: ");
    	userInfo[1] = userInput.nextLine();
    	userInput.close();
        return userInfo;
    }
    public void setUserInfo(String[] userInfo) {
    	try {
    	      File myObj = new File("userProfiles.txt");
    	      myObj.createNewFile();
    	} catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	}
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("userProfiles.txt", true));
            try {
                Scanner reader = new Scanner("userProfiles.txt");
                while (reader.hasNextLine()) {
                	writer.write("\n");
                	reader.nextLine();
                	}
                reader.close();
              } catch (IOException e) {e.printStackTrace();}
            writer.write(userInfo[0] + " " + userInfo[1]);
            writer.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
    }
    //check details are same as in text file
    public boolean validLogIn(String[] userInfo) {
    	try {
	    	File file = new File("userProfiles.txt");
	    	Scanner reader = new Scanner(file);
	    	while (reader.hasNextLine()) {
				if (((userInfo[0] + " " + userInfo[1]).trim()).equals((reader.nextLine().trim()))) {
					reader.close();
					return true;
				}
			}
	    	reader.close();
    	} catch (FileNotFoundException e) {
    		System.out.println("An error occurred.");
    		e.printStackTrace();
    	}
    	return false;
    }
}