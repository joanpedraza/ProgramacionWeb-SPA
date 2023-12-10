package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long>{
}
