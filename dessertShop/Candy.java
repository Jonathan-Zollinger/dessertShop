package dessertShop;

public class Candy extends DessertItem implements SameItem{

	// fields
	private double candyWeight, pricePerPound;

	// end of fields
	// Constructors
	public Candy() {
		candyWeight = 0;
		pricePerPound = 0;
		setPackaging("");
	}

	public Candy(String aName, double aCandyWeight, double aPricePerPound) {
		super(aName);
		candyWeight = aCandyWeight;
		pricePerPound = aPricePerPound;
		setPackaging("Bag");
		//setName(aName);
	}// end public Candy(String aName, double aCandyWeight, double aPricePerPound)

	// end of constructors
	// methods

	public String toString(){
		String numerator = " lbs @ $";
		return String.format("%s (%s)\n\t%-3.2f%-10s%.2f/lb.: \t\t$%.2f\t[Tax: $%.2f]\n",
				getName(),
				getPackaging(),
				getCandyWeight(),
				numerator,
				getPricePerPound(),
				calculateCost(),
				calculateTax());
	}//end public String toString()

	public double getCandyWeight() {
		return candyWeight;
	}// end public getName()

	public void setCandyWeight(double candyWeight) {
		this.candyWeight = candyWeight;
	}

	public double getPricePerPound() {
		return pricePerPound;
	}// end public getName()

	public void setPricePerPound(double pricePerPound) {
		this.pricePerPound = pricePerPound;
	}
	
	public double calculateCost() {
		double cost;
		cost = candyWeight * pricePerPound;
		return cost;
		
	}

	public boolean isSameAs(Candy other) {
		if(this.getPricePerPound() == other.pricePerPound
				&& this.getName().equalsIgnoreCase(other.getName())){
			return true;
		}else{
			return false;
		}
	}//end public boolean isSameAs(Candy other)

	@Override
	public boolean isSameAs(Object other) {
		return false;
	}

	// end of methods

}
