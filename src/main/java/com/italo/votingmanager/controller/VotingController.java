package com.italo.votingmanager.controller;

import com.italo.votingmanager.controller.requests.VotingRequest;
import com.italo.votingmanager.repository.entities.Vote;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VotingController {
    @PostMapping("/vote")
    public ResponseEntity<Void> newVote(@RequestBody VotingRequest request){
        var s = Vote.createFromRequest(request);
        return ResponseEntity.ok().build();
    }
}
