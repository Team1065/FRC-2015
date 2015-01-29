package team1065.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//DriverStationEnhancedIO ds;
	Joystick lJoystick, rJoystick, elevatorJoystick;
	
	JoystickButton mecanumButton;
	JoystickButton slowButton;
    
    
	public OI() {
		lJoystick = new Joystick(RobotMap.leftJoystick);
	    rJoystick = new Joystick(RobotMap.rightJoystick);
	    elevatorJoystick = new Joystick(RobotMap.elevatorJoystick);
	    
	    mecanumButton = new JoystickButton(rJoystick, RobotMap.mecanumButtonPort);
	    slowButton = new JoystickButton(lJoystick, RobotMap.mecanumButtonPort);
	    
	}
	public double getleftJoystickY () {
		return -lJoystick.getY();
	}
	
	public double getrightJoystickY () {
		return -rJoystick.getY();
	}
	public double getelevatorJoystickY(){
		return elevatorJoystick.getY();
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
    
    public boolean getSlowButton(){
        return slowButton.get();
    }
}

