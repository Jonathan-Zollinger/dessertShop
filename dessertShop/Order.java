package dessertShop;

import java.util.ArrayList;

public class Order implements Payable {

	// fields
	private ArrayList<DessertItem> order;
	private	PayType payMethod;

	// end of fields
	// Constructors
	public Order() {
		payMethod = PayType.CASH;
		order = new ArrayList<DessertItem>();
	}// end public Order()

	// end of constructors

	// methods
	public String toString(){
		String finalOutput = "";
		finalOutput += "------------------------Receipt-------------------\n";
		for(DessertItem sale: order){
			finalOutput += sale.toString();
		}//end for(DessertItem sale: order)
		String lines = "--------------------------------------------------\n";
		finalOutput += lines;
		String totals = String.format("Total number of items in order: %8d\n" +
				"Order Subtotals:\t\t$%.2f\t[Tax: $%.2f]\n" +
				"Order Total:\t\t\t$%.2f\n",
				itemCount(),
				orderCost(),
				orderTax(),
				orderTax()+orderCost());
		finalOutput += totals;
		finalOutput += lines;
		finalOutput += String.format("Paid for with %s",payMethod);
		return finalOutput;
	}//end public String toString()

	public ArrayList<DessertItem> getOrderList() {
		return order;
	}// end public ArrayList<DessertItem> getOrderList()

	public DessertItem add(DessertItem dessert) {
		try {
			order.add(dessert);
		} catch (Exception e) {
			System.out.printf("failed to add %s to the order", dessert.toString());
		} // end try / catch order.add(dessert);
		return dessert;
	}// end public DessertItem add(DessertItem dessert)

	public int itemCount() {
		return order.size();
	}// public int itemCount()

	public double orderCost() {
		double total = 0;
		for (DessertItem sale : order) {
			total += sale.calculateCost();
		}
		return total;
	}//public double orderCost()

	public double orderTax() {
		double totalTax = 0;
		for (DessertItem sale : order) {
			totalTax += sale.calculateTax();

		}
		return totalTax;
	}//public double orderTax()

	public PayType getPayType(){
		return payMethod;
	}//end public PayType getPayType()

	@Override
	public PayType setPayType(PayType payment) {
		payMethod = payment;
		return	payMethod;
	}

	//end of methods


}// end public class Order
