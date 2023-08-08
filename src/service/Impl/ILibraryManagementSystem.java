package service.Impl;

import Enums.ExceptionEnum;
import exception.BookNotFoundException;
import exception.InvalidException;
import exception.InvalidOptionExceptions;
import service.CustomerManagementSystem;
import service.CustomerService;
import service.LibraryManagementSystem;
import service.LibraryService;

import java.util.InputMismatchException;

import static Util.MenuUtil.entryApp;
import static Util.MenuUtil.entryAppCustomer;

public class ILibraryManagementSystem implements LibraryManagementSystem {

    @Override
    public void management() {
        while (true){ try {
            byte option=entryApp();
            LibraryService libraryService =new IlibraryService();
            CustomerService customerservice = new ICustomerService();
            switch (option) {
                case 1:
                    libraryService.register();
                    break;
                case 2:
                    libraryService.show();
                    break;
                case 3:
                    libraryService.search();
                    break;
                case 4:
                    libraryService.update();
                    break;
                case 5:
                    libraryService.delete();
                    break;
                case 6:
                libraryService.storageToStock();
                break;
                case 7:
                    customerservice.register();
                    break;
                case 8:
                    customerservice.show();
                    break;
                case 9:
                    customerservice.search();
                    break;
                case 10:
                    customerservice.update();
                    break;
                case 11:
                    customerservice.delete();
                    break;
                case 12:
                    customerservice.login();
                    break;
                    default:
                    throw new InvalidOptionExceptions(ExceptionEnum.INVALID_OPTION_EXCEPTION);
            }
        } catch (InvalidOptionExceptions | InvalidException | BookNotFoundException
                  | NumberFormatException | InputMismatchException e){
            System.err.println(e.getMessage());

        }

        }
    }

}

