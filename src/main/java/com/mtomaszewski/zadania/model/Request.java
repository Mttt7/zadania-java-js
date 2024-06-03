package com.mtomaszewski.zadania.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
}
