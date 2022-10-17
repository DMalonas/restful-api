package com.events.dynamic_processing.model.persistence.repositories;

import com.events.dynamic_processing.model.persistence.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author DMalonas
 */
public interface TournamentRepository extends JpaRepository<Tournament,String> {}
