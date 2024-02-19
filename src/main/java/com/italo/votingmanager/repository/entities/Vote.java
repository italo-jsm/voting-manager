package com.italo.votingmanager.repository.entities;

import com.italo.votingmanager.controller.requests.VotingRequest;
import com.italo.votingmanager.exceptions.EnumParseException;
import com.italo.votingmanager.repository.enums.VoteEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vote {
    @Id
    private String id;
    private String authorId;
    private String agendaId;
    private VoteEnum vote;

    public static Vote createFromRequest(VotingRequest request){
        if(request.getVote().equals("Sim") || request.getVote().equals("Nao")){
            return new Vote(UUID.randomUUID().toString(), request.getAuthorId(), request.getAgendaId(), VoteEnum.valueOf(request.getVote()));
        }else throw new EnumParseException("Vote can only be Sim ou Nao");

    }
}
