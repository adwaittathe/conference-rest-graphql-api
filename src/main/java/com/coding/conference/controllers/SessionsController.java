package com.coding.conference.controllers;

import com.coding.conference.models.Session;
import com.coding.conference.repositories.SessionRepository;
import com.coding.conference.services.SessionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public ResponseEntity<List<Session>> getAll()
    {
        List<Session> list = sessionService.getAll();
        return new ResponseEntity<List<Session>>(list, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id)
    {
        return sessionService.getById(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session)
    {
        return sessionService.create(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        sessionService.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session)
    {
        return sessionService.update(id,session);
    }
}
