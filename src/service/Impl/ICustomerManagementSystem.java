package service.Impl;

import Enums.ExceptionEnum;
import exception.*;
import service.CustomerManagementSystem;
import service.CustomerService;
import service.LibraryService;

import java.util.InputMismatchException;

import static Util.MenuUtil.entryApp;
import static Util.MenuUtil.entryAppCustomer;

//public class ICustomerManagementSystem implements CustomerManagementSystem {
//    @Override
//    public void management() {
//        while (true){ try {
//            byte choice= entryAppCustomer();
//            CustomerService customerService =new ICustomerService();
//            switch (choice) {
//                case 1:
//                    customerService.register();
//                    break;
//                case 2:
//                    customerService.show();
//                    break;
//                case 3:
//                    customerService.search();
//                    break;
//                case 4:
//                    customerService.update();
//                    break;
//                case 5:
//                    customerService.delete();
//                    break;
//                case 6:
//                    customerService.login();
//                default:
//                    throw new InvalidOptionExceptions(ExceptionEnum.INVALID_OPTION_EXCEPTION);
//            }
//        } catch (InvalidOptionExceptions | InvalidException | CustomerNotFoundException | EmptyListException
//                  e){
//            System.err.println(e.getMessage());
//
//        }
//
//        }
//
//    }
//}
