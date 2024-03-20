package it.live.itliveservice.repository;

import it.live.itliveservice.entity.FutureNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FutureNewsRepository extends JpaRepository<FutureNews, Long> {
}
