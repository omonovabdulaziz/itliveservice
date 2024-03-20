package it.live.itliveservice.repository;

import it.live.itliveservice.entity.TypeService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<TypeService, Long> {
    List<TypeService> findAllByServiceId(Long service_id);
}
