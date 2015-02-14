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
           driveStraightPTerm = 0.0001,
           regularSpeedPercentage = 0.35,
           elevatorPTerm = 1.0,
           elevatorPositionDeadBand = 0.1,
           elevatorJoystickMiddle = 0.063,
           elevatorJoystickDeadBand = 0.005;
    
  //Elevator Position values
    public static final double 
            elevatorPosition0 = 0.5,
            elevatorPosition1 = 1.0,
            elevatorPosition2 = 2.0,
            elevatorPosition3 = 2.5,
            elevatorPosition4 = 3.0,
            elevatorPosition5 = 4.5;
    
    //Elevator Knob values
    public static final double 
    		elevatorKnob0 = 0.000,
            elevatorKnob1 = 0.024,
            elevatorKnob2 = 0.047,
            elevatorKnob3 = 0.071,
            elevatorKnob4 = 0.094,
            elevatorKnob5 = 0.118;
            
    
    //Auto Knob values
    public static final double 
            autoKnob0 = 0.000,
            autoKnob1 = 0.024,
            autoKnob2 = 0.055,
            autoKnob3 = 0.087;
	
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
    
  //Analog Inputs
    public static final int
           potentiometer      = 0;
    
    //OI
    public static final int 
           leftJoystick       	= 0,
           rightJoystick      	= 1,
           enhancedDS   	  	= 2,
           triggerButtonPort  	= 1,  
           mecanumButtonPort  	= 2,
           elevatorAnalogPort	= 2,//LaunchPad analog
           elevatorKnobPort		= 0,//LaunchPad analog
           autoKnobPort			= 1,//LaunchPad analog
           elevatorDigitalPort	= 8;//LaunchPad digital
    
  
}
