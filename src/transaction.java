public abstract class transaction {
    private int transactionID;

    public transaction(int transactionID) {
        this.transactionID = transactionID;
    }

    public abstract double execute(account account);

    public abstract double cancelTransaction(account account);
}