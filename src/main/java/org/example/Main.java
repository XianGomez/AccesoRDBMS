package org.example;

import org.example.repository.PaisesRepositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws SQLException {
        PaisesRepositoryImpl repository = new PaisesRepositoryImpl();
        repository.findAll().forEach(System.out::println);
    }
}
