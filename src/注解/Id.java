package 注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Deprecated // 代表被标注的元素已过时
// 表示这个注解只能出现在类上面（元注解）
@Target(ElementType.TYPE)
/**
 * source：表示该注解只存在于Java源文件中
 * class：表示该注解被保存在class文件中
 * runtime：表示该注解被保存在class文件中，并且可以被反射机制读取
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {

}
