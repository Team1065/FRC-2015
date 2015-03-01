package team1065.robot.commands.autonomous;

import team1065.robot.Robot;
import team1065.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous4 extends CommandGroup {
	
	public Autonomous4()
	{
		//3 totes moving 2 bins out of the way in the process.
    	// Yellow tote 1
    	addParallel(new MoveElevatorToPosition(RobotMap.elevatorPosition3, 2));
    	addSequential(new IntakeOut(1,.05));
    	addSequential(new RotateToDistance(0.3,165));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(30)));
    	addSequential(new RotateToDistance(-0.3,200));
    	addSequential(new IntakeIn(1,.05));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(45)));
    	addSequential(new StopAndWait(.05));
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	
    	// Yellow tote 2
    	addParallel(new MoveElevatorToPosition(RobotMap.elevatorPosition3 + 0.001, 2));
    	addSequential(new RotateToDistance(0.3,200));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(30)));
    	addSequential(new StopAndWait(.05));
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	//Yellow tote 3
    	
    	// Move to AZ
    	addSequential(new RotateToDistance(0.3,540));
        addSequential(new DriveToDistance(.5,Robot.drive.InchToCount(50)));
    	addSequential(new StopAndWait(.05));
    	addParallel(new IntakeOut(1,.2));
    	addSequential(new DriveToDistance(-1,Robot.drive.InchToCount(30)));
    	addSequential(new StopAndWait(.2));
	}
}
