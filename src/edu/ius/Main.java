/**
 *Main.java
 *@author Yiliang Lu
 *@Program4, C201, @version 1.0 @build 11102015
 */
package edu.ius;

public class Main {
    public static void main(String[] args) {
        Verification card2 = new Verification();
        //Verification card1 = new Verification(4388576018402626L);//test data
        //Verification.cardType(card2.getNumber()); //test
        System.out.println("Card number is :" +Verification.toString(card2.getNumber()));

        if (Verification.isValid (card2.getNumber())){
            System.out.println(card2.getNumber()+ " is valid.");
        }
        else{
            System.out.println(card2.getNumber()+ " is invalid.");
        }
    }//main()
}//class{}
