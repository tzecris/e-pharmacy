package com.app.pharmacy.dto;

import java.util.List;

/**
 *
 * @author Chris Tzelis
 */
public class SearchResults<T> {

    private List<T> results;
    private long totalItems;

    public SearchResults(List<T> results, long totalItems) {
        this.results = results;
        this.totalItems = totalItems;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

}
