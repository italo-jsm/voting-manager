package com.italo.votingmanager.repository;

import com.italo.votingmanager.repository.entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, String> {
}
