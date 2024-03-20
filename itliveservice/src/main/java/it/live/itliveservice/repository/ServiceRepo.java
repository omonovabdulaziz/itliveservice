package it.live.itliveservice.repository;

import it.live.itliveservice.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<Service , Long> {

}
