package com.italo.votingmanager.repository.entities;

import com.italo.votingmanager.controller.requests.CreateAgendaRequest;
import com.italo.votingmanager.exceptions.AgendaException;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;


import static org.springframework.test.util.AssertionErrors.*;

public class AgendaEntityTest {
    @Test
    public void shouldCreateAgendaWithGeneratedIdFromRequest(){
        try {
            Agenda createdAgenda = createAgenda();
            assertEquals("Should be equal", "TestName",ReflectionUtils.tryToReadFieldValue(Agenda.class.getDeclaredField("name"), createdAgenda).get());
            assertEquals("Should be equal", "TestDescription",ReflectionUtils.tryToReadFieldValue(Agenda.class.getDeclaredField("description"), createdAgenda).get());
            assertNotNull("should not be null", createdAgenda.getId());
        } catch (Exception e) {
            fail("should not throw exception");
        }
    }
    
    @Test
    public void shouldOpenAgendaForVoting(){
        Agenda agenda = createAgenda();
        agenda.openForVoting();
        assertTrue("Agenda should be open", agenda.isOpen());
    }

    @Test
    public void shouldThrowExceptionWhenAgendaIsAlreadyOpen(){
        Agenda agenda = createAgenda();
        agenda.openForVoting();
        assertTrue("Agenda should be open", agenda.isOpen());
        try{
            agenda.openForVoting();
            fail("Should throw exception");
        }catch (Exception e){
            assertTrue("Should be AgendaException", e instanceof AgendaException);
        }
    }

    @Test
    public void shouldCloseForVoting(){
        Agenda agenda = createAgenda();
        agenda.openForVoting();
        assertTrue("Agenda should be open", agenda.isOpen());
        agenda.closeForVoting();
        assertFalse("Agenda should be open", agenda.isOpen());
    }

    private Agenda createAgenda(){
        CreateAgendaRequest request = new CreateAgendaRequest();
        request.setName("TestName");
        request.setDescription("TestDescription");
        return Agenda.createFromRequest(request);
    }
}
