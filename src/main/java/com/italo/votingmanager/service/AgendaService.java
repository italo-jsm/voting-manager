package com.italo.votingmanager.service;

import com.italo.votingmanager.repository.AgendaRepository;
import com.italo.votingmanager.repository.entities.Agenda;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
@AllArgsConstructor
public class AgendaService {
    private final AgendaRepository agendaRepository;
    private final Logger logger = LoggerFactory.getLogger(AgendaService.class);

    public void openAgenda(String agendaId, int duration){
        Agenda agenda = agendaRepository.findById(agendaId).orElseThrow(() -> new RuntimeException("Not Found"));
        agenda.openForVoting();
        agendaRepository.save(agenda);
        scheduleClosingTime(duration, agenda);
    }

    private void scheduleClosingTime(int duration, Agenda agenda) {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                logger.info("Closing voting session for agenda " + agenda.getId() + " after " + duration + " seconds" );
                agenda.closeForVoting();
                agendaRepository.save(agenda);
            }
        }, duration * 1000L);
    }

    public void createAgenda(Agenda agenda) {
        this.agendaRepository.save(agenda);
    }
}
