package dessertShop;

import java.util.*;

public class Customer {
	
	
	//fields
	private String custName;
	private ArrayList<Order> orderHistory;
	private int custID;
	private static int nextCustId = 1000; // static variable (it will be shared in all the objects)
	
	//constructors
	public Customer(String custName) {
		this.custName = custName;
		orderHistory = new ArrayList<Order>();
		custID = nextCustId;
		nextCustId++;
	}
	
	// methods
	//getters
	public String getName() {
		return custName;		
	}//end public String getName()
	
	public int getID() {
		return custID;
	}//end public int getID()
	
	public ArrayList<Order> getOrderHistory(){
		return orderHistory;
	}//end public ArrayList<Order> getOrderHistory()
	
	//setters
	public String setName (String custName) {
		this.custName = custName;
		return custName;
	}//end public String setName(String n)
	
	public void addToHistory(Order order) {
		orderHistory.add(order);
	}//end 	public void addToHistory(Order order)

}
