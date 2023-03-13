
import java.util.Scanner;

public class AverageOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number: ");
        double eins = Integer.valueOf(scanner.nextLine());
        System.out.println("Give the second number: ");
        double zwei = Integer.valueOf(scanner.nextLine());
        System.out.println("Give the third number: ");
        double drei = Integer.valueOf(scanner.nextLine());

      
      //put all the stuff into an array and then see the length of the array and build the sum of all values of the array
      // so i can calc the average from lots of numbers more comfortably.
      // was part of my mooc.fi java 1 course (well not this part. but it compiled sucessfully
        double [] inputz = {eins, zwei, drei};
        int divisor = inputz.length;
        int inputzSum = 0;
        int i;
        for (i = 0; i < inputz.length; i++)
            inputzSum += inputz[i];

        //System.out.println(inputz.length);
      //did this just to check if it s correct.
        double average = inputzSum / divisor;
      
        System.out.println("The average is " + average);    

    }
}
