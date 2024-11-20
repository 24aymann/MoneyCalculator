package software.ulpgc.moneycalculator.io;

import java.util.List;

public interface CurrencyAdapter {
    List<Currency> adapt(Object object);
}
