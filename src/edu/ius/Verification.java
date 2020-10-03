/**
 *Verification.java
 *@author Yiliang Lu
 *@Program4, C201, @version 1.0 @build 11092015
 */
package edu.ius;

import java.util.*;//1 of 1
public class Verification {
    //attributes
    private long cardNumber;
    private String cardType;

    public Verification(){
        System.out.println("Please enter a credit card number: " );
        Scanner input = new Scanner(System.in);//2 of 3
        cardNumber = input.nextLong();//3 of 3
        //System.out.println("You entered "+ cardNumber);//echo
    }//constructor w/o args, takes user input

    public Verification(long n){
        cardNumber = n;
    }//constructor w/ args

    public long getNumber() {
        return cardNumber;
    }//accssor

    public static int getSize(long n){
        int digits = 0;
        for(int i = 0; i < 16; i++){
            if(n % 10 >= 0){//test if the digit has value of not
                n = n / 10;
                digits++;
            }//if
        }//for
        //System.out.println("Card number has " +digits +" digits.");
        return digits;
    }//getSize

    public void setNumber(long n){
        cardNumber = n;
    }//mutator

    public static String cardType(long cardNumber){
        int fd = toInt(toCharEven(toString(cardNumber)))[0];//pick the 1st digit
        System.out.print("Card number with prefix " +fd +" is ");
        String cardType="";
        if(fd ==3){
            cardType = "American Express";
        }//AMEX
        else if(fd ==4){
            cardType = "Visa";
        }//visa
        else if(fd ==5){
            cardType = "Master card";
        }//master
        else if(fd ==6){
            cardType = "Discover";
        }//discovery
        System.out.println(cardType);
        return cardType;
    }//cardType, check credit card type

    public static String toString(long cardNumber){
        String cardNumberS = String.valueOf(cardNumber);
        return cardNumberS;
    }//toString

    public static char[] toCharOdd(String cardNumberS) {
        char[] oddDigitsC = new char[8];//char array, holds odd digits
        int j =1;        				//start with 2nd digit
        for(int i =0; i < oddDigitsC.length; i++ ){
            oddDigitsC[i]= cardNumberS.charAt(j);
            j +=2;						//skip every other digit
        }//for
        return oddDigitsC;
    }//toCharOdd

    public static char[] toCharEven(String cardNumberS) {
        char[] evenDigitsC = new char[8];//char array, hold even digits
        int j =0;        				 //start with 1st digit
        for(int i =0; i < evenDigitsC.length; i++ ){
            evenDigitsC[i]= cardNumberS.charAt(j);
            j +=2;						//skip every other digit
        }//for
        return evenDigitsC;
    }//toCharEven

    public static int[] toInt(char[] eightDigitsC){
        int[] eightDigitsI = new int [8];//array to hold eight digits
        for(int i =0; i < eightDigitsC.length; i++ ){
            eightDigitsI[i]= Integer.parseInt(String.valueOf(eightDigitsC[i]));
        }//char array to int array
        return eightDigitsI;
    }//toInt

    public static int sumOfOddPlace(long number){
        int sum =0;
        int temp;
        for(int i =0; i < toInt(toCharOdd(toString(number))).length; i=i+2){
            temp = toInt(toCharOdd(toString(number)))[i] + toInt(toCharOdd(toString(number)))[i+1];
            sum += temp;
        }//for, step 3
        System.out.println("The sum of odd places is " +sum);
        return sum;
    }//sumOfOddPlace step3 complete

    public static int sumOfdoubleEvenPlace(long number){
        int sum =0;
        int temp;
        int num1;//single digit
        int num2;//10th digit
        int [] doubleEvenPlace = new int[8];//instance array doubleEvenPlace[]
        for (int i=0; i < toInt(toCharEven(toString(number))).length; i++){
            doubleEvenPlace[i] = toInt(toCharEven(toString(number)))[i];
        }//load array doubleEvenPlace[]
        for (int i =0; i < doubleEvenPlace.length; i++){
            doubleEvenPlace[i] = doubleEvenPlace[i] *2;
        }//forarray doubleEvenPlace *2
        for (int i =0; i < doubleEvenPlace.length; i++){
            if (doubleEvenPlace[i] > 9){
                num1 = doubleEvenPlace[i]%10;//pick first digit
                num2 = doubleEvenPlace[i]/10%10;//pick 10th digit
                doubleEvenPlace[i]= num1 + num2;//add together and store back to array[i]
            }//if
        }//for, double digits to single digit, step1 complete,
        for (int i =0; i < doubleEvenPlace.length; i=i+2){
            temp = doubleEvenPlace[i] + doubleEvenPlace[i+1];
            sum += temp;
        }//add all single-digit numbers from Step 1, step2 complete
        System.out.println("The sum of double even places is: " +sum);
        return sum;
    }//sumOfdoubleEvenPlace, step1&2 complete

    public static boolean isValid(long number){
        boolean isValid = false;
        if ((sumOfOddPlace(number)+sumOfdoubleEvenPlace(number))%10 == 0){
            isValid = true;
        }//if
        return isValid;
    }//isValid, step 5 compete
}//class Verification

