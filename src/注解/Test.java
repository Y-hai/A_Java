package 注解;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取类
        Class userClass = Class.forName("注解.User");
        // 判断类上面是否存在注解
        if(userClass.isAnnotationPresent(Id.class)){
            boolean isOk = false;
            // 有id直接必须有id属性
            Field[] fields = userClass.getDeclaredFields();
            for (Field f:fields){
                if("id".equals(f.getName()) && "int".equals(f.getType().getSimpleName())){
                    // 表示类合法
                    isOk = true;
                    break;
                }
            }
            // 判断是否合法
            if(!isOk){
                throw new HasNotIdPropertyException("被@Id标注的类都必须有id属性");
            }
        }
    }
}
