package dessertShop;

public class IceCream extends DessertItem {

	// fields
	private int scoopCount;
	private double pricePerScoop;

	// end of fields
	// Constructors
	public IceCream() {
		scoopCount = 0;
		pricePerScoop = 0;
		setPackaging("");

	}


	public IceCream(String aName, int aScoopCount, double aPricePerScoop) {
		super(aName);
		scoopCount = aScoopCount;
		pricePerScoop = aPricePerScoop;
		setPackaging("Bowl");
		//setName(aName);
	}// end public IceCream(String aName, int aScoopCount, double aPricePerScoop)

	// end of constructors
	// methods

	public String toString(){
		return String.format("%s Ice Cream (%s)\n\t%-3d Scoops @ $%.2f/Scoop.: \t\t$%.2f\t[Tax: $%.2f]\n",
				getName(),
				getPackaging(),
				getScoopCount(),
				getPricePerScoop(),
				calculateCost(),
				calculateTax());
	}//end public String toString()

	public int getScoopCount() {
		return scoopCount;
	}// end public getName()

	public void setScoopCount(int sc) {
		scoopCount = sc;
	}

	public double getPricePerScoop() {
		return pricePerScoop;
	}// end public getName()

	public void setPricePerScoop(double pps) {
		pricePerScoop = pps;
	}
	
	public double calculateCost() {
		double cost;
		cost = scoopCount * pricePerScoop ;
		return cost;
		
	}


	// end of methods

}
