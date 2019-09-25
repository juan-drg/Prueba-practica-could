package com.jacc.everis.prueba.couldinventariorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jacc.everis.prueba.couldinventariorest.modelo.ProductoModel;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Integer>{

}
