package it.live.itliveservice.repository;

import it.live.itliveservice.entity.CommunicateMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicateMessageRepository extends JpaRepository<CommunicateMessage , Long> {
}
