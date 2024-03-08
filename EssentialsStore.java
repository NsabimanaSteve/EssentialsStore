
/*
 * EssentialsStore.java
 * 
 * This program represents an Essentials Store that calculates the change breakdown 
 * for a customer's purchase, considering the available denominations of notes and coins
 * in Ghana Cedis.
 * 
 * Constants:
 * - DENOMINATIONS: Array storing available denominations of notes and coins.
 * - NAMES: Array storing names corresponding to the denominations.
 * - CEDI_SYMBOL: Constant Unicode value of the Ghana Cedi symbol.
 * 
 * Main Method:
 * - Asks the user to enter the cost of items purchased and the amount paid by the customer.
 * - Invokes the computeChangeBreakdown method and displays the total change with its breakdown.
 * 
 * computeChangeBreakdown Method:
 * - Calculates the change amount and prints it with the Cedi symbol.
 * - Prints the change breakdown using available denominations.
 * 
 * Author: Steve Nsabimana
 * Date: Feb,2, 2024
 */
import java.util.Scanner;

// A class to represent the Essentials Store
public class EssentialsStore 
{

  // A constant array to store the available denominations of notes and coins in Ghana Cedis
  public static final double[] DENOMINATIONS = {200,100,50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.01};

  // A constant array to store the names of the denominations
  public static final String[] NAMES = {"200 note","100 note","50 note", "20 note", "10 note", "5 note", "2 coin", "1 coin", "50p coin", "20p coin", "10p coin", "5p coin", "1p coin"}; //p stands PESEWA

  // A constant to store the Unicode value of the Ghana Cedi symbol
  public static final String CEDI_SYMBOL = "\u20B5";

  // The main method to test the program
  public static void main(String[] args) 
  {
    // Create a scanner object to read input from the user
    Scanner scanner = new Scanner(System.in);

    // Ask the user to enter the cost of items purchased
    System.out.print("Enter the cost of items purchased: ");
    double cost = scanner.nextDouble();

    // Ask the user to enter the amount paid by the customer
    System.out.print("Enter the amount paid by the customer: ");
    double paid = scanner.nextDouble();

    // Invoke the computeChangeBreakdown method and store the result
    double change = computeChangeBreakdown(cost, paid);

    // Close the scanner object
    scanner.close();
  }

  // A method to compute the change breakdown
  public static double computeChangeBreakdown(double cost, double paid) 
  {
    // Calculate the change amount
    double change = paid - cost;

    // Print the change amount with two decimal places and the cedi symbol
    System.out.printf("Total change : %s%.2f%n", CEDI_SYMBOL, change);

    // Print the change breakdown
    System.out.println("Total change  Breakdown:");

    // Loop through the denominations array
    for (int i = 0; i < DENOMINATIONS.length; i++)
    {
      // Find the number of notes or coins of the current denomination
      int count = (int) (change / DENOMINATIONS[i]);

      // If the count is more than zero, print it with the name of the denomination
      if (count > 0) 
      {
        System.out.println(count +" "+ CEDI_SYMBOL + NAMES[i]);
      }

      // Update the change amount by subtracting the value of the current denomination
      change = change - count * DENOMINATIONS[i];

      // Round the change amount to two decimal places to avoid floating-point errors
      change = Math.round(change * 100) / 100.0;
    }

    // Return the change amount
    return change;
  }
}
