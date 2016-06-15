package com.devarchi33.persistance.jpa.repository;

import com.devarchi33.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by donghoon on 2016. 6. 15..
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * nativeQuery 옵션을 사용하면 SQL 도 사용가능 함.
     *
     * @return
     */
    @Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
    Page<Customer> findAllOrderByName(Pageable pageable);

}