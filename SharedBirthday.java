import java.util.*;
public class SharedBirthday {

    public static void main(String[] args) {
        try {
            if (args.length != 3) {
                throw new IllegalArgumentException("Exactly three arguments required");
            }
            int people = Integer.parseInt(args[0]);
            int days = Integer.parseInt(args[1]);
            int trials = Integer.parseInt(args[2]);
            System.out.println(probabilityEstimate(people, days, trials));
        } catch (NumberFormatException e) {
            System.err.println("Arguments must all be integers");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static double probabilityEstimate(int people, int days, int trials) {
       if (people < 2){
           throw new IllegalArgumentException("At least two people required");
       }

       if (days < 1){
           throw new IllegalArgumentException("At least one day required");
       }
       if (trials < 1){
           throw new IllegalArgumentException("At least one trial required");
       }

   int shared = 0;
      for (int i = 0; i < trials; i++) {
        ArrayList<Double> daysUsed = new ArrayList<>();
        for (int j = 0; j < people; j++) {
          double bday = (int)(Math.random() * days);
          if(daysUsed.contains(bday)){
            shared++;
            break;
          }
          daysUsed.add(bday);
        }
      }
    return (double)shared / (double)(trials);
    }
}
