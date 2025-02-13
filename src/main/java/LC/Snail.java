public class Snail {
    public static void main(String[] args) {
        System.out.println(snail(10, 3, 2));
        System.out.println(snail(20, 7, 3));
    }

    public static int snail(int column, int day, int night) {
        if (day >= column) return 1;

        int movementPerDay = day - night;
        int remainingHeight = column - movementPerDay;

        int fullDays = (int) Math.ceil((double) remainingHeight / movementPerDay);

        return fullDays + 1;

        // column = (day - night) * daysAmount
        // daysAmount = column / (day - night)
    }
}

