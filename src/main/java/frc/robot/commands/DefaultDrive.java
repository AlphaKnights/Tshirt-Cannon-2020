/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

import java.lang.Math;

public class DefaultDrive extends CommandBase {
  /**
   * Creates a new DefaultDrive.
   */

  private DrivetrainSubsystem m_Drivetrain;
  private Double m_power;
  private Double m_rotation;
  private Double driveThrottle;
  private Double rotateThrottle;
  private Joystick driveJoystick;
  private Joystick rotateJoystick;

  public DefaultDrive(DrivetrainSubsystem driveTrain, Joystick m_driveJoystick, Joystick m_rotateJoystick) {
    this.m_Drivetrain = driveTrain;
    this.driveJoystick = m_driveJoystick;
    this.rotateJoystick = m_rotateJoystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveThrottle = Math.pow(((1 - driveJoystick.getRawAxis(3)) / 2), 0.5);
   rotateThrottle = (1 - rotateJoystick.getRawAxis(3)) / 2;

   m_power = -driveJoystick.getY() * driveThrottle;
   m_rotation = rotateJoystick.getZ() * rotateThrottle;

   m_Drivetrain.alphaDriveArcade(m_power, m_rotation);

    // m_Drivetrain.alphaDriveTank(-rotateJoystick.getY() * driveThrottle, -driveJoystick.getY() * driveThrottle);
  }

  // public void executeRotateMoveStick() {
  //   driveThrottle = Math.pow(((1 - driveJoystick.getRawAxis(3)) / 2), 0.5);
  //   rotateThrottle = (1 - rotateJoystick.getRawAxis(3)) / 2;

  //   m_power = -driveJoystick.getY() * driveThrottle;
  //   m_rotation = rotateJoystick.getZ() * rotateThrottle;

  //   m_Drivetrain.alphaDriveArcade(m_power, m_rotation);
  // }

  public Double squareRootDouble(Double input_value) {
    double output_power = 0.0;
    if (input_value > 0) {
      output_power = Math.pow(input_value, 0.5);
    } else if (input_value < 0) {
      output_power = -Math.pow(Math.abs(input_value), 0.5);
    }
    return output_power;
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