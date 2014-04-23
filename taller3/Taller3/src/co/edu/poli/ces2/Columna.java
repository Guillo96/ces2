
package co.edu.poli.ces2;

/**
 *
 * @author guillo
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface Columna {
    
    boolean clavePrimaria() default false;
    boolean autoNumerico() default false;
    
}

