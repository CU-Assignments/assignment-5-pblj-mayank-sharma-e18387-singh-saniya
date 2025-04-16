import java.util.ArrayList;
import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for input
        System.out.print("Enter numbers separated by spaces: ");
        String input = scanner.nextLine();
        
        // Split the input string into an array of strings
        String[] numbers = input.split(" ");
        
        // Create an ArrayList to store Integer objects
        ArrayList<Integer> integerList = new ArrayList<>();
        
        // Convert the strings to Integer objects using autoboxing
        for (String number : numbers) {
            integerList.add(Integer.parseInt(number));  // Autoboxing happens here
        }
        
        // Calculate the sum using unboxing
        int sum = 0;
        for (Integer num : integerList) {
            sum += num;  // Unboxing happens here
        }
        
        // Display the result
        System.out.println("Sum of numbers: " + sum);
        
        scanner.close();
    }
}
