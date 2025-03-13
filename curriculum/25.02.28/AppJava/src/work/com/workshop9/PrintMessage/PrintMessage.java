package work.com.workshop9.PrintMessage;

import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface PrintMessage {

}
