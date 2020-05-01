package com.app.pharmacy.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "employee")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
//    , @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId")
//    , @NamedQuery(name = "Employee.findByRole", query = "SELECT e FROM Employee e WHERE e.role = :role")})
@PrimaryKeyJoinColumn(name = "person_id")
public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    private RoleEnum role;

    public Employee() {
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

}
