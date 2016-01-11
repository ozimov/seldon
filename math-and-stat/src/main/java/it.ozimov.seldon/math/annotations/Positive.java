package it.ozimov.seldon.math.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@Documented
@TypeQualifier(applicableTo = Number.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Positive {

    When when() default When.ALWAYS;

    class Checker implements TypeQualifierValidator<Positive> {
        public Checker() { }

        public When forConstantValue(final Positive annotation, final Object v) {
            if (!(v instanceof Number)) {
                return When.NEVER;
            } else {
                Number value = (Number) v;
                boolean isNonPositive;
                if (value instanceof Long) {
                    isNonPositive = value.longValue() <= 0L;
                } else if (value instanceof Double) {
                    isNonPositive = value.doubleValue() <= 0.0D;
                } else if (value instanceof Float) {
                    isNonPositive = value.floatValue() <= 0.0F;
                } else {
                    isNonPositive = value.intValue() <= 0;
                }

                return isNonPositive ? When.NEVER : When.ALWAYS;
            }
        }
    }
}
