package com.tutorclass.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorclass.demo.model.Reserva;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer>{

}
