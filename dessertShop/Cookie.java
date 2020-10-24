package dessertShop;

public class Cookie extends DessertItem {

	// fields
	private int cookieQuantity;
	private double pricePerDozen;

	// end of fields
	// Constructors
	public Cookie() {
		cookieQuantity = 0;
		pricePerDozen = 0;
		setPackaging("");
	}

	public Cookie(String aName, int aCookieQuantity, double aPricePerDozen) {
		super(aName);
		cookieQuantity = aCookieQuantity;
		pricePerDozen = aPricePerDozen;
		setPackaging("Box");
		//setName(aName);
	}//public Cookie(String aName,int aCookieQuantity, double aPricePerDozen)

	// end of constructors
	// methods

	public String toString(){
		return String.format("%s Cookies (%s)\n\t%-45d cookies @ $%.2f/dozen.: \t\t$%.2f\t[Tax: $%.2f]\n",
				getName(),
				getPackaging(),
				getCookieQuantity(),
				getPricePerDozen(),
				calculateCost(),
				calculateTax());
	}//end public String toString()

	public int getCookieQuantity() {
		return cookieQuantity;
	}// end public getName()

	public void setCookieQuantity(int cookieQuantity) {
		this.cookieQuantity = cookieQuantity;
	}

	public double getPricePerDozen() {
		return pricePerDozen;
	}// end public getName()

	public void setPricePerDozen(double pricePerDozen) {
		this.pricePerDozen = pricePerDozen;
	}
	
	public double calculateCost() {
		double cost;
		cost = cookieQuantity * (pricePerDozen/12) ;
		return cost;
		
	}


	// end of methods

}
