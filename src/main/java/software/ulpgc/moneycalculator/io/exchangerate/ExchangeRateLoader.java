package software.ulpgc.moneycalculator.io.exchangerate;

import software.ulpgc.moneycalculator.io.APIFileDeserializer;
import software.ulpgc.moneycalculator.io.APIFileReader;
import software.ulpgc.moneycalculator.io.currency.Currency;

public record ExchangeRateLoader(
        APIFileReader reader,
        ExchangeRateAdapter adapter,
        APIFileDeserializer deserializer
) {
    public ExchangeRate load(Currency from, Currency to) {
        return adapter.adapt(deserializer.deserialize(reader.read()), from, to);
    }
}