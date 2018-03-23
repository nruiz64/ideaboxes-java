package com.nruiz.sample.repositories;

import com.nruiz.sample.models.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Long> {
    Idea findById(Long id);
}