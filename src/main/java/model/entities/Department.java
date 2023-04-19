package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable {
    private int id;
    private String name;

    //Constructors
    public Department() {
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters / Setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // equals e hash code para comparação dos objetos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //metodo de representacao do objeto
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
