package com.italo.votingmanager.service;

import com.italo.votingmanager.controller.requests.OpenVotingRequest;
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

    public void openAgenda(OpenVotingRequest request){
        Agenda agenda = agendaRepository.findById(request.getAgendaId()).orElseThrow(() -> {
            logger.info("Could not find agenda " + request.getAgendaId());
            return new RuntimeException("Not Found");
        });
        agenda.openForVoting();
        agendaRepository.save(agenda);
        scheduleClosingTime(request.getDuration(), agenda);
    }

    private void scheduleClosingTime(int duration, Agenda agenda) {
        Timer t = new Timer();
        int finalDuration = duration == 0 ? 1 : duration;
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                logger.info("Closing voting session for agenda " + agenda.getId() + " after " + finalDuration + " minutes" );
                agenda.closeForVoting();
                agendaRepository.save(agenda);
            }
        }, finalDuration * 1000L * 60);
    }

    public Agenda createAgenda(Agenda agenda) {
        return this.agendaRepository.save(agenda);
    }
}
