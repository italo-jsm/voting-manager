package com.italo.votingmanager.controller.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotingRequest {
    private String authorId;
    private String agendaId;
    private String vote;
}
