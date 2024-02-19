package com.italo.votingmanager.controller.requests;

import lombok.Data;

@Data
public class OpenVotingRequest {
    private String agendaId;
    private int duration;
}
