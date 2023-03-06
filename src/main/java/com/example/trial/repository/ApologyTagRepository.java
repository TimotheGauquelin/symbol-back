package com.example.trial.repository;

import com.example.trial.model.ApologyTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApologyTagRepository extends JpaRepository<ApologyTag, Long> {
}
