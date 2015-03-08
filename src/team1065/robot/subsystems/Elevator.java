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
	private Talon motor1, motor2;
	private DigitalInput topSwitch, bottomSwitch;
	private AnalogInput pot;
	private double pTerm;
	public Elevator(){
		motor1 = new Talon(RobotMap.elevatorMotor1);
		motor2 = new Talon(RobotMap.elevatorMotor2);
		topSwitch = new DigitalInput(RobotMap.topLimitSwitch);
		bottomSwitch = new DigitalInput(RobotMap.bottomLimitSwitch);
		pot = new AnalogInput(RobotMap.potentiometer);
		pTerm = RobotMap.elevatorPTerm;
	}
	private void setSpeed(double speed){
		motor1.set(-speed);
		motor2.set(-speed);
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
		
		if(Math.abs(positionDifference) > RobotMap.elevatorPositionDeadBand){
			if(positionDifference > 0){
				if(positionDifference > 0.002){
					setElevatorSpeed(1);
				}
				else{
					setElevatorSpeed(.7);
				}
			}
			else{
				if(positionDifference < -0.002){
					setElevatorSpeed(-1);
				}
				else{
					setElevatorSpeed(-0.7);
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

