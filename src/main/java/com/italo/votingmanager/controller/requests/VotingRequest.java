package com.italo.votingmanager.controller.requests;

import lombok.Data;

@Data
public class VotingRequest {
    private String authorId;
    private String agendaId;
    private String vote;
}
