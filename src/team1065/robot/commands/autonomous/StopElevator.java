package team1065.robot.commands.autonomous;

import team1065.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class StopElevator extends Command{
		
	public StopElevator(double t)
	{
		requires(Robot.elevator);
		this.setTimeout(t);
	}
	
	protected void initialize() {
    }

    protected void execute() {
    	Robot.elevator.setElevatorSpeed(0);
    }
    
    protected boolean isFinished() {
    	return this.isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
		end();
    }
}
