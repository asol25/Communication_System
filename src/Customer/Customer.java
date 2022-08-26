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
     * Constructor have three parameter.
     * @param ID ID of the Customer.
     * @param name Name of the Customer.
     * @param age Age of the Customer.
     */

    public Customer(int ID, String name, int age) {
        this.ID = ID;
        this.name = name;
        this.age = age;

        operator = new Operator();
        bill = new Bill();
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

    }

    /**
     * A method talk with Other Customer.
     * @param quantity Quatity of Customer talking.
     * @param other Other customer.
     */
    public void Message(int quantity, Customer other) {

    } /**
     * A method talk with Other Customer.
     * @param amount Amount MB of Customer.
     */
    public void Connect(double amount) {

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
        this.age = age;
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
}
