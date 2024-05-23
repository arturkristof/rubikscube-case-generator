package io.github.arturkristof.rubikscube.model;

public enum Facelet {
    U,
    L,
    F,
    R,
    B,
    D,
    X;

    public static Facelet of(final char character) {
        return Facelet.valueOf(Character.toString(character).toUpperCase());
    }
}
