package changeJar;

import java.io.*;
import java.util.Scanner;
/**********************************************************************
 * This project simulates a jar that you would keep change in.  
 * Specifically, this jar contains quarters, dimes, nickels and pennies.
 * User's can interact with this jar by putting change in and taking it 
 * out in a variety of different ways.
 * 
 * @author Robert Molenhouse
 * @version 1.0
 *
 **********************************************************************/

public class ChangeJar {
	/** the amount of quarters in my changeJar */
	private int quarters;
	
	/** the amount of dimes in the changeJar */
	private int dimes;
	
	/** the amount of nickels in the changeJar*/
	private int nickels;
	
	/** the amount of pennies in the changeJar*/
	private int pennies;
	
	/** tells whether or the not the jar can be mutated */
	private static boolean suspend = false;

	/*******************************************************************
	 * Default constructor for ChangeJar.  Sets jar to 0.
	 ******************************************************************/
	public ChangeJar() {
		quarters = 0;
		dimes = 0;
		nickels = 0;
		pennies = 0;
	}

	/*******************************************************************
	 * Constructor for ChangeJar that creates an exact copy of another
	 * ChangeJar object. 
	 * 
	 * @param other.  ChangeJar object to copy.
	 ******************************************************************/
	public ChangeJar(ChangeJar other) {
		quarters = other.quarters;
		dimes = other.dimes;
		nickels = other.nickels;
		pennies = other.pennies;
	}

	/*******************************************************************
	 * Constructor for ChangeJar that allows the user to specify the
	 * amount of change in the Jar, in terms of number of quarters, 
	 * dimes, nickels, and pennies. 
	 * 
	 * @param quarters. Number of quarters to put in.
	 * @param dimes. Number of dimes to put in.
	 * @param nickels. Number of nickels to put in.
	 * @param pennies. Number of pennies to put in.
	 ******************************************************************/
	public ChangeJar(int quarters, int dimes, int nickels, int pennies){
		if((quarters < 0) || (dimes < 0) || (nickels < 0) || 
			(pennies < 0)){
			throw new IllegalArgumentException();
		}
		else{		
		this.quarters = quarters;
		this.dimes = dimes;
		this.nickels = nickels;
		this.pennies = pennies;
		}
	}

	/*******************************************************************
	 * Main method for the ChangeJar. Used for testing.
	 * 
	 * @param args. Various commands to test the functionality
	 * of the ChangeJar.
	 ******************************************************************/
	public static void main(String[] args) {
		ChangeJar s = new ChangeJar(10,3,1,2);
		System.out.println("Created ChangeJar:$2.87, result: " +
							s.getAmount());

		ChangeJar s1 = new ChangeJar();
		System.out.println("\nCreatedChangeJar:$0, result: " +
							s1.getAmount());

		s1.putIn(10,2,3,2);
		System.out.println("\nAddedChangeJar:$2.87, result: " +
							s1.getAmount());

		ChangeJar s2 = new ChangeJar(10,2,3,2);
		s2.putIn(0,0,0,99);
		System.out.println("\nAddedChangeJar:$3.86, result: " +
							s2.getAmount());

		s2 = new ChangeJar(0,0,3,269);
		ChangeJar temp = s2.takeOut(2.83);
		System.out.println ("\nTake out the following:\n" + temp);
		System.out.println("Remaining ChangeJar:$.01, result: " +
							s2.getAmount());

		s2 = new ChangeJar (5, 4, 3, 1);
		s2.save("pizza");
		s2 = new ChangeJar();
		s2.load("pizza");

		if (s2.equals(new ChangeJar(5,4,3,1))) 
			System.out.println ("\nLoad and Save and Equals works!");

		System.out.println (s2);
		
		System.out.println("\nlist current change jars");
		System.out.println("\ns = " + s + " " + s.getAmount());
		System.out.println("s1 = " + s1 + " " + s1.getAmount());
		System.out.println("s2 = " + s2 + " " + s2.getAmount());
		
		s.putIn(s1);
		System.out.println("\nput s1 into s, $5.74, result: " + 
							s.getAmount());
		
		s.takeOut(s2);
		System.out.println("\ntake s2 out of s, $3.93, result: " +
							s.getAmount());
		
		
		if (s1.compareTo(s) == -1){
			System.out.println("\ns1 compare to s = -1");
		}
		if (s1.compareTo(s2) == 1){
			System.out.println("s1 compare to s2 = 1");
		}
		if (s1.compareTo(new ChangeJar(10,2,3,2)) == 0){
			System.out.println("s1 compare to identical jar = 0");
		}
		
		if (compareTo(s1,s) == -1){
			System.out.println("\ns1 compare to s = -1");
		}
		if (compareTo(s1, s2) == 1){
			System.out.println("s1 compare to s2 = 1");
		}
		if (compareTo(s1,new ChangeJar(10,2,3,2)) == 0){
			System.out.println("s1 compare to identical jar = 0");
		}
		
		ChangeJar s3 = new ChangeJar();
		s3.setQuarters(1);
		s3.setDimes(2);
		s3.setNickels(3);
		s3.setPennies(4);
		System.out.println("\ncreated new change jar: $0.64, result:" + 
							s3.getAmount());
		
		if (equals(s2, s3) == false){
			System.out.println("\nS2 and s3 are not equal.");
		}
		
		ChangeJar s4 = s3.takeOut(0.41);
		if (s4.equals(new ChangeJar(1,1,1,1))){
			System.out.println("\ns3 take out $0.41. return new jar of" 
								+ " $0.41 and s3 has $0.23, result" +
								s3.getAmount());
		}
		
		System.out.println("\ns4: " + s4 + " " + s4.getAmount());
		
		s4.save("beer");
		s3.load("beer");
		ChangeJar s5 = new ChangeJar();
		s5.load("beer");
		
		if(equals(s4, s3) && equals(s4,s5) && s3.equals(s5)){
			System.out.println("\nsave, load and equals works again!");
		}
		
		suspend(true);
		s4.takeOut(1,1,1,1);
		
		if (s4.equals(s5)){
			System.out.println("\nsuspend works on.");
		}
		
		suspend(false);
		s4.takeOut(1,1,1,1);
		
		if(s4.equals(new ChangeJar())){
			System.out.println("\nsuspend works off.");
		}

	}

	/*******************************************************************
	 * Checks to see if two ChangeJar objects have the same number of
	 * quarters, dimes, nickels and pennies.
	 * 
	 * @param other1.  Object, should be ChangeJar, to compare to this.
	 * @return true if equal number of coins.
	 * @throws RunTimeException if other is not a ChangeJar
	 ******************************************************************/
	public boolean equals(Object other1) {
		if (other1 instanceof ChangeJar) {
			ChangeJar other = (ChangeJar) other1;
			return (this.quarters == other.quarters && this.dimes == 
					other.dimes && this.nickels == other.nickels
					&& this.pennies == other.pennies);
		} else
			throw new RuntimeException();
	}

	/*******************************************************************
	 * checks to see if another ChangeJar is equal to the current one
	 * in terms of number of quarters, dimes, nickels, and pennies.
	 * 
	 * @param other.  ChangeJar to compare to current one.
	 * @return true if equal number of coins.
	 ******************************************************************/
	public boolean equals(ChangeJar other) {
		return (this.quarters == other.quarters && 
				this.dimes == other.dimes && 
				this.nickels == other.nickels && 
				this.pennies == other.pennies);
	}
	
	/*******************************************************************
	 * Checks to see if two ChangeJar objects contain the same number
	 * of each coin type.
	 * 
	 * @param jar1. First ChangeJar to compare.
	 * @param jar2. Second ChangeJar to compare.
	 * @return true if equal number of coins.
	 ******************************************************************/
	public static boolean equals(ChangeJar jar1, ChangeJar jar2){
		return (jar1.getQuarters() == jar2.getQuarters() &&
				jar1.getDimes() == jar2.getDimes() &&
				jar1.getNickels() == jar2.getNickels() &&
				jar1.getPennies() == jar2.getPennies());
	}
	
	/*******************************************************************
	 * Compares the total amount of a ChangeJar object relative to the 
	 * current Jar.
	 * 
	 * @param other. ChangeJar object to compare to current.
	 * @return compareTo() value.
	 ******************************************************************/
	public int compareTo(ChangeJar other){
		if(convertToAmount(this) > convertToAmount(other)){
			return 1;
		}
		if(convertToAmount(this) < convertToAmount(other)){
			return -1;
		}
		else{
			return 0;
		}
	}
	
	/*******************************************************************
	 * Compares the total amount of a ChangeJar object relative to 
	 * another jar.
	 * 
	 * @param jar1. ChangeJar to see comparison of with another Jar.
	 * @param jar2. ChangeJar to use for comparison.
	 * @return compareTo() value relevant to jar1.
	 ******************************************************************/
	public static int compareTo(ChangeJar jar1, ChangeJar jar2){
		if(convertToAmount(jar1) > convertToAmount(jar2)){
			return 1;
		}
		if(convertToAmount(jar1) < convertToAmount(jar2)){
			return -1;
		}
		else{
			return 0;
		}
	}
	
	 //Converts the quarters, dimes, nickels, and pennies into a total
	 //of their monetary value and adds them all together into an int
	 //amount.
	private static int convertToAmount(ChangeJar other){
		return ((other.quarters*25) + (other.dimes*10) + 
				(other.nickels*5) + (other.pennies));
	}
	
	 /*******************************************************************
     * Converts the total amount of money stored in the jar into
     * a typical monetary form, 0.00.
     * 
     * @return double of the total amount.
     ******************************************************************/
	public double getAmount () {
        return (((quarters * 25) + (dimes * 10) + 
        		(nickels * 5) + pennies) / 100.0);
    }
	
	/*******************************************************************
	 * Adds the inputed change into the jar.
	 * 
	 * @param quarters. Number of quarters to add.
	 * @param dimes. Number of dimes to add.
	 * @param nickels. Number of nickels to add.
	 * @param pennies. Number of pennies to add.
	 * @throws IllegalArgumentException if non valid parameter.
	 ******************************************************************/
	public void putIn(int quarters, int dimes, int nickels, int pennies)
	{
		if(quarters < 0 || dimes < 0 || nickels < 0 || pennies < 0){
			throw new IllegalArgumentException();
		}
		if(!suspend){
			this.quarters += quarters;
			this.dimes += dimes;
			this.nickels += nickels;
			this.pennies += pennies;
		}
	}
	
	/*******************************************************************
	 * Adds the change from the another jar to this one.
	 * 
	 * @param other. ChangeJar to get amount from.
	 ******************************************************************/
	public void putIn(ChangeJar other){
		if(!suspend){
			quarters += other.quarters;
			dimes += other.dimes;
			nickels += other.nickels;
			pennies += other.pennies;
		}
	}
	
	/*******************************************************************
	 * Removes the inputed change from the jar.
	 * 
	 * @param quarters. Number of quarters to remove.
	 * @param dimes. Number of dimes to remove.
	 * @param nickels. Number of nickels to remove.
	 * @param pennies. Number of pennies to remove.
	 * @throws IllegalArgumentException if invalid input parameter.
	 ******************************************************************/
	public void takeOut(int quarters, int dimes, int nickels, 
						int pennies){
			if(quarters < 0 || dimes < 0 || nickels < 0 || pennies < 0){
				throw new IllegalArgumentException();
			}
			else if(this.quarters < quarters || this.dimes < dimes ||
					this.nickels < nickels || this.pennies < pennies){
				throw new IllegalArgumentException();
			}
			else{
			
			if(!suspend){
				this.quarters -= quarters;
				this.dimes -= dimes;
				this.nickels -= nickels;
				this.pennies -= pennies;
			}
		}
	}
	/*******************************************************************
	 * Getter for suspend.
	 * 
	 * @return if suspend is true or false.
	 ******************************************************************/
	public static boolean isSuspend() {
		return suspend;
	}

	/*******************************************************************
	 * Takes the amount of change in another jar and removes it from 
	 * this one.
	 * 
	 * @param other.  ChangeJar to get amount from.
	 * @throws IllegalArgumentException if other jar is too big.
	 ******************************************************************/
	public void takeOut(ChangeJar other) {
		if (other.quarters <= quarters && other.dimes <= dimes && 
				other.nickels <= nickels && other.pennies <= pennies) {
			
			if (!suspend) {
				quarters -= other.quarters;
				dimes -= other.dimes;
				nickels -= other.nickels;
				pennies -= other.pennies;
			}
		}

		else {
			throw new IllegalArgumentException();
		}
	}

	/*******************************************************************
	 * Takes the inputed amount out of the ChangeJar.  Converts a 
	 * double to an int representation of the amount and retrieves the
	 * Appropriate change in the form of a new ChangeJar object.
	 * 
	 * @param amount. double amount of how much change to take out. 
	 * @return ChangeJar of the given amount.
	 * @throws IllegalArgumentException if input parameter is not valid.
	 ******************************************************************/
	public ChangeJar takeOut(double amount) {
		if (!suspend) {
			// Check to see if the amount requested is positive.
			if (amount < 0) {
				throw new IllegalArgumentException();
			}
			// convert amount to int, instead of double
			int intAmount = (int) (amount * 100);

			if (convertToAmount(this) >= intAmount) {
				int[] change = calculateChange(intAmount);
				ChangeJar returnJar = new ChangeJar(change[0], 
							change[1], change[2], change[3]);
				if (convertToAmount(returnJar) == intAmount) {
					takeOut(returnJar);
					return returnJar;
				} else {
					return null;
				}
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	// Calculates the amount of quarters, dimes, nickels, and pennies
	// needed to make up the given amount. This method maximizes the
	// largest coins.
	private int[] calculateChange(int amount){
		int[] change = new int[4];
		if(amount >= 25){
			int lastDigit = (amount % 10);
			int quarters = calculateQuarters(amount);	
			
			//if the jar has no nickels, number of quarters should be
			//equal to insure all possible withdraws from the jar are
			//possible.
			if((this.nickels == 0) && (lastDigit <= 5)){
				quarters -= 1;
			}
			amount -= (quarters * 25);
			change[0] = quarters;
		}
		if(amount >= 10){
			int dimes = calculateDimes(amount);
			amount -= (dimes * 10);
			change[1] = dimes;
		}
		if(amount >= 5){
			int nickels = calculateNickels(amount);
			amount -= (nickels * 5);
			change[2] = nickels;
		}
		if(amount >= 1){
			int pennies = calculatePennies(amount);
			amount-= pennies;
			change[3] = pennies;
		}
		return change;
		
	}

	
	// Calculates the maximum amount of quarters you can use to reach
	// the given amount. If there are not enough quarters in the jar,
	// then return whatever there is.
	private int calculateQuarters(int amount) {
		if (amount >= 25) {
			double quarters = Math.floor(amount / 25);
			if (quarters <= this.quarters) {
					return (int) quarters;
			} 
			else {
					return this.quarters;
			}
		} 
		else {
			return 0;
		}
	}
	
	
	// Calculates the maximum amount of dimes you can use to reach
	// the given amount. If there are not enough dimes in the jar,
	// then return whatever there is.
	private int calculateDimes(int amount) {
		if (amount >= 10) {
			double dimes = Math.floor(amount / 10);
			if (dimes <= this.dimes) {
					return (int) dimes;
			} 
			else {
					return this.dimes;
			}
		} 
		else {
			return 0;
		}
	}
	

	// Calculates the maximum amount of nickels you can use to reach
	// the given amount. If there are not enough nickels in the jar,
	// then return whatever there is.
	private int calculateNickels(int amount) {
		if (amount >= 5) {
			double nickels = Math.floor(amount / 5);
			if (nickels <= this.nickels) {
					return (int) nickels;
			} 
			else {
					return this.nickels;
			}
		} 
		else {
			return 0;
		}
	}
	
	
	 // Calculates the maximum amount of pennies you can use to reach 
	 // the given amount.  If there are not enough pennies in the jar, 
	 // then return whatever there is.
	private int calculatePennies(int amount) {
		if (amount >= 1) {
			int pennies = amount;
			if (pennies <= this.pennies) {
					return pennies;
			} 
			else {
					return this.pennies;
			}
		} 
		else {
			return 0;
		}
	}
	
	/*******************************************************************
	 * Creates a String representation of the amount of coins in the 
	 * jar.  
	 * 
	 * @return String representation of the contents of the jar.
	 ******************************************************************/
	public String toString(){
		String returnString = "";
		if(quarters == 1){
			returnString += (quarters + " quarter, ");
		}
		else{
			returnString += (quarters + " quarters, ");
		}
		if (dimes == 1){
			returnString += (dimes + " dime, ");
		}
		else{
			returnString += (dimes + " dimes, ");
		}
		if(nickels == 1){
			returnString += (nickels + " nickel, ");
		}
		else{
			returnString += (nickels + " nickels, ");
		}
		if(pennies == 1){
			returnString += (pennies + " penny.");
		}
		else{
			returnString += (pennies + " pennies.");
		}
		return returnString;
	}
	
	/*******************************************************************
	 * Saves the current ChangeJar object to a file.
	 * 
	 * @param filename.  Name to give to the save file.
	 ******************************************************************/
	public void save(String filename){
		PrintWriter wr = null;
		try{
			wr = new PrintWriter(new BufferedWriter
					            (new FileWriter(filename)));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		wr.println(quarters);
		wr.println(dimes);
		wr.println(nickels);
		wr.println(pennies);
		wr.close();
	}
	
	/*******************************************************************
	 * Populates the current ChangeJar object from what's stored in a 
	 * given file.
	 * 
	 * @param filename. Name of the file to load from.
	 ******************************************************************/
	public void load(String filename){
		
		try{
			// open the data file
			Scanner fileReader = new Scanner(new File(filename)); 
			
			//assign values from the file to the instance variables.
			quarters = fileReader.nextInt();
			dimes = fileReader.nextInt();
			nickels = fileReader.nextInt();
			pennies = fileReader.nextInt();
            fileReader.close();
			
		}

	
		catch(Exception error) {
			throw new RuntimeException();
		}
	}	
	
	/*******************************************************************
	 * Changes the boolean value stored in the static instance variable
	 * suspend.  The suspend variable is used by the put in and take out 
	 * methods.
	 * 
	 * @param on.  Boolean value to assign.
	 ******************************************************************/
		public static void suspend(boolean on){
			suspend = on;
	}
	
	/*******************************************************************
	 * Getter method for the quarters variable.
	 * 
	 * @return number of quarters in the current jar.
	 ******************************************************************/
	public int getQuarters() {
		return quarters;
	}

	/*******************************************************************
	 * Set the number of quarters in the current jar.
	 * 
	 * @param quarters.  Amount to set too.
	 ******************************************************************/
	public void setQuarters(int quarters) {
		this.quarters = quarters;
	}

	/*******************************************************************
	 * Getter method for the dimes variable.
	 * 
	 * @return number of dime in the current jar.
	 ******************************************************************/
	public int getDimes() {
		return dimes;
	}

	/*******************************************************************
	 * Set the number of dimes in the current jar.
	 * 
	 * @param dimes. Amount to set too.
	 ******************************************************************/
	public void setDimes(int dimes) {
		this.dimes = dimes;
	}

	/*******************************************************************
	 * Getter method for the nickels variable.
	 * 
	 *@return number of nickels in the current jar.
	 ******************************************************************/

	public int getNickels() {
		return nickels;
	}

	/*******************************************************************
	 * Set the number of nickels in the current jar.
	 * 
	 * @param nickels. Amount to set too.
	 ******************************************************************/

	public void setNickels(int nickels) {
		this.nickels = nickels;
	}

	/*******************************************************************
	 * Getter method for the pennies variable.
	 * 
	 *@return number of pennies in the current jar.
	 ******************************************************************/

	public int getPennies() {
		return pennies;
	}

	/*******************************************************************
	 * Set the number of pennies in the current jar.
	 * 
	 * @param pennies. Amount to set too.
	 ******************************************************************/
	public void setPennies(int pennies) {
		this.pennies = pennies;
	}
}