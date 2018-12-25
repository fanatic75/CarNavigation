import java.util.*;

public class CarNavigation{
   public static void main(String ...args){
       Car car = new Car();
       car.takeInput();
       car.moveThroughRoute();
       double displacement=car.locationDisplacement();
       System.out.println("Displacement is "+displacement);
   }

}
