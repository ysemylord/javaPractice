package polymorphism.extensionDesign;
class AlertStatus{
  public void getStatus(){}
}
class NormalStatus extends AlertStatus{
    @Override
    public void getStatus() {
        System.out.println("正常状态");
    }
}
class WarningStatus extends AlertStatus{
    @Override
    public void getStatus() {
        System.out.println("报警状态");
    }
}
class Starship{
   private AlertStatus mAlertStatus=new NormalStatus();
   public void performStatus(){
       mAlertStatus.getStatus();
   }
   public void changeStatus(AlertStatus alertStatus){
       mAlertStatus=alertStatus;
   }

}

public class EX16_Starship {
    public static void main(String[] args) {
        Starship starship=new Starship();
        starship.performStatus();
        starship.changeStatus(new WarningStatus());
        starship.performStatus();
    }
}
