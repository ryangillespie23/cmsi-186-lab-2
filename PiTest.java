public class PiTest extends TestSuite {
    public static void main(String[] args) {
        TestSuite.run(new PiTest());
    }

    public Test[] getTests() {
        return new Test[]{
            new Test("Bad darts argument", () -> expectThrows(
                () -> PiEstimator.estimate(0),
                IllegalArgumentException.class, "At least one dart required"
            )),
            new Test("100 darts should be within 0.9", () -> {
                expectWithin(PiEstimator.estimate(100), Math.PI, 0.9);
            }),
            new Test("1000000 darts should be pretty close", () -> {
              expectWithin(PiEstimator.estimate(1000000), Math.PI, 0.005);
            }),
            new Test("Having no command line arguments", () -> expectStandardErrorToHave(
                () -> PiEstimator.main(new String[]{}),
                "Exactly one argument required"
            )),
            new Test("Having two command line arguments", () -> expectStandardErrorToHave(
                () -> PiEstimator.main(new String[]{"100", "100"}),
                "Exactly one argument required"
            )),
            new Test("A non-numeric command line argument", () -> expectStandardErrorToHave(
                () -> PiEstimator.main(new String[]{"dog"}),
                "Argument must be an integer"
            )),
            new Test("Bad dart argument on command line", () -> expectStandardErrorToHave(
                () -> PiEstimator.main(new String[]{"0"}),
                "At least one dart required"
            )),
            new Test("1000000 darts on the command line", () -> expectStandardOutput(
                () -> PiEstimator.main(new String[]{"1000000"}),
                (result) -> expectWithin(Double.parseDouble(result), Math.PI, 0.005)
            )),
        };
    }
}
