package org.example;

import org.example.model.Pais;
import org.example.repository.PaisesRepositoryImpl;


import java.sql.SQLException;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws SQLException {
        PaisesRepositoryImpl repository = new PaisesRepositoryImpl();
        List<Pais> paises = repository.findAll();
        paises.forEach(System.out::println);


        repository.getPaisConMasHabitantes(paises);
        repository.getPaisesConMoneda(paises, "Euro");
        repository.getPaisesPorNombre(paises, "al");
        repository.getPaisesConMasDeHabitantes(paises, 4000000);
        repository.getPaisesOrdenAlfabetico(paises);
    }


}
