package it.live.itliveservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Entity
public class CommunicateMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @NotNull(message = "Full name")
    private String fullname;
    @NotNull(message = "phoneNumber")
    private String phoneNumber;
    @Column(columnDefinition = "text")
    @NotNull(message = "message")
    private String message;
    @CreationTimestamp
    @JsonIgnore
    private Timestamp timestamp;
}
