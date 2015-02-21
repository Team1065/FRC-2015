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
public class Autonomous5 extends CommandGroup {
    
    public Autonomous5() {
    	//3 totes moving 2 bins out of the way in the process.
    	// Yellow tote 1
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition2, 2));
    	addSequential(new StopAndWait(2));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(60)));
    	addSequential(new StopAndWait(.2));
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition1, 2));
    	// Yellow tote 2 
    	addParallel(new DriveToDistance(-0.3,Robot.drive.InchToCount(4)));
    	addSequential(new StopAndWait(.2));
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	addParallel(new DriveToDistance(0.3,Robot.drive.InchToCount(12)));
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition2, 2));
    	addSequential(new StopAndWait(.2));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(48)));
    	addSequential(new StopAndWait(.2));
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition1, 2));
    	// Yellow Tote 3
    	addParallel(new DriveToDistance(-0.3,Robot.drive.InchToCount(4)));
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	addSequential(new StopAndWait(.2));
    	addParallel(new DriveToDistance(0.3,Robot.drive.InchToCount(12)));
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition1, 2));
    	addSequential(new StopAndWait(.2));
    	//Move to auto zone
    	addSequential(new RotateToDistance(-0.3,360));
    	addSequential(new DriveToDistance(-0.3,Robot.drive.InchToCount(36)));
    	addSequential(new StopAndWait(.2));
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	addSequential(new DriveToDistance(-0.3,Robot.drive.InchToCount(36)));
    	addSequential(new StopAndWait(.2));
    }
}