package com.nruiz.sample.controllers;

import com.nruiz.sample.services.IdeaService;
import com.nruiz.sample.models.Idea;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/idea")
public class IdeaController {

    private IdeaService ideaService;

    public IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<Idea> getAllIdeas() {
        return this.ideaService.getAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public Idea save(@RequestBody Idea idea) {
        return this.ideaService.save(idea);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean delete(@PathVariable Long id) {
        return this.ideaService.delete(id);
    }

    @RequestMapping(value = "/upvote/{id}", method = RequestMethod.GET)
    public Idea upvote(@PathVariable Long id) {
        return this.ideaService.upvote(id);
    }

    @RequestMapping(value = "/downvote/{id}", method = RequestMethod.GET)
    public Idea downvote(@PathVariable Long id) {
        return this.ideaService.downvote(id);
    }
}