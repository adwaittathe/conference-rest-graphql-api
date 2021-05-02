package com.coding.conference.controllers;

import com.coding.conference.models.Speaker;
import com.coding.conference.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list()
    {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id)
    {
        return speakerRepository.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker)
    {
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        //Need to check for children record before deleting
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker)
    {
        //As this is put we need to add all the attributes to be passed in
        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
