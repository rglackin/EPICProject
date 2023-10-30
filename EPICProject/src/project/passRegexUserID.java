package project;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class passRegexUserID {
	public static void main(String[] args) {
		
	}

	public static boolean validPassword(String password) {
		String string = password;
		
		final Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
		Matcher matcher = pattern.matcher(string);
		
		while (matcher.find()) {
			return true;
		} 
		return false;
	}
}