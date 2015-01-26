package team1065.robot.commands;

import team1065.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoysticks extends Command {

    public DriveWithJoysticks() {
    	requires (Robot.drive);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.startEncoders();
    	Robot.drive.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.drive.tankDrive(Robot.oi.getleftJoystickY(), Robot.oi.getrightJoystickY());
    	double leftY = Robot.oi.getleftJoystickY();
        double rightY = Robot.oi.getrightJoystickY();
        
        double rightX = Robot.oi.getRightX();
        
        double averageY = Robot.oi.getYAverage();
        
        if(Robot.oi.getSlowButton()){
            leftY = leftY / 2.0;
            rightY = rightY / 2.0;
            averageY = averageY /2.0;
        }

        double joystickDiff = Math.abs(leftY-rightY);
        
        if(Robot.oi.getMecanumButton())
        {
            if(Math.abs(rightY)<.4 && Math.abs(leftY)<.2)
            {
            	Robot.drive.mecanumFeedback(rightX-Robot.drive.getEncoderDifference(), rightX+Robot.drive.getEncoderDifference()); 
            }
            else
            {
            	Robot.drive.mecanumDriveCartesian(rightX, -rightY, leftY,0);
            }
        }
        else
        {
            //Drive Straight Active if:
            //1) Both Joysticks are going in the same direction
            //2) The Difference between the Joysticks is not larger than a percentage of the set speed
            //As the speed is higher the is a greater forgiveness for error
            if((leftY * rightY >= 0) && joystickDiff < (Math.abs(averageY) * .30))//Moose.pref.getDouble("DriveStraightPercentage", RobotMap.driveStraightThresholdPercentage)))
            {
            	Robot.drive.driveStraight(averageY);
            }
            else
            {
            	Robot.drive.tankDrive(leftY, rightY);
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
