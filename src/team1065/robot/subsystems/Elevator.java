package team1065.robot.subsystems;

import team1065.robot.Robot;
import team1065.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
/**
 *
 */
public class Elevator extends Subsystem {
	private Talon motor;
	private DigitalInput topSwitch, bottomSwitch;
	private AnalogInput pot;
	private double pTerm;
	public Elevator(){
		motor = new Talon(RobotMap.elevatorMotor);
		topSwitch = new DigitalInput(RobotMap.topLimitSwitch);
		bottomSwitch = new DigitalInput(RobotMap.bottomLimitSwitch);
		pot = new AnalogInput(RobotMap.potentiometer);
		pTerm = RobotMap.elevatorPTerm;
	}
	private void setSpeed(double speed){
		motor.set(-speed);
	}
	public boolean topLimitReached(){
		return topSwitch.get();
	}
	public boolean bottomLimitReached(){
		return bottomSwitch.get();
	}
	public double getCurrentPosition(){
		return pot.getAverageVoltage();
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
	
	public void moveToPosition(double desiredPosition){
		double positionDifference = desiredPosition - getCurrentPosition();
		
		if(Math.abs(positionDifference) > Robot.pref.getDouble("elevatorPositionDeadBand", RobotMap.elevatorPositionDeadBand)){
			pTerm = Robot.pref.getDouble("elevatorPTerm", RobotMap.elevatorPTerm);
			if(positionDifference > 0){
				if(positionDifference > 0.005){
					setElevatorSpeed(1);
				}
				else{
					setElevatorSpeed(.5);//positionDifference * pTerm);
				}
			}
			else{
				if(positionDifference < -0.005){
					setElevatorSpeed(-1);
				}
				else{
					setElevatorSpeed(-0.5);//positionDifference * pTerm);
				}
			}
		}
		else{
			Robot.elevator.setElevatorSpeed(0);
		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void updateStatus()
    {
    	SmartDashboard.putBoolean("Top Limit Switch", topLimitReached());
    	SmartDashboard.putBoolean("Bottom Limit Switch",bottomLimitReached());
    	SmartDashboard.putNumber("Elevator Height", getCurrentPosition());
    	
    }
}

