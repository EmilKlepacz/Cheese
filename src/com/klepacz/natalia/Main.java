package com.klepacz.natalia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME_DATA = "data.txt";
    private static final String INVALID_CHOICE_MESSAGE = "Invalid Choice. Please try again.";
    private static final String EXIT_MESSAGE = "Good Bye!";
    private static final String NOT_NUMBER_MESSAGE = "Your input is not a number. PLease try again.";
    private static final String CHOOSE_DEPARTMENT_MESSAGE = "Please filter by Department e.g 'Ain'. ";
    private static final String CHOOSE_ZIP_CODE_MESSAGE = "Please filter by Zip Code e.g '1000'.";
    private static final String CHOOSE_MILK_MESSAGE = "Please filter by Milk e.g 'Cow'.";
    private static final String CHOOSE_NAME_MESSAGE = "Please filter by Name e.g 'Moulin de Gaye'.";
    private static final String CURRENT_SEARCH_NO_RECORDS_MESSAGE = "Current search has no records";
    private static final String REMOVE_FILTERS_MESSAGE = "All filters have been removed.";
    private static final String PROVIDE_FILENAME = "Provide filename to save current search e.g 'save.txt'";
    private static final String FILE_SAVED_MESSAGE = "File saved successfully.";
    private static CheeseFilter cheeseFilter = new CheeseFilter();
    private static List<Cheese> defaultCheeseList;

    private static void displayMainMenuBar() {
        System.out.println("=======================================");
        System.out.println("|          CHEESE APP SEARCH          |");
        System.out.println("=======================================");
        System.out.println("| Options:                            |");
        System.out.println("|        1. Filter by Department      |");
        System.out.println("|        2. Filter by Zip Code        |");
        System.out.println("|        3. Filter by Milk            |");
        System.out.println("|        4. Filter by Name            |");
        System.out.println("|        5. Remove filters            |");
        System.out.println("|        6. Save Current Search       |");
        System.out.println("|        7. Display Search History    |");
        System.out.println("|        8. Display Full Cheese List  |");
        System.out.println("|        0. Exit                      |");
        System.out.println("=======================================");
    }

    private static void displayCheeseList(List<Cheese> cheeseList) {
        if (cheeseList.isEmpty()) {
            System.out.println(CURRENT_SEARCH_NO_RECORDS_MESSAGE);
        } else {
            for (int i = 0; i < cheeseList.size(); i++) {
                System.out.println((i + 1) + ". " + cheeseList.get(i));
            }
        }

    }

    public static void main(String[] args) {
        defaultCheeseList = FileUtils.loadFromFileToListOfCheeses(FILE_NAME_DATA);
        //on start filteredList is same as Cheese list that means that it has all records
        List<Cheese> filteredCheeseList = new ArrayList<>(defaultCheeseList);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        int choice;
        String filterValue;
        String fileName;

        do {
            displayMainMenuBar();

            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println(NOT_NUMBER_MESSAGE);
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(CHOOSE_DEPARTMENT_MESSAGE);
                    scanner.nextLine();
                    filterValue = scanner.nextLine();
                    filteredCheeseList = cheeseFilter.filterByDepartment(filteredCheeseList, filterValue);

                    displayCheeseList(filteredCheeseList);

                    FileUtils.saveCheeseListToFile(filteredCheeseList, null, true);
                    break;
                case 2:
                    System.out.println(CHOOSE_ZIP_CODE_MESSAGE);

                    while (!scanner.hasNextInt()) {
                        scanner.next();
                        System.out.println(NOT_NUMBER_MESSAGE);
                    }
                    scanner.nextLine();
                    filterValue = scanner.nextLine();
                    filteredCheeseList = cheeseFilter.filterByZipCode(filteredCheeseList, Integer.valueOf(filterValue));

                    displayCheeseList(filteredCheeseList);

                    FileUtils.saveCheeseListToFile(filteredCheeseList, null, true);
                    break;
                case 3:
                    System.out.println(CHOOSE_MILK_MESSAGE);
                    scanner.nextLine();
                    filterValue = scanner.nextLine();
                    filteredCheeseList = cheeseFilter.filterByMilk(filteredCheeseList, filterValue);

                    displayCheeseList(filteredCheeseList);

                    FileUtils.saveCheeseListToFile(filteredCheeseList, null, true);
                    break;
                case 4:
                    System.out.println(CHOOSE_NAME_MESSAGE);
                    scanner.nextLine();
                    filterValue = scanner.nextLine();
                    filteredCheeseList = cheeseFilter.filterByCheeseName(filteredCheeseList, filterValue);

                    displayCheeseList(filteredCheeseList);

                    FileUtils.saveCheeseListToFile(filteredCheeseList, null, true);
                    break;
                case 5:
                    System.out.println(REMOVE_FILTERS_MESSAGE);
                    filteredCheeseList.clear();
                    filteredCheeseList.addAll(defaultCheeseList);
                    break;
                case 6:
                    System.out.println(PROVIDE_FILENAME);
                    scanner.nextLine();
                    fileName = scanner.nextLine();

                    FileUtils.saveCheeseListToFile(filteredCheeseList, fileName, false);
                    System.out.println(FILE_SAVED_MESSAGE);
                    break;
                case 7:
                    FileUtils.displayHistoryOfSearch();
                    break;
                case 8:
                    displayCheeseList(defaultCheeseList);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println(INVALID_CHOICE_MESSAGE);
                    break;
            }
        } while (!exit);
        System.out.println(EXIT_MESSAGE);
    }


}

