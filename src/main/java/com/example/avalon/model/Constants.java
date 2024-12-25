package com.example.avalon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Constants {
    public enum TeamType { GOOD, EVIL }


    @Getter
    @AllArgsConstructor
    public enum RoleType {
        // Good roles
        MERLIN(TeamType.GOOD),
        PERCIVAL(TeamType.GOOD),
        KNIGHT(TeamType.GOOD),

        // Evil roles
        MORDRED(TeamType.EVIL),
        OBERON(TeamType.EVIL),
        EVIL_KNIGHT(TeamType.EVIL),
        ASSASSIN(TeamType.EVIL),
        MORGANA(TeamType.EVIL);

        private final TeamType team;

        public static RoleType getRandomRole() {
            return values()[(int) (Math.random() * values().length)];
        }
        public static RoleType[] getGoodRoles() {
            return new RoleType[]{MERLIN, PERCIVAL, KNIGHT};
        }

        public static RoleType[] getEvilRoles() {
            return new RoleType[]{MORDRED, OBERON, EVIL_KNIGHT, ASSASSIN, MORGANA};
        }

        public static RoleType[] get5PlayerRoles() {
            return new RoleType[]{MERLIN, PERCIVAL, KNIGHT, MORGANA, ASSASSIN};
        }

        public static RoleType[] get6PlayerRoles() {
            return new RoleType[]{MERLIN, PERCIVAL, KNIGHT, MORGANA, ASSASSIN, KNIGHT};
        }

    }
}
