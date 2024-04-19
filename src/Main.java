// Author      : Pratham Gupta
// Description : Ice Cream Order Processing And Invoice Producing Assignment

// Imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    //*----------------------------------*
    // Variables used in the assignment where totalItems is kept 4 so its
    // more than itemNumber which doesn't matter as its going to be replaced later by user
    //*----------------------------------*
    private static int totalItems=4;
    private static int itemNumber=1;
    private static float totalPrice=0;


    // Introducing Scanner Class
    static Scanner scnr = new Scanner(System.in);


    public static void main(String[] args) throws IOException {

        // Order Type Menu Choice Variable
        int menuChoice = 0;

        //*-----------------------------------------------------------------*
        // Menu asking user for choosing between Manual or File type of order
        //*-----------------------------------------------------------------*
        while (menuChoice != 2) {
            displayMenu();
            menuChoice = getMenuChoice();

            //*------------------------------------------------------------------------*
            // Menu After the User selects Manual type of ordering
            // Using While loop and if statements connect users choice with right option
            //*------------------------------------------------------------------------*
            if      (menuChoice == 1) {
                int secondMenuChoice = 0;
                menuChoice++;
                System.out.println("How many items are you ordering?");
                //*----------------------------------------------*
                // User enters number of Items they want to order
                // Which is used to create a personalised array for
                // user's order
                //*----------------------------------------------*
                totalItems= scnr.nextInt();
                if(totalItems<0) {
                	System.out.println("!!!Invalid Choice!!!");
                	totalItems= scnr.nextInt();
                }
                String[] order = new String[totalItems];
                int orderNumber= 0;
                float[] orderPrice = new float[totalItems];


                if (totalItems<0 || totalItems>11) {
                    System.out.println("Please Choose a Valid Option");}

                while (secondMenuChoice != 12 && itemNumber<=totalItems && orderNumber<totalItems) {
                    secondDisplayMenu();
                    secondMenuChoice = getMenuChoice1();
                    //*-----------------------------------------------------------------------*
                    // Choices of user is converted to 2 separate arrays for item and its price
                    // Using float to get precision till two decimal->cents
                    //*-----------------------------------------------------------------------*
                    if      (secondMenuChoice == 1)
                    {
                        totalPrice=(float) (totalPrice+2.00);
                        order[orderNumber]= "SINGLE SCOOP";
                        orderPrice[orderNumber]= 2.00f;
                        itemNumber++;
                        orderNumber++;
                    }
                    else if (secondMenuChoice == 2){
                        totalPrice=(float) (totalPrice+3.50);
                        order[orderNumber]= "DOUBLE SCOOP";
                        orderPrice[orderNumber]= 3.50f;
                        itemNumber++;
                        orderNumber++;
                    }
                    else if (secondMenuChoice == 3){
                        totalPrice=(float) (totalPrice+4.00);
                        order[orderNumber]= "WAFFLE CONE";
                        orderPrice[orderNumber]= 4.00f;
                        itemNumber++;
                        orderNumber++;
                    }
                    else if (secondMenuChoice == 4){
                        totalPrice=(float) (totalPrice+5.00);
                        order[orderNumber]= "BANANA SPLIT";
                        orderPrice[orderNumber]= 5.00f;
                        itemNumber++;
                        orderNumber++;}
                    else if (secondMenuChoice == 5){
                        totalPrice=(float) (totalPrice+6.25);
                        order[orderNumber]= "TURTLE SUNDAE";
                        orderPrice[orderNumber]= 6.50f;
                        itemNumber++;
                        orderNumber++;}
                    else if (secondMenuChoice == 6){
                        totalPrice=(float) (totalPrice+4.00);
                        order[orderNumber]= "SHAKE";
                        orderPrice[orderNumber]= 4.00f;
                        itemNumber++;
                        orderNumber++;}
                    else if (secondMenuChoice == 7){
                        totalPrice=(float) (totalPrice+4.50);
                        order[orderNumber]= "MALT";
                        orderPrice[orderNumber]= 4.50f;
                        itemNumber++;
                        orderNumber++;}
                    else if (secondMenuChoice == 8){
                        totalPrice=(float) (totalPrice+5.00);
                        order[orderNumber]= "CONCRETE MALT";
                        orderPrice[orderNumber]= 5.00f;
                        itemNumber++;
                        orderNumber++;}
                    else if (secondMenuChoice == 9){
                        totalPrice=(float) (totalPrice+1.50);
                        order[orderNumber]= "SODA";
                        orderPrice[orderNumber]= 1.50f;
                        itemNumber++;
                        orderNumber++;}
                    else if (secondMenuChoice == 10){
                        totalPrice=(float) (totalPrice+3.20);
                        order[orderNumber]= "SODA FLOAT";
                        orderPrice[orderNumber]= 3.25f;
                        itemNumber++;
                        orderNumber++;}
                    else if (secondMenuChoice == 11){
                        totalPrice=(float) (totalPrice+3.75);
                        order[orderNumber]= "ICE CREAM SANDWICH";
                        orderPrice[orderNumber]= 3.75f;
                        itemNumber++;
                        orderNumber++;
                    }
                    else {
                        System.out.println("  !!! Invalid Menu Choice !!!");
                        System.out.println("  Please Choose Again");}
                }
                //*-----------------------------------------------------------------------*
                // Using Method named invoiceList which creates an invoice for the user
                // by getting an input of list of items and their corresponding prices
                // more on the working of method later.
                //*-----------------------------------------------------------------------*
                invoiceList(order,orderPrice);

                //*-----------------------------------------------------------------------*
                // Choice of Menu when user wants to enter their order via a file
                // This reads the file and writes invoice for the order taken via reading
                // the file
                //*-----------------------------------------------------------------------*
            }
            else if (menuChoice == 2) {
                System.out.println("Processing order from file. ");
                System.out.println("Please enter the filename: ");
                String fileName= scnr.next();                           // File name given by user
                int i=0;
                try {
                    //*-----------------------------------------------------------------------*
                    // Reading a the file whose name was given by user and transferring the data
                    // to a array whose length is measure by reading the first line of the file
                    // which is read by Buffered Reader while the whole while is read by Scanner
                    //*-----------------------------------------------------------------------*
                    File file= new File(fileName);  // File
                    // Scanning the File
                    Scanner scan = new Scanner(file);
                    // Using Buffered Reader
                    BufferedReader line1 = new BufferedReader(new FileReader(file));
                    // Scanning line 1 of file for index of array
                    String text = line1 .readLine();
                    // converting string taken from file to integer for index
                    int numberItems1= Integer.parseInt(text);
                    String[] orderFile = new String[numberItems1+2];
                    String row = scan.nextLine();
                    // Using while loop to scan the whole file
                    while (scan.hasNextLine()){
                        if (i>=numberItems1) {
                            break;
                        }
                        orderFile[i]= scan.nextLine();
                        i++;
                    }
                    //*-----------------------------------------------------------------------*
                    // Making new array minimizing the index of the array filled by file
                    // Making new price array and item array to provide base to create an invoice
                    //*-----------------------------------------------------------------------*
                    // New Price array
                    float[] priceList= new float[orderFile.length-2];
                    String[] order= new String[orderFile.length-2];
                    for(int m=0; m<orderFile.length-2;m++) {
                        order [m]=orderFile[m];
                        System.out.println("read "+ order[m]);
                    }
                    //*-----------------------------------------------------------------------*
                    // New Item array
                    // Comparing the data read from file with menu to make arrays with items and
                    // their corresponding prices
                    //*-----------------------------------------------------------------------*
                    String[] itemList= new String[order.length];
                    for(int o=0; o<order.length;o++) {
                        if (order[o].equalsIgnoreCase("singlescoop")) {
                            itemList[o] = "SINGLE SCOOP";
                            priceList[o] = 2.00f;
                        }
                        else if (order[o].equalsIgnoreCase("doublescoop")) {
                            itemList[o] = "DOUBLE SCOOP";
                            priceList[o] = 3.50f;
                        }
                        else if(order[o].equalsIgnoreCase("wafflecone")) {
                            itemList[o] = "WAFFLE CONE";
                            priceList[o] = 4.00f;
                        }
                        else if(order[o].equalsIgnoreCase("bananasplit")) {
                            itemList[o] = "BANANA SPLIT";
                            priceList[o] = 5.00f;
                        }
                        else if(order[o].equalsIgnoreCase("turtle")) {
                            itemList[o] = "TURTLE SUNDAE";
                            priceList[o] = 6.25f;
                        }
                        else if(order[o].equalsIgnoreCase("shake")) {
                            itemList[o] = "SHAKE";
                            priceList[o] = 4.00f;
                        }
                        else if(order[o].equalsIgnoreCase("malt")) {
                            itemList[o] = "MALT";
                            priceList[o] = 4.50f;
                        }
                        else if(order[o].equalsIgnoreCase("concrete")) {
                            itemList[o] = "CONCRETE MALT";
                            priceList[o] = 5.00f;
                        }
                        else if(order[o].equalsIgnoreCase("soda")) {
                            itemList[o] = "SODA";
                            priceList[o] = 1.50f;
                        }
                        else if(order[o].equalsIgnoreCase("float")) {
                            itemList[o] = "SODA FLOAT";
                            priceList[o] = 3.25f;
                        }
                        else if(order[o].equalsIgnoreCase("icesandwich")) {
                            itemList[o] = "ICE CREAM SANDWICH";
                            priceList[o] = 3.75f;
                        }
                        //*-----------------------------------------------------------------------*
                        // Making a different invoice for the file type order due to change in
                        // variables used by invoiceList method
                        // Using File to create a new file named invoice.txt
                        // Using PrintWriter to write all the data collected in Items and Price
                        // arrays to make the invoice
                        // As outf is output for file
                        //*-----------------------------------------------------------------------*
                        try {
                            File file1 = new File("invoice.txt");
                            PrintWriter outf = new PrintWriter(file1);
                            outf.println("");
                            outf.println("IMMEDIATE INDULGENCES ICE-CREAM ");
                            outf.println("---------------------------------");
                            // Printing the Data Collected
                            for(int ij=0; ij< order.length;ij++) {
                                outf.printf("%-19s -       $%.2f\n",itemList[ij],(priceList[ij]));

                            }
                            // Making a new total Price list by adding the Price data collected earlier
                            float totalPrice1=0;
                            for(int p=0; p<priceList.length;p++){
                                totalPrice1= totalPrice1+ priceList[p];
                            }
                            outf.println("---------------------------------");
                            // Subtotal
                            outf.printf( "%20.9s – %10.2f\n","Subtotal",totalPrice1);
                            // Tax- 5%
                            outf.printf( "%20.9s – %10.2f\n","Tax",totalPrice1*0.05);
                            // Total= Subtotal with tax
                            outf.printf( "%20.9s – %10.2f\n","Total",totalPrice1*(1.05));
                            outf.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        finally {

                        }
                    }

                }

                catch (FileNotFoundException exception) {
                    System.out.println("File not found.");}
            }

            else
                System.out.println("  !!! Invalid Menu Choice !!!");
        }

    }

    //*------------------------------------------------------------------*
    // Menu for giving the user the choice of manual or file type ordering
    //*-------------------------------------------------------------------*
    static void displayMenu() {
        System.out.println("Welcome to Immediate Indulgences Ice-Cream!");
        System.out.println("1) Manually process an order");
        System.out.println("2) Read an order from a file ");
    }

    //*---------------------------------------------------------------------------*
    // Scanning for the input user gave for the choice of manual or file type order
    //*---------------------------------------------------------------------------*
    static int getMenuChoice() {
        System.out.print("Would you like to:");
        return scnr.nextInt();
    }

    //*-----------------------------------------------------------------------*
    // Manual Order Processing Display Menu with Items and Prices List
    //*-----------------------------------------------------------------------*
    static void secondDisplayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Single Scoop Cone - $2.00");
        System.out.println("2. Double Scoop Cone - $3.50");
        System.out.println("3. Waffle Cone - $4.00");
        System.out.println("4. Banana Split - $5.00");
        System.out.println("5. Turtle Sundae - $6.25");
        System.out.println("6. Shake - $4.00");
        System.out.println("7. Malt - $4.50");
        System.out.println("8. Concrete Malt - $5.00");
        System.out.println("9. Soda - $1.50");
        System.out.println("10. Soda Float - $3.25");
        System.out.println("11.Ice Cream Sandwich - $3.75");

    }

    //*-----------------------------------------------------------------------*
    // Manual Order Processing Display Menu Item and Choice Number
    //*-----------------------------------------------------------------------*
    static int getMenuChoice1() {
        System.out.print("Please Choose Item #"+itemNumber+": ");
        return scnr.nextInt();
    }
    
    //*-----------------------------------------------------------------------*
    // INVOICE CREATING METHOD
    // Making a new file to contain the invoice information
    // Using PrintWriter to output the necessary items and corresponding price
    // list taken via Manual ordering to a file named invoice.txt
    //*-----------------------------------------------------------------------*
    static void invoiceList(String[] order, float[] orderPrice){

        try {
            File file = new File("invoice.txt");
            PrintWriter out = new PrintWriter(file);
            out.println("");
            out.println("IMMEDIATE INDULGENCES ICE-CREAM ");
            out.println("---------------------------------");
            // Creating list of Items and Price
            for(int i=0; i<itemNumber-1;i++) {
                out.printf("%-19s -       $%.2f\n",order[i],(orderPrice[i]));
                if (i==itemNumber-1) {i=10;}
            }
            out.println("---------------------------------");
            // Subtotal
            out.printf( "%20.9s – %10.2f\n","Subtotal",totalPrice);
            // Tax- 5%
            out.printf( "%20.9s – %10.2f\n","Tax",totalPrice*0.05);
            // Total= Subtotal with tax
            out.printf( "%20.9s – %10.2f\n","Total",totalPrice*(1.05));
            out.close();
        	} catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}