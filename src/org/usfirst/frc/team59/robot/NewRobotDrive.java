package org.usfirst.frc.team59.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.communication.UsageReporting;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tInstances;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tResourceType;

public class NewRobotDrive extends RobotDrive {
	
	public NewRobotDrive(int leftMotorChannel, int rightMotorChannel) {
		super(leftMotorChannel, rightMotorChannel);
		// TODO Auto-generated constructor stub
	}


	 public void TankDrive(GenericHID leftStick, final int leftAxis, GenericHID rightStick, final int rightAxis, boolean squaredInputs) 
	 {
		 if (leftStick == null || rightStick == null) 
		 {
			 throw new NullPointerException("Null HID provided");
		 }
		 tankDrive(leftStick.getRawAxis(leftAxis), rightStick.getRawAxis(rightAxis), squaredInputs);
	 }

	 public void TankDrive(double leftValue, double rightValue, boolean squaredInputs) {

	        if(!kTank_Reported) {
	            UsageReporting.report(tResourceType.kResourceType_RobotDrive, getNumMotors(), tInstances.kRobotDrive_Tank);
	            kTank_Reported = true;
	        }

	        // square the inputs (while preserving the sign) to increase fine control while permitting full power
	        leftValue = limit(leftValue);
	        rightValue = limit(rightValue);
	        double leftValueControlReverse = 0.46;
	        double leftValueControlForward = 0.5;
	        double rightValueControlReverse = 0.5;
	        double rightValueControlForward = 0.46;
	        if(squaredInputs) {
	            if (leftValue >= 0.0) 
	            {
	                leftValue = ((leftValue * leftValue)*leftValueControlForward);
	            } 
	            else 
	            {
	                leftValue = -((leftValue * leftValue) * leftValueControlReverse);
	            }
	            if (rightValue >= 0.0)
	            {
	                rightValue =((rightValue * rightValue)* rightValueControlForward);
	            }
	            else 
	            {
	                rightValue = -((rightValue * rightValue) * rightValueControlReverse);
	            }
	        }
	        setLeftRightMotorOutputs(leftValue, rightValue);
	    }
	 

	 
	 public void Drive(double leftOutputMagnitude,double rightOutputMagnitude) 
	 {
	        double leftOutput, rightOutput;
	       
//	        if(!kArcadeRatioCurve_Reported) 
//	        {
//	            UsageReporting.report(tResourceType.kResourceType_RobotDrive, getNumMotors(), tInstances.kRobotDrive_ArcadeRatioCurve);
//	            kArcadeRatioCurve_Reported = true;
//	        }
//	        if (curve < 0) 
//	        {
//	            double value = Math.log(-curve);
//	            double ratio = (value - m_sensitivity) / (value + m_sensitivity);
//	            if (ratio == 0) 
//	            {
//	                ratio = .0000000001;
//	            }
//	            leftOutput = leftOutputMagnitude / ratio;
//	            rightOutput = rightOutputMagnitude;
//	        } 
//	        else if (curve > 0) 
//	        {
//	            double value = Math.log(curve);
//	            double ratio = (value - m_sensitivity) / (value + m_sensitivity);
//	            if (ratio == 0) 
//	            {
//	                ratio = .0000000001;
//	            }
//	            leftOutput = leftOutputMagnitude;
//	            rightOutput = rightOutputMagnitude / ratio;
//	        } 
//	        else 
//	        {
	            leftOutput = leftOutputMagnitude;
	            rightOutput = rightOutputMagnitude;
//	        }
	         super.setLeftRightMotorOutputs(leftOutput, rightOutput);   
//	        setLeftRightMotorOutputs(leftOutput, rightOutput);
	    }
}
	 
