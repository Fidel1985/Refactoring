package com.fidel.refactoring.rentals.result.price;

import com.fidel.refactoring.rentals.result.Movie;

public abstract class Price {
    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented){
        return 1;
    }

/*    public double getCharge(int daysRented) {
        double result = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 15;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                result += 15;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 15;
                }
                break; }
        return result;
    }*/

/*    public int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) &&
                daysRented > 1) {
            return 2;
        } else {
            return 1; }
    }*/
}