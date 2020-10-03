# CreditCard

## Problem
Credit card numbers follow certain patterns. A credit card number must have 16 digits. It must start with:
4 for Visa cards
5 for Master cards
6 for Discover cards

In 1954, Hans Luhn of IBM proposed an algorithm for validating credit card numbers. The algorithm is useful to determine if a card number is entered correctly or if a credit card is scanned correctly by a scanner. Almost all credit card numbers are generated following this validity check, commonly known as the Luhn check or the Mod 10 check, which can be described as follows (for illustration, consider the card number 4388576018402626):

1. Double every second digit from right to left. If doubling of a digit results in a two-digit number, add up the two digits to get a single-digit number.
2 * 2 = 4
2 * 2 = 4
4 * 2 = 8
1 * 2 = 2
6 * 2 = 12 (1 + 2 = 3)
5 * 2 = 10 (1 + 0 = 1)
8 * 2 = 16 (1 + 6 = 7)
4 * 2 = 8

2. Now add all single-digit numbers from Step 1. 
4 + 4 + 8 + 2 + 3 + 1 + 7 + 8 = 37

3. Add all digits in the odd places from right to left in the card number.
   6 + 6 + 0 + 8 + 0 + 7 + 8 + 3 = 38

4. Sum the results from Step 2 and Step 3.
37 + 38 = 75

5. If the result from Step 4 is divisible by 10, the card number is valid; otherwise, it is invalid. For example, the number 4388576018402626 is invalid, but the number 4388576018410707 is valid.


## Analysis

The input is a 16-digit long literal, and the output is a boolean value of true or false depending on the validity of the credit card number. It takes several intermediate steps to reach the final output. 
Step 1, read user input of a 16-digit long literal as long type cardNumber. 
Step 2, convert the long variable to a String reference variable cardNumberS for further processing. 
Step 3, create 2 char arrays with a length of 8 each. 
Step 4, from right to left, the odd digit values of cardNumberS get assigned to char array oddDigitsC, and the even digit values of cardNumberS get assigned to char array evenDigitsC. Method cardType was written to display credit card type, although it is not needed for the assignment.
Step 5, each char array is further converted to an integer array for arithmetic operations.
Step 6, sum all digits in the oddDigits array.
Step 7, double all values in the evenDigits array.
Step 8, find every two-digit number as a result of doubling, and add up the two digits to get a single-digit number.
Step 9, sum the newly doubled evenDigits array.
Step10, sum oddDigits and evenDigits.
Step11, test if the final sum is divisible by 10 (%10). If true, then the card is valid, otherwise invalid. 
Step 12, output results to user.
