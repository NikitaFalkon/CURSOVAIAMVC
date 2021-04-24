package com.repository;

import com.model.Norma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NormaRepository extends JpaRepository<Norma, Long> {
    Norma findByAge(String age);

    List<Norma> findAllByAge(String age);

    List<Norma> findAllByName(String name);
}
