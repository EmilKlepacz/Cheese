package com.klepacz.natalia;

import java.util.List;
import java.util.stream.Collectors;

public class CheeseFilter {
    public List<Cheese> filterByDepartment(List<Cheese> cheeseList, String department) {
        List<Cheese> filteredList = cheeseList.stream()
                .filter(cheese -> cheese.getDepartment().equals(department))
                .collect(Collectors.toList());
        return filteredList;
    }

    public List<Cheese> filterByZipCode(List<Cheese> cheeseList, int zipCode) {
        List<Cheese> filteredList = cheeseList.stream()
                .filter(cheese -> cheese.getZipCode() == zipCode)
                .collect(Collectors.toList());
        return filteredList;
    }

    public List<Cheese> filterByMilk(List<Cheese> cheeseList, String milk) {
        List<Cheese> filteredList = cheeseList.stream()
                .filter(cheese -> cheese.getMilk().equals(milk))
                .collect(Collectors.toList());
        return filteredList;
    }

    public List<Cheese> filterByCheeseName(List<Cheese> cheeseList, String cheeseName) {
        List<Cheese> filteredList = cheeseList.stream()
                .filter(cheese -> cheese.getCheese().equals(cheeseName))
                .collect(Collectors.toList());
        return filteredList;
    }

}
