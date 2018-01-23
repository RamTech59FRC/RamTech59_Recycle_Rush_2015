
package org.usfirst.frc.team59.robot;

import org.usfirst.frc.team59.robot.commands.ExampleCommand;
import org.usfirst.frc.team59.robot.subsystems.ExampleSubsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	SpeedController leftDrive = new Talon(1);
	SpeedController rightDrive = new Talon(0);

	NewRobotDrive DR = new NewRobotDrive(leftDrive, rightDrive); /* DR = drive*/
	
	
	Joystick MC = new Joystick(0);// main controller setup//
	Joystick SC = new Joystick(1);// secondary controller setup//
		
    WPI_TalonSRX LIFT1 = new WPI_TalonSRX(1);
    WPI_TalonSRX LIFT2 = new WPI_TalonSRX(2);
    WPI_TalonSRX SR = new WPI_TalonSRX(3);//spinner motor on right side
    WPI_TalonSRX SL = new WPI_TalonSRX(4);//spinner motor on left side
    WPI_TalonSRX GL = new WPI_TalonSRX(5);//gripper arm motor on left side
    WPI_TalonSRX GR = new WPI_TalonSRX(6);//gripper arm motor on right side
    
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	
	Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();

	}
    public void autonomousInit() 
    {
/*
    	if (autonomousCommand != null) autonomousCommand.start();
    	Scheduler.getInstance().run();
//    	autonomous = true; 
//    	Timer.delay(4.25);
//    	autonomous = false;
    	boolean BUTTON1 = SmartDashboard.getBoolean("DB/Button 1");
    	boolean BUTTON2 = SmartDashboard.getBoolean("DB/Button 2");
    	boolean BUTTON3 = SmartDashboard.getBoolean("DB/Button 3");
    	
    	if (BUTTON1 == true )
    		{
				SmartDashboard.putBoolean("DB/LED 1", true);
				SmartDashboard.putString("DB/String 0", "Just Drive and push");
    			DR.setSafetyEnabled(false);
             	DR.Drive(0.0,0.0);
//             	Timer.delay(3.5);
             	DR.Drive(0.41, 0.45);
             	Timer.delay(3);
             	DR.Drive(0.0, 0.0); 
             	
    		}
    	else if (BUTTON2 == true)
    		{
    			SmartDashboard.putBoolean("DB/LED 2", true);
    			SmartDashboard.putString("DB/String 1", "Pick Up tote");
    			DR.setSafetyEnabled(false);
    			DR.Drive(0.0, 0.0);
    			GR.set(.45);
    			GL.set(-.45);
    			Timer.delay(2);
    			SR.set(.75);
    			SL.set(.75);
    			Timer.delay(2);
    			LIFT1.set(.4);
    			LIFT2.set(.4);
    			Timer.delay(2);
    			SR.set(0);
    			SL.set(0);
    			GR.set(-.45);
    			GL.set(.45);
    			Timer.delay(2);
    			GR.set(0);
    			GL.set(0);
    			LIFT1.set(.50);
    			LIFT2.set(.50);
    			Timer.delay(3);
    			LIFT1.set(0);
    			LIFT2.set(0);
    			DR.Drive(.20, -.20);
    			Timer.delay(1.9);
    			DR.Drive(0, 0);
    			Timer.delay(.25);
    			DR.Drive(0.34, 0.38);
    			Timer.delay(4.25);
    			DR.Drive(0, 0);
    			LIFT1.set(-0.35);
    			LIFT2.set(-0.35);
    			Timer.delay(2.75);
    			LIFT1.set(0);
    			LIFT2.set(0);
    			DR.Drive(-0.38, -0.34);
    			Timer.delay(.5);
    			DR.Drive(0, 0);
    		}
    	
		else
			{
				SmartDashboard.putBoolean("DB/LED 0", false);
				SmartDashboard.putBoolean("DB/LED 1", false);
				SmartDashboard.putBoolean("DB/LED 2", false);
				SmartDashboard.putBoolean("DB/LED 3", false);
				SmartDashboard.putString("DB/String 0", "No auto");
			}
	*/
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {

//    	if (autonomous == true)
//    		{
//    		DR.setSafetyEnabled(false);
//		   	DR.Drive(0.0,0.0);
//		   	DR.Drive(0.41, 0.45);
//    		}
//    	else if(autonomous == false)
//    		{
//		   	DR.Drive(0.0, 0.0); 
//    		}

    
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
//        if (autonomousCommand != null) 
//    	DR.setSafetyEnabled(false);
//    	SmartDashboard.putString("DB/String 0", "");
//    	SmartDashboard.putString("DB/String 1", "");
    	/*
    	String DB5 = SmartDashboard.getString("DB/String 5");
    	
    	if (DB5.equals("Tele-op Return")==true)
    	{
    		SmartDashboard.putString("DB/String 5", "Returning");
    		DR.setSafetyEnabled(false);
    		DR.Drive(0.30, -0.30);
        	Timer.delay(1.5);
        	DR.Drive(0, 0);
        	Timer.delay(1.1);
        	DR.Drive(0.36,0.40);
        	Timer.delay(2);
        	DR.Drive(0,0);
    		SmartDashboard.putString("DB/String 5", "Returned");
    		autonomousCommand.cancel();
    	}
    	else
    	{
    		SmartDashboard.putString("DB/String 5", "");
    		SmartDashboard.putString("DB/String 6", "");
    		autonomousCommand.cancel();
    	}*/
//    	DR.setSafetyEnabled(false);
//    	DR.Drive(0.30, -0.30);
//    	Timer.delay(1.5);
//    	DR.Drive(0, 0);
//    	Timer.delay(1.1);
//    	DR.Drive(0.36,0.40);
//    	Timer.delay(2);
//    	DR.Drive(0,0);
    	
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
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
        
        double GVR;
        double GVL;
        double LV = SC.getRawAxis(3);
        double SV = SC.getRawAxis(2);
       
       
       
        /***************************       Drive         ***************************/
        boolean squaredInputs = true;
        
        if(MC.getRawButton(1))//Go Back
        	{
        		DR.Drive(0.20, 0.16);
        	}
        else if(MC.getRawButton(4))//Go Forward
        	{
        		DR.Drive(-0.20, -0.24);
        	}
        else if(MC.getRawButton(3))//Turn Left
    		{
    			DR.Drive(0.20, -0.20);
    		}
        else if(MC.getRawButton(2))//Turn Right
    		{
    			DR.Drive(-0.16, 0.16);
    		}
        else
        	{
        		DR.TankDrive(MC,1, MC,5, squaredInputs);
        	}
        
        
       
        
        /***************************        LIFT          ***************************/
        
        if(SC.getRawButton(6))
        	{
        	
        			LIFT1.set(.75);
        			LIFT2.set(.75);
        	
        	}
       
        else if(SC.getRawButton(8))
    	{
    	
    			LIFT1.set(.350);
    			LIFT2.set(.350);
    	
    	}
        
        else if(SC.getRawAxis(3)>0)
			{
	
    			LIFT1.set(-LV);
    			LIFT2.set(-LV);
	
			}
        else
        	{
        		LIFT1.set(0);
        		LIFT2.set(0);
        		
        	}    
        
        /************************        SPINNERS      ******************************/
        
        if(SC.getRawButton(4) || SC.getRawAxis(2)>0)
    		{
        	if(SC.getRawButton(4))
    			{
    				SR.set(-.75);
    				SL.set(-.75);
    			}
        	else if(SC.getRawAxis(2)>0 && SC.getRawAxis(2)<.75)
        		{
        		
        			SR.set(-SV);
        			SL.set(-SV);
        		}
    	
    		}
        else if(SC.getRawButton(1) || SC.getRawButton(5))
			{
        		
				SR.set(.75);
				SL.set(.75);
        		
        		

			}
        else if(SC.getRawButton(3))
			{

				SR.set(.75);
				SL.set(-.75);
			}
        else if(SC.getRawButton(2))
			{

				SR.set(-.75);
				SL.set(.75);
			}
        else
    		{
    			SR.set(0);
    			SL.set(0);
    		
    		}    
    
    /*************************		GRIPPER		********************************/        
        GVL= SC.getRawAxis(1);
        GVR= SC.getRawAxis(5);
        
        double limiter = 0.60;
        
        GL.set(GVL * limiter);
        GR.set(-GVR * limiter);
    
    }
    
}

