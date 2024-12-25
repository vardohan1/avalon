package com.example.avalon.model;

import com.example.avalon.model.Constants.TeamType;
import com.example.avalon.model.Constants.RoleType;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Player {

    private String name;
    private RoleType role;

    public Player(String name, RoleType role) {
        this.name = name;
        this.role = role;
    }

    public TeamType getTeam() {
        return role.getTeam();
    }

}
