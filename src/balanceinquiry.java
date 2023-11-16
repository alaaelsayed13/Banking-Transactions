class balanceinquiry extends transaction {
   private String currencyType;

   public balanceinquiry(int transactionID, String currencyType) {
      super(transactionID);
      this.currencyType = currencyType;
   }

   @Override
   public double execute(account account) {

      return account.getBalance();
   }

   @Override
   public double cancelTransaction(account account) {

      return account.getBalance();
   }
}
