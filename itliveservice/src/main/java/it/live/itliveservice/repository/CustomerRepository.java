package it.live.itliveservice.repository;

import it.live.itliveservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer , Long> {
}
