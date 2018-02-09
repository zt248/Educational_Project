package com.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "organization")
//    private String organization;

    @Column(name = "position")
    private String position;

    @ManyToMany(mappedBy = "departments", fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public Department() {

    }


    public Department(Long id, String position) {
        this.id = id;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", employees=" + employees +
                '}';
    }
}
