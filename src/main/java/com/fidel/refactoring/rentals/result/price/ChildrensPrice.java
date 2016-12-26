package com.fidel.refactoring.rentals.result.price;

import com.fidel.refactoring.rentals.result.Movie;

public class ChildrensPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 15;
        if (daysRented > 3) {
            result += (daysRented - 3) * 15;
        }
        return result;
    }
}