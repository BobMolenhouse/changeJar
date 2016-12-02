package changeJar;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChangeJarTest {
	
	//Testing takeOut with zero nickels to unsure adaptability to
	// the methods to skip coins if needed.
	@Test
    public void testTakeOut3() {
        ChangeJar s1 = new ChangeJar(5,3,0,4);
        ChangeJar s2 = s1.takeOut(1.34);
        assertEquals (s1.getQuarters(), 1);
        assertEquals (s1.getDimes(), 0);
        assertEquals (s1.getNickels(), 0);
        assertEquals (s1.getPennies(), 0);

        assertEquals (s2.getQuarters(), 4);
        assertEquals (s2.getDimes(), 3);
        assertEquals (s2.getNickels(),0);
        assertEquals (s2.getPennies(), 4);
    }

	//Testing takeOut with zero nickels to unsure adaptability to
	// the methods to skip coins if needed.
    @Test
    public void testTakeOut4() {
        ChangeJar s1 = new ChangeJar(1,30,0,4);
        ChangeJar s2 = s1.takeOut(3.04);
        assertEquals (s1.getQuarters(), 1);
        assertEquals (s1.getDimes(), 0);
        assertEquals (s1.getNickels(), 0);
        assertEquals (s1.getPennies(), 0);

        assertEquals (s2.getQuarters(),0);
        assertEquals (s2.getDimes(), 30);
        assertEquals (s2.getNickels(), 0);
        assertEquals (s2.getPennies(), 4);
    }

    //Testing takeOut with zero nickels to unsure adaptability to
    // the methods to skip coins if needed.
    @Test
    public void testTakeOut5() {
        ChangeJar s1 = new ChangeJar(1,3,0,2);
        ChangeJar s2 = s1.takeOut(0.32);
        assertEquals (s1.getQuarters(), 1);
        assertEquals (s1.getDimes(), 0);
        assertEquals (s1.getNickels(), 0);
        assertEquals (s1.getPennies(), 0);

        assertEquals (s2.getQuarters(),0);
        assertEquals (s2.getDimes(), 3);
        assertEquals (s2.getNickels(), 0);
        assertEquals (s2.getPennies(), 2);
    }
	
	//Testing all three constructors.
	@Test
	public void testConstructor() {
		ChangeJar s1 = new ChangeJar(6, 5, 4, 2);
		
		assertEquals (s1.getQuarters(), 6);
		assertEquals (s1.getDimes(), 5);
		assertEquals (s1.getNickels(), 4);
		assertEquals (s1.getPennies(), 2);
		
		ChangeJar s2 = new ChangeJar();
		assertEquals (s2.getQuarters(), 0);
		assertEquals (s2.getDimes(), 0);
		assertEquals (s2.getNickels(), 0);
		assertEquals (s2.getPennies(), 0);
		
		ChangeJar s3 = new ChangeJar(s1);
		assertEquals (s3.getQuarters(), 6);
		assertEquals (s3.getDimes(), 5);
		assertEquals (s3.getNickels(), 4);
		assertEquals (s3.getPennies(), 2);
	}
	
	//Testing all three constructors with large numbers.
	@Test
	public void testConstructor2() {
		ChangeJar s1 = new ChangeJar(568303, 85697924, 94962094, 
										36924012);
		
		assertEquals (s1.getQuarters(), 568303);
		assertEquals (s1.getDimes(), 85697924);
		assertEquals (s1.getNickels(), 94962094);
		assertEquals (s1.getPennies(), 36924012);
		
		ChangeJar s2 = new ChangeJar();
		assertEquals (s2.getQuarters(), 0);
		assertEquals (s2.getDimes(), 0);
		assertEquals (s2.getNickels(), 0);
		assertEquals (s2.getPennies(), 0);
		
		ChangeJar s3 = new ChangeJar(s1);
		assertEquals (s3.getQuarters(), 568303);
		assertEquals (s3.getDimes(), 85697924);
		assertEquals (s3.getNickels(), 94962094);
		assertEquals (s3.getPennies(), 36924012);
	}
	
	// testing valid takeOut with wide range of
	// quarters, dimes, nickels, pennies
	@Test
	public void testTakeOut1() {
		ChangeJar s1 = new ChangeJar(3,3,2,2);
		s1.takeOut(1,1,1,1);
		assertEquals (s1.getQuarters(), 2);
		assertEquals (s1.getDimes(), 2);
		assertEquals (s1.getNickels(), 1);
		assertEquals (s1.getPennies(), 1);
	}
	
	// testing valid takeOut with wide range of
	// quarters, dimes, nickels, pennies
	@Test
	public void testTakeOut2() {
		ChangeJar s1 = new ChangeJar(100,100,100,100);
		s1.takeOut(78,23,100,89);
		assertEquals (s1.getQuarters(),22);
		assertEquals (s1.getDimes(), 77);
		assertEquals (s1.getNickels(), 0);
		assertEquals (s1.getPennies(), 11);
	}
	
	// testing valid takeOut with double amount.
	@Test
	public void testTakeOutDouble() {
		ChangeJar s1 = new ChangeJar(5,3,4,3);
		ChangeJar s2 = s1.takeOut(1.22);
		
		assertEquals (s1.getQuarters(), 1);
		assertEquals (s1.getDimes(), 1);
		assertEquals (s1.getNickels(), 4);
		assertEquals (s1.getPennies(), 1);
		
		assertEquals (s2.getQuarters(), 4);
		assertEquals (s2.getDimes(), 2);
		assertEquals (s2.getNickels(), 0);
		assertEquals (s2.getPennies(), 2);
	}
	
	//Testing valid return of null for takeOut.
	@Test
	public void testTakeOutDoubleNull() {
		ChangeJar s1 = new ChangeJar(2,3,4,0);
		ChangeJar s2 = s1.takeOut(0.62);
		
		assertEquals (s1.getQuarters(), 2);
		assertEquals (s1.getDimes(), 3);
		assertEquals (s1.getNickels(), 4);
		assertEquals (s1.getPennies(), 0);
		
		assertEquals (s2, null);
	}
	
	//Testing valid return of null for takeOut.
	@Test
	public void testTakeOutDoubleNull2() {
		ChangeJar s1 = new ChangeJar(3,4,0,4);
		ChangeJar s2 = s1.takeOut(1.00);
		
		assertEquals (s1.getQuarters(), 3);
		assertEquals (s1.getDimes(), 4);
		assertEquals (s1.getNickels(), 0);
		assertEquals (s1.getPennies(), 4);
		
		assertEquals (s2, null);
	}
	
	//Testing valid return of null for takeOut.
	@Test
	public void testTakeOutDoubleNull3() {
		ChangeJar s1 = new ChangeJar();
		ChangeJar s2 = s1.takeOut(1.60);
		
		assertEquals (s1.getQuarters(), 0);
		assertEquals (s1.getDimes(), 0);
		assertEquals (s1.getNickels(), 0);
		assertEquals (s1.getPennies(), 0);
		
		assertEquals (s2, null);
	}
	
	// testing putIn for valid low numbers
	@Test
	public void testPutIn() {
		ChangeJar s1 = new ChangeJar();
		s1.putIn(2,3,4,5);
		assertEquals (s1.getQuarters(), 2);
		assertEquals (s1.getDimes(), 3);
		assertEquals (s1.getNickels(), 4);
		assertEquals (s1.getPennies(), 5);
	}
	
	// testing putIn and takeOut together
	@Test
	public void testPutInTakeOut() {
		ChangeJar s1 = new ChangeJar();
		s1.putIn(3,3,2,2);
		s1.takeOut(1,1,1,1);
		assertEquals (s1.getQuarters(), 2);
		assertEquals (s1.getDimes(), 2);
		assertEquals (s1.getNickels(), 1);
		assertEquals (s1.getPennies(), 1);
	}

	// Testing equals for valid numbers
	@Test
	public void testEqual () {
		ChangeJar s1 = new ChangeJar(2, 5, 4, 2);
		ChangeJar s2 = new ChangeJar(6, 5, 4, 2);
		ChangeJar s3 = new ChangeJar(2, 5, 4, 2);

		assertFalse(s1.equals(s2));
		assertTrue(s1.equals(s3));
	}

	// testing compareTo all returns
	@Test
	public void testCompareTo () {
		ChangeJar s1 = new ChangeJar(2, 5, 4, 2);
		ChangeJar s2 = new ChangeJar(6, 5, 4, 2);
		ChangeJar s3 = new ChangeJar(2, 3, 4, 2);
		ChangeJar s4 = new ChangeJar(2, 5, 4, 2);

		assertTrue(s2.compareTo(s1) > 0);
		assertTrue(s3.compareTo(s1) < 0);
		assertTrue(s1.compareTo(s4) == 0);
	}

	// load and save combined. 
	@Test
	public void testLoadSave() {
		ChangeJar s1 = new ChangeJar(6, 5, 4, 2);
		ChangeJar s2 = new ChangeJar(6, 5, 4, 2);

		s1.save("file1");
		s1 = new ChangeJar();  // resets to zero

		s1.load("file1");
		assertTrue(s1.equals(s2));

	}
	
	// load and save combined with different jars..
	@Test
	public void testLoadSave2() {
		ChangeJar s1 = new ChangeJar(6, 5, 4, 2);

		s1.save("file2");
		ChangeJar s2 = new ChangeJar();

		s2.load("file2");
		assertTrue(s1.equals(s2));
	}

	// testing not able to make change
	@Test
	public void testTakeOutNull() {
		ChangeJar s1 = new ChangeJar(3,1,2,2);
		ChangeJar s2 = s1.takeOut(1.22);
		assertEquals(s2,  null);
	}
	
	//Testing takeOut with other valid jar.
	@Test
	public void testTakeOutOther() {
		ChangeJar s1 = new ChangeJar(3,1,2,2);
		ChangeJar s2 = new ChangeJar(2,1,2,1);
		s1.takeOut(s2);
		assertEquals(s1.getQuarters(), 1);
		assertEquals(s1.getDimes(), 0);
		assertEquals(s1.getNickels(), 0);
		assertEquals(s1.getPennies(), 1);
	}
	
	//Testing takeOut  with other valid jar and large numbers.
	@Test
	public void testTakeOutOther2() {
		ChangeJar s1 = new ChangeJar(560,0,490,223);
		ChangeJar s2 = new ChangeJar(450,0,50,1);
		s1.takeOut(s2);
		assertEquals(s1.getQuarters(), 110);
		assertEquals(s1.getDimes(), 0);
		assertEquals(s1.getNickels(), 440);
		assertEquals(s1.getPennies(), 222);
	}
	
	//Testing suspend on takeOut(double).
	@Test
	public void testMutateTakeOutDouble() {
		ChangeJar s1 = new ChangeJar(6, 5, 4, 2);
		ChangeJar.suspend(true);
		s1.takeOut(1.22);
		assertEquals (s1.getQuarters(), 6);
		assertEquals (s1.getDimes(), 5);
		assertEquals (s1.getNickels(), 4);
		assertEquals (s1.getPennies(), 2);
		ChangeJar.suspend(false);
	}
	
	//Testing suspend on takeOut.
	@Test
	public void testMutateTakeOut() {
		ChangeJar s1 = new ChangeJar(6, 45, 9, 30);
		ChangeJar.suspend(true);
		s1.takeOut(1,5,2,6);
		assertEquals (s1.getQuarters(), 6);
		assertEquals (s1.getDimes(), 45);
		assertEquals (s1.getNickels(), 9);
		assertEquals (s1.getPennies(), 30);
		ChangeJar.suspend(false);
	}
	
	//Testing suspend on takeOut(other).
	@Test
	public void testMutateTakeOutOther() {
		ChangeJar s1 = new ChangeJar(4, 5, 6, 7);
		ChangeJar s2 = new ChangeJar(1,1,1,1);
		ChangeJar.suspend(true);
		s1.takeOut(s2);
		assertEquals (s1.getQuarters(), 4);
		assertEquals (s1.getDimes(), 5);
		assertEquals (s1.getNickels(), 6);
		assertEquals (s1.getPennies(), 7);
		ChangeJar.suspend(false);
	}
	
	//Testing suspend on putIn(other).
	@Test
	public void testMutatePutInOther() {
		ChangeJar s1 = new ChangeJar(4, 5, 6, 7);
		ChangeJar s2 = new ChangeJar(1,1,1,1);
		ChangeJar.suspend(true);
		s1.putIn(s2);
		assertEquals (s1.getQuarters(), 4);
		assertEquals (s1.getDimes(), 5);
		assertEquals (s1.getNickels(), 6);
		assertEquals (s1.getPennies(), 7);
		ChangeJar.suspend(false);
	}
	
	//Testing suspend on putIn.
	@Test
	public void testMutatePutIn() {
		ChangeJar s1 = new ChangeJar(65, 23, 109, 72);
		ChangeJar.suspend(true);
		s1.putIn(23,45,2,131);
		assertEquals (s1.getQuarters(), 65);
		assertEquals (s1.getDimes(), 23);
		assertEquals (s1.getNickels(), 109);
		assertEquals (s1.getPennies(), 72);
		ChangeJar.suspend(false);
	}
	
	//Testing equals returns false for different Jars.
	@Test
	public void testEqualsFalse(){
		ChangeJar s1 = new ChangeJar(300, 35, 54, 2109);
		ChangeJar s2 = new ChangeJar(60, 50, 40, 20);

		assertFalse(s1.equals(s2));
	}
	
	//Testing equals returns false for jars with a very 
	//slight difference.
	@Test
	public void testEqualsFalse2(){
		ChangeJar s1 = new ChangeJar(0, 0, 0, 1);
		ChangeJar s2 = new ChangeJar(0, 0, 0, 0);

		assertFalse(s1.equals(s2));
	}
	
	//Testing equals for wide range of numbers.
	@Test
	public void testEqualsTrue(){
		ChangeJar s1 = new ChangeJar(67, 8990, 5, 21);
		ChangeJar s2 = new ChangeJar(67, 8990, 5, 21);

		assertTrue(s1.equals(s2));
	}
	
	//Testing equals for differently formatted numbers.
	@Test
	public void testEqualsTrue2(){
		ChangeJar s1 = new ChangeJar(0, 0, 0, 1);
		ChangeJar s2 = new ChangeJar(0000, 00, 00, 01);

		assertTrue(s1.equals(s2));
	}
	
	//Testing static equals for large numbers.
	@Test
	public void testStaticEqualsTrue(){
		ChangeJar s1 = new ChangeJar(10000000, 54909202, 0, 145);
		ChangeJar s2 = new ChangeJar(10000000, 54909202, 0, 145);

		assertTrue(ChangeJar.equals(s2,s1));
	}
	
	//Testing static equals for empty jars.
	@Test
	public void testStaticEqualsTrue2(){
		assertTrue(ChangeJar.equals(new ChangeJar(), 
									new ChangeJar(0,0,0,0)));
	}
	
	//Testing static equals properly returns false.
	@Test
	public void testStaticEqualsFalse(){
		assertFalse(ChangeJar.equals(new ChangeJar(), 
									new ChangeJar(44552,0,4,653)));
	}
	
	//Testing static equals returns false for large numbers.
	@Test
	public void testStaticEqualsFalse2(){
		ChangeJar s1 = new ChangeJar(105900, 0, 0, 45);
		ChangeJar s2 = new ChangeJar(10000000, 54909202, 0, 145);

		assertFalse(ChangeJar.equals(s2,s1));
	}
	
	//Testing compareTo for multiple jars.
	@Test
	public void testCompareTo2 () {
		ChangeJar s1 = new ChangeJar();
		ChangeJar s2 = new ChangeJar(0,12,594,3);
		ChangeJar s3 = new ChangeJar(0,12,594,3);
		ChangeJar s4 = new ChangeJar(s3);

		assertTrue(s2.compareTo(s1) > 0);
		assertTrue(s1.compareTo(s4) < 0);
		assertTrue(s3.compareTo(s2) == 0);
		assertTrue(s3.compareTo(s4) == 0);
	}
	
	//Testing static compareTo for multiple jars.
	@Test
	public void testStaticCompareTo () {
		ChangeJar s1 = new ChangeJar();
		ChangeJar s2 = new ChangeJar(0,2,7,3);
		ChangeJar s3 = new ChangeJar(10000,1,393,3);
		ChangeJar s4 = new ChangeJar(s3);

		assertTrue(ChangeJar.compareTo(s2,s1) > 0);
		assertTrue(ChangeJar.compareTo(s3,s2) > 0);
		assertTrue(ChangeJar.compareTo(s1,s3) < 0);
		assertTrue(ChangeJar.compareTo(s2,s4) < 0);
		assertTrue(ChangeJar.compareTo(s3,s4) == 0);
		assertTrue(ChangeJar.compareTo(s4,s3) == 0);
	}
	
	//Testing static compareTo returns false for multiple jars.
	@Test
	public void testStaticCompareToFalse () {
		ChangeJar s1 = new ChangeJar();
		ChangeJar s2 = new ChangeJar(05,53,4,234);
		ChangeJar s3 = new ChangeJar(1,1,7,53);
		ChangeJar s4 = new ChangeJar(s3);

		assertFalse(ChangeJar.compareTo(s1,s2) > 0);
		assertFalse(ChangeJar.compareTo(s3,s2) > 0);
		assertFalse(ChangeJar.compareTo(s3,s1) < 0);
		assertFalse(ChangeJar.compareTo(s3,s4) < 0);
		assertFalse(ChangeJar.compareTo(s1,s4) == 0);
		assertFalse(ChangeJar.compareTo(s2,s3) == 0);
	}
	
	//Testing get amount returns correct double amount.
	@Test
	public void testGetAmount() {
		ChangeJar s1 = new ChangeJar(2,2,2,5);
		double d = s1.getAmount();
		assertTrue(d == 0.85);
	}
	
	//Testing get amount returns correct double amount.
	@Test
	public void testGetAmount2() {
		ChangeJar s1 = new ChangeJar(400,59,3042,64);
		double d = s1.getAmount();
		assertTrue(d == 258.64);
	}
	
	//Testing putIn with valid amounts.
	@Test
	public void testPutIn2() {
		ChangeJar s1 = new ChangeJar(5,2,5,2);
		s1.putIn(18,54,0,3);
		assertEquals (s1.getQuarters(), 23);
		assertEquals (s1.getDimes(),56);
		assertEquals (s1.getNickels(), 5);
		assertEquals (s1.getPennies(), 5);
	}
	
	//Testing putIn with valid other Jar of big numbers.
	@Test
	public void testPutInOther() {
		ChangeJar s1 = new ChangeJar();
		ChangeJar s2 = new ChangeJar(100,30,2,600000);
		s1.putIn(s2);
		assertEquals (s1.getQuarters(), 100);
		assertEquals (s1.getDimes(), 30);
		assertEquals (s1.getNickels(), 2);
		assertEquals (s1.getPennies(), 600000);
	}
	
	//Testing putIn with valid other Jar.
	@Test
	public void testPutInOther2() {
		ChangeJar s1 = new ChangeJar(3,4,5,6);
		ChangeJar s2 = new ChangeJar();
		s1.putIn(s2);
		assertEquals (s1.getQuarters(), 3);
		assertEquals (s1.getDimes(), 4);
		assertEquals (s1.getNickels(), 5);
		assertEquals (s1.getPennies(), 6);
	}
	
	//Testing toString method for single coins.
	@Test
	public void testToStringSingular(){
		ChangeJar s1 = new ChangeJar(1,1,1,1);
		assertEquals(s1.toString(), 
				"1 quarter, 1 dime, 1 nickel, 1 penny.");
	}
	
	//Testing toString for plural coins.
	@Test
	public void testToStringplural(){
		ChangeJar s1 = new ChangeJar(5,250,2,0);
		assertEquals(s1.toString(), 
				"5 quarters, 250 dimes, 2 nickels, 0 pennies.");
	}
	
	//Testing toString with a mix of tenses.
	@Test
	public void testToStringMix(){
		ChangeJar s1 = new ChangeJar(1,250,1,0);
		assertEquals(s1.toString(), 
				"1 quarter, 250 dimes, 1 nickel, 0 pennies.");
	}
	
	//Test suspend toggles the suspend variable.
	@Test
	public void testSuspendOn(){
		ChangeJar.suspend(true);
		assertTrue(ChangeJar.isSuspend());
		ChangeJar.suspend(false);
		assertFalse(ChangeJar.isSuspend());
	}
	// IMPORTANT: only one test per exception!!!
	
	
	// testing negative number for nickels, takeOut
	@Test
	(expected = IllegalArgumentException.class)
	public void testTakeOutNegNickels() {
		ChangeJar s1 = new ChangeJar(2,2,2,2);
		s1.takeOut(1,1,-1,1);
	}
	
	// testing takeOut negative number of quarters.
	@Test
	(expected = IllegalArgumentException.class)
	public void testTakeOutNegQuarters() {
		ChangeJar s1 = new ChangeJar(5,0,0,56);
		s1.takeOut(-1,0,0,1);
	}
	
	// testing takeOut negative number of dimes.
	@Test
	(expected = IllegalArgumentException.class)
	public void testTakeOutNegDimes() {
		ChangeJar s1 = new ChangeJar(5,6,0,6);
		s1.takeOut(1,-4,0,1);
	}
	
	//testing takeOut negative number of pennies.
	@Test
	(expected = IllegalArgumentException.class)
	public void testTakeOutNegPennies() {
		ChangeJar s1 = new ChangeJar(5,0,0,56);
		s1.takeOut(1,0,0,-39);
	}

	// testing negative number quarters, for constructors
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegQuarters() {
		new ChangeJar(-300, 0, 0, 0);		
	}
	
	// testing takeOut too many quarters.
	@Test(expected = IllegalArgumentException.class)
	public void testTakeOutTooManyQuarters() {
		ChangeJar s1 = new ChangeJar(3, 46, 5, 6);	
		s1.takeOut(4,0,0,0);
		}
		
	//testing takeOut too many dimes.
	@Test(expected = IllegalArgumentException.class)
	public void testTakeOutTooManyDimes() {
		ChangeJar s1 = new ChangeJar(3, 4, 5, 6);	
		s1.takeOut(0,5,0,0);
		}
	
	//testing takeOut too many nickels.
	@Test(expected = IllegalArgumentException.class)
	public void testTakeOutTooManyNickels() {
		ChangeJar s1 = new ChangeJar(3, 4, 5, 6);	
		s1.takeOut(3,0,6,3);
		}
	
	//testing takeOut too many pennies.
	@Test(expected = IllegalArgumentException.class)
	public void testTakeOutTooManyPennies() {
		ChangeJar s1 = new ChangeJar(3, 4, 5, 6);	
		s1.takeOut(0,0,0,79);
		}
	
	// testing negative number for quarters, putIn
	@Test(expected = IllegalArgumentException.class)
	public void testPutInNegQuarters() {
		ChangeJar s = new ChangeJar(2,3,4,5);
		s.putIn(-30,2,30,2);
	}
	
	//test constructor for negative quarters.
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegQuarter() {
		new ChangeJar(-6, 0, 5, 0);
	}
	
	//test constructor for negative dimes.
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegDime() {
		new ChangeJar(7, -10, 5005834, 2);
	}
	
	//test Constructor for negative nickels.
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegNickel() {
		new ChangeJar(7, 10, -9, 2);
	}
	
	//test constructor for negative pennies.
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegPenny() {
		new ChangeJar(700909, 10, 9, -2);
	}
	
	//test equals with object of wrong type.
	@Test(expected = RuntimeException.class)
	public void testEqualsIncorrectObject() {
		ChangeJar s1 = new ChangeJar(7,5,3,2);
		String s2 = new String("hello");
		s1.equals(s2);
	}
	
	//test equals with wrong object.
	@Test(expected = RuntimeException.class)
	public void testEqualsIncorrectObject2() {
		ChangeJar s1 = new ChangeJar(7,5,3,2);
		int s2 = 5740;
		s1.equals(s2);
	}
	
	//testing putIn negative number of dime.
	@Test
	(expected = IllegalArgumentException.class)
	public void testPutInNegDimes() {
		ChangeJar s1 = new ChangeJar(2,2,2,2);
		s1.putIn(67,-56,45,3);
	}
	
	//testing putIn negative number of nickels.
	@Test
	(expected = IllegalArgumentException.class)
	public void testPutInNegNickels() {
		ChangeJar s1 = new ChangeJar(2,2,2,2);
		s1.putIn(7,8,-4,9);
	}
	
	//testing putIn negative number of pennies.
	@Test
	(expected = IllegalArgumentException.class)
	public void testPutInNegPennies() {
		ChangeJar s1 = new ChangeJar(2,2,2,2);
		s1.putIn(7,8,4,-9);
	}
	
	//testing takeOut negative double value.
	@Test
	(expected = IllegalArgumentException.class)
	public void testTakeOutDoubleNeg(){
		ChangeJar s1 = new ChangeJar();
		s1.takeOut(-10.00);
	}
	
	//testing takeOut negative double value.
	@Test
	(expected = IllegalArgumentException.class)
	public void testTakeOutDoubleNeg2(){
		ChangeJar s1 = new ChangeJar(5,5,5,5);
		s1.takeOut(-1.40);
	}
	
	//test takeOut(other) with too large a Jar.
	@Test
	(expected = IllegalArgumentException.class)
	public void testTakeOutBigOther(){
		ChangeJar s1 = new ChangeJar();
		ChangeJar s2 = new ChangeJar(1,1,1,1);
		s1.takeOut(s2);
	}
	
	//testing testTakeOut3 with one nickel.
	@Test
    public void testTakeOut30() {
        ChangeJar s1 = new ChangeJar(5,3,1,4);
        ChangeJar s2 = s1.takeOut(1.34);
        assertEquals (s1.getQuarters(), 0);
        assertEquals (s1.getDimes(), 3);
        assertEquals (s1.getNickels(), 0);
        assertEquals (s1.getPennies(), 0);

        assertEquals (s2.getQuarters(), 5);
        assertEquals (s2.getDimes(), 0);
        assertEquals (s2.getNickels(),1);
        assertEquals (s2.getPennies(), 4);
    }

	//testing testTakeOut4 with one nickel.
    @Test
    public void testTakeOut40() {
        ChangeJar s1 = new ChangeJar(1,30,1,4);
        ChangeJar s2 = s1.takeOut(3.04);
        assertEquals (s1.getQuarters(), 0);
        assertEquals (s1.getDimes(), 3);
        assertEquals (s1.getNickels(), 0);
        assertEquals (s1.getPennies(), 0);

        assertEquals (s2.getQuarters(),1);
        assertEquals (s2.getDimes(), 27);
        assertEquals (s2.getNickels(), 1);
        assertEquals (s2.getPennies(), 4);
    }

    //testing testTakeOut5 with one nickel.
    @Test
    public void testTakeOut50() {
        ChangeJar s1 = new ChangeJar(1,3,1,2);
        ChangeJar s2 = s1.takeOut(0.32);
        assertEquals (s1.getQuarters(), 0);
        assertEquals (s1.getDimes(), 3);
        assertEquals (s1.getNickels(), 0);
        assertEquals (s1.getPennies(), 0);

        assertEquals (s2.getQuarters(),1);
        assertEquals (s2.getDimes(), 0);
        assertEquals (s2.getNickels(), 1);
        assertEquals (s2.getPennies(), 2);
    }
    
    //testing takeOut without nickels but using all quarters.
    @Test
    public void testTakeOut6(){
    	ChangeJar s1 = new ChangeJar(5,3,0,4);
    	ChangeJar s2 = s1.takeOut(1.29);
    	assertEquals (s1.getQuarters(), 0);
        assertEquals (s1.getDimes(), 3);
        assertEquals (s1.getNickels(), 0);
        assertEquals (s1.getPennies(), 0);

        assertEquals (s2.getQuarters(),5);
        assertEquals (s2.getDimes(), 0);
        assertEquals (s2.getNickels(), 0);
        assertEquals (s2.getPennies(), 4);
    }
    
    //testing takeOut without nickels but using all quarters.
    @Test
    public void testTakeOut7(){
    	ChangeJar s1 = new ChangeJar(1,3,0,4);
    	ChangeJar s2 = s1.takeOut(.39);
    	assertEquals (s1.getQuarters(), 0);
        assertEquals (s1.getDimes(), 2);
        assertEquals (s1.getNickels(), 0);
        assertEquals (s1.getPennies(), 0);

        assertEquals (s2.getQuarters(),1);
        assertEquals (s2.getDimes(), 1);
        assertEquals (s2.getNickels(), 0);
        assertEquals (s2.getPennies(), 4);
    }
    
    //testing takeOut without nickels but using all quarters.
    @Test
    public void testTakeOut8(){
    	ChangeJar s1 = new ChangeJar(1,3,0,4);
    	ChangeJar s2 = s1.takeOut(.37);
    	assertEquals (s1.getQuarters(), 0);
        assertEquals (s1.getDimes(), 2);
        assertEquals (s1.getNickels(), 0);
        assertEquals (s1.getPennies(), 2);

        assertEquals (s2.getQuarters(),1);
        assertEquals (s2.getDimes(), 1);
        assertEquals (s2.getNickels(), 0);
        assertEquals (s2.getPennies(), 2);
    }
}
