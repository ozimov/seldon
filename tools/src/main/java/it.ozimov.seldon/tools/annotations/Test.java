package it.ozimov.seldon.tools.annotations;

import javax.annotation.Nullable;

public class Test {

    public static void main(final String... args) {
// Reflections reflection = new Reflections();
        Nullable n = XXX.class.getAnnotation(javax.annotation.Nullable.class);
        System.out.println(n);
    }
}
