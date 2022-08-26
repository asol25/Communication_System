package Bill;

public class Bill {
    /**
     * limitingAmount of the bill.
     */
    private double limitingAmount;

    /**
     * currentDebt of the bill.
     */
    private double currentDebt;

    /**
     * totalMoneySpent of the bill.
     */
    private double totalMoneySpent;


    /**
     * Constructor with 1 parameter.
     * Throw an exception if the given limiting amount is negative.
     * @param limitingAmount Limiting amount of the bill.
     */
    public Bill(double limitingAmount) {
        try {
            if (limitingAmount <= 0.0)
                throw new IllegalArgumentException("Limit Amount must lager than zero");

            this.limitingAmount = limitingAmount;
            this.currentDebt = 0.0;
            this.totalMoneySpent = 0.0;
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Checks whether the limitingAmount is exceeded or not.
     * @param amount Amount to check.
     * @return TRUE if the limitingAmount is not larger than total current debt, FALSE otherwise.
     */
    public boolean Check(double amount) {
        return this.currentDebt + amount <= this.limitingAmount;
    }

    /**
     * Adds current debt to the bill.
     * This method has to be called with the "public boolean Check(double amount)" method.
     * @param amount Amount to be added to the current debt.
     */
    public void Add(double amount) {
        currentDebt += amount;
    }

    /**
     * Payment for the bill with the given amount.
     * @param amount Amount paid to current debt.
     */
    public void Pay(double amount) {
        if(amount < this.currentDebt) {
            this.currentDebt -= amount;
            this.totalMoneySpent += amount;
        }
        else {
            this.totalMoneySpent += this.currentDebt;
            this.currentDebt = 0.0;		// There is no negative debt.
        }
    }

    /**
     * Changes the limitingAmount, i.e. setter method for limitingAmount.
     * If the current debt would exceed the limit after setting a new limit, then the limit remains unchanged.
     * @param amount New limiting amount of the bill.
     */
    public void ChangeLimitingAmount(double amount) {
        if(amount >= this.currentDebt)
            this.limitingAmount = amount;
    }

    /**
     * Getter method of limitingAmount.
     * @return limitingAmount.
     */
    public double getLimitingAmount() {
        return limitingAmount;
    }

    /**
     * Getter method of currentDebt.
     * @return currentDebt.
     */
    public double getCurrentDebt() {
        return currentDebt;
    }

    /**
     * Getter method of totalMoneySpent.
     * @return totalMoneySpent.
     */
    public double getTotalMoneySpent() {
        return totalMoneySpent;
    }
}
