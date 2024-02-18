package com.italo.votingmanager.controller.requests;

import lombok.Data;

@Data
public class CreateAgendaRequest {
    private String name;
    private String description;
}
