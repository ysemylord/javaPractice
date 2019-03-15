package reusingClass.delegant;

public class Exercise11 {
    public static void main(String[] args) {
        Detergent detergent=new Detergent("detergent");
        DetergentDelegant detergentDelegant=new DetergentDelegant(detergent);
        detergentDelegant.append("代理append");
        detergentDelegant.scrub();
        detergentDelegant.dilute();
    }
}
