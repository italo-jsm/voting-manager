package com.italo.votingmanager.controller;

import com.italo.votingmanager.controller.requests.CreateAgendaRequest;
import com.italo.votingmanager.controller.requests.OpenVotingRequest;
import com.italo.votingmanager.repository.entities.Agenda;
import com.italo.votingmanager.service.AgendaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
public class AgendaController {
    private final AgendaService agendaService;

    @PostMapping("/agenda/create")
    public ResponseEntity<Void> createAgenda(@RequestBody CreateAgendaRequest request){
        String id = agendaService.createAgenda(Agenda.createFromRequest(request)).getId();
        return ResponseEntity.created(URI.create(id)).build();
    }

    @PutMapping("/agenda/open")
    public ResponseEntity<Void> openVotingSession(@RequestBody OpenVotingRequest request){
        agendaService.openAgenda(request);
        return ResponseEntity.ok().build();
    }
}
