package service.Impl;

import Enums.ExceptionEnum;
import Enums.StatusEnum;
import Util.InputUtil;
import Util.MenuUtil;
import exception.*;
import globalData.GlobalData;
import helper.LibraryServiceHelper;
import model.Library;
import service.LibraryService;

import static Util.InputUtil.*;
import static Util.MenuUtil.entryDetail;
import static Util.MenuUtil.entryShow;
import static globalData.GlobalData.libraries;
import static helper.LibraryServiceHelper.*;

public class IlibraryService implements LibraryService {


    @Override
    public void register() {
        byte count = inputRequiredByte("Enter the  count");

        if (libraries == null) {
            libraries = new Library[count];
            for (int i = 0; i < count; i++) {
                helpRegister();
            }

            System.out.println(StatusEnum.REGISTER_SUCCESSFULLY);

        } else {
            Library[] tempLibrary = libraries;
            libraries = new Library[libraries.length + count];
            for (int i = 0; i < libraries.length; i++) {
                if (i < tempLibrary.length){
                libraries[i] = tempLibrary[i];
            }
                else
             {
                helpRegister();
            }
            System.out.println(StatusEnum.REGISTER_SUCCESSFULLY);

        }

    }
    }

    @Override
    public void show() {
        if (libraries == null){
            throw new EmptyListException(ExceptionEnum.EMPTY_LIST_EXCEPTION);
        } else {
            byte option = entryShow();
            switch (option) {
                case 1:
                    showHelper((byte) 0);
                    break;
                case 2:
                    showHelper((byte) 1);
                    break;
                default:
                    throw new InvalidOptionExceptions(ExceptionEnum.INVALID_OPTION_EXCEPTION);

            }
        }
    }

    @Override
    public void search() {
        if (libraries == null) {
            throw new EmptyListException(ExceptionEnum.EMPTY_LIST_EXCEPTION);
        }
        byte option = entryShow();
        switch (option){
            case 1:
                searchByStatus((byte) 0);
                break;
            case 2:
                searchByStatus((byte) 1);
                break;
            default:
                throw new InvalidOptionExceptions(ExceptionEnum.INVALID_OPTION_EXCEPTION);
        }
    }
    @Override
    public boolean update() {
        if (libraries == null && libraries.length == 0)
            throw new EmptyListException(ExceptionEnum.EMPTY_LIST_EXCEPTION);
        long id = inputRequiredLong("enter the update book id");
        boolean isTrue = false;

        for (int i = 0; i < libraries.length; i++) {
            if (libraries[i].getId()==id){
                String parameter = inputRequiredString("Enter the book parameters");
                String [] parameters = parameter.toLowerCase().split(",");

                for (String str:parameters) {
                    switch (str) {
                        case "name":
                            libraries[i].setName(inputRequiredString("update the book name"));
                            isTrue = true;
                            break;
                        case "author":
                            libraries[i].setAuthor(inputRequiredString("update the author name"));
                            isTrue = true;
                            break;
                        case "genre":
                            libraries[i].setGenre(inputRequiredString("Update genre: "));
                            isTrue = true;
                              break;
                        case "page count":
                            libraries[i].setPageCount(inputRequiredInt("Update page count: "));
                            isTrue = true;
                               break;
                        case "language":
                            libraries[i].setLanguage(inputRequiredString("Update language: "));
                            isTrue = true;
                            break;
                        case "price":
                            libraries[i].setPrice(inputRequiredInt("Update price: "));
                            isTrue = true;
                            break;
                        case "count":
                            libraries[i].setCount(inputRequiredInt("Update count: "));
                            isTrue = true;
                            break;
                        default :
                            throw new WrongFormatException(ExceptionEnum.WRONG_FORMAT);
                    }
                }
                if (isTrue) {
                    System.out.println(StatusEnum.UPDATE_SUCCESSFULLY);
                }
                    }
        }

        return true;
    }

    @Override
    public boolean delete() {
        if (libraries == null || libraries.length == 0)
            throw new EmptyListException(ExceptionEnum.EMPTY_LIST_EXCEPTION);

        long id = InputUtil.inputRequiredLong("Enter the deleted book id");

        for (int i = 0; i < libraries.length; i++) {
            if (libraries[i].getId() == id) {
                Library[] libraries  = GlobalData.libraries;
                GlobalData.libraries = new Library[GlobalData.libraries.length - 1];
                int k = 0;
                for (Library library : libraries ) {
                    if (library.getId() == id) {
                        continue;
                    }
                    GlobalData.libraries[k] = library;
                    k++;
                }
                System.out.println(StatusEnum.DELETED_SUCCESSFULLY);
                return true;
    }}
        throw new BookNotFoundException(ExceptionEnum.BOOK_NOT_FOUND);
    }

    @Override
    public void storageToStock() {
        if (libraries != null && libraries.length != 0) {
            String bookName = inputRequiredString("Enter the book name : ");
            for (Library library : libraries) {
                if (library.getName().equals(bookName)) {
                    library.setStockStatus((byte) 0);

                }

            }
            System.out.println(StatusEnum.BOOKPLACE_CHANGED_SUCCESSFULLY);
        }
        else {
            throw new InvalidOptionExceptions(ExceptionEnum.INVALID_OPTION_EXCEPTION);
        }
    }
}


