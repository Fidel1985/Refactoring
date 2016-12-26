package com.fidel.refactoring.rentals.result;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class Customer {
    private String _name;
    private List<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Учет аренды для " + getName() + "\n";
        for (Rental _rental : _rentals) {
            //определить сумму для каждой строки
            double each = amountFor(_rental);

            // добавить очки для активного арендатора
            frequentRenterPoints++;
            // бонус за аренду новинки на два дня
            if ((_rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    _rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            //показать результаты для этой аренды

            result += "\t" + _rental.getMovie().getTitle() + "\t" +
                    String.valueOf(each) + "\n";
            totalAmount += each;
        }
        //добавить нижний колонтитул
        result += "Сумма задолженности составляет " +
                String.valueOf(totalAmount) + "\n";
        result += "Вы заработали " + String.valueOf(frequentRenterPoints) +
                " очков за активность";
        return result;
    }

    private double amountFor(Rental each) { double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2) {
                    thisAmount += (each.getDaysRented() - 2) * 15;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 15;
                if (each.getDaysRented() > 3) {
                    thisAmount += (each.getDaysRented() - 3) * 15;
                }
                break;
        }
        return thisAmount;
    }
}