package eventBus;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {
     ThreadMode threadMode() default ThreadMode.POSTING;
}
