package com.turing.api.stadium.repository;

import com.turing.api.stadium.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium,Long> {
}
