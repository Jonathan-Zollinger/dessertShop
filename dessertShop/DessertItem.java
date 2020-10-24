package dessertShop;

public abstract class DessertItem implements Packaging , Comparable<DessertItem>{

	// fields
	private String name;
	private double taxPercent = 7.25;
	private String packaging;

	// end of fields
	// Constructors
	public DessertItem() {
		name = "";
	}

	public DessertItem(String name) {
		this.name = name;
	}
	// end of constructors
	// methods

	public String getName() {
		return name;
	}// end public getName()

	public void setName(String name) {
		this.name = name;
	}

	public double getTaxPercent() {
		return taxPercent;
	}

	public void setTaxPercent(double taxPercent) {
		this.taxPercent = taxPercent;
	}

	public double calculateTax() {
		double tax;
		tax = calculateCost() * (taxPercent/100);
		return tax;

	}

	public abstract double calculateCost();
	
	public String getPackaging() {
		return packaging;
	}
	
	public String setPackaging(String packaging) {
		this.packaging = packaging;
		return packaging;
	}
	
	/*public int compareTo(DessertItem dessertItem, DessertItem dessertItem2) {
		if (dessertItem1.calculateCost() < dessertItem2.calculateCost()) return -1; 
        if (dessertItem1.calculateCost() > dessertItem2.calculateCost()) return 1; 
        else return 0; 
		
	}*/
	public int compareTo(DessertItem dessertItem1) {
		if (this.calculateCost() < dessertItem1.calculateCost()) return -1; 
        if (this.calculateCost() > dessertItem1.calculateCost()) return 1; 
        else return 0; 
		
	}
     

	// end of methods

}
