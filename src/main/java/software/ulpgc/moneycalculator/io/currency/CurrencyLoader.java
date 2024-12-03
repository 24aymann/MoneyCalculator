package software.ulpgc.moneycalculator.io.currency;

import software.ulpgc.moneycalculator.io.APIFileDeserializer;
import software.ulpgc.moneycalculator.io.APIFileReader;

import java.util.List;

public record CurrencyLoader(
        APIFileReader reader,
        CurrencyAdapter adapter,
        APIFileDeserializer deserializer
) {

    public List<Currency> load() {
        return adapter.adapt(deserializer.deserialize(reader.read()));
    }
}
