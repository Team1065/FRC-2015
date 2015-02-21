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
public class Autonomous6 extends CommandGroup {
    
    public Autonomous6() {
    	//2 Totes without Disturbing the bins
    	
    	//Pick up Tote 1
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition1, 3));
        addSequential(new DriveToDistance(-0.3,Robot.drive.InchToCount(10)));
        
        //Move to Tote 2 
        addSequential(new RotateToDistance(0.3,360));
        addSequential(new StopAndWait(0.2));
        addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(20)));
        addSequential(new StopAndWait(0.2));
        addSequential(new RotateToDistance(-0.3,360));
        addSequential(new StopAndWait(0.2));
        addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(50)));
        addSequential(new StopAndWait(0.2));
        addSequential(new RotateToDistance(-0.3,360));
        addSequential(new StopAndWait(0.2));
        addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(20)));
        addSequential(new StopAndWait(0.2));
        addSequential(new RotateToDistance(0.3,360));
        addSequential(new StopAndWait(0.2));
        
        //place Tote 1 on top of Tote 2        
        addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition2, 3));
        addSequential(new DriveToDistance(.3,Robot.drive.InchToCount(10)));
        addSequential(new StopAndWait(0.2));
        addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition1, 3));
        addSequential(new DriveToDistance(-0.3,Robot.drive.InchToCount(3)));
        addSequential(new StopAndWait(0.2));
        addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 3));
        addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(3)));
        addSequential(new StopAndWait(0.2));
        
      //Pick up Tote 2 and Tote 1 and move to auto zone
        addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition1, 3));
        addSequential(new RotateToDistance(0.3,360));
        addSequential(new StopAndWait(0.2));
        addSequential(new DriveToDistance(.3,Robot.drive.InchToCount(10)));
        addSequential(new DriveToDistance(.5,Robot.drive.InchToCount(90)));
        addSequential(new DriveToDistance(.3,Robot.drive.InchToCount(10)));
        addSequential(new StopAndWait(2));
    }
}