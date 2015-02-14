
package team1065.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import team1065.robot.commands.DriveWithJoysticks;
import team1065.robot.commands.ElevatorControl;
import team1065.robot.commands.autonomous.Autonomous3;
import team1065.robot.commands.autonomous.Autonomous2;
import team1065.robot.commands.autonomous.Autonomous6;
import team1065.robot.commands.autonomous.Autonomous5;
import team1065.robot.subsystems.DriveSystem;
import team1065.robot.subsystems.Elevator;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static final DriveSystem drive = new DriveSystem();
	public static OI oi;
	public static final Elevator elevator = new Elevator();
	
	public static Preferences pref;

	Command initDrive, initElevator;
	
	Command auto1,auto2,auto3, auto4;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		pref = Preferences.getInstance();
		
		initDrive = new DriveWithJoysticks();
		initElevator = new ElevatorControl();
		
		auto1 = new Autonomous3();
        auto2 = new Autonomous2();
        auto3 = new Autonomous6();
        auto4 = new Autonomous5();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        switch(oi.autonomousSelection())
        {
            case 1: auto1.start();
                    break;
            case 2: auto2.start();
                    break;
            case 3: auto3.start();
                    break;
            case 4: auto4.start();
                    break;
            default: auto1.start();
                    break;
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //if (autonomousCommand != null) autonomousCommand.cancel();
    	initDrive.start();
    	initElevator.start();
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
