package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwareCarl {
    /* Public OpMode members*/
    public DcMotor leftDriveF = null;
    public DcMotor leftDriveB = null;
    public DcMotor rightDriveF = null;
    public DcMotor rightDriveB = null;
    public DcMotor flyWheel = null;


    /* local OpMode members. */
    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    /* Constructor */
    public HardwareCarl() {

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftDriveF  = hwMap.get(DcMotor.class, "left_drive_f");
        leftDriveB  = hwMap.get(DcMotor.class, "left_drive_b");
        rightDriveF = hwMap.get(DcMotor.class, "right_drive_f");
        rightDriveB = hwMap.get(DcMotor.class, "right_drive_b");
        flyWheel = hwMap.get(DcMotor.class, "flywheel");

        leftDriveF.setDirection(DcMotor.Direction.REVERSE); //Set to REVERSE if using AndyMark Motors
        leftDriveB.setDirection(DcMotor.Direction.REVERSE);
        rightDriveF.setDirection(DcMotor.Direction.FORWARD); //Set to FORWARD if using AndyMark Motors
        rightDriveF.setDirection(DcMotor.Direction.FORWARD);

        flyWheel.setDirection(DcMotorSimple.Direction.FORWARD);

        leftDriveF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftDriveB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDriveF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDriveB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //Set all motors to zero power
        leftDriveF.setPower(0);
        leftDriveB.setPower(0);
        rightDriveF.setPower(0);
        rightDriveB.setPower(0);
        flyWheel.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftDriveF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftDriveB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDriveF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDriveB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        flyWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }


}