package frc.team4931.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4931.robot.subsystems.Arm;
import frc.team4931.robot.subsystems.Drivetrain;
import frc.team4931.robot.subsystems.Roller;

public class Robot extends IterativeRobot {

  public static OperatorInput operatorInput;
  public static Drivetrain drivetrain;
  public static Arm arm;
  public static Roller roller;

  @Override
  public void robotInit() {
    operatorInput = new OperatorInput();

    drivetrain = new Drivetrain();

    arm = new Arm();
    roller = new Roller();

    System.out.println("Hello World! Beep Boop!");
  }

  @Override
  public void robotPeriodic() {
    roller.checkBeam();
    log();
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  public void log() {
    drivetrain.log();

    SmartDashboard.putNumber("Joy Y", operatorInput.getJoystick().getY());
    SmartDashboard.putNumber("Joy X", operatorInput.getJoystick().getX());
    SmartDashboard.putNumber("Joy Z", operatorInput.getJoystick().getZ());
    SmartDashboard.putNumber("Joy T", operatorInput.getJoystick().getThrottle());
  }
}
