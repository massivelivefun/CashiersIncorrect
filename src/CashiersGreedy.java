// Greedily calculate the minimum number of coins from an amount of change.
public class CashiersGreedy {
    int[] coins;

    public CashiersGreedy(int[] coins) {
        this.coins = coins;
    }

    public int getMinimumNumberOfCoins(int amountOfChange) {
        int minNumOfCoins = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            while (amountOfChange >= coins[i]) {
                amountOfChange -= coins[i];
                minNumOfCoins++;
            }
        }

        return minNumOfCoins;
    }
}
