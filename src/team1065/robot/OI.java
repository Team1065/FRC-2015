package team1065.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//DriverStationEnhancedIO ds;
	Joystick lJoystick, rJoystick, enhancedDS;
	
	JoystickButton mecanumButton;
	JoystickButton halfSpeedButton;
    
    
	public OI() {
		lJoystick = new Joystick(RobotMap.leftJoystick);
	    rJoystick = new Joystick(RobotMap.rightJoystick);
	    enhancedDS = new Joystick(RobotMap.enhancedDS);
	    
	    mecanumButton = new JoystickButton(rJoystick, RobotMap.mecanumButtonPort);
	    halfSpeedButton = new JoystickButton(rJoystick, RobotMap.triggerButtonPort);
	    
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
    
    public boolean getHalfSpeedButton(){
        return halfSpeedButton.get();
    }
    
    public boolean getElevatorManualButton(){
    	return enhancedDS.getRawButton(RobotMap.elevatorOverridePort);	
    }
    
    public boolean getIntakeOverrideButton(){
    	return enhancedDS.getRawButton(RobotMap.intakeOverridePort);
    }
    
    public boolean getIntakeInButton(){
    	return enhancedDS.getRawButton(RobotMap.intakeInPort);
    }
    
    public boolean getIntakeOutButton(){
    	return enhancedDS.getRawButton(RobotMap.intakeOutPort);
    }
    
    public boolean getFishingPoleButton(){
    	return enhancedDS.getRawButton(RobotMap.fishingPolePort);
    }
    
    public double getElevatorJoystickY(){
		return enhancedDS.getRawAxis(RobotMap.elevatorAnalogPort);
	}
    
    public double getIntakeJoystickY(){
		return enhancedDS.getRawAxis(RobotMap.intakeAnalogYPort);
	}
    
    public double getIntakeJoystickX(){
		return enhancedDS.getRawAxis(RobotMap.intakeAnalogXPort);
	}
    
    public double getElevatorDesiredPosition(){
    	double position;
		double knobValue = enhancedDS.getRawAxis(RobotMap.elevatorKnobPort);
		double threshold = 0.008;
		
		//If Station Knob is at 0
		if(knobValue < RobotMap.elevatorKnob0 + threshold){
            position = Robot.pref.getDouble("elevatorPosition0", RobotMap.elevatorPosition0);
        }
        //If Station Knob is at 1
        else if(knobValue >= RobotMap.elevatorKnob1 - threshold && knobValue < RobotMap.elevatorKnob1 + threshold){
            position = Robot.pref.getDouble("elevatorPosition1", RobotMap.elevatorPosition1);
        }
        //If Station Knob is at 2
        else if(knobValue >= RobotMap.elevatorKnob2 - threshold && knobValue < RobotMap.elevatorKnob2 + threshold){
            position = Robot.pref.getDouble("elevatorPosition2", RobotMap.elevatorPosition2);
        }
        //If Station Knob is at 3
        else if(knobValue >= RobotMap.elevatorKnob3 - threshold && knobValue < RobotMap.elevatorKnob3 + threshold){
            position = Robot.pref.getDouble("elevatorPosition3", RobotMap.elevatorPosition3);
        }
        //If Station Knob is at 4
        else if(knobValue >= RobotMap.elevatorKnob4 - threshold && knobValue < RobotMap.elevatorKnob4 + threshold){
            position = Robot.pref.getDouble("elevatorPosition4", RobotMap.elevatorPosition4);
        }
        //If Station Knob is at 5
        else if(knobValue >= RobotMap.elevatorKnob5 - threshold){
            position = Robot.pref.getDouble("elevatorPosition5", RobotMap.elevatorPosition5);
        }
        else
        {
        	position = Robot.pref.getDouble("elevatorPosition0", RobotMap.elevatorPosition0);
        }
		
		return position;
	}
    
    public int autonomousSelection(){
    	int position;
		double knobValue = enhancedDS.getRawAxis(RobotMap.autoKnobPort);
		double threshold = 0.008;
		
		//Introduce the use of a switch to double the number of auto modes we are able to select
		
		//If Station Knob is at 1
		if(knobValue < RobotMap.autoKnob0 + threshold){
            position = 1;
        }
        //If Station Knob is at 2
        else if(knobValue >= RobotMap.autoKnob1 - threshold && knobValue < RobotMap.autoKnob1 + threshold){
            position = 2;
        }
        //If Station Knob is at 3
        else if(knobValue >= RobotMap.autoKnob2 - threshold && knobValue < RobotMap.autoKnob2 + threshold){
            position = 3;
        }
        //If Station Knob is at 4
        else if(knobValue >= RobotMap.autoKnob3 - threshold && knobValue < RobotMap.autoKnob3 + threshold){
            position = 4;
        }
        else
        {
        	position = 1;
        }
		
		return position;
    }
    
    public void updateStatus()
    {
    	SmartDashboard.putBoolean("Button 0", enhancedDS.getRawButton(1));
    	SmartDashboard.putBoolean("Button 1", enhancedDS.getRawButton(2));
    	SmartDashboard.putBoolean("Button 2", enhancedDS.getRawButton(3));
    	SmartDashboard.putBoolean("Button 3", enhancedDS.getRawButton(4));
    	SmartDashboard.putBoolean("Button 4", enhancedDS.getRawButton(5));
    	SmartDashboard.putBoolean("Button 5", enhancedDS.getRawButton(6));
    	SmartDashboard.putBoolean("Button 6", enhancedDS.getRawButton(7));
    	SmartDashboard.putBoolean("Button 7", enhancedDS.getRawButton(8));
    	SmartDashboard.putBoolean("Button 8", enhancedDS.getRawButton(9));
    	SmartDashboard.putBoolean("Button 9", enhancedDS.getRawButton(10));
    	SmartDashboard.putBoolean("Button 10", enhancedDS.getRawButton(11));
    	SmartDashboard.putBoolean("Button 11", enhancedDS.getRawButton(12));
    	
    	SmartDashboard.putNumber("Axis 0", enhancedDS.getRawAxis(0));
    	SmartDashboard.putNumber("Axis 1", enhancedDS.getRawAxis(1));
    	SmartDashboard.putNumber("Axis 2", enhancedDS.getRawAxis(2));
    	SmartDashboard.putNumber("Axis 3", enhancedDS.getRawAxis(3));
    	SmartDashboard.putNumber("Axis 4", enhancedDS.getRawAxis(4));
    	SmartDashboard.putNumber("Axis 5", enhancedDS.getRawAxis(5));
    	SmartDashboard.putNumber("Axis 6", enhancedDS.getRawAxis(6));
    	SmartDashboard.putNumber("Axis 7", enhancedDS.getRawAxis(7));
    	
    }
}

