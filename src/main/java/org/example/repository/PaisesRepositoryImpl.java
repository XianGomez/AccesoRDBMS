package org.example.repository;

import org.example.database.DatabaseService;
import org.example.model.Pais;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PaisesRepositoryImpl {
    private final DatabaseService db;

    public PaisesRepositoryImpl() {
        this.db = new DatabaseService();
    }

    public List<Pais> findAll() throws SQLException {
        String sql = "SELECT * FROM Paises";
        return db.select(sql).stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    private Pais toModel(Map<String, Object> entity) {
        return new Pais(
                (int) entity.get("id"),
                (String) entity.get("nombre"),
                (double) entity.get("numero_habitantes"),
                (String) entity.get("capital"),
                (String) entity.get("moneda")
        );
    }
}
