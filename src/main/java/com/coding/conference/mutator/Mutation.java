package com.coding.conference.mutator;

import com.coding.conference.models.Session;
import com.coding.conference.repositories.SessionRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private SessionRepository sessionRepository;

    public Session newSession(String session_name, String session_description, int session_length)
    {
        Session session = new Session();
        session.setSession_name(session_name);
        session.setSession_description(session_description);
        session.setSession_length(session_length);
        sessionRepository.save(session);
        return session;
    }

    public boolean deleteSession(Long id)
    {
        sessionRepository.deleteById(id);
        return true;
    }

    public Session updateSessionName(String new_session_name, Long id)
    {
        Optional<Session> optionalExistingSession = sessionRepository.findById(id);
        if(optionalExistingSession.isPresent())
        {
            Session session = optionalExistingSession.get();
            session.setSession_name(new_session_name);
            sessionRepository.save(session);
            return session;
        }
        return null;
    }
}
