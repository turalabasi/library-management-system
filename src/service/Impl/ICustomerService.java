package service.Impl;

import Enums.ExceptionEnum;
import Enums.StatusEnum;
import Util.InputUtil;
import exception.BookNotFoundException;
import exception.CustomerNotFoundException;
import exception.EmptyListException;
import exception.WrongParameterException;
import globalData.GlobalData;
import helper.CustomerServiceHelper;
import helper.LibraryServiceHelper;
import model.Customer;
import service.CustomerService;

import static Util.InputUtil.*;
import static Util.InputUtil.inputRequiredInt;
import static globalData.GlobalData.customers;
import static globalData.GlobalData.libraries;
import static helper.CustomerServiceHelper.detailCustomer;
import static helper.CustomerServiceHelper.nowDate;



public class ICustomerService implements CustomerService {
    @Override
    public void register() {
        byte count = inputRequiredByte("enter the count");
        if (customers == null) {
            customers = new Customer[count];
            for (int i = 0; i < count; i++) {
                CustomerServiceHelper.helpRegister();
            }

            System.out.println(StatusEnum.REGISTER_SUCCESSFULLY);

        } else {
            Customer[] tempCustomer = customers;
            customers = new Customer[customers.length + count];
            for (int i = 0; i < customers.length; i++) {
                if (i < tempCustomer.length){
                    customers[i] = tempCustomer[i];
                }
                else
                {
                    CustomerServiceHelper.helpRegister();
                }
                System.out.println(StatusEnum.REGISTER_SUCCESSFULLY);

            }

        }

    }

    @Override
    public void show() {
        if (customers == null) {
            throw new EmptyListException(ExceptionEnum.EMPTY_LIST_EXCEPTION);
        }
        if (customers != null ) {

            for (Customer customer : customers) {
                System.out.println(customer.getInfo());
            }
            if (customers != null) {

                detailCustomer();
            }
        }
    }

    @Override
    public void search() {
        if (customers==null || customers.length==0)
            throw new EmptyListException(ExceptionEnum.EMPTY_LIST_EXCEPTION);
        else {
            String key = InputUtil.inputRequiredString("Search");
            boolean isFind = false;

            for (int i = 0; i < customers.length; i++) {
                if (customers[i].getSurname().contains(key) ||
                        customers[i].getName().contains(key)) {
                    isFind = true;
                    System.out.println(customers[i].toString());
                }

            }
            if (!isFind) {
                throw new CustomerNotFoundException(ExceptionEnum.CUSTOMER_NOT_FOUND);

            }
        }

    }

    @Override
    public boolean update() {
        if (customers == null && customers.length ==0)
            throw new EmptyListException(ExceptionEnum.EMPTY_LIST_EXCEPTION);
        long id = inputRequiredLong("enter the customer book id");
        boolean isTrue = false;

        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getId()==id){
                String parameter = inputRequiredString("Enter the customer parameters");
                String [] parameters = parameter.toLowerCase().split(",");

                for (String str:parameters) {
                    switch (str) {
                        case "name":
                            customers[i].setName(inputRequiredString("update the customer name"));
                            isTrue = true;
                            break;
                        case "surname":
                            customers[i].setSurname(inputRequiredString("update the  surname"));
                            isTrue = true;
                            break;
                        case "username":
                            customers[i].setUsername(inputRequiredString("Update usarname : "));
                            isTrue = true;
                            break;
                        case "bookId" :
                            customers[i].setBookId(inputRequiredInt("update bookId"));
                            break;
                        default :
                            throw new WrongParameterException(ExceptionEnum.WRONG_FORMAT);
                    }
                }

                if (isTrue) {
                    customers[i].setUpdateDate(nowDate());
                    System.out.println(StatusEnum.UPDATED_SUCCESFULLY);
                }

                else {
                    throw new CustomerNotFoundException(ExceptionEnum.CUSTOMER_NOT_FOUND);
                }}
        }

        return true;

    }

    @Override
    public boolean delete() {
        if (customers == null && customers.length == 0)
            throw new EmptyListException(ExceptionEnum.EMPTY_LIST_EXCEPTION);

        long id = inputRequiredLong("enter the delete book id");
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getId() == id) {
                Customer[] customers = GlobalData.customers;
                GlobalData.customers = new Customer[GlobalData.customers.length - 1];
                int k = 0;
                for (Customer customer : customers) {
                    if (customer.getId() == id) {
                        continue;
                    }
                    GlobalData.customers[k] = customer;
                    k++;

                }
                System.out.println(StatusEnum.DELETED_SUCCESSFULLY);
                return true;
            }
        }
        throw new CustomerNotFoundException(ExceptionEnum.CUSTOMER_NOT_FOUND);
    }

    @Override
    public void login() {
        String username = inputRequiredString("enter the usarname");
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getUsername().equals(username)) {
                System.out.println("Welcome to Library ");
            }
            if ( GlobalData.libraries[i].getStockStatus() == 1) {
                System.out.println(GlobalData.libraries[i].getInfo());
                LibraryServiceHelper.detailBook();
            }
            String bookName = inputRequiredString("enter the book name you want to rent");
            if (libraries[i].getName().equals(bookName)) {
                customers[i].setBookId(libraries[i].getId());
                libraries[i].setBookStatus(false);
                if (libraries[i].getCount() > 1){
                    libraries[i].setCount(libraries[i].getCount() - 1);

                }

        }


    }
}}
