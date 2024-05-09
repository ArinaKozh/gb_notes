package ru.gb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
@Data
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String header;

    @Column(nullable = false)
    private String body;

    @Column
    private LocalDateTime creationTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private MyUser user;

    private String StringCreationTime;

    public String getStringCreationTime(){
         StringCreationTime = DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss").format(creationTime);
         return StringCreationTime;
    }
}
