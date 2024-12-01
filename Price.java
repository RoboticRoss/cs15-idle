package idle;

public class Price {
  private CurrencyType type;
  private int amount;
  public Price(CurrencyType type, int amount) {
    this.type = type;
    this.amount = amount;
  }

  public CurrencyType getType() {
    return this.type;
  }

  public int getAmount() {
    return this.amount;
  }

  @Override
  public String toString() {
    return this.type + " " + this.amount;
  }
}
