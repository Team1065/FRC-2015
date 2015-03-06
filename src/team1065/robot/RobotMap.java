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
           regularSpeedPercentage = 0.45,
           elevatorPTerm = 1.0,
           elevatorPositionDeadBand = 0.001,
           elevatorJoystickMiddle = 0.063,
           elevatorJoystickDeadBand = 0.010,
		   intakeJoystickDeadBand = 0.010;
    
  //Elevator Position values
    public static final double 
            elevatorPosition0 = 4.859,
            elevatorPosition1 = 4.866,
            elevatorPosition2 = 4.874,
            elevatorPosition3 = 4.885,
            elevatorPosition4 = 4.932,
            elevatorPosition5 = 4.950;
    
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
	
	//PMW Outputs
    public static final int 
            frontLeftMotor  = 0,  
            frontRightMotor = 1,  
            backLeftMotor   = 2,  
            backRightMotor  = 3,
            elevatorMotor   = 4,
            leftIntakeMotor	= 5,
            rightIntakeMotor= 6;
    
  //Solenoids Outputs
    public static final int 
            fishingPoleLeftActuator  = 0,
    		fishingPoleRightActuator = 1;
    
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
           
           triggerButtonPort  	= 1,//JoyStick Digital
           mecanumButtonPort  	= 2,//JoyStick Digital
           
           elevatorKnobPort		= 0,//LaunchPad analog
           autoKnobPort			= 1,//LaunchPad analog
           elevatorAnalogPort	= 2,//LaunchPad analog
           intakeAnalogYPort	= 5,//LaunchPad analog VERIFY
           intakeAnalogXPort	= 4,//LaunchPad analog VERIFY
           
           fishingPolePort		= 1,//LaunchPad digital
           intakeInPort			= 4,//LaunchPad digital
           intakeOutPort		= 5,//LaunchPad digital
           elevatorOverridePort	= 9,//LaunchPad digital
           intakeOverridePort	= 2;//LaunchPad digital
  
}
