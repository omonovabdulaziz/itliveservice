package it.live.itliveservice.repository;

import it.live.itliveservice.controller.HappyDayController;
import it.live.itliveservice.entity.HappyDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HappyDayRepository extends JpaRepository<HappyDay, Long> {
}
