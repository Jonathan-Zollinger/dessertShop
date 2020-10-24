package dessertShop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SundaeTest {

    @org.junit.jupiter.api.Test
    void getScoopCount() {
        Sundae fudgeSundae = new Sundae("",2,4.0,"Fudge", 5);
        assertEquals(2,fudgeSundae.getScoopCount());
    }//end void getScoopCount()

    @org.junit.jupiter.api.Test
    void setScoopCount() {
        Sundae fudgeSundae = new Sundae("",2,4.0,"Fudge", 5);
        fudgeSundae.setScoopCount(2);
        assertEquals(2,fudgeSundae.getScoopCount());
    }//end void setScoopCount()

    @org.junit.jupiter.api.Test
    void getToppingPrice() {
        Sundae fudgeSundae = new Sundae("",2,4.0,"Fudge", 5);
        assertEquals(5,fudgeSundae.getToppingPrice());
    }//end void getPricePerScoop()

    @org.junit.jupiter.api.Test
    void setToppingPrice() {
        Sundae fudgeSundae = new Sundae("",2,4.0,"Fudge", 5);
        fudgeSundae.setPricePerScoop(100);
        assertEquals(100,fudgeSundae.getPricePerScoop());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        Sundae fudgeSundae = new Sundae("",2,4.0,"Fudge", 5);
        assertEquals("",fudgeSundae.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        Sundae fudgeSundae = new Sundae("",2,4.0,"Fudge", 5);
        fudgeSundae.setName("sundae");
        assertEquals("sundae",fudgeSundae.getName());
    }

    @org.junit.jupiter.api.Test
    void getToppingName() {
        Sundae fudgeSundae = new Sundae("",2,4.0,"Fudge", 5);
        assertEquals("Fudge",fudgeSundae.getToppingName());
    }

    @org.junit.jupiter.api.Test
    void setToppingName() {
        Sundae fudgeSundae = new Sundae("",2,4.0,"Fudge", 5);
        fudgeSundae.setToppingName("not fudge");
        assertEquals("not fudge",fudgeSundae.getToppingName());
    }
    
    @Test
    void calculateCost() {
        Sundae chocolate = new Sundae("",3,2.0,"fudge",4.0);
        assertEquals(10.0,chocolate.calculateCost());
    }
    @Test
    void calculateTax() {
        Sundae chocolate = new Sundae("darkchocolate",3,20.0,"fudge",40.0);
        assertEquals(7.25,chocolate.calculateTax(),0.000001);
    }

}