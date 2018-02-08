package model;


import model.wonderboards.WonderBoard;

public interface Bonus {

    default void applyInstant(WonderBoard wonderBoard) {
        // To override if needed
    }

    default void applyEnd(WonderBoard wonderBoard) {
        // To override if needed
    }
}
