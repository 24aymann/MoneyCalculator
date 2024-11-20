package software.ulpgc.moneycalculator.io.pojos;

import java.util.Map;

public record FixerCurrencyGetResponse(Map<String, String> symbols) {
}
