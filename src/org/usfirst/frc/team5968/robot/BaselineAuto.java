package org.usfirst.frc.team5968.robot;

import edu.wpi.first.wpilibj.DriverStation.Alliance;

public class BaselineAuto implements IRobotMode {
	
	private FieldSide startingPoint;
	private IDrive drive;
	private double driveSpeed = 0.5;

    public BaselineAuto(FieldSide startingPoint, IDrive drive) {
        startingPoint = this.startingPoint;
        this.drive = drive;
    }

    @Override
    public void init() {
        // Start the first step of this autonomous mode:
        goStraight();
    }

    @Override
    public void periodic() {
        // No periodic processing required, autonomous state is implicitly stored in drive and lift.
    }

    /*
	 * FIRST STEP: go straight 168 inches
	 */	
	public void goStraight() {
		drive.driveDistance(168.0, driveSpeed);
	}
	
}
