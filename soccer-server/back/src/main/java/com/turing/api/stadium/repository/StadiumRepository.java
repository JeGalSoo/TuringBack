package com.turing.api.stadium.repository;

import com.turing.api.stadium.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("rawtypes")
@Repository
public interface StadiumRepository extends JpaRepository<Stadium,Long>, StadiumJpqlRepository,StadiumDao {


}
