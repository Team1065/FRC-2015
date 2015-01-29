package team1065.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Constants
    public static final double
           encoderCountPerRev = 360.0,
           driveWheelsDiameter = 8.0,
           driveMinSpeed = 0.2,
           driveStraightThresholdPercentage = .30,
           driveStraightPTerm = 0.0001;
	
	//Motors PMW input on Robot
    public static final int 
            frontLeftMotor  = 0,  
            frontRightMotor = 1,  
            backLeftMotor   = 2,  
            backRightMotor  = 3,
            elevatorMotor   = 4;
    
    //Digital Inputs
    public static final int
           encoderLeftA      = 0,
           encoderLeftB      = 1,
           encoderRightA     = 2,
           encoderRightB     = 3,
           topLimitSwitch    = 4,
           bottomLimitSwitch = 5;
    
    //OI
    public static final int 
           leftJoystick       = 0,
           rightJoystick      = 1,
           elevatorJoystick   = 2,
           triggerPort        = 1,  
           mecanumButtonPort  = 2; 
    
  //Elevator Knob values
    public static final double 
            elevatorVDposition0 = 0.3,
            elevatorVDposition1 = 0.5,
            elevatorVDposition2 = 1.2,
            elevatorVDposition3 = 1.8,
            elevatorVDposition4 = 2.4,
            elevatorVDposition5 = 3.1;
    
    //Auto Knob values
    public static final double 
            autoVDposition1 = 0.5,
            autoVDposition2 = 1.2,
            autoVDposition3 = 1.9,
            autoVDposition4 = 2.7;
}
