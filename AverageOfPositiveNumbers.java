import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = 0;
        int divisor = 0;
        double average = 0;
        double sum = 0;

        while (true){

            input = Integer.valueOf(scanner.nextLine());

            if (input > 0){
                sum += input;
                divisor++;
                average = sum / (divisor);

            } else if (sum == 0 && input ==0 ){
                System.out.println("Cannot calculate the average");
                break;
            } else if (input ==0){
                System.out.println(average);
                break;
            }




        }


    }
}
