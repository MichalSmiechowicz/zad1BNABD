package com.example.demo.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "department_id")
    private Set<Employee> employees;

    public Department(String name, Set<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Department)) return false;
        final Department other = (Department) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$Name = this.getName();
        final Object other$Name = other.getName();
        if (this$Name == null ? other$Name != null : !this$Name.equals(other$Name)) return false;
        final Object this$employees = this.getEmployees();
        final Object other$employees = other.getEmployees();
        if (this$employees == null ? other$employees != null : !this$employees.equals(other$employees)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Department;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $Name = this.getName();
        result = result * PRIME + ($Name == null ? 43 : $Name.hashCode());
        final Object $employees = this.getEmployees();
        result = result * PRIME + ($employees == null ? 43 : $employees.hashCode());
        return result;
    }

    public String toString() {
        return "Department(id=" + this.getId() + ", Name=" + this.getName() + ", employees=" + this.getEmployees() + ")";
    }
}
