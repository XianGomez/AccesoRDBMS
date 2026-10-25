package org.example.model;

public class Pais {

    private int id;
    private String nombre;
    private double numeroHabitantes;
    private String capital;
    private String moneda;

    public Pais(int id, String nombre, double numeroHabitantes, String capital, String moneda) {
        this.id = id;
        this.nombre = nombre;
        this.numeroHabitantes = numeroHabitantes;
        this.capital = capital;
        this.moneda = moneda;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public String getCapital() {
        return capital;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroHabitantes(double numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numeroHabitantes=" + numeroHabitantes +
                ", capital='" + capital + '\'' +
                ", moneda='" + moneda + '\'' +
                '}';
    }

}
