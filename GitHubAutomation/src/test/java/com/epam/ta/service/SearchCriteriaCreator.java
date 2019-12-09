package com.epam.ta.service;

import com.epam.ta.model.SearchCriteria;

public class SearchCriteriaCreator {
    public static final String TESTDATA_SEARCH_CRITERIA_DESTINATION = "testdata.searchCriteria.destination";
    public static final String TESTDATA_SEARCH_CRITERIA_RATING = "testdata.searchCriteria.rating";
    public static final String TESTDATA_SEARCH_CRITERIA_ARRIVAL_DATE = "testdata.searchCriteria.arrivalDate";
    public static final String TESTDATA_SEARCH_CRITERIA_DEPARTURE_DATE = "testdata.searchCriteria.departureDate";
    public static final String TESTDATA_SEARCH_CRITERIA_GUESTS_NUMBER = "testdata.searchCriteria.guestsNumber";
    public static final String TESTDATA_SEARCH_CRITERIA_ROOMS_NUMBER = "testdata.searchCriteria.roomsNumber";

    public static SearchCriteria withCredentialsFromProperty() {
        return new SearchCriteria(TestDataReader.getTestData(TESTDATA_SEARCH_CRITERIA_DESTINATION),
                TestDataReader.getTestData(TESTDATA_SEARCH_CRITERIA_RATING),
                TestDataReader.getTestData(TESTDATA_SEARCH_CRITERIA_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCH_CRITERIA_DEPARTURE_DATE),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCH_CRITERIA_GUESTS_NUMBER)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCH_CRITERIA_ROOMS_NUMBER)));
    }

    public static SearchCriteria withEmptyDate() {
        return new SearchCriteria(TestDataReader.getTestData(TESTDATA_SEARCH_CRITERIA_DESTINATION),
                TestDataReader.getTestData(TESTDATA_SEARCH_CRITERIA_RATING),
                "", "",
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCH_CRITERIA_GUESTS_NUMBER)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCH_CRITERIA_ROOMS_NUMBER)));
    }
}
