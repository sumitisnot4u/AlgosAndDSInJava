package practice.problemSolving.recursion;

/**
 * Calculates the number of ways n cents can be represented using quarters (25 cents), dimes (10 cents),
 * nickels (5 cents) and pennies (1 cent).
 *
 * @author Yashraj R. Sontakke
 */
public class WaysToRepresentNCents_9_8 {

    public Integer waysToRepresent(Integer nCents, Integer currentValue) {
        if (currentValue == nCents) {
            return 1;
        } else if (currentValue > nCents) {
            return 0;
        } else {
            return waysToRepresent(nCents, currentValue + 1)
                    + waysToRepresent(nCents, currentValue + 5)
                    + waysToRepresent(nCents, currentValue + 10)
                    + waysToRepresent(nCents, currentValue + 25);
        }

    }

    int[] map = new int[100];

    public Integer getWays(Integer currentValue){
        if (currentValue == 0){
            return 1;
        }else if (currentValue < 0){
            return 0;
        }else if (map[currentValue] !=0){
            return map[currentValue];
        }
        else {
            map[currentValue] =
             getWays(currentValue-1) + getWays( currentValue-5)
                    + getWays(currentValue-10) + getWays(currentValue-25);
            return map[currentValue];
        }
    }


    public static void main(String[] args) {
        WaysToRepresentNCents_9_8 waysToRepresentNCents = new WaysToRepresentNCents_9_8();
        System.out.println("No of ways to represent 10 cents = " + waysToRepresentNCents.waysToRepresent(8, 0));
        System.out.println("No of ways to represent 10 cents = " + waysToRepresentNCents.getWays(8));
    }
}
