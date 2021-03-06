package org.usfirst.frc.team5968.robot;

public class ScaleAuto implements IRobotMode {
	
	private FieldSide startingPoint;
    private IDrive drive; 
    private IGrabber grabber;
    private ILift lift;
    private double rotationSpeed = 0.3;
    private double driveSpeed = 0.5;

    public ScaleAuto(FieldSide s, IDrive drive, IGrabber grabber, ILift lift) {
        startingPoint = s;
        this.drive = drive;
        this.grabber = grabber;
        this.lift = lift;
    }


    @Override
    public void init() {
        // Start the first step of this autonomous mode:
        goStraightLong();
    }

    @Override
    public void periodic() {
        // No periodic processing required, autonomous state is implicitly stored in drive and lift.
    }
    
    /*
	 * FIRST STEP: go straight 324 inches
	 */	
	public void goStraightLong() {
		
		if (startingPoint == FieldSide.LEFT) {
	        drive.driveDistance(324.0, driveSpeed, () -> turnRight());
        } else if (startingPoint==FieldSide.RIGHT) {
            drive.driveDistance(324.0, driveSpeed, () -> turnLeft());
        }
	}
	
    /*
     * SECOND STEP A: turn right towards scale
     */ 
    public void turnRight() {
        //drive.rotateDegrees(90.0, drive -> goStraightShort(drive));
        drive.rotateDegrees(90.0, rotationSpeed, () -> liftGrabber());
    }
    
    /*
     * SECOND STEP B: turn left towards scale
     */ 
    public void turnLeft() {
        //drive.rotateDegrees(-90.0, drive -> goStraightShort(drive));
        drive.rotateDegrees(-90.0, rotationSpeed, () -> liftGrabber());
    }
	
	/*
	 * THIRD STEP: lift the grabber to the highest preset
	 */	
	public void liftGrabber() {
		lift.goToScaleHeight(() -> openGrabber());

	}

	/*
	 * FOURTH STEP: go straight a small amount of inches 
	 * PROBABLY UNNECESSARY AS OF NOW
	public void goStraightShort(IDrive drive) {
		drive.driveDistance(0.5, 30.0, () -> openGrabber(drive));
	}
	*/	
	
	/*
	 * FIFTH STEP: open the grabber
	 */	
	public void openGrabber() {
		grabber.release();
	}
	
}
