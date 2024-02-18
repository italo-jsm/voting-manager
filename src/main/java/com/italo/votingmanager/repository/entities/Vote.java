package com.italo.votingmanager.repository.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class Vote {
    @Id
    private String id;
    private String authorId;
    private String agendaId;
}
