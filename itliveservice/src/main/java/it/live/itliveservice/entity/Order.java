package it.live.itliveservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "buyurtmalar")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String phoneNumber;
    @ManyToOne
    private TypeService service;
    @Column(columnDefinition = "text")
    private String message;
    @CreationTimestamp
    private Timestamp createdAt;
}
