package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="CarlTeleop", group="Test")
public class CarlTeleop extends LinearOpMode {

    /* Decalre OpMode memebers*/
    HardwareCarl robot = new HardwareCarl();

    @Override
    public void runOpMode() {
        double turn;
        double ForBack, LeftRight;
        double FL, FR, RL, RR;
        double maxMec1, maxMec2, maxMecSafe;
        double speed = 0;

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //Mecanum Wheel Drive
            {
                ForBack = -gamepad1.left_stick_y;
                LeftRight = gamepad1.left_stick_x;
                turn = gamepad1.right_stick_x;

                FL = ForBack + LeftRight + turn;
                FR = ForBack - LeftRight - turn;
                RL = ForBack - LeftRight + turn;
                RR = ForBack + LeftRight - turn;
                maxMec1 = Math.max(Math.abs(FL), Math.abs(FR));
                maxMec2 = Math.max(Math.abs(RR), Math.abs(RL));
                maxMecSafe = Math.max(Math.abs(maxMec1), Math.abs(maxMec2));
                if (maxMecSafe > 1){
                    FL /= maxMecSafe;
                    FR /= maxMecSafe;
                    RL /= maxMecSafe;
                    RR /= maxMecSafe;
                }

                if(gamepad1.left_bumper){
                    speed = 0;
                }
                else if (gamepad1.right_bumper){
                    speed = 1;
                }

                if (speed == 1){
                    robot.leftDriveF.setPower(FL);
                    robot.rightDriveF.setPower(FR);
                    robot.leftDriveB.setPower(RL);
                    robot.rightDriveB.setPower(RR);
                }
                else if (speed == 0){
                    robot.leftDriveF.setPower(FL / 3);
                    robot.rightDriveF.setPower(FR / 3);
                    robot.leftDriveB.setPower(RL / 3);
                    robot.rightDriveB.setPower(RR / 3);
                }

                //FlyWheel
                {
                    if (gamepad1.right_trigger > 0){
                        robot.flyWheel.setPower(gamepad1.right_trigger);
                    }
                    else{
                        robot.flyWheel.setPower(0);
                    }
                }

            }
        }
    }
}


