package dessertShop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CookieTest {

    Cookie oatmealRaisin    = new Cookie("oatmeal",2,4.2);
    Cookie oatmealCranberry = new Cookie("oatmeal",5,4.2);
    Cookie oatmealShrimp    = new Cookie("oatmeal",5,10);


    @Test
    void getName() {
        Cookie chocolateChip = new Cookie("",2,4.2);

        assertEquals("",chocolateChip.getName());
    }

    @Test
    void setName() {
        Cookie chocolateChip = new Cookie("",2,4.2);
        chocolateChip.setName("double chocolate");
        assertEquals("double chocolate",chocolateChip.getName());
    }

    @Test
    void getCookieQuantity() {
        Cookie chocolateChip = new Cookie("",2,4.2);
        assertEquals(2,chocolateChip.getCookieQuantity());
    }

    @Test
    void setCookieQuantity() {
        Cookie chocolateChip = new Cookie("",2,4.2);
        chocolateChip.setCookieQuantity(11);
        assertEquals(11,chocolateChip.getCookieQuantity());
    }

    @Test
    void getPricePerDozen() {
        Cookie chocolateChip = new Cookie("",2,4.2);
        assertEquals(4.2,chocolateChip.getPricePerDozen());
    }

    @Test
    void setPricePerDozen() {
        Cookie chocolateChip = new Cookie("",2,4.2);
        chocolateChip.setPricePerDozen(100.2);
        assertEquals(100.2,chocolateChip.getPricePerDozen());
    }
    
    @Test
    void calculateCost() {
        Cookie chocolate = new Cookie("",12,2.5);
        assertEquals(2.5,chocolate.calculateCost(),0.0000001);
    }
    @Test
    void calculateTax() {
        Cookie chocolate = new Cookie("darkchocolate",12,100);
        assertEquals(7.25,chocolate.calculateTax(),0.000001);
    }

    @Test
    void isSameAsReturnsTrue(){
        assertTrue(oatmealRaisin.isSameAs(oatmealCranberry));
    }

    @Test
    void isSameAsReturnsFalse(){
        assertFalse(oatmealShrimp.isSameAs(oatmealCranberry));
    }

}