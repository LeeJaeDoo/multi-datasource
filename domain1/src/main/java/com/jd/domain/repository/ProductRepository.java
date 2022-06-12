package com.jd.domain.repository;

import com.jd.domain.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

/**
 * @author Jaedoo Lee
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByStartedAtAfterAndFinishedAtBefore(LocalDateTime startedAt, LocalDateTime finishedAt, Pageable pageable);

}
