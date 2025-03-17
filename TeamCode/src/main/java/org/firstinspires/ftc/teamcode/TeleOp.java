package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.intake.Intake;
import org.firstinspires.ftc.teamcode.intake.Spinner;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {

   Intake intake;


    @Override
    public void runOpMode() throws InterruptedException {
        intake = new Intake(hardwareMap);

        waitForStart();

        while (opModeIsActive()){
            intake.loop();
        }
    }

    boolean wasAPressed = false;
    public void controls() {
        if(gamepad1.a && !wasAPressed){
            if (gamepad1.left_bumper) {
                intake.setState((Intake.State.REVERSED));
            }
        }
        if(gamepad1.a && !wasAPressed){
            if (intake.getState() = Intake.State.DROPPED);

        }else {
            intake.setState(Intake.State.IDLE);
        }
    }


    public void controls(){
     if (gamepad1.a){
         intake.setState(Intake.State.FORWARD);
     }
    }

}



