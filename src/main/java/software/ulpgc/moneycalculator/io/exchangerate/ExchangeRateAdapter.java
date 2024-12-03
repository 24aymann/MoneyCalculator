package software.ulpgc.moneycalculator.io.exchangerate;


import software.ulpgc.moneycalculator.io.currency.Currency;

public interface ExchangeRateAdapter {
    ExchangeRate adapt(Object object, Currency from, Currency to);
}
