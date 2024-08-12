package com.example.demo.controllers;

import com.example.demo.dto.SaleRequest;
import com.example.demo.models.Product;
import com.example.demo.models.Sale;
import com.example.demo.models.User;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.SaleRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
    @Autowired
    private SaleRepository  saleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Sale> store(@RequestBody SaleRequest saleRequest) {
        try {

            Optional<User> customerOpt = userRepository.findById(saleRequest.getCustomerId());
            Optional<User> employeeOpt = userRepository.findById(saleRequest.getEmployeeId());

            if (customerOpt.isEmpty() || employeeOpt.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            User customer = customerOpt.get();
            User employee = employeeOpt.get();

            List<Product> products = productRepository.findAllById(saleRequest.getProductIds());

            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            double totalAmount = products.stream()
                    .mapToDouble(Product::getPreco)
                    .sum();

            Sale sale = new Sale();
            sale.setCustomer(customer);
            sale.setEmployee(employee);
            sale.setProducts(products);
            sale.setNotes(saleRequest.getNotes());
            sale.setTotalAmount(totalAmount);

            Sale savedSale = saleRepository.save(sale);

            return new ResponseEntity<>(savedSale, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Sale>> getSalesByCustomerName(@RequestParam String name) {
        List<Sale> sales = saleRepository.findByCustomerNomeContainingIgnoreCase(name);
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Sale>> getSalesByEmployeeName(@RequestParam String name) {
        List<Sale> sales = saleRepository.findByEmployeeNomeContainingIgnoreCase(name);
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/top10")
    public ResponseEntity<List<Sale>> getTop10SalesByTotal() {
        List<Sale> sales = saleRepository.findAllByOrderByTotalAmountDesc(PageRequest.of(0, 10));
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }
}
