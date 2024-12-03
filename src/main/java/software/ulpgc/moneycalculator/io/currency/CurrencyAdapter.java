package software.ulpgc.moneycalculator.io.currency;

import java.util.List;

public interface CurrencyAdapter {
    List<Currency> adapt(Object object);
}
