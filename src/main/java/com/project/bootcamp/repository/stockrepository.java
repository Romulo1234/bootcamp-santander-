package com.project.bootcamp.repository;

import com.project.bootcamp.mode.dto.StockDTO;
import com.project.bootcamp.mode.stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface stockrepository extends JpaRepository<stock, Long> {

    Optional<stock> finByNameAndDate(String name, LocalDate date);
@Query("SELECT stock" +
        "FROM stock stock" +
          "where stock.name = :name and stock.date = :date and stock.id <> :id")
    Optional<stock> findSBytockUpdate(String name, LocalDate date, Long id);


@Query("SELECT stock" +
        "FROM stock stock" +
        "where stock.date = :date")
    Optional<List<stock>>findByToday(LocalDate date);
}
