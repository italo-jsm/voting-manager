package com.italo.votingmanager.controller;

import com.italo.votingmanager.controller.requests.VotingRequest;
import com.italo.votingmanager.repository.entities.Vote;
import com.italo.votingmanager.service.VotingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class VotingController {
    private final VotingService votingService;
    @PostMapping("/vote")
    public ResponseEntity<Void> newVote(@RequestBody VotingRequest request){
        votingService.saveVote(request);
        return ResponseEntity.ok().build();
    }
}
