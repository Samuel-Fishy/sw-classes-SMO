package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Extension {
    Servo Left;
    Servo Right;

    State currentState = State.IDLE;
    boolean firstRun = true;

    public Extension(HardwareMap map) {
        Right = map.get(Servo.class, "Sright");
        Left = map.get(Servo.class, "Sleft");
    }

    public void setState(State newState) {
        if (currentState != newState) {
            currentState = newState;
        }
    }

    public State getState() {
        return currentState;
    }

    private static final double Servo_EXTENDED = 0.62, Servo_IDLE = 0;

    public void loop() {
        switch (currentState) {
            case EXTENDED:
                if (firstRun) {
                    Left.setPosition(Servo_IDLE);
                }
                break;
            case IDLE:
                if (firstRun) {
                    Right.setPosition(Servo_EXTENDED);
                }
                break;
        }

        firstRun = false;
    }

    public void setState(Arm.State state) {
    }

    public enum State {
        IDLE,
        EXTENDED,
    }
}
