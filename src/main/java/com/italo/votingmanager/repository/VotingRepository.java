package com.italo.votingmanager.repository;

import com.italo.votingmanager.repository.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VotingRepository extends JpaRepository<Vote, String> {
    Optional<Vote> findByAgendaIdAndAuthorId(String agendaId, String authorId);
}
