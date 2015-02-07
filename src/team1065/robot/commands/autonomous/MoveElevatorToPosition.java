package team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import team1065.robot.Robot;
import team1065.robot.RobotMap;

public class MoveElevatorToPosition extends Command {

	double desiredPosition;
	double positionDifference;
	
	MoveElevatorToPosition(double desiredPosition, double t)
	{
		requires(Robot.elevator);
		this.desiredPosition = desiredPosition;
		this.setTimeout(t);
	}
	protected void initialize() {
    }

    protected void execute() {
    	positionDifference = desiredPosition - Robot.elevator.getCurrentPosition();
		
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

    protected boolean isFinished() {
    	if((Math.abs(positionDifference) < Robot.pref.getDouble("elevatorPositionDeadBand", RobotMap.elevatorPositionDeadBand))
    			|| this.isTimedOut())
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    protected void end() {
    }

    protected void interrupted() {
		end();
    }
}
