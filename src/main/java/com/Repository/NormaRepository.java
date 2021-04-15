package com.Repository;

import com.Model.Norma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NormaRepository extends JpaRepository<Norma, Long> {
    Norma findByAge(String age);

    List<Norma> findAllByAge(String age);
}
