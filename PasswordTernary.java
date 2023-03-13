import java.util.Scanner;

public class Password {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String answer;
        String enter = ("Welcome!");
        String password = ("Caput Draconis");
        String stayOutside = ("Off with you!");
        System.out.println("Password?");
        String firstStringInput = scan.nextLine();

        answer = (firstStringInput.equals(password)) ? enter : stayOutside;

        System.out.println(answer);


        
    }
}
