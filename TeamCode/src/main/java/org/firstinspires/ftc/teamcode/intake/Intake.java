package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
  Spinner spinner;
  Arm arm;


  Extension extension;

  State currentState = State.IDLE;

    public Intake(HardwareMap map) {
        arm = new Arm(map);
        spinner = new Spinner(map);
    }

    public void setState(State newState){
        currentState = newState;

    }
    public State getState() {
        currentState = newState;
    }

    public void loop() {
       switch (currentState) {
            case IDLE:
                arm.setState(Arm.State.IDLE);
                spinner.setState(Spinner.State.IDLE);
                break;
            case DROPPED:
                arm.setState(Arm.State.DROPPED);
                spinner.setState(Spinner.State.Forward);
                break;
            case REVERSED:
                arm.setState(Arm.State.DROPPED);
                spinner.setState(Spinner.State.REVERSED);
                break;
           case EXTENDED:
               extension.setState(Arm.State.EXTENDED);
               spinner.setState(Spinner.State.IDLE);
               break;
        }
        arm.loop();
        spinner.loop();

    }





    public enum State{
       IDLE,
       DROPPED,
       REVERSED,

        EXTENDED,
   }
}
