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
		lJoystick = new Joystick(0);
	    rJoystick = new Joystick(1);
	    elevatorJoystick = new Joystick(2);
	    
	    mecanumButton = new JoystickButton(rJoystick, 2);//RobotMap.mecanumButtonPort);
	    slowButton = new JoystickButton(lJoystick, 2);//RobotMap.mecanumButtonPort);
	    //ds =DriverStation.getInstance().getEnhancedIO();
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
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

