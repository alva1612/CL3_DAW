package com.tutorclass.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorclass.demo.model.Carrera;

@Repository
public interface ICarreraRepository extends JpaRepository<Carrera, Integer> {

}
