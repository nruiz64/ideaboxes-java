package com.nruiz.sample.services;

import com.nruiz.sample.models.Idea;
import com.nruiz.sample.repositories.IdeaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IdeaService {

    private IdeaRepository ideaRepository;

    public IdeaService(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    public List<Idea> getAll(){
        return this.ideaRepository.findAll();
    }

    public Idea save(Idea idea){
        return this.ideaRepository.save(idea);
    }

    public boolean delete(Long id){
        Idea ideaToDelete = this.ideaRepository.findById(id);
        if( ideaToDelete == null){
            return false;
        }

        this.ideaRepository.delete(id);

        return false;

    }

    public Idea upvote(Long id){
        Idea idea = this.ideaRepository.findById(id);
        if(idea != null){
            idea.setVote(idea.getVote()+1);
            idea = this.ideaRepository.save(idea);
        }

        return idea;
    }

    public Idea downvote(Long id){
        Idea idea = this.ideaRepository.findById(id);
        if(idea != null){
            idea.setVote(idea.getVote()-1);
            idea = this.ideaRepository.save(idea);
        }

        return idea;
    }
}
