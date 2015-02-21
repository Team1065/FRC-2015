package team1065.robot.commands;

import team1065.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FishingPoleControl extends Command {

    public FishingPoleControl() {
        requires(Robot.fishingPole);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.fishingPole.SetActuators(Robot.oi.getFishingPoleButton());
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
