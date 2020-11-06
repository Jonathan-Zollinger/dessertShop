package dessertShop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandyTest {
    Candy chocolateBar      = new Candy("darkchocolate",1,3.49);
    Candy chocolateChips    = new Candy("darkchocolate",3,3.49);
    Candy swissChocolate    = new Candy("darkchocolate",1,13.49);
    Candy caramelChew       = new Candy("caramel",0.5,5);
    Candy hersheyBar        = new Candy("crapChocholate",0.0125,1.29);

    @Test
    void getName() {
        Candy chocolate = new Candy("",2.219,5.4);
        assertEquals("",chocolate.getName());
    }

    @Test
    void setName() {
        Candy chocolate = new Candy("",2.219,5.4);
        chocolate.setName("chips");
        assertEquals("chips",chocolate.getName());
    }

    @Test
    void getCandyWeight() {
        Candy chocolate = new Candy("",2.219,5.4);
        assertEquals(2.219,chocolate.getCandyWeight());
    }

    @Test
    void setCandyWeight() {
        Candy chocolate = new Candy("",2.219,5.4);
        chocolate.setCandyWeight(0.54);
        assertEquals(0.54,chocolate.getCandyWeight());
    }

    @Test
    void getPricePerPound() {
        Candy chocolate = new Candy("",2.219,5.4);
        assertEquals(5.4,chocolate.getPricePerPound());
    }

    @Test
    void setPricePerPound() {
        Candy chocolate = new Candy("",2.219,5.4);
        chocolate.setPricePerPound(98.7);
        assertEquals(98.7,chocolate.getPricePerPound());
    }
    
    @Test
    void calculateCost() {
        Candy chocolate = new Candy("",1,100.0);
        assertEquals(100,chocolate.calculateCost());
    }
    @Test
    void calculateTax() {
        Candy chocolate = new Candy("darkchocolate",1,100);
        assertEquals(7.25,chocolate.calculateTax(),0.000001);
    }

    @Test
    void isSameAsReturnsTrue(){
        assertTrue(chocolateBar.isSameAs(chocolateChips));
    }

    @Test
    void isSameAsReturnsFalse(){
        assertFalse(chocolateBar.isSameAs(swissChocolate));
    }

}