package frc.team1923.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Turret;

public class TurretSubsystem extends SubsystemBase {
    private CANSparkMax turret = Turret.TURRET.create();

    private DigitalInput isAtZeroSensor = new DigitalInput(Turret.IS_AT_ZERO_SENSOR);

    private ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    public void set(double speed) {
        this.turret.set(speed);
    }

    public void setPosition(double position) {
        this.turret.getPIDController().setReference(position, ControlType.kPosition);
    }

    public double getPosition() {
        return this.turret.getEncoder().getPosition();
    }

    public void resetPosition(double position) {
        this.turret.getEncoder().setPosition(position);
    }

    public void stop() {
        this.turret.stopMotor();
    }

    public boolean isAtZero() {
        return this.isAtZeroSensor.get();
    }

    public double getHeading() {
        return this.gyro.getAngle();
    }

    public double getHeadingRate() {
        return this.gyro.getRate();
    }

    public void resetHeading() {
        this.gyro.reset();
    }

    {
        SmartDashboard.putBoolean("Reset Turret", true);
        SmartDashboard.putBoolean("Reset Turret", false);
    }

    @Override
    public void periodic() {
        if (SmartDashboard.getBoolean("Reset Turret", false)) {
            SmartDashboard.putBoolean("Reset Turret", false);

            this.resetPosition(0);
        }
    }
}
