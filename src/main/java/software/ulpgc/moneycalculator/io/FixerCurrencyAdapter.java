package software.ulpgc.moneycalculator.io;

import software.ulpgc.moneycalculator.io.pojos.FixerCurrencyGetResponse;

import java.util.List;
import java.util.stream.Collectors;

public class FixerCurrencyAdapter implements CurrencyAdapter{
    @Override
    public List<Currency> adapt(Object object) {
        return adapt(((FixerCurrencyGetResponse) object));
    }

    private List<Currency> adapt(FixerCurrencyGetResponse symbols) {
        return symbols.symbols()
                .entrySet()
                .stream()
                .map(entry -> new Currency(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
