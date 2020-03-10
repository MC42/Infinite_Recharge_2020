package frc.team1923.robot.utilities.motor;

public abstract class MotorGroup {
    protected final int leaderID;
    protected final int[] followerIDs;

    protected boolean invert, coast;

    protected boolean softLimit;
    protected double forwardSoftLimit, reverseSoftLimit;

    protected double rampRate;

    protected double p, i, d, f;

    protected MotorGroup(int leaderID, int... followerIDs) {
        this.leaderID = leaderID;
        this.followerIDs = followerIDs;
    }

    public abstract Motor create();

    public MotorGroup inverting() {
        this.invert = true;

        return this;
    }

    public MotorGroup coasting() {
        this.coast = true;

        return this;
    }

    public MotorGroup softLimiting(double reverse, double forward) {
        this.softLimit = true;

        this.forwardSoftLimit = forward;
        this.reverseSoftLimit = reverse;

        return this;
    }

    public MotorGroup ramping(double rate) {
        this.rampRate = rate;

        return this;
    }

    public MotorGroup withPIDF(double p, double i, double d, double f) {
        this.p = p;
        this.i = i;
        this.d = d;
        this.f = f;

        return this;
    }
}
