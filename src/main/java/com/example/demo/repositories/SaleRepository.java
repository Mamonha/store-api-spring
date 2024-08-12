package com.example.demo.repositories;

import com.example.demo.models.Product;
import com.example.demo.models.Sale;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findByCustomerNomeContainingIgnoreCase(String name);

    List<Sale> findByEmployeeNomeContainingIgnoreCase(String name);

    List<Sale> findAllByOrderByTotalAmountDesc(PageRequest pageRequest);
}
