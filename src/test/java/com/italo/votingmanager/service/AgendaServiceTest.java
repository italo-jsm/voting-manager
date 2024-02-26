package com.italo.votingmanager.service;

import com.italo.votingmanager.controller.requests.CreateAgendaRequest;
import com.italo.votingmanager.controller.requests.OpenVotingRequest;
import com.italo.votingmanager.exceptions.AgendaException;
import com.italo.votingmanager.repository.AgendaRepository;
import com.italo.votingmanager.repository.entities.Agenda;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgendaServiceTest {
    @Mock
    private AgendaRepository agendaRepository;
    @InjectMocks
    private AgendaService agendaService;
    @Captor
    ArgumentCaptor<Agenda> agendaArgumentCaptor;

    @Test
    public void shouldOpenAgendaForVoting(){
        Agenda agenda = Agenda
                .builder()
                .id("AgendaId")
                .open(false)
                .build();
        OpenVotingRequest openVotingRequest = new OpenVotingRequest();
        openVotingRequest.setAgendaId("AgendaId");
        openVotingRequest.setDuration(1);
        when(agendaRepository.findById("AgendaId")).thenReturn(Optional.of(agenda));
        when(agendaRepository.save(agendaArgumentCaptor.capture())).thenReturn(agenda);
        agendaService.openAgenda(openVotingRequest);
        assertTrue(agendaArgumentCaptor.getValue().isOpen());
    }

    @Test
    public void shouldThrowExceptionWHenAgendaNotFound(){
        when(agendaRepository.findById("AgendaId")).thenReturn(Optional.empty());
        OpenVotingRequest openVotingRequest = new OpenVotingRequest();
        openVotingRequest.setAgendaId("AgendaId");
        openVotingRequest.setDuration(1);
        try{
            agendaService.openAgenda(openVotingRequest);
            fail("Should throw exception");
        }catch (Exception e){
            assertTrue(e instanceof AgendaException);
        }
    }
}
