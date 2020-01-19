public class PiEstimator {

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException("Exactly one argument required");
            }
            //
            // TODO: Parse the command line argument and call your estimate function
            //
        } catch (NumberFormatException e) {
            //
            // TODO: Take care of a possible non-integer argument.
            //
        } catch (IllegalArgumentException e) {
            //
            // TODO: Take care of the exception you threw above.
            //
        }
    }

    public static double estimate(int darts) {
        //
        // TODO: Do the main work here. I've just returned 0.0 as a place holder
        // so the code compiles. It isn't right though. Remove the return here and
        // implement the whole method on your own.
        //
        return 0.0;
    }

    //
    // Don't be afraid to put in some private "helper" methods. You don't have to, of
    // course, but they could be useful and keep your code modular.
    //
}
