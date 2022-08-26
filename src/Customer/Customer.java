package Customer;

import Bill.Bill;
import Operater.Operator;

public class Customer {

    /**
     * ID of the Customer
     */
    private int ID;

    /**
     * Name of the Customer
     */
    private String name;

    /**
     * Age of the Customer
     */
    private int age;

    /**
     * Total spent talking of the Customer
     */
    private int totalSpentTalking;

    /**
     * Total spent talking of the Customer
     */
    private int totalSentMessage;

    /**
     * Total spent talking of the Customer
     */
    private int totalInternetUsage;

    /**
     * Operator at Customer
     */
    private Operator operator;

    /**
     * Bill at Customer
     */
    private Bill bill;

    /**
     * Constructor have five parameter.
     * @param ID ID of the Customer.
     * @param name Name of the Customer.
     * @param age Age of the Customer.
     * @param operator Operator of the customer.
     * @param limitingAmount Limiting amount of the bill of the customer.
     */

    public Customer(int ID, String name, int age, Operator operator, double limitingAmount) {
        this.ID = ID;
        this.name = name;
        setAge(age);

        this.operator = operator;
        this.bill = new Bill(limitingAmount);
        this.totalSpentTalking = 0;
        this.totalSentMessage = 0;
        this.totalInternetUsage = 0;
    }

    /**
     * A method talk with Other Customer.
     * @param minute Minute timer Customer talking.
     * @param other Other customer.
     */
    public void Talk(int minute, Customer other) {
        try {
            if (minute <= 0)
                throw new IllegalArgumentException("minute must larger then zero");


            if (this.ID != other.getID()) {
                final double cost = this.operator.CalculateTalkingCost(minute, this);

                if (this.bill.Check(cost)) {
                    this.bill.Add(cost);
                    this.operator.AddTalkingTime(minute);
                    other.operator.AddTalkingTime(minute);
                    totalSpentTalking += minute;
                    other.totalSpentTalking += minute;
                }
            }
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * A method talk with Other Customer.
     * @param quantity Quantity of Customer talking.
     * @param other Other customer.
     */
    public void Message(int quantity, Customer other) {
        try {
            if(quantity < 0)
                throw new IllegalArgumentException("Number of messages to be sent must be non-negative.");

            if(ID != other.ID) {
                final double cost = operator.CalculateMessageCost(quantity, this, other);

                if(this.bill.Check(cost)) {
                    this.bill.Add(cost);
                    this.operator.AddMessage(quantity);
                    this.totalSentMessage += quantity;
                }
            }
        } catch(final IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    } /**
     * A method talk with Other Customer.
     * @param amount Amount MB of Customer.
     */
    public void Connect(double amount) {
        try {
            if (amount <= 0.0)
                throw new IllegalArgumentException("Amount must larger than zero");

            final double cost = this.operator.CalculateNetworkCost(amount);
            if (this.bill.Check(cost))
                this.bill.Add(cost);
                this.operator.AddInternet(cost);
                totalInternetUsage += cost;
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Getter method getTotalSpentTalking of Customer.
     * @return totalSpentTalking of Customer.
     */
    public int getTotalSpentTalking() {
        return totalSpentTalking;
    }

    /**
     * Getter method getTotalSentMessage of Customer.
     * @return totalSentMessage of Customer.
     */
    public int getTotalSentMessage() {
        return totalSentMessage;
    }

    /**
     * Getter method getTotalInternetUsage of Customer.
     * @return totalInternetUsage of Customer.
     */
    public int getTotalInternetUsage() {
        return totalInternetUsage;
    }

    /**
     * Getter method getID of Customer.
     * @return ID of Customer.
     */
    public int getID() {
        return ID;
    }

    /**
     * Setter method setID of Customer.
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Getter method getName of Customer.
     * @return name of Customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method setName of Customer.
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Getter method getAge of Customer.
     * @return age of Customer.
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method setAge of Customer.
     */
    public void setAge(int age) {
        try {
            if(age < 0)
                throw new IllegalArgumentException("Age must be non-negative.");

            this.age = age;

        } catch(final IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Getter method getOperator of Customer.
     * @return operator of Customer.
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * Setter method operator of Customer.
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * Getter method getBill of Customer.
     * @return bill of Customer.
     */
    public Bill getBill() {
        return bill;
    }

    @Override
    public String toString() {
        return String.format("Customer %d : %.2f %.2f", this.ID, this.bill.getTotalMoneySpent(), this.bill.getCurrentDebt());
    }
}
