package com.theironyard;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by amalabukar on 1/9/17.
 */
public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
    // @Query("SELECT g FROM Purchase g WHERE g.category LIKE ?1%")

    List<Purchase> findByCategory(String category);
}
