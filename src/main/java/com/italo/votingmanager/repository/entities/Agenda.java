package com.italo.votingmanager.repository.entities;

import com.italo.votingmanager.controller.requests.CreateAgendaRequest;
import com.italo.votingmanager.exceptions.AgendaException;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {
    @Getter
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime openingTime;
    private LocalDateTime closingTime;
    private boolean open;

    public static Agenda createFromRequest(CreateAgendaRequest request){
        return new Agenda(UUID.randomUUID().toString(), request.getName(), request.getDescription(), null, null, false);
    }

    public Agenda openForVoting(){
        if(!this.open){
            this.open = true;
            this.openingTime = LocalDateTime.now();
            return this;
        }else throw new AgendaException("Agenda ja esta aberta");
    }

    public Agenda closeForVoting(){
        this.open = false;
        this.closingTime = LocalDateTime.now();
        return this;
    }

}
