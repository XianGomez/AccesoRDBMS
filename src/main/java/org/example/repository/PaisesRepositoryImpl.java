package org.example.repository;

import org.example.database.DatabaseService;
import org.example.model.Pais;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PaisesRepositoryImpl {
    private final DatabaseService db;

    public PaisesRepositoryImpl() {
        this.db = new DatabaseService();
    }

    public void getPaisConMasHabitantes(List<Pais> paises) {
        Pais paisConMasHabitantes = paises.stream()
                                            .max(Comparator.comparingDouble(Pais::getNumeroHabitantes))
                                            .orElseThrow(() -> new RuntimeException("La lista está vacía"));
        System.out.println("\nPais con mas habitantes: " + paisConMasHabitantes);
    }

    public void getPaisesConMoneda(List<Pais> paises, String moneda) {
        System.out.println("\nPaises con moneda: " + moneda);
        paises.stream()
                .filter(p -> p.getMoneda()
                                    .equals(moneda))
                                    .forEach(System.out::println);
    }

    public void getPaisesPorNombre(List<Pais> paises, String nombre) {
        System.out.println("\nPaises cuyo nombre contiene: " + nombre);
        paises.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .forEach(System.out::println);
    }

    public void getPaisesConMasDeHabitantes(List<Pais> paises, double habitantes) {
        System.out.println("\nPaises con mas de " + habitantes + " habitantes:");
        paises.stream()
                .filter(p -> p.getNumeroHabitantes() > habitantes)
                .sorted(Comparator.comparingDouble(Pais::getNumeroHabitantes).reversed())
                .forEach(System.out::println);
    }

    public void getPaisesOrdenAlfabetico(List<Pais> paises) {
        System.out.println("\nPaises por orden alfabético: ");
        paises.stream()
                .sorted(Comparator.comparing(Pais::getNombre))
                .toList().forEach(System.out::println);
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
