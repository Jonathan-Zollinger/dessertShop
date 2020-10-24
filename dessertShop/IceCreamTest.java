package dessertShop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamTest {

    @Test
    void getName() {
        IceCream bananSplit = new IceCream("",2,4.0);
        assertEquals("",bananSplit.getName());
    }

    @Test
    void setName() {
        IceCream bananSplit = new IceCream("",2,4.0);
        bananSplit.setName("IceCream");
        assertEquals("IceCream",bananSplit.getName());
    }

    @Test
    void getScoopCount() {
        IceCream bananSplit = new IceCream("",2,4.0);
        assertEquals(2,bananSplit.getScoopCount());
    }

    @Test
    void setScoopCount() {
        IceCream bananSplit = new IceCream("",2,4.0);
        bananSplit.setScoopCount(2);
        assertEquals(2,bananSplit.getScoopCount());
    }

    @Test
    void getPricePerScoop() {
        IceCream bananSplit = new IceCream("",2,4.0);
        assertEquals(4,bananSplit.getPricePerScoop());
    }

    @Test
    void setPricePerScoop() {
        IceCream bananSplit = new IceCream("",2,4.0);
        bananSplit.setPricePerScoop(100);
        assertEquals(100,bananSplit.getPricePerScoop());
    }
    
    @Test
    void calculateCost() {
        IceCream chocolate = new IceCream("",2,2.5);
        assertEquals(5,chocolate.calculateCost());
    }
    @Test
    void calculateTax() {
        IceCream chocolate = new IceCream("darkchocolate",1,100);
        assertEquals(7.25,chocolate.calculateTax(),0.000001);
    }
}