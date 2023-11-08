package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by sskim on 2021/06/06
 * Github : http://github.com/sskim91
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxLength {
    int value() default 0;
}
