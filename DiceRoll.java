import java.util.Random;

public class DiceRoll {

    public static void main(String[] args) {
        
        Random rand = new Random();
        int dice = 0;
        System.out.println("________________");
        
        // Simulate rolling a dice 50 times
        for (int i = 0; i < 50; i++) {
            // Generate a random number between 1 and 6
            dice = rand.nextInt(6) + 1;
            // Return the cursor to the beginning of the line
            System.out.print("\r");
            // Print the dice number
            System.out.print(dice);
            // Wait for one/tenth of a second
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("\r");
        System.out.print ("You rolled a " + dice);
        System.out.println("\n________________");        
    }
}

/*
the try catch:
I implemented the try-catch block to handle the possible InterruptedException
that might be thrown by the Thread.sleep method. The Thread.sleep method causes
the current thread to pause for a specified amount of time in milliseconds.
However, this method might be interrupted by another thread before the time is up.
In that case, the method will throw an InterruptedException, which is a
checked exception that must be either caught or declared to be thrown.
A try-catch block is a way to catch and handle the exception. In this case,
I just printed the stack trace of the exception, but you can also do something else with it.
 */
