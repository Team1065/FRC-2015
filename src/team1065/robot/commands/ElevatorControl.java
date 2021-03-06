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
	    	if(Math.abs(joystickValue - RobotMap.elevatorJoystickMiddle) > RobotMap.elevatorJoystickDeadBand){
	    		Robot.elevator.setElevatorSpeed(-(joystickValue - RobotMap.elevatorJoystickMiddle)/RobotMap.elevatorJoystickMiddle);
	    	}
	    	else{
	    		Robot.elevator.setElevatorSpeed(0);
	    	}
    	}
    	else
    	{
    		double desiredPosition = Robot.oi.getElevatorDesiredPosition();
    		Robot.elevator.moveToPosition(desiredPosition);
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
    	end();
    }
}
