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
    	addSequential(new RotateToDistance(-0.3,200));//rotate towards the second tote
    	addSequential(new IntakeIn(1,.05));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(45)));
    	addSequential(new StopAndWait(.05));
    	
    	// Yellow tote 2
    	addParallel(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	addSequential(new RotateToDistance(0.3,200));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(25)));
    	addParallel(new MoveElevatorToPosition(RobotMap.elevatorPosition3, 3));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(5)));
    	addSequential(new RotateToDistance(-0.3,200));//rotate towards the third tote
    	addSequential(new DriveToDistance(0.35,Robot.drive.InchToCount(45)));
    	addSequential(new StopAndWait(.05));
    	
    	//Yellow tote 3
    	addParallel(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	
    	// Move to AZ and back out
    	addSequential(new RotateToDistance(0.5,560));//speed up?
        addSequential(new DriveToDistance(.6,Robot.drive.InchToCount(45)));//increase?
    	addParallel(new IntakeOut(1,.2));
    	addSequential(new DriveToDistance(.5,Robot.drive.InchToCount(5)));
    	addSequential(new DriveToDistance(-1,Robot.drive.InchToCount(30)));
    	addSequential(new StopAndWait(.2));
	}
}
