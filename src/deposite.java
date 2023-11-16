class deposit extends transaction {
    private double amount;

    public deposit(int transactionID, double amount) {
        super(transactionID);
        this.amount = amount;
    }

    @Override
    public double execute(account account) {
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        return newBalance;
    }

    @Override
    public double cancelTransaction(account account) {
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        return newBalance;
    }
}
