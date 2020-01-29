/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.SerialPort;

import static frc.robot.Constants.DrivetrainConstants.*;

public class DrivetrainSubsystem extends SubsystemBase {
    private final WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(leftMotor1ID);
    private final WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(leftMotor2ID);
    private final WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(RightMotor1ID);
    private final WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(RightMotor2ID);

    private final AHRS navX = new AHRS(SerialPort.Port.kUSB);


    private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
    private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);

    private final DifferentialDrive m_drive = new DifferentialDrive(leftMotors, rightMotors);

    /**
     * The Singleton instance of this DrivetrainSubsystem. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static DrivetrainSubsystem INSTANCE = new DrivetrainSubsystem();

    private DrivetrainSubsystem() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.
    }

    public void alphaDriveArcade(Double speed, Double rotate) {
        System.out.println(speed);
        m_drive.arcadeDrive(speed, rotate);
    }

    public void alphaCurveArcade(Double speed, Double rotate) {
        System.out.println(speed);
        m_drive.curvatureDrive(speed, rotate, false);
    }

    public void alphaDriveTank(Double lSpeed, Double rSpeed) {
        System.out.println(lSpeed);
        m_drive.tankDrive(lSpeed, rSpeed);
    }

    public double getNavXAngle() {
        return navX.getAngle();
    }
      
      public void setNavXZero() {
        navX.reset();
      }



    public static DrivetrainSubsystem getInstance() {
        return INSTANCE;
    }
}
