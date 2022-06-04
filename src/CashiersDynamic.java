// Dynamically calculate the minimum number of coins from an amount of change.
public class CashiersDynamic {
    int[] coins;

    public CashiersDynamic(int[] coins) {
        this.coins = coins;
    }

    public int getMinimumNumberOfCoins(int amountOfChange) {
        int[] minNumOfCoinsTable = new int[amountOfChange + 1];
        minNumOfCoinsTable[0] = 0;

        for (int i = 1; i <= amountOfChange; i++) {
            minNumOfCoinsTable[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= amountOfChange; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    int previous = minNumOfCoinsTable[i - coin];
                    if (previous != Integer.MAX_VALUE &&
                            previous + 1 < minNumOfCoinsTable[i]) {
                        minNumOfCoinsTable[i] = previous + 1;
                    }
                }
            }
        }

        return minNumOfCoinsTable[amountOfChange];
    }
}
