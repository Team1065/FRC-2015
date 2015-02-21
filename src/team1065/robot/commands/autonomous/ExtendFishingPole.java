package team1065.robot.commands.autonomous;

import team1065.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExtendFishingPole extends Command {
	boolean extend;
    public ExtendFishingPole(boolean extend, double time) {
        requires(Robot.fishingPole);
        this.setTimeout(time);
        this.extend = extend;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(extend){
    		Robot.fishingPole.Extend();
    	}
    	else{
    		Robot.fishingPole.Retract();
    	}
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
