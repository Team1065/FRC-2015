
package  team1065.robot.commands.autonomous;

import team1065.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForTime extends Command {
    
	double lVal, rVal;
	
    public DriveForTime(double lVal, double rVal, double t) {
        requires(Robot.drive);
		this.setTimeout(t);
		this.lVal = lVal;
		this.rVal = rVal;
    }
    protected void initialize() {
    }

    protected void execute() {
    	Robot.drive.tankDrive(lVal, rVal);
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

