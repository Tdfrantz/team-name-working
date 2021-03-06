// statement, decision, and loop test cases
// for every method in the helper class
package runtime;

import static org.junit.Assert.*;

import org.junit.Test;

public class helperTest {

	//Tests statement coverage of addTicket method
	@Test
	public void testAddTicketStatement() throws Exception {
		ticket testList[] = new ticket[1];
		testList[0] = new ticket("Test Show 1", "TestSeller", 1, 1.0);
		ticket newTicket = new ticket("Test Show 2", "TestSeller", 1, 1.0);
		testList = helper.addTicket(testList, newTicket);
		String testName1 = testList[0].getName();
		String testName2 = testList[1].getName();
		assertEquals("Test Show 1", testName1);
		assertEquals("Test Show 2", testName2);
		
	}
	
	//Tests decision coverage, for loop is false right away vs true then false
	@Test
	public void testAddTicketDecision() throws Exception {
		//for loop returns false right away, doesn't execute loop at all
		ticket testList[] = new ticket[0];
		ticket newTicket1 = new ticket("Test Show 1", "TestSeller", 1, 1.0);
		testList = helper.addTicket(testList, newTicket1);
		String testName1 = testList[0].getName();
		assertEquals("Test Show 1", testName1);

		// for loop returns true, executes once, then returns false
		ticket newTicket2 = new ticket("Test Show 2", "TestSeller", 1, 1.0);
		testList = helper.addTicket(testList, newTicket2);
		String testName2 = testList[1].getName();
		assertEquals("Test Show 1", testName1);
		assertEquals("Test Show 2", testName2);
	}
	
	//Tests zero executions, one execution and many executions
	@Test
	public void testAddTicketLoop() throws Exception {
		//for loop executes zero times
		ticket testList[] = new ticket[0];
		ticket newTicket1 = new ticket("Test Show 1", "TestSeller", 1, 1.0);
		testList = helper.addTicket(testList, newTicket1);
		String testName1 = testList[0].getName();
		assertEquals("Test Show 1", testName1);
		
		
		
		// for loop executes once
		ticket newTicket2 = new ticket("Test Show 2", "TestSeller", 1, 1.0);
		testList = helper.addTicket(testList, newTicket2);
		String testName2 = testList[1].getName();
		assertEquals("Test Show 1", testName1);
		assertEquals("Test Show 2", testName2);
		
		
		// for loop executes many times
		//shows numbered 1-10
		for(int index = 3; index <= 10; index++){
			ticket newTicket = new ticket("Test Show " + index, "TestSeller", 1, 1.0);
			testList = helper.addTicket(testList, newTicket);
		}
		
		String testNames[] = new String[10];
		
		//indexes numbered 0-9
		for(int index = 0; index < 10; index++){
			testNames[index] = testList[index].getName();
		}
		
		//test all names for consistency
		assertEquals("Test Show 1", testNames[0]);
		assertEquals("Test Show 2", testNames[1]);
		assertEquals("Test Show 3", testNames[2]);
		assertEquals("Test Show 4", testNames[3]);
		assertEquals("Test Show 5", testNames[4]);
		assertEquals("Test Show 6", testNames[5]);
		assertEquals("Test Show 7", testNames[6]);
		assertEquals("Test Show 8", testNames[7]);
		assertEquals("Test Show 9", testNames[8]);
		assertEquals("Test Show 10", testNames[9]);		
	}
	

	//Tests statement coverage of addUser method
	@Test
	public void testAddUserStatement() throws Exception {
		user testList[] = new user[1];
		testList[0] = new user("TestUser1", "AA", 1.0);
		user newUser = new user("TestUser2", "AA", 1.0);
		testList = helper.addUser(testList, newUser);
		String testName1 = testList[0].getName();
		String testName2 = testList[1].getName();
		assertEquals("TestUser1", testName1);
		assertEquals("TestUser2", testName2);
	}
	
	//Tests decision coverage, for loop is false right away vs true then false
	@Test
	public void testAddUserDecision() throws Exception {
		//for loop returns false right away, doesn't execute loop at all
		user testList[] = new user[0];
		user newUser1 = new user("TestUser1", "AA", 1.0);		
		testList = helper.addUser(testList, newUser1);	
		String testName1 = testList[0].getName();	
		assertEquals("TestUser1", testName1);
		
		// for loop returns true, executes once, then returns false
		user newUser2 = new user("TestUser2", "AA", 1.0);
		testList = helper.addUser(testList, newUser2);	
		String testName2 = testList[1].getName();	
		assertEquals("TestUser1", testName1);
		assertEquals("TestUser2", testName2);
	}
			
	//Tests zero executions, one execution and many executions
	@Test
	public void testAddUserLoop() throws Exception {
		//for loop executes zero times
		user testList[] = new user[0];
		user newUser1 = new user("TestUser1", "AA", 1.0);
		testList = helper.addUser(testList, newUser1);	
		String testName1 = testList[0].getName();	
		assertEquals("TestUser1", testName1);
		
		// for loop executes once
		user newUser2 = new user("TestUser2", "AA", 1.0);
		testList = helper.addUser(testList, newUser2);
		String testName2 = testList[1].getName();
		assertEquals("TestUser1", testName1);
		assertEquals("TestUser2", testName2);
		
		// for loop executes many times
		//shows numbered 1-10
		for(int index = 3; index <= 10; index++){
			user newUser = new user("TestUser" + index, "AA", 1.0);
			testList = helper.addUser(testList, newUser);
		}
		
		String testNames[] = new String[10];
		//indexes numbered 0-9
		for(int index = 0; index < 10; index++){
			testNames[index] = testList[index].getName();	
		}
		
		//test all names for consistency
		assertEquals("TestUser1", testNames[0]);
		assertEquals("TestUser2", testNames[1]);
		assertEquals("TestUser3", testNames[2]);
		assertEquals("TestUser4", testNames[3]);
		assertEquals("TestUser5", testNames[4]);
		assertEquals("TestUser6", testNames[5]);
		assertEquals("TestUser7", testNames[6]);
		assertEquals("TestUser8", testNames[7]);
		assertEquals("TestUser9", testNames[8]);
		assertEquals("TestUser10", testNames[9]);
	}

	//Tests Statement coverage
	@Test
	public void testDeleteUserStatement() throws Exception {
		// test when (address == -1) is true
		user testList[] = new user[1];
		testList[0] = new user("TestUser1", "AA", 1.0);
		user notRealUser = new user("NotRealUser", "AA", 1.0);
		
		// array shouldn't change since user doesn't exist
		testList = helper.deleteUser(testList, notRealUser.getName());
		String testName1 = testList[0].getName();
		assertEquals("TestUser1", testName1);
		
		// test when (address == -1) is false
		user realUser = new user("TestUser1", "AA", 1.0);
		
		// array should be empty after this execution
		testList = helper.deleteUser(testList, realUser.getName());
		assertEquals(0, testList.length);
	}
		
	//Tests decision coverage
	// NOTE THIS IS IDENTICAL TO THE STATEMENT TEST
	// THIS IS BECAUSE THE FOR LOOP CANNOT POSSIBLY
	// RETURN FALSE RIGHT AWAY AND EXECUTE 0 TIMES
	@Test
	public void testDeleteUserDecision() throws Exception {
		// test when (address == -1) is true
		user testList[] = new user[1];
		testList[0] = new user("TestUser1", "AA", 1.0);
		
		user notRealUser = new user("NotRealUser", "AA", 1.0);
		
		// array shouldn't change since user doesn't exist
		testList = helper.deleteUser(testList, notRealUser.getName());
		String testName1 = testList[0].getName();
		assertEquals("TestUser1", testName1);
		
		// test when (address == -1) is false
		user realUser = new user("TestUser1", "AA", 1.0);
		
		// array should be empty after this execution
		testList = helper.deleteUser(testList, realUser.getName());	
		assertEquals(0, testList.length);

	}
	
	//Tests many executions then one execution
	// NOTE that it is not possible to test 0 executions
	// since if array is empty address will return -1
	@Test
	public void testDeleteUserLoop() throws Exception {
		//populate list with 10 users
		user testList[] = new user[10];
		for(int index = 0; index < 10; index++){
			testList[index] = new user("TestUser" + (index+1), "AA", 1.0);			
		}
		
		// delete 9 of the users in reverse order, this will execute the for loop many times
		for(int index = 10; index > 1; index--){	
			testList = helper.deleteUser(testList, "TestUser" + index);	
		}
		assertEquals(1, testList.length);
		assertEquals("TestUser1", testList[0].getName());
		
		// delete last user, this will make for loop execute once
		
		testList = helper.deleteUser(testList, "TestUser1");
		assertEquals(0, testList.length);
	}

	//Statement coverage for findUser
	@Test
	public void testFindUserStatement() throws Exception {
		// successfully searching for a user will provide statement coverage
		user testList[] = new user[1];
		testList[0] = new user("TestUser1", "AA", 1.0);
		int address = helper.findUser(testList, "TestUser1");
		assertEquals(0, address);
	}
	
	//Decision coverage for findUser
	@Test
	public void testFindUserDecision() throws Exception {
		// searching an empty array will cause the for loop to return false right away
		user testList[] = new user[0];
		int address = helper.findUser(testList, "TestUser");
		assertEquals(-1, address);
		
		// searching for a user that does not exist in a non-empty array will make
		// nested if return false every time
		testList = new user[1];
		testList[0] = new user("TestUser1", "AA", 1.0);
		address = helper.findUser(testList, "NotRealUser");
		assertEquals(-1, address);
		
		// searching for a user that does exist in a non-empty array will make
		// nested if return true once		
		address = helper.findUser(testList, "TestUser1");
		assertEquals(0, address);
	}
	
	//for loop executed 0 times, 1 time and many times
	@Test
	public void testFindUserLoop() throws Exception {
		// searching an empty array will make for loop execute 0 times
		user testList[] = new user[0];
		int address = helper.findUser(testList, "TestUser");
		assertEquals(-1, address);
	
		// searching for the only element in a 1 element array will make 
		// the for loop execute 1 time
		testList = new user[1];
		testList[0] = new user("TestUser1", "AA", 1.0);
		address = helper.findUser(testList, "TestUser1");
		assertEquals(0, address);
		
		// searching for last element in a 10 element array will make the 
		// for loop execute many times
		testList = new user[10];	
		for(int index = 0; index < 10; index ++){
			testList[index] = new user("TestUser" + (index+1), "AA", 1.0);
		}	
		address = helper.findUser(testList, "TestUser10");
		assertEquals(9, address);
	}	

	//Statement coverage for findTicket
	@Test
	public void testFindTicketStatement() throws Exception {
		// successfully searching for a ticket will provide statement coverage
		ticket testList[] = new ticket[1];
		testList[0] = new ticket("Test Show 1", "TestSeller", 1, 1.0);
		int address = helper.findTicket(testList, "Test Show 1");
		assertEquals(0, address);
	}
	
	//Decision coverage for findTicket
	@Test
	public void testFindTicketDecision() throws Exception {
		// searching an empty array will cause the for loop to return false right away
		ticket testList[] = new ticket[0];
		int address = helper.findTicket(testList, "Test Show");
		assertEquals(-1, address);
		
		// searching for a ticket that does not exist in a non-empty array will make
		// nested if return false every time
		testList = new ticket[1];
		testList[0] = new ticket("Test Show 1", "TestSeller", 1, 1.0);
		address = helper.findTicket(testList, "Not Real Ticket");
		assertEquals(-1, address);
		
		// searching for a ticket that does exist in a non-empty array will make
		// nested if return true once		
		address = helper.findTicket(testList, "Test Show 1");
		assertEquals(0, address);
	}
		
	//for loop executed 0 times, 1 time and many times
	@Test
	public void testFindTicketLoop() throws Exception {
		// searching an empty array will make for loop execute 0 times
		ticket testList[] = new ticket[0];
		int address = helper.findTicket(testList, "Test Show");
		assertEquals(-1, address);

		// searching for the only element in a 1 element array will make 
		// the for loop execute 1 time
		testList = new ticket[1];
		testList[0] = new ticket("Test Show 1", "TestSeller", 1, 1.0);
		address = helper.findTicket(testList, "Test Show 1");
		assertEquals(0, address);

		// searching for last element in a 10 element array will make the 
		// for loop execute many times
		testList = new ticket[10];
		for(int index = 0; index < 10; index ++){
			testList[index] = new ticket("Test Show " + (index+1), "TestSeller", 1, 1.0);	
		}
		address = helper.findTicket(testList, "Test Show 10");
		assertEquals(9, address);	
	}

	//Statement coverage of padInt
	@Test
	public void testPadIntStatement() {
		// a successful pad where the for loop executes once provides statement coverage
		String testString  = helper.padInt(1, 2);
		assertEquals("01", testString);
	}
	
	//Decision coverage of padInt
	@Test
	public void testPadIntDecision() {
		// if the int is already the proper length the loop will return false right away
		String testString  = helper.padInt(1, 1);
		assertEquals("1", testString);
	
		// if the number needs one padding 0 the loop will return true then false
		testString  = helper.padInt(1, 2);	
		assertEquals("01", testString);
	}
	
	//Loop executed 0 times, 1 time and many times
	@Test
	public void testPadIntLoop() {
		//Loop executes 0 times
		String testString  = helper.padInt(1, 1);
		assertEquals("1", testString);
		
		//Loop executes 1 time
		testString  = helper.padInt(1, 2);
		assertEquals("01", testString);
		
		//Loop executes many times
		testString  = helper.padInt(1, 10);
		assertEquals("0000000001", testString);
	}

	//Statement coverage for padDouble
	@Test
	public void testPadDoubleStatement() {
		// padding in both directions will provide statement coverage
		String testString = helper.padDouble(1.1, 5);
		assertEquals("01.10", testString);	
	}
	
	//Decision coverage for padDouble
	@Test
	public void testPadDoubleDecision() {
		// no padding means both loops return false right away
		String testString = helper.padDouble(1.1, 3);
		assertEquals("1.1", testString);
		
		// left only padding means only second loop returns false right away
		testString = helper.padDouble(1.11, 5);
		assertEquals("01.11", testString);
		
		// right only padding means only first loop returns false right away
		testString = helper.padDouble(1.1, 4);	
		assertEquals("1.10", testString);

		// padding in both directions means both loops return true at first	
		testString = helper.padDouble(1.1, 5);	
		assertEquals("01.10", testString);
	}
	
	//Both loops must execute 0 times and 1 time
	// NOTE only the first loop can execute many times
	// since each double has at least 1 decimal place (ex. 1.0)
	@Test
	public void testPadDoubleLoop() {
		// both loops execute 0 times
		String testString = helper.padDouble(1.1, 3);
		assertEquals("1.1", testString);
		
		// both loops execute 1 time
		testString = helper.padDouble(1.1, 5);
		assertEquals("01.10", testString);
		
		//first loops execute many times (5x)
		testString = helper.padDouble(1.0, 9);
		assertEquals("000001.00", testString);
	}
}
