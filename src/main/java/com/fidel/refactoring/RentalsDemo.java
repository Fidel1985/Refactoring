package com.fidel.refactoring;

import com.fidel.refactoring.rentals.result.Customer;
import com.fidel.refactoring.rentals.result.Movie;
import com.fidel.refactoring.rentals.result.Rental;

//import com.fidel.refactoring.rentals.source.Customer;
//import com.fidel.refactoring.rentals.source.Movie;
//import com.fidel.refactoring.rentals.source.Rental;

public class RentalsDemo {
    public static void main(String[] args) {
        Movie movieChildren = new Movie("Kolobok", Movie.CHILDRENS);
        Movie movieRegular = new Movie("Die Hard", Movie.REGULAR);
        Movie movieNew = new Movie("West World", Movie.NEW_RELEASE);
        Rental rentMovieChildren = new Rental(movieChildren, 1);
        Rental rentMovieRegular = new Rental(movieRegular, 1);
        Rental rentMovieNew = new Rental(movieNew, 10);

        Customer customer = new Customer("Andrew");
        customer.addRental(rentMovieChildren);
        customer.addRental(rentMovieRegular);
        customer.addRental(rentMovieNew);

        String rentResult = customer.statement();
        System.out.println(rentResult);
    }
}
