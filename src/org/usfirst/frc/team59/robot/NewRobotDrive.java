package org.usfirst.frc.team59.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class NewRobotDrive extends DifferentialDrive {

	private SpeedController left;
	private SpeedController right;
	
	
	public NewRobotDrive(SpeedController left, SpeedController right) {
		super(left, right);
		
		this.left = left;
		this.right = right;
		
	}

	public void TankDrive(GenericHID leftStick, final int leftAxis, GenericHID rightStick, final int rightAxis,
			boolean squaredInputs) {
		if (leftStick == null || rightStick == null) {
			throw new NullPointerException("Null HID provided");
		}
		tankDrive(leftStick.getRawAxis(leftAxis), rightStick.getRawAxis(rightAxis), squaredInputs);
	}


	public void TankDrive(double leftValue, double rightValue, boolean squaredInputs) {
		// square the inputs (while preserving the sign) to increase fine control while
		// permitting full power
		tankDrive(leftValue, rightValue, squaredInputs);
	}

	public void Drive(double leftOutputMagnitude, double rightOutputMagnitude) {

		left.set(leftOutputMagnitude);
		right.set(rightOutputMagnitude);
	}
}
