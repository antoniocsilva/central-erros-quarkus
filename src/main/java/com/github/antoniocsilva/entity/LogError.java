package com.github.antoniocsilva.entity;

import com.github.antoniocsilva.enums.Level;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "log")
public class LogError extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Enumerated(EnumType.STRING)
    private Level level;

    @NotNull
    private String description;

    @NotNull
    private String eventLog;

    @NotNull
    private String origin;

    @NotNull
    private int quantity;

    @UpdateTimestamp
    private Date dateEventLog;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventLog() {
        return eventLog;
    }

    public void setEventLog(String eventLog) {
        this.eventLog = eventLog;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateEventLog() {
        return dateEventLog;
    }

    public void setDateEventLog(Date dateEventLog) {
        this.dateEventLog = dateEventLog;
    }
}
