package team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import team1065.robot.Robot;
import team1065.robot.RobotMap;

public class MoveElevatorToPosition extends Command {

	double desiredPosition;
	
	MoveElevatorToPosition(double desiredPosition, double t)
	{
		requires(Robot.elevator);
		this.desiredPosition = desiredPosition;
		this.setTimeout(t);
	}
	protected void initialize() {
    }

    protected void execute() {
    	Robot.elevator.moveToPosition(desiredPosition);
    }

    protected boolean isFinished() {
    	double positionDifference = desiredPosition - Robot.elevator.getCurrentPosition();
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
