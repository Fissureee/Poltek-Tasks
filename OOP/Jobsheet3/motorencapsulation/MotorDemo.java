package motorencapsulation;

public class MotorDemo {

    public static void main(String[] args) {
        Motor motor = new Motor();
//        motor.printStatus();
//        motor.tambahKecepatan();
//
//        motor.nyalakanMesin();
//        motor.printStatus();
//
//        motor.tambahKecepatan();
//        motor.printStatus();
//
//        motor.tambahKecepatan();
//        motor.printStatus();
//
//        motor.tambahKecepatan();
//        motor.printStatus();
//
//        motor.matikanMesin();
//        motor.printStatus();

        motor.nyalakanMesin();
        for (int i = 0; i <= 100; i++){
            motor.tambahKecepatan();
        }
        motor.printStatus();
    }
}
