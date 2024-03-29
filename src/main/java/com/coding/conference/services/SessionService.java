package com.coding.conference.services;

import com.coding.conference.models.Session;
import com.coding.conference.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> getAll()
    {
        return sessionRepository.findAll();
    }

    public Session getById(Long id)
    {
        return sessionRepository.getOne(id);
    }

    public Session create(Session session)
    {
        return sessionRepository.saveAndFlush(session);
    }

    public  void delete(Long id)
    {
        //Need to check for children record before deleting
        sessionRepository.deleteById(id);
    }

    public Session update(Long id, Session session)
    {
        //As this is put we need to add all the attributes to be passed in
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }


}
