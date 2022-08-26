package Operater;

import Bill.Bill;
import Customer.Customer;

public class Operator {

    //DO_NOT_EDIT_BELOW_THIS_LINE

    /**
     * ID of the Operator.
     */
    private int ID;

    /**
     * talkingCharge of the Operator.
     */
    private double talkingCharge;

    /**
     * messageCosts of the Operator.
     */
    private double messageCosts;

    /**
     * networkCharge of the Operator.
     */
    private double networkCharge;

    /**
     * totalInternetUsage of the Operator.
     */
    private double totalInternetUsage;

    /**
     * totalSpentTalkingTime of the Operator.
     */
    private int totalSpentTalkingTime;

    /**
     * totalSentMessage of the Operator.
     */
    private int totalSentMessages;

    /**
     * Constructor have four parameter.
     * @param ID ID of the Operator.
     * @param talkingCharge talkingCharge of the Operator.
     * @param messageCosts messageCosts of the Operator.
     * @param networkCharge networkChargeID of the Operator.
     */
    public Operator(int ID, double talkingCharge, double messageCosts, double networkCharge) {
        this.ID = ID;
        this.talkingCharge = talkingCharge;
        this.messageCosts = messageCosts;
        this.networkCharge = networkCharge;

        this.totalSpentTalkingTime = 0;
        this.totalSentMessages = 0;
        this.totalInternetUsage = 0.0;
    }

    /**
     * For calculating the total amount to pay for talking.
     * @param minute Duration of the call in minutes.
     * @param customer Customer who is making the call.
     * @return Talking cost.
     */
    public double CalculateTalkingCost(int minute, Customer customer) {
        if(minute <= 0)
            throw new IllegalArgumentException("minute must lager than zero");

        double cost = minute * this.talkingCharge;

        int AGE_YOUNGER = 18;
        int AGE_OLDER = 65;
        if (customer.getAge() < AGE_YOUNGER || customer.getAge() > AGE_OLDER) {
            int discount  = 20;
            int TotalPercent = 100;
            cost = cost - (cost * discount/ TotalPercent);
        }
        return cost;
    }

    /**
     * For calculating the total amount to pay for message.
     * @param quantity Number of the message to be sent.
     * @param customer Customer who is sending the quantity.
     * @param  other Customer who is restive quantity.
     * @return Message cost.
     */
    public double CalculateMessageCost(int quantity, Customer customer, Customer other) {
        double cost = quantity * this.messageCosts;

        if (customer.getOperator().ID == other.getOperator().ID) {
            int discount  = 50;
            int TotalPercent = 100;
            cost = cost - (cost * discount/ TotalPercent);
        }
        return cost;
    }

    /**
     * For calculating the total amount to pay for network.
     * @param amount Number of data as MB.
     * @return Network Cost.
     */
    public double CalculateNetworkCost(double amount) {
        double cost = amount * this.networkCharge;
        return cost;
    }

    /**
     * Getter method for talkingCharge.
     * @return talkingCharge of the operator.
     */
    public double getTalkingCharge() {
        return talkingCharge;
    }

    /**
     * Setter method for talkingCharge.
     * Throw exception if talkingCharge given is negative.
     * @param talkingCharge New talkingCharge of the operator per talk.
     */
    public void setTalkingCharge(double talkingCharge) {
        try {
            if (talkingCharge <= 0.0)
                throw new IllegalArgumentException("Talking Charge must lager than zero.");

            this.talkingCharge = talkingCharge;
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Getter method for messageCost.
     * @return messageCost
     */
    public double getMessageCosts() {
        return messageCosts;
    }

    /**
     * Setter method for messageCost.
     * Throw exception if messageCost given is negative.
     * @param  messageCosts New messageCost of the operator per messages.
     */
    public void setMessageCosts(double messageCosts) {
        try {
            if (messageCosts <= 0.0)
                throw new IllegalArgumentException("Message Costs must lager than zero.");

            this.messageCosts = messageCosts;
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Getter method for messageCost.
     * @return messageCost
     */
    public double getNetworkCharge() {
        return networkCharge;
    }

    /**
     * Setter method of networkCharge.
     * Throw exception if networkCharge given is negative.
     * @param networkCharge New networkCharge of the operator.
     */
    public void setNetworkCharge(double networkCharge) {
        try {
            if (networkCharge <= 0.0)
                throw  new IllegalArgumentException("Network Charge must lager than zero");

            this.networkCharge = networkCharge;
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Getter method for ID.
     * @return ID of the operator.
     */
    public int getID() {
        return ID;
    }

    /**
     * Getter method for totalSpentTalkingTime.
     * @return Total amount of time the operator has serviced for talking over the course of simulation.
     */
    public int getTotalSpentTalkingTime() {
        return totalSpentTalkingTime;
    }

    /**
     * Getter method for totalSentMessages.
     * @return Total number of messages sent via the operator over the course of simulation.
     */
    public int getTotalSentMessages() {
        return totalSentMessages;
    }

    /**
     * Getter method for totalInternetUsage.
     * @return Total amount of Internet usage in terms of MB the operator has provided over the course of simulation.
     */
    public double getTotalInternetUsage() {
        return totalInternetUsage;
    }

    /**
     * Adds to the total spent talking time.
     * @param minute Duration of the call in minutes.
     */
    public void AddTalkingTime(int minute) {
        try {
            if (minute <= 0)
                throw new IllegalArgumentException("amount must large than zero");

            final int newTotalSpentTalkingTime = this.totalSpentTalkingTime + minute;
            this.totalSpentTalkingTime = newTotalSpentTalkingTime;
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Adds to the total sent message.
     * @param quantity Number of the message to be sent.
     */
    public void AddMessage(int quantity) {
        try {
            if (quantity <= 0)
                throw new IllegalArgumentException("amount must large than zero");

            final int newTotalSentMessages = this.totalSentMessages + quantity;
            this.totalSpentTalkingTime = newTotalSentMessages;
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     Adds to the total Internet usage.
     * @param amount Number of data as MB.
     */
    public void AddInternet(double amount) {
        try {
            if (amount <= 0)
                throw new IllegalArgumentException("amount must large than zero");

            final double newTotalInternetUsage = this.totalInternetUsage + amount;
            this.totalInternetUsage = newTotalInternetUsage;
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("Operator %d : %d %d %.2f \n", this.ID,
                this.totalSpentTalkingTime,
                this.totalSentMessages,
                this.totalInternetUsage);
    }
}
