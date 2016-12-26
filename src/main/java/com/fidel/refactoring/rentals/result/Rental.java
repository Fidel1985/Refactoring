package com.fidel.refactoring.rentals.result;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    double getCharge() {
        double result = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (getDaysRented() > 2) {
                    result += (getDaysRented() - 2) * 15;
                }
                break;
            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 15;
                if (getDaysRented() > 3) {
                    result += (getDaysRented() - 3) * 15;
                }
                break;
        }
        //System.out.println("\t" + getMovie().getTitle() + " " + result);
        return result;
    }

    int getFrequentRenterPoints() {
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                getDaysRented() > 1) {
            return 2;
        }
        //показать результаты для этой аренды
        return 1;
    }
}
