package dessertShop;

import java.util.Collections;
import java.util.Scanner;

import dessertShop.Payable.PayType;

public class DessertShop {
    public static void main(String[] args){
        Order sale = new Order();
        Order order1 = new Order();
        String paymentMethod; //I think this should be of a PayType class.

        Scanner sIn = new Scanner(System.in);
        String choice;
        DessertItem orderItem;

        boolean done = false;
        order1.add(new Candy(
                "Candy Corn",
                1.5,
                0.25));
        order1.add(new Candy(
                "Gummy Bears",
                .25,
                .35));
        order1.add(new Cookie(
                "Chocolate Chip",
                6,
                3.99));
        order1.add(new IceCream(
                "Pistachio",
                2,
                .79));
        order1.add(new Sundae(
                "Vanilla",
                3,
                .69,
                "Hot Fudge",
                1.29));
        order1.add(new Cookie(
                "Oatmeal Raisin",
                2,
                3.45));
        while (!done) {
            System.out.println("\n1: Candy");
            System.out.println("2: Cookie");
            System.out.println("3: Ice Cream");
            System.out.println("4: Sunday");

            System.out.print("\nWhat would you like to add to the order? (1-4, Enter for done): ");
            choice = sIn.nextLine();

            if (choice.equals("")) {
                done = true;
            } else {
                switch (choice) {
                    case "1":
                        orderItem = userPromptCandy();
                        order1.add(orderItem);
                        break;
                    case "2":
                        orderItem = userPromptCookie();
                        order1.add(orderItem);
                        break;
                    case "3":
                        orderItem = userPromptIceCream();
                        order1.add(orderItem);
                        break;
                    case "4":
                        orderItem = userPromptSundae();
                        order1.add(orderItem);
                        break;
                }//end of switch (choice)
            }//end of if (choice.equals(""))
        }//end of while (!done)
        System.out.println("\n");
        
        //Sorting the list         
        Collections.sort(order1.getOrderList());
        
        
        //asking the user the payment method
        String answer = askForPaymentMethod();
        answer = answer.toUpperCase();
        
        PayType enumanswer =  PayType.valueOf(answer);
        
        order1.setPayType(enumanswer);
        
        System.out.print(order1.toString());

//        //print all the names of the dessert items
//        for (DessertItem item : sale.getOrderList()) {
//        	System.out.printf("%-25s$%-8.2f[Tax: $%.2f]\n", item.getName(), item.calculateCost(), item.calculateTax());
//
//        }
//
//        System.out.println("------------------------------------------------------");
//
//        System.out.printf("Order subtotals: $%-8.2f[Tax: $%.2f]\n", sale.orderCost(),sale.orderTax());
//
//        System.out.printf("Order Total: $%-8.2f\n", sale.orderCost() + sale.orderTax());
//
//        //print the total number of items
//        System.out.printf("%nTotal number of items in order: %d",sale.itemCount());


    } //end public static void main(String[] args)

    private static String askForPaymentMethod(){
        //add variables
        Scanner sIn = new Scanner(System.in);
        String response = "this is to be replaced";
        boolean isValid = false;

        //ask for input
        while(!isValid) {
            print("What form of payment will be used? (CASH, CARD, PHONE):", false);
            response = sIn.nextLine();

            //validate input

            for(Payable.PayType payment: Payable.PayType.values()){
                if (payment.toString().equalsIgnoreCase(response)){
                    isValid = true;
                }//if (payment.toString().equalsIgnoreCase(response))
            }//for(Payable.PayType payment: Payable.PayType.values())
            if (!isValid){
                print("That's not a valid form of payment.",false);
            }//if (!isValid)
        }//while(!isValid) (input validation)

        return response;
    }

    private static void print(String printMe, boolean isPrintLine){
        if (isPrintLine) {
            System.out.println(printMe);
        }else{
            System.out.print(printMe);
        }
    }//private static void print(String printMe, boolean isPrintLine){


    private static double getValidDouble(String prompt, String error){
        //create variables
        double value = 0;
        boolean done;
        Scanner scan = new Scanner(System.in);
        String response;

        //ask for input
        do{
            done = false;
            print(prompt,true);
            response = scan.nextLine();
            try{
                value = Double.parseDouble(response);
                done = true;
            }catch(Exception e){
                print(error,true);
            }
        }while(!done);
        return value;

    }//private static double getValidDouble(String prompt, String error)

    private static int getValidInt(String prompt, String error){
        //create variables
        int value = 0;
        boolean done;
        Scanner scan = new Scanner(System.in);
        String response;

        //ask for input
        do{
            done = false;
            print(prompt,true);
            response = scan.nextLine();
            try{
                value = Integer.parseInt(response);
                done = true;
            }catch(Exception e){
                print(error,true);
            }
        }while(!done);
        return value;

    }//private static double getValidDouble(String prompt, String error)

    private static DessertItem userPromptCandy(){
        //define variables
        Scanner scan    = new Scanner(System.in);
        String nameQ    = "Enter the type of candy: ";
        String weightQ  = "Enter the weight purchased: ";
        String priceQ   = "Enter the price per pound: ";
        String nmbrErr  = "please enter a valid number";
        String name;
        Double candyweight, priceperpound;
        //Candy candy     = new Candy();

        //ask for name
        print(nameQ,true);
        name = scan.nextLine();
        //candy.setName(scan.nextLine());

        //ask for weight
        candyweight = getValidDouble(weightQ,nmbrErr);
        //candy.setCandyWeight(getValidDouble(weightQ,nmbrErr));

        //ask for price
        priceperpound = getValidDouble(priceQ,nmbrErr);
        //candy.setPricePerPound(getValidDouble(priceQ,nmbrErr));
        
        Candy candy = new Candy(name,candyweight,priceperpound);

        return candy;
    }//end private static DessertItem userPromptCandy()

    private static DessertItem userPromptCookie(){
        //define variables
        Scanner scan    = new Scanner(System.in);
        String nameQ    = "Enter the type of cookie: ";
        String countQ  = "Enter the quantity purchased: ";
        String priceQ   = "Enter the price per dozen: ";
        String nmbrErr  = "please enter a valid number";
        String name;
        int cookieqty;
        double priceperdz;
        //Cookie cookie   = new Cookie();

        //ask for name
        print(nameQ,true);
        name = scan.nextLine();
        //cookie.setName(scan.nextLine());

        //ask for count
        cookieqty = getValidInt(countQ,nmbrErr);
        //cookie.setCookieQuantity(getValidInt(countQ,nmbrErr));

        //ask for price
        priceperdz = getValidDouble(priceQ,nmbrErr);
        //cookie.setPricePerDozen(getValidDouble(priceQ,nmbrErr));
        
        Cookie cookie   = new Cookie(name,cookieqty,priceperdz);

        return cookie;

    }//end private static DessertItem userPromptCookie()

    private static DessertItem userPromptIceCream(){
        //define variables
        Scanner scan    = new Scanner(System.in);
        String nameQ    = "Enter the type of Ice Cream: ";
        String countQ  = "Enter the scoop count purchased: ";
        String priceQ   = "Enter the price per scoop: ";
        String nmbrErr  = "please enter a valid number";
        String name;
        int scoopcnt;
        double priceperscp;
        //IceCream icecream = new IceCream();

        //ask for name
        print(nameQ,true);
        name = scan.nextLine();
        //icecream.setName(scan.nextLine());

        //ask for count
        scoopcnt = getValidInt(countQ,nmbrErr);
        //icecream.setScoopCount(getValidInt(countQ,nmbrErr));

        //ask for price
        priceperscp = getValidDouble(priceQ,nmbrErr);
        //icecream.setPricePerScoop(getValidDouble(priceQ,nmbrErr));
        
        IceCream icecream = new IceCream(name,scoopcnt,priceperscp);

        return icecream;

    }//end private static DessertItem userPromptIceCream(){

    private static DessertItem userPromptSundae(){
        //define variables
        Scanner scan        = new Scanner(System.in);
        String nameQ        = "Enter the type of Ice Cream: ";
        String countQ       = "Enter the scoop count purchased: ";
        String iceCrmPrice  = "Enter the price per scoop: ";
        String toppingsQ    = "Enter the type of topping: ";
        String priceQ       = "Enter the price of the topping: ";
        String nmbrErr      = "please enter a valid number";
        String name, topname;
        int scoopcnt;
        double priceperscp, topprice;
        //Sundae sundae       = new Sundae();

        //ask for the ice cream name
        print(nameQ,true);
        name = scan.nextLine();
        //sundae.setName(scan.nextLine());

        //ask for the ice cream count
        scoopcnt = getValidInt(countQ,nmbrErr);
        //sundae.setScoopCount(getValidInt(countQ,nmbrErr));

        //ask for the price per scoop
        priceperscp = getValidDouble(iceCrmPrice,nmbrErr);
        //sundae.setPricePerScoop(getValidDouble(iceCrmPrice,nmbrErr));

        //ask for the topping name
        print(toppingsQ,true);
        topname = scan.nextLine();
        //sundae.setToppingName(scan.nextLine());

        //ask for the topping price
        topprice = getValidDouble(priceQ,nmbrErr);
        //sundae.setToppingPrice(getValidDouble(priceQ,nmbrErr));
        
        Sundae sundae = new Sundae(name,scoopcnt,priceperscp,topname,topprice);

        return sundae;
    }//end private static DessertItem userPromptSundae(){


}//end public class DessertShop
