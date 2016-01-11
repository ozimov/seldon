package it.ozimov.seldon.math.annotations;

import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@TypeQualifier(
        applicableTo = Number.class
)
@Retention(RetentionPolicy.RUNTIME)
public @interface Nonzero {

    When when() default When.ALWAYS;

    class Checker implements TypeQualifierValidator<Nonzero> {
        public Checker() {
        }

        public When forConstantValue(Nonzero annotation, Object v) {
            if(!(v instanceof Number)) {
                return When.NEVER;
            } else {
                Number value = (Number)v;
                boolean isZero;
                if(value instanceof Long) {
                    isZero = value.longValue() == 0L;
                } else if(value instanceof Double) {
                    isZero = value.doubleValue() == 0.0D;
                } else if(value instanceof Float) {
                    isZero = value.floatValue() == 0.0F;
                } else {
                    isZero = value.intValue() == 0;
                }

                return isZero?When.NEVER:When.ALWAYS;
            }
        }
    }
}
