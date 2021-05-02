package com.coding.conference.resolver;


import com.coding.conference.models.Session;
import com.coding.conference.repositories.SessionRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private SessionRepository sessionRepository;

    public Iterable<Session> findAllSessions()
    {
        return sessionRepository.findAll();
    }

    public int countSession()
    {
        return (int)sessionRepository.count();
    }
}
