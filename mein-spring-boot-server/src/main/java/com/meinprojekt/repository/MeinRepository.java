package com.meinprojekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.meinprojekt.model.MeinModel;

@Repository
public interface MeinRepository extends JpaRepository<MeinModel, Long> {
    // Add custom query methods here
}