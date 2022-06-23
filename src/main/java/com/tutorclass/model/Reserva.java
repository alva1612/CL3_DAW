package com.tutorclass.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_carreras")
public class Reserva {
	@Id
	private int codigo;
	private String nombre;
	private String apellido;
	@ManyToOne
	@JoinColumn(name = "idcarrera", insertable = false, updatable = false)
	private Carrera carrera;
	private int idcarrera;
	
	private Date fchregistro;
}
