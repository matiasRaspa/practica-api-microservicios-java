package com.api.cursadaservice.repository;

import com.api.cursadaservice.model.Cursada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursadaRepository extends JpaRepository<Cursada, Long> {
}
