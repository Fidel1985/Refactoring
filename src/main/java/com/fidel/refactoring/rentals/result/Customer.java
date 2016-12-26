package com.fidel.refactoring.rentals.result;

import java.util.ArrayList;
import java.util.List;

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
        String result = "Учет аренды для " + getName() + "\n";
        for (Rental _rental : _rentals) {
            // показать результаты по каждой аренде
            result += _rental.getMovie().getTitle() + " " +
                    String.valueOf(_rental.getCharge()) + "\n";
        }
        //добавить нижний колонтитул
        result += "Сумма задолженности составляет " +
                String.valueOf(getTotalCharge()) + "\n";
        result += "Вы заработали " + String.valueOf(getTotalFrequentRenterPoints()) +
                " очков за активность";
        return result;
    }

    public String htmlStatement() {
        String result = "<Н1>0перации аренды для <ЕМ>" + getName() + "</EM></H1><P>\n";
        for (Rental _rental : _rentals) {
            // показать результаты по каждой аренде
            result += _rental.getMovie().getTitle() + " " +
                    String.valueOf(_rental.getCharge()) + "<BR>\n";
        }
        //добавить нижний колонтитул
        result += "<Р>Ваша задолженность составляет <ЕМ>" +
                String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "На этой аренде вы заработали <ЕМ>" +
                String.valueOf(getTotalFrequentRenterPoints()) + "</ЕМ> очков за активность<Р>";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental _rental : _rentals) {
            result += _rental.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental _rental : _rentals) {
            result += _rental.getFrequentRenterPoints();
        }
        return result;
    }
}