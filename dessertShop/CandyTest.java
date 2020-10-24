package dessertShop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandyTest {

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

}