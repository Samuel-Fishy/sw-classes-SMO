package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class HelloWorld extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotorEx motor = hardwareMap.get(DcMotorEx.class, "motor");

        Servo servo = hardwareMap.get(Servo.class, "Servo");

        double CLAW_OPEN = 0.65;
        double CLAW_CLOSE = 0.35;

        boolean clawOpen = false;
        boolean wasAPressed = false;

        double ARM_DOWN = 0.92;
        double ARM_UP = 0.09;

        boolean armDown = false;
        boolean wasBPressed = false;

        Servo outkClaw = hardwareMap.get(Servo.class, "outkClaw");

        Servo armLeft = hardwareMap.get(Servo.class, "outkArmL");
        Servo armRight = hardwareMap.get(Servo.class, "outkArmR");

        armRight.setDirection((Servo.Direction.REVERSE));

        armLeft.setPosition(ARM_UP);
        armRight.setPosition(ARM_UP);


        outkClaw.setPosition(CLAW_CLOSE);

        waitForStart();

        while (opModeIsActive()) {


            if (gamepad1.b && !wasBPressed) {

                if (armDown) {
                    armDown = false;
                    armLeft.setPosition(ARM_UP);
                    armRight.setPosition(ARM_UP);
                } else {
                    armDown = true;
                    armLeft.setPosition(ARM_DOWN);
                    armRight.setPosition(ARM_DOWN);
                }


            }

            if (gamepad1.a && !wasAPressed) {
                if (clawOpen) {
                    clawOpen = false;
                    outkClaw.setPosition(CLAW_CLOSE);

                } else {
                    clawOpen = true;
                    outkClaw.setPosition(CLAW_OPEN);
                }


            }


            wasAPressed = gamepad1.a;


        }
    }
}
