package com.jd.domain.repository;

import com.jd.domain.entity.Investor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Jaedoo Lee
 */
public interface InvestorRepository extends JpaRepository<Investor, Long> {

    @Query(value = "select i from Investor i join fetch i.product where i.userId = :userId")
    List<Investor> findAllByUserId(long userId);

}
