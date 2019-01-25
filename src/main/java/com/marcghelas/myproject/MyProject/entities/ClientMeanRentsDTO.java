package com.marcghelas.myproject.MyProject.entities;

import java.util.Map;

/**
 * Created by Marc on 24.01.2019.
 */
public class ClientMeanRentsDTO {
    String name;
    String surname;
    Map<String, Integer> map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }
}
