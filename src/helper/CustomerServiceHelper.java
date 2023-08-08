package helper;

import Util.InputUtil;
import model.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static Util.MenuUtil.entryDetailCustomer;
import static globalData.GlobalData.customers;
import static globalData.GlobalData.libraries;


public class CustomerServiceHelper {
    static long id=0;
    static int customerCount=0;
    public static LocalDateTime nowDate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.withNano(0);
    }
    public static Customer fillCustomer() {
        try {
            String name = InputUtil.inputRequiredString("Enter the name");
            String surname = InputUtil.inputRequiredString("Enter the surname");
            String username = InputUtil.inputRequiredString("Enter the username");
            LocalDate birthdate = birthdayHelperService();
            LocalDateTime registerDate = nowDate();
            Long bookId = InputUtil.inputRequiredLong("enter the bookId");
            return new Customer(++id,name,surname,birthdate,username,bookId,registerDate,null);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());

        }
        return null;

    }
    public static void detailCustomer(){
        String detailCustomer = entryDetailCustomer();
        for (Customer customer: customers) {
            if (customer.getName().equals(detailCustomer)) {
                System.out.println(customer);
            }
        }
    }

    private static LocalDate birthdayHelperService() {
        try {
            String str1 = InputUtil.inputRequiredString("Enter the Local Date (day-month-years) : ");
            String[] str2 = str1.split("-");
            int years = Integer.parseInt(str2[0]);
            int month = Integer.parseInt(str2[1]);
            int day = Integer.parseInt(str2[2]);
            return LocalDate.of(day, month, years);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
        public static void helpRegister() {
            Customer customer = fillCustomer();
            if (customer != null) {
                customers[customerCount] = customer;
                customerCount++;
            }
        }

}




