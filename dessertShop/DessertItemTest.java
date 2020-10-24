package dessertShop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DessertItemTest {

    @Test
    void getName() {
        DessertItem milkyway = new Candy("candy", 2,2.0);
        assertEquals("candy",milkyway.getName());
    }

    @Test
    void setName() {
        DessertItem milkyway = new Candy("candy", 2,2.0);
        assertEquals("candy",milkyway.getName());
    }
    
    @Test
    void getTaxPercent() {
        DessertItem milkyway = new Candy("candy", 2,2.0);
        assertEquals(7.25,milkyway.getTaxPercent());
    }
    
    @Test
    void setTaxPercent() {
        DessertItem milkyway = new Candy("candy", 2,2.0);
        milkyway.setTaxPercent(6.25);
        assertEquals(6.25,milkyway.getTaxPercent());
    }
}