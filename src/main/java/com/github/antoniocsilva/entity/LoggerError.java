package com.github.antoniocsilva.entity;

import com.github.antoniocsilva.enums.Level;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "logger")
public class LoggerError extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Enumerated(EnumType.STRING)
    private Level level;


    @NotNull
    private String description;

    @NotNull
    private String sourceIssue;

    @NotNull
    private int quantity;

    @UpdateTimestamp
    private Date dateLogger;

}
