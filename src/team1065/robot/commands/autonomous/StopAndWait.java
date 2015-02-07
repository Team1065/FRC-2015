/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import team1065.robot.Robot;


/**
 *
 * @author Team1065
 */
public class StopAndWait extends Command {
    
    public StopAndWait(double time) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
        this.setTimeout(time);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.drive.tankDrive(0, 0);
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
