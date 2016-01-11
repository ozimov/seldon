package it.ozimov.seldon.model.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import it.ozimov.seldon.model.primitive.DataEntry;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
@Documented
public @interface SafelyConvertable {

    Class<? extends DataEntry>[] to();

    class None implements DataEntry { }
}
