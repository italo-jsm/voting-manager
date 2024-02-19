package com.italo.votingmanager.repository;

import com.italo.votingmanager.repository.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VotingRepository extends JpaRepository<Vote, String> {
    Optional<Vote> findByAgendaIdAndAuthorId(String agendaId, String authorId);

    @Query(value = "select count(vote) from vote v where v.vote = 0 and v.agenda_id = ?1", nativeQuery = true)
    int findCountVotesYesByAgendaId(String agendaId);

    @Query(value = "select count(vote) from vote v where v.vote = 1 and v.agenda_id = ?1", nativeQuery = true)
    int findCountVotesNoByAgendaId(String agendaId);
}
