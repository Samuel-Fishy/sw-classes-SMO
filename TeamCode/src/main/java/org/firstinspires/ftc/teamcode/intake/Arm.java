package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {
    Servo armServo;

    State currentState = State.IDLE;
    boolean firstRun = true;

    public Arm(HardwareMap map) {
        armServo = map.get(Servo.class, "intkArm");
    }

    public void setState(State newState) {
        if (currentState != newState) {
            firstRun = true;
            currentState = newState;
        }
    }

    public State getState() {
        return currentState;
    }

    private static final double ARM_DROPPED = 0, ARM_IDLE = 0;

    public void loop() {
        switch (currentState) {
            case DROPPED:
                if (firstRun) {
                    armServo.setPosition(ARM_DROPPED);
                }
                break;
            case IDLE:
                if (firstRun) {
                    armServo.setPosition(ARM_IDLE);
                }
                break;
        }

        firstRun = false;
    }

    public enum State {
        IDLE,
        EXTENDED, DROPPED
    }
}
