package com.italo.votingmanager.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotingResultResponse {
    private String agendaId;
    private int votesSIM;
    private int votesNAO;
}
