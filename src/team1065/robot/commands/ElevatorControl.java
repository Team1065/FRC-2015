package team1065.robot.commands;

import team1065.robot.Robot;
import team1065.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorControl extends Command {

    public ElevatorControl() {
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.getElevatorManualButton())
    	{
    		double joystickValue = Robot.oi.getElevatorJoystickY();
	    	if(Math.abs(joystickValue - RobotMap.extraJoystickMiddle) > 0.01){
	    		Robot.elevator.setElevatorSpeed((joystickValue - RobotMap.extraJoystickMiddle)/RobotMap.extraJoystickMiddle);
	    	}
	    	else{
	    		Robot.elevator.setElevatorSpeed(0);
	    	}
    	}
    	else
    	{
    		double desiredPosition = Robot.oi.getElevatorDesiredPosition();
    		double positionDifference = desiredPosition - Robot.elevator.getCurrentPosition();
    		
    		if(Math.abs(positionDifference) > Robot.pref.getDouble("elevatorPositionDeadBand", RobotMap.elevatorPositionDeadBand)){
    			if(positionDifference > 0){
    				Robot.elevator.setElevatorSpeed(1);
    			}
    			else{
    				Robot.elevator.setElevatorSpeed(-1);
    			}
    		}
    		else{
    			Robot.elevator.setElevatorSpeed(0);
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
