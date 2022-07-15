package com.example.demo.entities;



import java.util.ArrayList;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Partido {
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String torneo;
	private String jugador1;
	private String jugador2;
	private Integer cant_sets;
	private Integer probabilidad_J1;
	private Integer probabilidad_J2;
	private Integer sets_J1;
	private Integer sets_J2;
	private ArrayList<Integer> lista_Sets_J1;
	private ArrayList<Integer> lista_Sets_J2;
}