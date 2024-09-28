package com.example.back.repositorys;

import com.example.back.clases.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Ventas, Integer> {
}
