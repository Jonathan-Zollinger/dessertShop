package dessertShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	Customer customer = new Customer ("James");
	
	
	//testing constructor
	@Test
	void testCustomer() {
		assertEquals("James",customer.getName());
		//fail("Not yet implemented"); // TODO
	}

	//test getName
	@Test
	void testGetName() {
		assertEquals("James",customer.getName());
		//fail("Not yet implemented"); // TODO
	}

	//test getID
	@Test
	void testGetID() {
		assertEquals(1000,customer.getID());
		//fail("Not yet implemented"); // TODO
	}

	//testGetOrderHistory()
	@Test
	void testGetOrderHistory() {
		assertEquals(0,customer.getOrderHistory().size());
		//fail("Not yet implemented"); // TODO
	}

	//test setName
	@Test
	void testSetName() {
		customer.setName("Paul");
		assertEquals("Paul",customer.getName());
		//fail("Not yet implemented"); // TODO
	}

	//test addtoHistory
	@Test
	void testAddToHistory() {
		Order order = new Order();
		customer.addToHistory(order);
		assertEquals(1,customer.getOrderHistory().size());
		//fail("Not yet implemented"); // TODO
	}

}
