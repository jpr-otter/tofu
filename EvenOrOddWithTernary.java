import java.util.Scanner;

public class OddOrEven {

    public static void main(String[] args) {
      
        Scanner scan = new Scanner(System.in);

        System.out.println("Give a number:");
      
        int evenOdd = Integer.valueOf(scan.nextLine());
        String odd = ("Number " + evenOdd + " is odd.");
        String even = ("Number " + evenOdd + " is even.");
        String result;

        result = (evenOdd % 2 > 0 || evenOdd % 2 < 0) ? odd : even;
      
        System.out.println(result);
    }
}
