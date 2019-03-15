package annotationDemo;

public class Fruit {
    @FruitName("西瓜")
    private String fruitName;

    @FruitColor(color = "红色")
    private String fruitColor;

    @FruitProvider(providerName = "天天水果",providerAddress="广西")
    private String fruitProvidor;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitColor() {
        return fruitColor;
    }

    public void setFruitColor(String fruitColor) {
        this.fruitColor = fruitColor;
    }

    public String getFruitProvidor() {
        return fruitProvidor;
    }

    public void setFruitProvidor(String fruitProvidor) {
        this.fruitProvidor = fruitProvidor;
    }
}
