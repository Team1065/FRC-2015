/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team1065.robot.commands.autonomous;

import team1065.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Team1065
 */
public class Autonomous5 extends CommandGroup {
    
    public Autonomous5() {
    	//Pick up Tote 1
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(10)));
    	addSequential(new StopAndWait(0.2));
    	addSequential(new MoveElevatorToPosition(1, 3));
        addSequential(new StopElevator(0.2));
        addSequential(new DriveToDistance(-0.3,Robot.drive.InchToCount(10)));
        
        //Move to Tote 2 
        addSequential(new RotateToDistance(0.3,360));
        addSequential(new StopAndWait(0.2));
        addSequential(new DriveToDistance(1,Robot.drive.InchToCount(55.25)));
        addSequential(new StopAndWait(0.2));
        addSequential(new RotateToDistance(-0.3,360));
        
        //place Tote 1 on top of Tote 2        
        addSequential(new MoveElevatorToPosition(2, 3));
        addSequential(new StopElevator(0.2));
        addSequential(new DriveToDistance(.3,Robot.drive.InchToCount(10)));
        addSequential(new StopAndWait(0.2));
        addSequential(new MoveElevatorToPosition(0.5, 3));
        addSequential(new StopElevator(0.2));
        
        //Pick up Tote 2 and Tote 1
        addSequential(new MoveElevatorToPosition(1, 3));
        addSequential(new StopElevator(0.2));
        addSequential(new DriveToDistance(-0.3,Robot.drive.InchToCount(10)));
        
        //Move to Tote 3
        addSequential(new RotateToDistance(0.3,360));
        addSequential(new StopAndWait(0.2));
        addSequential(new DriveToDistance(1,Robot.drive.InchToCount(55.25)));
        addSequential(new StopAndWait(0.2));
        addSequential(new RotateToDistance(-0.3,360));
        
        //place Tote 1 and Tote 2 on top of Tote 3        
        addSequential(new MoveElevatorToPosition(2, 3));
        addSequential(new StopElevator(0.2));
        addSequential(new DriveToDistance(.3,Robot.drive.InchToCount(10)));
        addSequential(new StopAndWait(0.2));
        addSequential(new MoveElevatorToPosition(0.5, 3));
        addSequential(new StopElevator(0.2));
        
        //Pick up Tote 1, 2, and 3 and move to auto zone
        addSequential(new MoveElevatorToPosition(1, 3));
        addSequential(new StopElevator(0.2));
        addSequential(new DriveToDistance(-.3,Robot.drive.InchToCount(10)));
        addSequential(new DriveToDistance(-.5,Robot.drive.InchToCount(90)));
        addSequential(new DriveToDistance(-.3,Robot.drive.InchToCount(10)));
        addSequential(new StopAndWait(2));
    }
}