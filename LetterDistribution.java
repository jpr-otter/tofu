
String input = "Hello World"; // The input string
input = input.toLowerCase(); // Convert the input to lowercase
int[] letterCount = new int[26]; // An array to store the frequency of each letter
for (char ch : input.toCharArray()) { // A for each loop to iterate over each character in the input
  if (ch >= 'a' && ch <= 'z') { // Check if the character is a letter
    letterCount[ch - 'a']++; // Increment the frequency of the letter by 1
  }
}
// Print the result
for (int i = 0; i < 26; i++) {
  if (letterCount[i] > 0) {
    System.out.println((char) (i + 'a') + ": " + letterCount[i]);
  }
}
