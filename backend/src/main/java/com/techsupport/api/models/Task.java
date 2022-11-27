package com.techsupport.api.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;

    @CreationTimestamp
    private Date date;

    @OneToMany(mappedBy = "noteId")
    private List<Note> notes;

    public Task() {
    }
}
