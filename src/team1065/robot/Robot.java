
package team1065.robot;

import java.util.Vector;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import team1065.robot.commands.DriveWithJoysticks;
import team1065.robot.commands.ElevatorControl;
import team1065.robot.commands.FishingPoleControl;
import team1065.robot.commands.IntakeControl;
import team1065.robot.commands.autonomous.Autonomous1;
import team1065.robot.commands.autonomous.Autonomous2;
import team1065.robot.commands.autonomous.Autonomous3;
import team1065.robot.commands.autonomous.Autonomous4;
import team1065.robot.commands.autonomous.Autonomous5;
import team1065.robot.commands.autonomous.Autonomous6;
import team1065.robot.commands.autonomous.Autonomous7;
import team1065.robot.commands.autonomous.Autonomous8;
import team1065.robot.subsystems.DriveSystem;
import team1065.robot.subsystems.Elevator;
import team1065.robot.subsystems.FishingPole;
import team1065.robot.subsystems.Intake;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi;
	public static final DriveSystem drive = new DriveSystem();
	public static final Elevator elevator = new Elevator();
	public static final Intake intake = new Intake();
	public static final FishingPole fishingPole = new FishingPole();
	
	public static Preferences pref;

	Vector<Command> initCommands;
	
	Vector<Command> auto = new Vector<Command>(8);
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		pref = Preferences.getInstance();
		
		initCommands.add(new DriveWithJoysticks());
		initCommands.add(new ElevatorControl());
		initCommands.add(new IntakeControl());
		initCommands.add(new FishingPoleControl());
		
		auto.add(new Autonomous1());
		auto.add(new Autonomous2());
		auto.add(new Autonomous3());
		auto.add(new Autonomous4());
		auto.add(new Autonomous5());
		auto.add(new Autonomous6());
		auto.add(new Autonomous7());
		auto.add(new Autonomous8());
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        auto.elementAt(oi.autonomousSelection()).start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	auto.elementAt(oi.autonomousSelection()).cancel();

    	for (Command command : initCommands) {
    		command.start();
        }
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        drive.updateStatus();
        elevator.updateStatus();
        oi.updateStatus();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
