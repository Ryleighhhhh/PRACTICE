import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "PRACTICE", group = "TeleOp")
public class PRACTICE extends OpMode {

    DcMotor lf;
    DcMotor lb;
    DcMotor rf;
    DcMotor rb;

    @Override
    public void init() {
        lf = hardwareMap.dcMotor.get("lf");
        lb = hardwareMap.dcMotor.get("lb");
        rf = hardwareMap.dcMotor.get("rf");
        rb = hardwareMap.dcMotor.get("rb");
    }

    @Override
    public void loop() {
        //Rights
        if (Math.abs(-gamepad1.right_stick_y) > .2) {
            rf.setPower(-gamepad1.right_stick_y * -1);
            rb.setPower(-gamepad1.right_stick_y * -1);
        } else {
            rb.setPower(0);
            rf.setPower(0);
        }
        //Lefts
        if (Math.abs(-gamepad1.left_stick_y) > .2) {
            lf.setPower(-gamepad1.left_stick_y * 1);
            lb.setPower(-gamepad1.left_stick_y * 1);
        } else {
            lb.setPower(0);
            lf.setPower(0);
        }
        //Strafe right
        if (Math.abs(-gamepad1.right_trigger) > .2) {
            lf.setPower(0.8);
            rb.setPower(-0.8);
            lb.setPower(-0.8);
            rf.setPower(0.8);
        } else {
            rf.setPower(0);
            lb.setPower(0);
            rb.setPower(0);
            lf.setPower(0);
        }
        //Strafe left
        if (Math.abs(-gamepad1.left_trigger) > .2) {
            lf.setPower(-0.8);
            rb.setPower(0.8);
            lb.setPower(0.8);
            rf.setPower(-0.8);
        } else {
            rf.setPower(0);
            lb.setPower(0);
            rb.setPower(0);
            lf.setPower(0);
        }
    }
}