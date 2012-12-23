package com.therapservice.mealplanner.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/23/12
 * Time: 12:31 PM
 */
public enum Role {
    ROLE_ADMIN(9), ROLE_USER(1);
    private int value;

    private Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
