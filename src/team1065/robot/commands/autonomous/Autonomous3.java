/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team1065.robot.commands.autonomous;

import team1065.robot.Robot;
import team1065.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Team1065
 */
public class Autonomous3 extends CommandGroup {
    
    public Autonomous3() {
    	//3 totes moving 2 bins out of the way in the process.
    	// Yellow tote 1
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition2, 2));
    	addSequential(new IntakeOut(1,.2));
    	addSequential(new RotateToDistance(-0.3,180));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(30)));
    	addSequential(new RotateToDistance(0.3,360));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(20)));
    	addSequential(new RotateToDistance(-0.3,180));
    	addSequential(new IntakeIn(1,.2));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(10)));
    	addSequential(new StopAndWait(.2));
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	// Yellow tote 2
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition2, 2));
    	addSequential(new IntakeOut(1,.2));
    	addSequential(new RotateToDistance(-0.3,180));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(30)));
    	addSequential(new RotateToDistance(0.3,360));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(20)));
    	addSequential(new RotateToDistance(-0.3,180));
    	addSequential(new IntakeIn(1,.2));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(10)));
    	addSequential(new StopAndWait(.2));
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	// Yellow tote 3
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition2, 2));
    	addSequential(new IntakeOut(1,.2));
    	addSequential(new RotateToDistance(-0.3,180));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(30)));
    	addSequential(new RotateToDistance(0.3,360));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(20)));
    	addSequential(new RotateToDistance(-0.3,180));
    	addSequential(new IntakeIn(1,.2));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(10)));
    	addSequential(new StopAndWait(.2));
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	// Move to AZ
    	addSequential(new RotateToDistance(0.3,360));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(36)));
    	addSequential(new StopAndWait(.2));
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	addSequential(new IntakeOut(1,.2));
    	addSequential(new DriveToDistance(-0.3,Robot.drive.InchToCount(5)));
    	addSequential(new StopAndWait(.2));
    	
    }
}