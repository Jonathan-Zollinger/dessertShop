package dessertShop;

import java.util.*;

import dessertShop.Payable.PayType;

public class DessertShop {
	
	private static HashMap<String,Customer> customerDB = new HashMap<String,Customer>();
    private static Scanner sIn = new Scanner(System.in);
    private static String lines = "---------------------------------------------------------";
	
    public static void main(String[] args){
        
    	
    	boolean closed = false;
    	
    	while (!closed) {
			//Order sale = new Order();
			Order order = new Order();
			String paymentMethod; //I think this should be of a PayType class.
			String choice;
			DessertItem orderItem;
			boolean done = false;
			order.add(new Candy("Candy Corn", 1.5, 0.25));
			order.add(new Candy("Gummy Bears", .25, .35));
			order.add(new Cookie("Chocolate Chip", 6, 3.99));
			order.add(new IceCream("Pistachio", 2, .79));
			order.add(new Sundae("Vanilla", 3, .69, "Hot Fudge", 1.29));
			order.add(new Cookie("Oatmeal Raisin", 2, 3.45));
			Customer Abe = new Customer("Abe");
			Customer George = new Customer("George");
			Customer Alfonso = new Customer("Alfonso");
			customerDB.put("George",George);
			customerDB.put("Alfonso",Alfonso);
            customerDB.put("Abe",Abe);
            Order expensive = new Order();
            expensive.add(new IceCream("Dona Chonita", 100,100));
            Abe.addToHistory(expensive);
            int count = 0;
            while(count < 2){
                George.addToHistory(order);
                Alfonso.addToHistory(order);
                count ++;
            }
            Alfonso.addToHistory(order);
			while (!done) {
				System.out.println("\n1: Candy");
				System.out.println("2: Cookie");
				System.out.println("3: Ice Cream");
				System.out.println("4: Sunday");
				System.out.println("5: Admin Module");

				System.out.print("What would you like to add to the order? (1-4, Enter for done): ");
				choice = sIn.nextLine();

				if (choice.equals("")) {
					done = true;
				} else {
					switch (choice) {
					case "1":
						orderItem = userPromptCandy();
						order.add(orderItem);
						break;
					case "2":
						orderItem = userPromptCookie();
						order.add(orderItem);
						break;
					case "3":
						orderItem = userPromptIceCream();
						order.add(orderItem);
						break;
					case "4":
						orderItem = userPromptSundae();
						order.add(orderItem);
						break;
                    case "5":
                        adminModule();
						break;
					}//end of switch (choice)
				} //end of if (choice.equals(""))
			} //end of while (!done)
			System.out.println("\n");
			//Sorting the list         
			Collections.sort(order.getOrderList());
			
			//asking for customer name
			//boolean isAdded = false;
			System.out.println("Enter the customer name: ");
			String name = sIn.nextLine();
			Customer customer;
			try {
				customer = customerDB.get(name);
				customer.addToHistory(order);
				
			}catch(Exception e){
				customer = new Customer (name);
				customer.addToHistory(order);
				customerDB.put(name, customer);
			}
			
			
			/*for(String customer : customerDB.keySet()) {
				if (customer.equalsIgnoreCase(name)) {
					isAdded = true;
				}
			}
			if(!isAdded) {
				Customer 
				customerDB.put(name, customerObj);
			}*/
			
			
			//asking the user the payment method
			String answer = askForPaymentMethod();
			answer = answer.toUpperCase();
			PayType enumanswer = PayType.valueOf(answer);
			order.setPayType(enumanswer);
			System.out.print(order.toString());
			System.out.println("\n\n---------------------------------------------------------\n");
			System.out.printf("Customer Name: %s \t Customer ID: %d     Total orders: %d", 
					customer.getName(),
					customer.getID(),
					customer.getOrderHistory().size());
			System.out.println("\nHit enter to start a new order");
			sIn.nextLine();
			
		}

    } //end public static void main(String[] args)

    private static void adminModule(){
        //define objects
        boolean done = false;
        String prompt =
        "\n1: Shop Customer List\n"
        +"2: Customer Order History\n"
        +"3: Best Customer\n"
        +"4: Exit Admin Module\n"
        +"What would you like to do? (1-4):";

        while(!done){
            System.out.print(prompt);
            String choice = sIn.nextLine();
            switch (choice) {
                case "1":
                    //customer list
                    printCustomerList();
                    break;
                case "2":
                    //customer order history
                    printCustomerHistory();
                    break;
                case "3":
                    //best customer
                    getBestCustomer();
                    break;
                case "4":
                    //exit admin module
                    done = true;
            }//end  switch (choice)
        }//end else
    }//end private static void adminModule()

    private static void printCustomerList(){
        String header1 = "Customer Name: ";
        String header2 = "Customer ID:";
        for(String name : customerDB.keySet()){
            print(String.format(
                    "%s%-15s%s%d",
                    header1,
                    name,
                    header2,
                    customerDB.get(name).getID()),
                    true);
        }//end for(String name : customerDB.keySet())
    }//end private static void printCustomerList()

    private static void printCustomerHistory(){
        //set values
        String prompt = "Enter the name of the customer:";
        String nameHeader = "Customer Name: ";
        String idHeader = "Customer ID: ";
        //String receiptHeader = "-------------------------Receipt-------------------------";
        String orderHeader = "Order #: ";
        print(prompt,false);
        String name = sIn.nextLine();
        Customer customer = customerDB.get(name);
        //print the main header
        print("ln",false);
        print(String.format(
                "%s%-15s%s%d",
                nameHeader,
                name,
                idHeader,
                customer.getID()),
                true);
        print(lines,true);
        int count = 1;
        //printing orders
        for (Order order:customer.getOrderHistory()) {
            print(String.format(
                    "%s%d%n%s",
                    orderHeader,
                    count,
                    //receiptHeader,
                    order.toString()
            ), true);
            print("\n",true);
            count++;
        }//end for (Order order:customer.getOrderHistory())
    }//end private static void printCustomerHistory()

    private static void getBestCustomer(){
        String winner = "";
        double total = 0;
        int winCount = 0;
        for(Customer customer: customerDB.values()) {
            double thisTotal = 0;
            int orderCount = 0;
            for (Order order : customer.getOrderHistory()) {
                thisTotal = thisTotal + order.orderCost();
                orderCount = orderCount +1;
            }
            if (thisTotal > total){
                total = thisTotal;
                winner = customer.getName();
                winCount = orderCount;
            }
        }//end for(Customer customer: customerDB.values())
        print(String.format("\nThe Dessert Shop's most valued customer is: %s!",winner),true);
        print(String.format("%s spent $%.2f over %d order(s)!",winner,total,winCount),true);
    }// end private static void getBestCustomer()

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
    }//end private static DessertItem userPromptSundae()


}//end public class DessertShop
