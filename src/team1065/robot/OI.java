package team1065.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//DriverStationEnhancedIO ds;
	Joystick lJoystick, rJoystick, enhancedDS;
	
	JoystickButton mecanumButton;
	JoystickButton fullSpeedButton;
    
    
	public OI() {
		lJoystick = new Joystick(RobotMap.leftJoystick);
	    rJoystick = new Joystick(RobotMap.rightJoystick);
	    enhancedDS = new Joystick(RobotMap.enhancedDS);
	    
	    mecanumButton = new JoystickButton(rJoystick, RobotMap.mecanumButtonPort);
	    fullSpeedButton = new JoystickButton(rJoystick, RobotMap.triggerButtonPort);
	    
	}
	
	public double getleftJoystickY () {
		return -lJoystick.getY();
	}
	
	public double getrightJoystickY () {
		return -rJoystick.getY();
	}
	
	public double getRightX() {
        return rJoystick.getX();
    }
    
    public double getYAverage(){
        return ((-lJoystick.getY()) + (-rJoystick.getY()))/2.0;
    }
    
    public boolean getMecanumButton(){
        return mecanumButton.get();
    }
    
    public boolean getFullSpeedButton(){
        return fullSpeedButton.get();
    }
    
    public boolean getElevatorManualButton(){
    	//add once we have a functional knob
    	//return enhancedDS.getRawButton(RobotMap.elevatorDigitalPort);
    	return false;
    }
    
    public double getElevatorJoystickY(){
		return enhancedDS.getRawAxis(RobotMap.elevatorAnalogPort);
	}
    
    public double getElevatorDesiredPosition(){
    	double position = RobotMap.elevatorKnob0;
		double knobValue = enhancedDS.getRawAxis(RobotMap.elevatorKnobPort);
		double threshold = .3;
		
		if(knobValue < RobotMap.elevatorKnob0 + threshold){
            position = Robot.pref.getDouble("elevatorPosition0", RobotMap.elevatorPosition0);
        }
        //If Station Knob is at 
        else if(knobValue >= RobotMap.elevatorKnob1 && knobValue < RobotMap.elevatorKnob1 + threshold){
            position = Robot.pref.getDouble("elevatorPosition1", RobotMap.elevatorPosition1);
        }
        //If Station Knob is at 
        else if(knobValue >= RobotMap.elevatorKnob2 && knobValue < RobotMap.elevatorKnob2 + threshold){
            position = Robot.pref.getDouble("elevatorPosition2", RobotMap.elevatorPosition2);
        }
        //If Station Knob is at 
        else if(knobValue >= RobotMap.elevatorKnob3 && knobValue < RobotMap.elevatorKnob3 + threshold){
            position = Robot.pref.getDouble("elevatorPosition3", RobotMap.elevatorPosition3);
        }
        //If Station Knob is at 
        else if(knobValue >= RobotMap.elevatorKnob4 && knobValue < RobotMap.elevatorKnob4 + threshold){
            position = Robot.pref.getDouble("elevatorPosition4", RobotMap.elevatorPosition4);
        }
        //If Station Knob is at 
        else if(knobValue >= RobotMap.elevatorKnob5){
            position = Robot.pref.getDouble("elevatorPosition5", RobotMap.elevatorPosition5);
         }
		
		return position;
	}
}

