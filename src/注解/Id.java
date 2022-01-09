package 注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 表示这个注解只能出现在类上面
@Target(ElementType.TYPE)
// 可以通过反射读取
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {

}
