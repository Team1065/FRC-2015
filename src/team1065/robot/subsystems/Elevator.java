package team1065.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
/**
 *
 */
public class Elevator extends Subsystem {
	Talon motor;
	DigitalInput topSwitch, bottomSwitch;
	public Elevator(){
		motor = new Talon(4);
		topSwitch = new DigitalInput(4);
		bottomSwitch = new DigitalInput(5);
	}
	private void setSpeed(double speed){
		motor.set(speed);
	}
	public boolean topLimitReached(){
		return topSwitch.get();
	}
	public boolean bottomLimitReached(){
		return bottomSwitch.get();
	}
	public void setElevatorSpeed(double speed){
		if (speed > 0){
			if (topLimitReached()){
				setSpeed(0);
			}
			else{
				setSpeed(speed);
			}
		}
		else if (speed < 0){
			if (bottomLimitReached()){
				setSpeed(0);
			}
			else{
				setSpeed(speed);
			}
		}
		else if (speed == 0){
			setSpeed(0);
		}
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

