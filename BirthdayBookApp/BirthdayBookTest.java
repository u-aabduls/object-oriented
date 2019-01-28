import static org.junit.Assert.*;

import org.junit.Test;

public class BirthdayBookTest {

	@Test
	public void test_01() {
		Birthday bd01 = new Birthday(1, 11);
		assertEquals(1, bd01.getMonth());
		assertEquals(11, bd01.getDay());
	}
	
	@Test
	public void test_02() {
		Birthday bd01 = new Birthday(1, 11);
		Birthday bd02 = new Birthday(2, 12);
	    Birthday bd03 = new Birthday(3, 13);
	    Birthday bd04 = new Birthday(4, 14);
	    Birthday bd05 = new Birthday(5, 15);
	    Birthday bd06 = new Birthday(6, 16);
	    Birthday bd07 = new Birthday(7, 17);
	    Birthday bd08 = new Birthday(8, 18);
	    Birthday bd09 = new Birthday(9, 19);
	    Birthday bd10 = new Birthday(10, 20);
	    Birthday bd11 = new Birthday(11, 21);
	    Birthday bd12 = new Birthday(12, 22);
	    assertEquals("January 11", bd01.toString());
	    assertEquals("February 12", bd02.toString());
	    assertEquals("March 13", bd03.toString());
	    assertEquals("April 14", bd04.toString());
	    assertEquals("May 15", bd05.toString());
	    assertEquals("June 16", bd06.toString());
	    assertEquals("July 17", bd07.toString());
	    assertEquals("August 18", bd08.toString());
	    assertEquals("September 19", bd09.toString());
	    assertEquals("October 20", bd10.toString());
	    assertEquals("November 21", bd11.toString());
	    assertEquals("December 22", bd12.toString());
	}
	
	@Test
	public void test_02_violation() {
		try {
			Birthday invalidBD = new Birthday(13, 39);
			fail("Expected precondition violation did not occur.");
		}
		catch(IllegalArgumentException e) {
			// expected, do nothing
		}
	}
	
	@Test
	public void test_03() {
		Birthday bd06 = new Birthday(6, 16);
	    Birthday bd07 = new Birthday(7, 17);
		Birthday bd13 = new Birthday(6, 16);
	    assertEquals("June 16", bd06.toString());
	    assertEquals("July 17", bd07.toString());
	    assertEquals("June 16", bd13.toString());
	    assertTrue(bd06.equals(bd13));
	    assertFalse(bd07.equals(bd13));
	}
	
	@Test
	public void test_04() {
		Birthday bd01 = new Birthday(1, 11);
		Entry e1 = new Entry("A", bd01);
	    assertEquals("A", e1.getName());
	    assertEquals("January 11", e1.getBirthday().toString());
	    assertEquals("A was born on January 11", e1.toString());
	}
	
	@Test
	public void test_05() {
		Entry e2 = new Entry("B", 2, 12);
	    assertEquals("B", e2.getName());
	    assertEquals("February 12", e2.getBirthday().toString());
	    assertEquals("B was born on February 12", e2.toString());
	}
	
	@Test
	public void test_06() {
		Birthday bd01 = new Birthday(1, 11);
		Entry e1 = new Entry("A", bd01);
		Entry e2 = new Entry("B", 2, 12);
		Entry e3 = new Entry("A", 1, 11);
	    assertEquals("A was born on January 11", e1.toString());
	    assertEquals("B was born on February 12", e2.toString());
	    assertEquals("A was born on January 11", e3.toString());
	    assertFalse(e1.equals(e2));
	    assertTrue(e1.equals(e3));
	}
	
	@Test
	public void test_07() {
		Birthday bd01 = new Birthday(1, 11);
		Entry e1 = new Entry("A", bd01);
		Entry e2 = new Entry("B", 2, 12);
		Entry e3 = new Entry("A", 1, 11);
		e2.setName("A");
	    /* Change e2's birthday to January 11. */
	    e2.setBirthday(1, 11);
	    assertEquals("A was born on January 11", e1.toString());
	    assertEquals("A was born on January 11", e2.toString());
	    assertEquals("A was born on January 11", e3.toString());
	    assertTrue(e1.equals(e2));
	    assertTrue(e1.equals(e3));
	}
	
	@Test
	public void test_08() {
		Birthday bd01 = new Birthday(1, 11);
		Birthday bd03 = new Birthday(3, 13);
		Entry e1 = new Entry("A", bd01);
		Entry e2 = new Entry("B", 2, 12);
		Entry e3 = new Entry("A", 1, 11);
		e2.setName("A");
	    e2.setBirthday(1, 11);
		e3.setBirthday(bd03);
	    assertEquals("A was born on January 11", e1.toString());
	    assertEquals("A was born on January 11", e2.toString());
	    assertEquals("A was born on March 13", e3.toString());
	    assertTrue(e1.equals(e2));
	    assertFalse(e1.equals(e3));
	}
	
	@Test
	public void test_09() {
		BirthdayBook bb = new BirthdayBook();
		assertEquals(0, bb.getNumberOfEntries());
		assertEquals(0, bb.getEntries().length);
	}
	
	@Test
	public void test_10() {
		BirthdayBook bb = new BirthdayBook();
		assertEquals("There are 0 entries in the book\n", bb.toString());
	}
	
	@Test
	public void test_11() {
		BirthdayBook bb = new BirthdayBook();
		assertFalse(bb.nameExists("A"));
		assertFalse(bb.nameExists("B"));
		assertFalse(bb.nameExists("C"));
	}
	
	@Test
	public void test_12() {
		BirthdayBook bb = new BirthdayBook();
		Birthday bdOfA = bb.getBirthday("A");
	    Birthday bdOfB = bb.getBirthday("B");
	    Birthday bdOfC = bb.getBirthday("C");
	    /* Return birthdays on names.
	     * When names are non-existing, their associated birthdays are nulls.
	     */
	    assertEquals(null, bdOfA); 
	    assertEquals(null, bdOfB);
	    assertEquals(null, bdOfC);
	}
	
	@Test
	public void test_13() {
		BirthdayBook bb = new BirthdayBook();
		Birthday bd13 = new Birthday(6, 16);
		String[] toRemind = bb.getReminders(bd13);
	    assertEquals(0, toRemind.length);
	    toRemind = bb.getReminders(6, 16);
	    assertEquals(0, toRemind.length);
	}
	
	@Test
	public void test_14() {
		BirthdayBook bb = new BirthdayBook();
		bb.removeEntry("A"); 
	    bb.removeEntry("B");
	    bb.removeEntry("C");
	    bb.removeEntry("D");
	    assertEquals(0, bb.getNumberOfEntries());
	    assertEquals(0, bb.getEntries().length);
	}
	
	@Test
	public void test_15() {
		BirthdayBook bb = new BirthdayBook();
		Birthday bd01 = new Birthday(1, 11);
		Entry e1 = new Entry("A", bd01);
		Birthday bd13 = new Birthday(6, 16);
		bb.addEntry(e1.getName(), e1.getBirthday().getMonth(), e1.getBirthday().getDay());
	    bb.addEntry("B", bd13);
	    bb.addEntry("C", 6, 16);
	    assertEquals(3, bb.getNumberOfEntries());
	    assertEquals(3, bb.getEntries().length);
	    assertEquals("A was born on January 11", bb.getEntries()[0].toString());
	    assertEquals("B was born on June 16", bb.getEntries()[1].toString());
	    assertEquals("C was born on June 16", bb.getEntries()[2].toString());
	}
	
	@Test
	public void test_16() {
		BirthdayBook bb = new BirthdayBook();
		Birthday bd01 = new Birthday(1, 11);
		Entry e1 = new Entry("A", bd01);
		Birthday bd13 = new Birthday(6, 16);
		bb.addEntry(e1.getName(), e1.getBirthday().getMonth(), e1.getBirthday().getDay());
	    bb.addEntry("B", bd13);
	    bb.addEntry("C", 6, 16);
	    String expected = "There are 3 entries in the book\n";
	    expected += "A was born on January 11\n";
	    expected += "B was born on June 16\n";
	    expected += "C was born on June 16\n";
		assertEquals(expected, bb.toString());
	}
	
	@Test
	public void test_17to21() {
		BirthdayBook bb = new BirthdayBook();
		Birthday bd01 = new Birthday(1, 11);
		Entry e1 = new Entry("A", bd01);
		Birthday bd13 = new Birthday(6, 16);
		bb.addEntry(e1.getName(), e1.getBirthday().getMonth(), e1.getBirthday().getDay());
	    bb.addEntry("B", bd13);
	    bb.addEntry("C", 6, 16);
	    
	    // 17
	    assertTrue(bb.nameExists("A"));
	    assertTrue(bb.nameExists("B"));
	    assertTrue(bb.nameExists("C"));

	    // 18
	    Birthday bdOfA = bb.getBirthday("A");
	    Birthday bdOfB = bb.getBirthday("B");
	    Birthday bdOfC = bb.getBirthday("C");
	    bdOfA = bb.getBirthday("A");
	    bdOfB = bb.getBirthday("B");
	    bdOfC = bb.getBirthday("C");
	    /* Birthdays of existing names are not nulls */
	    assertEquals("January 11", bdOfA.toString()); 
	    assertEquals("June 16", bdOfB.toString());
	    assertEquals("June 16", bdOfC.toString());

	    // 19
	    String[] toRemind = bb.getReminders(1, 16);
	    assertEquals(0, toRemind.length);

	    // 20
	    toRemind = bb.getReminders(1, 11);
	    /* Return names of persons whose birthdays are January 11. 
	     * One entry added so far has this birthday. 
	     */
	    assertEquals(1, toRemind.length);
	    assertEquals("A", toRemind[0]);

	    // 21
	    toRemind = bb.getReminders(6, 16);
	    /* Return names of persons whose birthdays are June 16. 
	     * Two entries added so far have this birthday. 
	     */
	    assertEquals(2, toRemind.length);
	    assertEquals("B", toRemind[0]);
	    assertEquals("C", toRemind[1]);
	}
	
	@Test
	public void test22_23() {
		BirthdayBook bb = new BirthdayBook();
		Birthday bd01 = new Birthday(1, 11);
		Birthday bd13 = new Birthday(6, 16);
		Entry e1 = new Entry("A", bd01);
		bb.addEntry(e1.getName(), e1.getBirthday().getMonth(), e1.getBirthday().getDay());
	    bb.addEntry("B", bd13);
	    bb.addEntry("C", 6, 16);
	    
	    // 22
	    bb.removeEntry("D");
	    assertEquals("There are 3 entries in the book\n" + 
	    		"A was born on January 11\n" + 
	    		"B was born on June 16\n" + 
	    		"C was born on June 16\n", bb.toString());

	    // 23
	    bb.removeEntry("A");
	    assertEquals("There are 2 entries in the book\n" + 
	    		"B was born on June 16\n" + 
	    		"C was born on June 16\n", bb.toString());
	}

}
