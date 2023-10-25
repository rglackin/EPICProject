package project;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class User {
	private String username,password;
	
	
	public String getUsername(){
		return username;
	}
	private void setUsername(String value){
		this.username = value;
	}
	public String getPassword(){
		return password;
	}
	private void setPassword(String value){
		this.password= value;
	}
	
    /*public static String[] getUserInfo() {
    	String[] userInfo = new String[2];

    	//Scanner userInput = new Scanner(System.in);
    	//System.out.println("Enter username: ");
		//LoginScreen login = new LoginScreen();
		
    	//userInfo[0] = login.getUsernameInput();//userInput.nextLine();
    	//System.out.println("Enter password: ");
    	//userInfo[1] = login.getPassInput();//userInput.nextLine();
    	//userInput.close();
        return userInfo;
    }*/
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
			setUsername(userInfo[0]);
			setPassword(userInfo[1]);
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
					setUsername(userInfo[0]);
					setPassword(userInfo[1]);
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