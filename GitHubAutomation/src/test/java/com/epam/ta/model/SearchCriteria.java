package com.epam.ta.model;

import java.util.Objects;

public class SearchCriteria {

    private String destination;
    private String rating;
    private String arrivalDate;
    private String departureDate;
    private int numberOfGuests;
    private int numberOfRooms;

    public SearchCriteria(String destination, String rating, String arrivalDate, String departureDate, int numberOfGuests, int numberOfRooms) {
        this.destination = destination;
        this.rating = rating;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.numberOfGuests = numberOfGuests;
        this.numberOfRooms = numberOfRooms;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "destination='" + destination + '\'' +
                ", rating='" + rating + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", numberOfGuests=" + numberOfGuests +
                ", numberOfRooms=" + numberOfRooms +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchCriteria that = (SearchCriteria) o;
        return numberOfGuests == that.numberOfGuests &&
                numberOfRooms == that.numberOfRooms &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(arrivalDate, that.arrivalDate) &&
                Objects.equals(departureDate, that.departureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, rating, arrivalDate, departureDate, numberOfGuests, numberOfRooms);
    }
}
