package Util;

import static Util.InputUtil.inputRequiredByte;
import static Util.InputUtil.inputRequiredString;

public class MenuUtil {
    public static byte entryApp (){

        System.out.println(
                "[1] - > Register \n" +
                        "[2] - > Show \n" +
                        "[3] - > Search \n" +
                        "[4] - > Update \n" +
                        "[5] - > Delete \n" +
                        "[6] - > StorageToStock \n" +
                        "[7] - > Customer Register \n" +
                        "[8] - > Customer Show \n" +
                        "[9] - > Customer Search \n" +
                        "[10] - > Customer Update \n" +
                        "[11] - > Customer Delete \n" +
                        "[12] - > Customer Login \n"  );
        return inputRequiredByte("" + "Enter the option");

    }

    public static byte entryAppCustomer () {

        System.out.println(
                "[1] - > Register \n" +
                        "[2] - > Library Show \n" +
                        "[3] - > Library Search \n" +
                        "[4] - > Library Update \n" +
                        "[5] - > Library Delete \n" +
                        "[6] - > Library StorageToStock \n" +
                        "[7] - > Customer Register \n" +
                        "[8] - > Customer Show \n" +
                        "[9] - > Customer Search \n" +
                        "[10] - > Customer Update \n" +
                        "[11] - > Customer Delete \n" +
                        "[12] - > Customer Login \n"  );
        return inputRequiredByte("" + "Enter the option");
    }


    public static byte entryShow(){
             System.out.println(""" 
                                [1] - > Storage
                                [2] - > Stocks
                                """ );

        return inputRequiredByte("Enter the option");
    }

    public static String entryDetail(){
        System.out.println("Detailed information book! ");
        return inputRequiredString("Enter the book name");
    }
    public static String entryDetailCustomer(){
        System.out.println("Detailed information customer! ");
        return inputRequiredString("Enter the customer name");
    }

    public static byte entrySearch(){
        System.out.println("""
                [1] - > Name
                [2] - > Author
                [3] - > Genre
                """);
        return inputRequiredByte("Enter the option search");
    }
    
}
