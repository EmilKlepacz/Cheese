package com.klepacz.natalia;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String FILENAME_SEARCH_HISTORY = "search_history.txt";
    private static final String HISTORY_OF_SEARCH_EMPTY_MESSAGE = "Current History of Search is empty.";

    public static List<Cheese> loadFromFileToListOfCheeses(String fileName) {

        List<Cheese> cheeseList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;
            //to start with 2nd line
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\t");

                Cheese cheese = new Cheese();
                if (!tokens[0].equals("")) {
                    cheese.setDepartment(tokens[0]);
                }
                if (!tokens[1].equals("")) {
                    cheese.setZipCode(Integer.valueOf(tokens[1]));
                }
                if (!tokens[2].equals("")) {
                    cheese.setCheese(tokens[2]);
                }
                if (!tokens[3].equals("")) {
                    cheese.setFrenchURL(new URL(tokens[3]));
                }
                if (!tokens[4].equals("")) {
                    cheese.setEnglishURL(new URL(tokens[4]));
                }
                if (!tokens[5].equals("")) {
                    cheese.setImageURL(new URL(tokens[5]));
                }
                if (!tokens[6].equals("")) {
                    cheese.setMilk(tokens[6]);
                }

                cheeseList.add(cheese);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cheeseList;
    }

    // If You want to save Current Search to File with given name use with parameters(cheeseList, filename, false)
    // If You want to append this Search to Search History File use with parameters(cheeseList, null, true)
    public static void saveCheeseListToFile(List<Cheese> cheeseList, String filename, boolean append) {
        ZonedDateTime localDateTime = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String formattedLocalDateTime = localDateTime.format(formatter);

        BufferedWriter bw = null;
        FileWriter fw = null;
        String filenameHistoryOrCurrent;
        if (filename != null) {
            filenameHistoryOrCurrent = filename;
        } else {
            filenameHistoryOrCurrent = FILENAME_SEARCH_HISTORY;
        }

        try {
            File file = new File(filenameHistoryOrCurrent);

            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile(), append);
            bw = new BufferedWriter(fw);

            //write list to File with Current Local Date Time and Time Zone included
            bw.write("------------------" + formattedLocalDateTime + "------------------" + "\n");

            if (cheeseList.isEmpty()) {
                bw.write("NO RESULTS" + "\n");
            } else {
                for (int i = 0; i < cheeseList.size(); i++) {
                    bw.write((i + 1) + ". " + cheeseList.get(i) + "\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void displayHistoryOfSearch(){
        File file = new File(FILENAME_SEARCH_HISTORY);

        if (!file.exists()) {
            System.out.println(HISTORY_OF_SEARCH_EMPTY_MESSAGE);
        }else{
            try {
                BufferedReader reader = new BufferedReader(new FileReader(FILENAME_SEARCH_HISTORY));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
