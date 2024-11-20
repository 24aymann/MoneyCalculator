package software.ulpgc.moneycalculator.io;

import java.util.List;

public record CurrencyLoader(
        CurrencyReader reader,
        CurrencyAdapter adapter,
        CurrencyDeserializer deserializer
) {
    public List<Currency> load() {
        return adapter.adapt(deserializer.deserialize(reader.read()));
    }
}
