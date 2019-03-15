package annotationDemo;

import java.lang.reflect.Field;

public class FruitInfoUtil {
    public static void getFruitInfo(Class<Fruit> fruitClass) {
        Field[] fruitFields = fruitClass.getDeclaredFields();
        for (Field fruitField : fruitFields) {
            if (fruitField.isAnnotationPresent(FruitName.class)) {//field上有FruitName这个注解
                FruitName fruitNameAnotation = fruitField.getAnnotation(FruitName.class);
                System.out.println("水果名称" + fruitNameAnotation.value());
            } else if (fruitField.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColorAnotation=fruitField.getAnnotation(FruitColor.class);
                System.out.println("水果颜色"+fruitColorAnotation.color());
            } else if (fruitField.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProviderAnotation=fruitField.getAnnotation(FruitProvider.class);
                System.out.println("供应商信息:"+fruitProviderAnotation.providerAddress()+" "+fruitProviderAnotation.providerName());

            }
        }
    }
}
