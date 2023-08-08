package helper;

import Enums.ExceptionEnum;
import Enums.StatusEnum;
import Util.InputUtil;
import exception.InvalidOptionExceptions;
import globalData.GlobalData;
import model.Library;

import static Util.InputUtil.*;
import static Util.MenuUtil.*;
import static globalData.GlobalData.libraries;

public class LibraryServiceHelper {
    static int id = 0;
    static int libraryCount=0;
    public static Library fillLibrary() {
        try {
            String bookName = inputRequiredString("Enter the name: ");
            String bookAuthor = inputRequiredString("Enter the author: ");
            String bookGenre = inputRequiredString("Enter the genre: ");
            int bookPageCount = InputUtil.inputRequiredInt("Enter the count page : ");
            String bookLanguage = inputRequiredString("Enter the language: ");
            long bookPrice = inputRequiredLong("Enter the price: ");
            int bookCount = inputRequiredInt("Enter the count: ");
            byte bookStockStatus = inputRequiredByte("Enter the stock Status: ");

            return new Library(++id, bookName, bookAuthor, bookGenre, bookPageCount, bookLanguage, bookPrice, bookCount, bookStockStatus);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public static void detailBook(){
        String detailBook = entryDetail();
        for (Library library:libraries) {
            if (library.getName().equals(detailBook)) {
                System.out.println(library);
            }
        }
    }

    public static void helpRegister() {
        Library library = fillLibrary();
        if (library != null) {
            libraries[libraryCount] = library;
            libraryCount++;
        }

    }

    public static void showHelper(byte status) {


        for (int i = 0; i < libraries.length; i++) {
            if (libraries[i].getStockStatus() == status) {
                System.out.println(libraries[i].getInfo());

            }
        }
        String name = entryDetail();
        for (int i = 0; i < libraries.length; i++) {
            if (libraries[i].getName().equals(name) && libraries[i].getStockStatus() == status) {
            System.out.println(libraries[i].toString());
        }

      }
    }
    public static void searchByStatus(byte message){
        byte searchOption = entrySearch();
        switch (searchOption) {
            case 1:
                nameSearch(message);
                break;
            case 2:
                authorSearch(message);
                break;
            case 3:
                genreSearch(message);
                break;
            default: throw new InvalidOptionExceptions(ExceptionEnum.INVALID_OPTION_EXCEPTION);
        }

    }


    public static void nameSearch(byte message){
        String name = inputRequiredString("enter the search name");
        for (int i = 0; i < libraries.length; i++) {
            if (libraries[i].getName().equals(name)&& libraries[i].getStockStatus() == message) {
            System.out.println(libraries[i].toString());

        }

      }
    }

public static void authorSearch(byte message){
    String author = inputRequiredString("enter the search author");
    for (int i = 0; i < libraries.length; i++) {
        if (libraries[i].getName().equals(author) && libraries[i].getStockStatus() == message) {

            System.out.println(libraries[i].toString());

    }
    }
} public static void genreSearch(byte message){
        String genre = inputRequiredString("enter the search genre");
        for (int i = 0; i < libraries.length; i++) {
            if (libraries[i].getName().equals(genre) && libraries[i].getStockStatus() == message) {

                System.out.println(libraries[i].toString());

            }
        }
    }
}
