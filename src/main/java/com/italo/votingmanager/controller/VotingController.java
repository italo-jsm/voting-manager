package com.italo.votingmanager.controller;

import com.italo.votingmanager.controller.requests.VotingRequest;
import com.italo.votingmanager.controller.response.VotingResultResponse;
import com.italo.votingmanager.repository.entities.Vote;
import com.italo.votingmanager.repository.enums.VoteEnum;
import com.italo.votingmanager.service.VotingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@AllArgsConstructor
public class VotingController {
    private final VotingService votingService;
    @PostMapping("/vote")
    public ResponseEntity<Void> newVote(@RequestBody VotingRequest request){
        votingService.saveVote(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/vote/result")
    public ResponseEntity<VotingResultResponse> getVotingResultByAgendaId(@RequestParam String agendaId){
        VotingResultResponse result = new VotingResultResponse(agendaId, votingService.getVotesCountByVoteEnum(VoteEnum.SIM, agendaId), votingService.getVotesCountByVoteEnum(VoteEnum.NAO, agendaId));
        return ResponseEntity.ok(result);
    }
}
