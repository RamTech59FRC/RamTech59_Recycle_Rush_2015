package org.usfirst.frc.team59.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class NewRobotDrive extends DifferentialDrive {

	private SpeedController left;
	private SpeedController right;
	
	/**
	 * @param left
	 * @param right
	 * 
	 * Creates a NewRobotDrive taking two SpeedControllers and assigns them to private
	 * global variables
	 */
	public NewRobotDrive(SpeedController left, SpeedController right) {
		super(left, right);
		
		this.left = left;
		this.right = right;
		
	}

	/**
	 * @param leftStick
	 * @param leftAxis
	 * @param rightStick
	 * @param rightAxis
	 * @param squaredInputs
	 * 
	 * Activates the tank drive method in the Differential Drive by taking the values of
	 * the left and right sticks on the Controller
	 */
	public void TankDrive(GenericHID leftStick, final int leftAxis, GenericHID rightStick, final int rightAxis,
			boolean squaredInputs) 
	{
		if (leftStick == null || rightStick == null) 
		{
			throw new NullPointerException("Null HID provided");
		}
		tankDrive(leftStick.getRawAxis(leftAxis), rightStick.getRawAxis(rightAxis), squaredInputs);
	}

	/**
	 * @param leftOutputMagnitude
	 * @param rightOutputMagnitude
	 * 
	 * Sets the left and right motor to drive at a speed passed by variable
	 */
	public void Drive(double leftOutputMagnitude, double rightOutputMagnitude) {

		left.set(leftOutputMagnitude);
		right.set(rightOutputMagnitude);
	}
}
