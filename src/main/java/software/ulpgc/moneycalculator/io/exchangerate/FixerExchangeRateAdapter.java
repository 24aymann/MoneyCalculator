package software.ulpgc.moneycalculator.io.exchangerate;

import software.ulpgc.moneycalculator.io.currency.Currency;
import software.ulpgc.moneycalculator.io.pojos.FixerExchangeRateGetResponse;

import java.time.LocalDate;

public class FixerExchangeRateAdapter implements ExchangeRateAdapter {
    @Override
    public ExchangeRate adapt(Object object, Currency from, Currency to) {
        return adapt((FixerExchangeRateGetResponse) object, from, to);
    }

    private ExchangeRate adapt(FixerExchangeRateGetResponse response, Currency from, Currency to) {
        Double rate = response.rates().get(to.getCode());
        return new ExchangeRate(
                from, to, rate, LocalDate.now()
        );
    }
}
