package team1065.robot.commands.autonomous;

import team1065.robot.Robot;
import team1065.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous4 extends CommandGroup {
	
	public Autonomous4()
	{
		//3 totes moving 2 bins out of the way in the process.
    	// Yellow tote 1
    	//addParallel(new MoveElevatorToPosition(RobotMap.elevatorPosition3, 2));
		addParallel(new SetElevatorSpeed(1, 2));//TODO: Remove after Practice and uncoment above
    	addSequential(new RotateToDistance(0.3,165));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(30)));
    	addSequential(new RotateToDistance(-0.3,200));//rotate towards the second tote
    	addSequential(new IntakeIn(0.3,.05));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(50)));
    	addSequential(new StopAndWait(.05));
    	
    	// Yellow tote 2
    	//addParallel(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	addParallel(new SetElevatorSpeed(-1, 2));//TODO: Remove after Practice and uncoment above
    	addSequential(new RotateToDistance(0.3,300));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(25)));
    	//addParallel(new MoveElevatorToPosition(RobotMap.elevatorPosition3, 3));
    	addParallel(new SetElevatorSpeed(1, 2));//TODO: Remove after Practice and uncoment above
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(5)));
    	addSequential(new RotateToDistance(-0.3,380));//rotate towards the third tote
    	addSequential(new DriveToDistance(0.35,Robot.drive.InchToCount(18)));
    	addSequential(new RotateToDistance(0.3,180));//rotate towards the third tote
    	addSequential(new DriveToDistance(0.35,Robot.drive.InchToCount(25)));
    	addSequential(new StopAndWait(.05));
    	
    	//Yellow tote 3
    	//addParallel(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	addParallel(new SetElevatorSpeed(-1, 2));//TODO: Remove after Practice and uncoment above
    	
    	// Move to AZ and back out
    	addSequential(new RotateToDistance(0.6,580));//speed up?
        addSequential(new DriveToDistance(.5,Robot.drive.InchToCount(55)));//increase?
    	addParallel(new IntakeOut(.5,.2));
    	addSequential(new DriveToDistance(.3,Robot.drive.InchToCount(30)));
    	addSequential(new DriveToDistance(-.7,Robot.drive.InchToCount(30)));
    	addSequential(new StopAndWait(.2));
	}
}
