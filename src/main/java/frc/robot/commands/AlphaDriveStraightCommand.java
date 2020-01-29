/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Constants;

public class AlphaDriveStraightCommand extends CommandBase {
  /**
   * Creates a new AlphaDriveStraightCommand.
   */
  Joystick throttleJoystick;
  JoystickButton straightStick;


  DrivetrainSubsystem driveTrainSubSystem;
  public AlphaDriveStraightCommand(DrivetrainSubsystem driveTrainSubSystem, Joystick throttleStick, JoystickButton straightStick) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrainSubSystem = driveTrainSubSystem;
    this.throttleJoystick = throttleStick;
    this.straightStick = straightStick;
    addRequirements(driveTrainSubSystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrainSubSystem.setNavXZero();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println(driveTrainSubSystem.getNavXAngle());
    if (straightStick.get()) {
      if (DrivetrainConstants.notSimpleStraightMode) {
        driveTrainSubSystem.setNavXZero();
        DrivetrainConstants.notSimpleStraightMode = false;
      }

    }
    else{
      DrivetrainConstants.notSimpleStraightMode = true;
    }
    if (straightStick.get()) {
      DrivetrainConstants.navXCorrectionTank = driveTrainSubSystem.getNavXAngle() * 0.01;
      DrivetrainConstants.leftTalonPower = throttleJoystick.getRawAxis(Constants.OIConstants.throttleAxis) - throttleJoystick.getRawAxis(Constants.OIConstants.brakeAxis) - Constants.driveStraightConstants.navXCorrectionTank;
      DrivetrainConstants.rightTalonPower = throttleJoystick.getRawAxis(Constants.OIConstants.throttleAxis) - throttleJoystick.getRawAxis(Constants.OIConstants.brakeAxis) + Constants.driveStraightConstants.navXCorrectionTank;
    }
    else {
     DrivetrainConstants.leftTalonPower = throttleJoystick.getRawAxis(Constants.OIConstants.throttleAxis) + throttleJoystick.getRawAxis(Constants.OIConstants.rotateJoystickAxis) - throttleJoystick.getRawAxis(Constants.OIConstants.brakeAxis);
     DrivetrainConstants.rightTalonPower = throttleJoystick.getRawAxis(Constants.OIConstants.throttleAxis) - throttleJoystick.getRawAxis(Constants.OIConstants.rotateJoystickAxis) - throttleJoystick.getRawAxis(Constants.OIConstants.brakeAxis);
    }
    
    
    DrivetrainSubsystem.getInstance().alphaDriveTank(DrivetrainConstants.leftTalonPower, DrivetrainConstants.rightTalonPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}