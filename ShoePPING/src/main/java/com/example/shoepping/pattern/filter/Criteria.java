package com.example.shoepping.pattern.filter;

import com.example.shoepping.model.catalog.Catalog;

public interface Criteria {
    Catalog meetCriteria(Catalog catalog, String filter);
}
