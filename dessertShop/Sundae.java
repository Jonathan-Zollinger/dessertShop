package dessertShop;

public class Sundae extends IceCream {

	// fields
	private String toppingName;
	private double toppingPrice;

	// end of fields
	// Constructors
	public Sundae() {
		toppingName 	= "";
		toppingPrice 	= 0;
		setPackaging("");

	}

	public Sundae(String dessertName, //dessertName is an ice cream name
				  int aScoopCount,
				  double aScoopPrice,
				  String aToppingName, //name of the sundae
				  double aToppingPrice) {
		super(dessertName, aScoopCount, aScoopPrice);
		toppingName = aToppingName;
		toppingPrice = aToppingPrice;
		setPackaging("Boat");

		//setName(dessertName);

	}//public Sundae(String dessertName, String aToppingName, double aToppingPrice)


	// end of constructors
	// methods

	public String toString(){
		return String.format("%s Sundae (%s)\n%d Scoops of %s ice cream @ $%.2f/Scoop\n" +
						"\t%s topping @ $%.2f: \t$%.2f\t[Tax: $%.2f]\n",
				getToppingName(),
				getPackaging(),
				getScoopCount(),
				getName(),
				getPricePerScoop(),
				getToppingName(),
				getToppingPrice(),
				calculateCost(),
				calculateTax());
	}//end public String toString()

	public String getToppingName() {
		return toppingName;
	}// end public getName()

	public void setToppingName(String tn) {
		toppingName = tn;
	}

	public double getToppingPrice() {
		return toppingPrice;
	}// end public getName()

	public void setToppingPrice(double tp) {
		toppingPrice = tp;
	}
	
	public double calculateCost() {
		double cost;
		cost = super.calculateCost();
		cost += toppingPrice  ;
		return cost;
		
	}
	// end of methods
}
