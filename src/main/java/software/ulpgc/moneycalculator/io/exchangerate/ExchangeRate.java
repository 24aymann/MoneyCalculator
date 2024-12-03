package software.ulpgc.moneycalculator.io.exchangerate;

import software.ulpgc.moneycalculator.io.currency.Currency;

import java.time.LocalDate;

public class ExchangeRate {
    private final Currency from;
    private final Currency to;
    private final double rate;
    private final LocalDate date;

    public ExchangeRate(Currency from, Currency to, double rate, LocalDate date) {
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.date = date;
    }

    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

    public double getRate() {
        return rate;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ExchangeRate {" +
                "from=" + from +
                ", to=" + to +
                ", rate=" + rate +
                ", date=" + date +
                '}';
    }
}
