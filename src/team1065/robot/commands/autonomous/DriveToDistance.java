package team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import team1065.robot.Robot;
import team1065.robot.RobotMap;


/**
 *
 * @author atenc_000
 */

//set speed to a negative value [-1,0) to go backwards. distance should allways be positive
public class DriveToDistance extends Command {
    private double setSpeed, distance;
    
    public DriveToDistance(double speed, double distance) {
        requires(Robot.drive);
	this.setSpeed = speed;
	this.distance = distance;
    }

    protected void initialize() {
        Robot.drive.startEncoders();
	Robot.drive.resetEncoders();
    }

    protected void execute() {
        
        if(setSpeed > 0 && setSpeed < RobotMap.driveMinSpeed)
        {
            setSpeed = RobotMap.driveMinSpeed;
        }
        else if(setSpeed < 0 && setSpeed > -RobotMap.driveMinSpeed)
        {
            setSpeed = -RobotMap.driveMinSpeed;
        }
        
        Robot.drive.driveStraight(setSpeed);
    }

    protected boolean isFinished() {
        return Math.abs(Robot.drive.avgEncoderCount()) >= distance;
    }

    protected void end() {
        Robot.drive.stopEncoders();
    }


    protected void interrupted() {
        end();
    }
}
