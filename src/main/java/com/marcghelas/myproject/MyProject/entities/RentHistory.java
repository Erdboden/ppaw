/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcghelas.myproject.MyProject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Student
 */
@Entity
@Table(name = "rent_history")
public class RentHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @Column(name = "days", nullable = false, unique = false)
    private int days;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @JsonBackReference
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_vehicle", referencedColumnName = "id")
    @JsonBackReference
    private Vehicle vehicle;

    public RentHistory() {
    }

}
