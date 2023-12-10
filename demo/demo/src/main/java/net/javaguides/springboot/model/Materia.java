package net.javaguides.springboot.model;

import jakarta.persistence.*;


@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="nombre_materia", nullable = false)
    private String nombre;
    @Column(name="creditos_materia", nullable = false)
    private int creditos;

    public Materia(){

    }

    public Materia(String nombre, int creditos){
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString(){
        return "Materia [id=" + id + ", nombre=" + nombre + ", creditos=" + creditos + "]";
    }

}
