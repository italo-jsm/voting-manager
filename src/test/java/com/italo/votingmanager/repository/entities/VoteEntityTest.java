package com.italo.votingmanager.repository.entities;

import com.italo.votingmanager.controller.requests.VotingRequest;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class VoteEntityTest {
    @Test
    public void shouldCreateVoteFromRequest(){
        VotingRequest votingRequest = new VotingRequest();
        votingRequest.setVote("SIM");
        votingRequest.setAgendaId("agendaId");
        votingRequest.setAuthorId("authorId");
        var createdVote = Vote.createFromRequest(votingRequest);
        try {
            assertNotNull(ReflectionUtils.tryToReadFieldValue(Vote.class.getDeclaredField("id"), createdVote));
        } catch (NoSuchFieldException e) {
            fail("Should Not Throw exception");
        }
    }
}
