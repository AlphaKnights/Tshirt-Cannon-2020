package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.LauncherSubsystem;

public class FireBottomRowGroup extends SequentialCommandGroup {
    public FireBottomRowGroup(LauncherSubsystem launcherSubsystem) {
        super(
                new InstantCommand(launcherSubsystem::OpenBot),
                new WaitCommand(0.2),
                new InstantCommand(launcherSubsystem::CloseBot)
        );
    }
}