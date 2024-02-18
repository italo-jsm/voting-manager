package com.italo.votingmanager.controller;

import com.italo.votingmanager.controller.requests.CreateAgendaRequest;
import com.italo.votingmanager.repository.AgendaRepository;
import com.italo.votingmanager.repository.entities.Agenda;
import com.italo.votingmanager.service.AgendaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class AgendaController {
    private final AgendaService agendaService;

    @PostMapping("/agenda/create")
    public ResponseEntity<?> createAgenda(@RequestBody CreateAgendaRequest request){
        agendaService.createAgenda(Agenda.createFromRequest(request));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/agenda/open")
    public ResponseEntity<?> openVotingSession(@RequestParam String agendaId, @RequestParam int duration){
        agendaService.openAgenda(agendaId, duration);
        return ResponseEntity.ok().build();
    }
}
