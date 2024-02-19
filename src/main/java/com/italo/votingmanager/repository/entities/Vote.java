package com.italo.votingmanager.repository.entities;

import com.italo.votingmanager.controller.requests.VotingRequest;
import com.italo.votingmanager.exceptions.EnumParseException;
import com.italo.votingmanager.repository.enums.VoteEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vote {
    @Id
    private String id;
    @Getter
    private String authorId;
    @Getter
    private String agendaId;
    private VoteEnum vote;

    public static Vote createFromRequest(VotingRequest request){
        if(request.getVote().equals("SIM") || request.getVote().equals("NAO")){
            return new Vote(UUID.randomUUID().toString(), request.getAuthorId(), request.getAgendaId(), VoteEnum.valueOf(request.getVote()));
        }else throw new EnumParseException("Vote can only be SIM ou NAO");

    }
}
