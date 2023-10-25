package project;

public class Main {
    public static void main(String[] args) {
        User u = new User();
        String[] info = {"ruairi","pass"};
        u.setUserInfo(info);
        //new LoginScreen();
        new QuizScreen(u);
    }
}
