package ces2_2014a.jdbc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author thomas
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Columna {

    boolean PK() default false;
    boolean AI() default false;

}
