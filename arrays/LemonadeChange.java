public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {

                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                if (five != 0 && ten != 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] intArray = new int[] { 5, 5, 10, 10, 20 };
        LemonadeChange solution = new LemonadeChange();
        boolean result = solution.lemonadeChange(intArray);
        System.out.println(result);
    }
}
