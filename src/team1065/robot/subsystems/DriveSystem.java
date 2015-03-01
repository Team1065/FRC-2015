package team1065.robot.subsystems;

import team1065.robot.Robot;
import team1065.robot.RobotMap;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveSystem extends Subsystem {
    
	private Talon lFrontMotor, lBackMotor, rFrontMotor, rBackMotor;
	private RobotDrive drive;
	private Encoder encoderLeft, encoderRight;
	private double proportional;
	
	public DriveSystem() {
		lFrontMotor = new Talon(RobotMap.frontLeftMotor);
		lBackMotor = new Talon(RobotMap.backLeftMotor);
		rFrontMotor = new Talon(RobotMap.frontRightMotor);
		rBackMotor = new Talon(RobotMap.backRightMotor);
		encoderLeft = new Encoder (RobotMap.encoderLeftA, RobotMap.encoderLeftB,true,CounterBase.EncodingType.k1X);
        encoderRight = new Encoder (RobotMap.encoderRightA, RobotMap.encoderRightB,false,CounterBase.EncodingType.k1X);
        encoderLeft.setDistancePerPulse(RobotMap.driveWheelsDiameter * Math.PI / RobotMap.encoderCountPerRev);
        encoderRight.setDistancePerPulse(RobotMap.driveWheelsDiameter * Math.PI / RobotMap.encoderCountPerRev);
        encoderLeft.setSamplesToAverage(1);
        encoderRight.setSamplesToAverage(1);
		drive = new RobotDrive(lFrontMotor, lBackMotor, rFrontMotor, rBackMotor);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        drive.setSafetyEnabled(false);
        proportional = RobotMap.driveStraightPTerm; 
	}
	
	public void tankDrive(double lSpeed, double rSpeed){
		lFrontMotor.set(lSpeed);
		lBackMotor.set(lSpeed);
		rFrontMotor.set(-rSpeed);
		rBackMotor.set(-rSpeed);
	}
	
	public void driveStraight(double speed)
    {
        driveStraight(speed, false);
    }
    
    //for rotation: positive speed -> clockwise (rotate flag must be true) 
    public void driveStraight(double speed, boolean rotate)
    {
        double leftMotorValue;
        double rightMotorValue;
        
        if(rotate)
        {
            //rotating in place
            if(speed<0)
            {
                    leftMotorValue = speed + getEncoderAbsDifference();
                    rightMotorValue = -speed + getEncoderAbsDifference();
            }
            else
            {
                    leftMotorValue = speed - getEncoderAbsDifference();
                    rightMotorValue = -speed - getEncoderAbsDifference();
            }
        }
        else
        {
            //driving straight
            leftMotorValue = speed - getEncoderDifference();
            rightMotorValue = speed + getEncoderDifference();
            
            if(speed >= 0)
            {
                if(leftMotorValue < 0)
                {
                    leftMotorValue = 0;
                }
                if(rightMotorValue < 0)
                {
                    rightMotorValue = 0;
                }
            }
            else
            {
                if(leftMotorValue > 0)
                {
                    leftMotorValue = 0;
                }
                if(rightMotorValue > 0)
                {
                    rightMotorValue = 0;
                }
            }
        }
        
        tankDrive(leftMotorValue, rightMotorValue);
    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void resetEncoders()
    {
        encoderLeft.reset();
        encoderRight.reset();
    }
    
    //inches
    public double avgEncoderdistance()
    {
        return (encoderLeft.getDistance()+encoderRight.getDistance())/2.0;
    }
    
    public double avgEncoderAbsdistance()
    {
        return (Math.abs(encoderLeft.get())+Math.abs(encoderRight.get()))/2.0;
    }
    
    public double avgEncoderCount()
    {
        return (encoderLeft.get()+encoderRight.get())/2.0;
    }
    
    public double avgEncoderAbsCount()
    {
        return (Math.abs(encoderLeft.get())+Math.abs(encoderRight.get()))/2.0;
    }
    
    //for straight drive
    public double getEncoderDifference()
    {
        double diff = (encoderLeft.getRate()-encoderRight.getRate()) * Robot.pref.getDouble("DriveStraightPTerm", proportional);
        if (diff >.5)
        {
            diff = .5;
        }
        else if (diff < -.5)
        {
            diff = -.5;
        }
        return diff;
    }
    
    //for rotating in place
    public double getEncoderAbsDifference()
    {
        double diff = (Math.abs(encoderLeft.getRate())-Math.abs(encoderRight.getRate())) * Robot.pref.getDouble("DriveStraightPTerm", proportional);
        if (diff >.5)
        {
            diff = .5;
        }
        else if (diff < -.5)
        {
            diff = -.5;
        }
        return diff;
    }
    
  //for straight mecanum drive
    public void mecanumFeedback(double motors1,double motors2)
    {
        lFrontMotor.set(motors1);
        rBackMotor.set(-motors2);
        lBackMotor.set(-motors2);
        rFrontMotor.set(motors1);
    }
    
    public void mecanumDriveCartesian(double xVal, double yVal, double rotation, double gyroAngle)
    {
        drive.mecanumDrive_Cartesian(xVal, yVal, rotation, gyroAngle);
    }
    
    public void updateStatus()
    {
        SmartDashboard.putNumber("Encoder Left Rate",encoderLeft.getRate());
        SmartDashboard.putNumber("Encoder Right Rate",encoderRight.getRate());
        SmartDashboard.putNumber("Encoder Difference",getEncoderDifference());
        //SmartDashboard.putNumber("Encoder Left Count",encoderLeft.get());
        //SmartDashboard.putNumber("Encoder Right Count",encoderRight.get());
        //SmartDashboard.putNumber("Left Front Motor",lFrontMotor.get());
        //SmartDashboard.putNumber("Left Back Motor",lBackMotor.get());
        //SmartDashboard.putNumber("Right Front Motor",rFrontMotor.get());
        //SmartDashboard.putNumber("Right Back Motor",rBackMotor.get());
    }

	public double InchToCount(double inches) {
		double count = inches * (RobotMap.encoderCountPerRev /(RobotMap.driveWheelsDiameter*Math.PI));
		return count;
	}
}

