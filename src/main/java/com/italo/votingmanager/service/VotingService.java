package com.italo.votingmanager.service;

import com.italo.votingmanager.controller.requests.VotingRequest;
import com.italo.votingmanager.exceptions.VotingException;
import com.italo.votingmanager.repository.AgendaRepository;
import com.italo.votingmanager.repository.VotingRepository;
import com.italo.votingmanager.repository.entities.Agenda;
import com.italo.votingmanager.repository.entities.Vote;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VotingService {
    private final VotingRepository votingRepository;
    private final AgendaService agendaService;

    public void saveVote(VotingRequest request){
        Vote vote = Vote.createFromRequest(request);
        agendaService.validateAgenda(vote.getAgendaId());
        validateVoteAuthor(vote);
        votingRepository.save(vote);
    }

    private void validateVoteAuthor(Vote vote) {
        votingRepository.findByAgendaIdAndAuthorId(vote.getAgendaId(), vote.getAuthorId()).ifPresent(v -> {
            throw new VotingException("Esse autor ja votou e nao pode votar novamente");
        });
    }

}
