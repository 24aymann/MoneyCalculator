package software.ulpgc.moneycalculator.io.pojos;

import java.util.Map;

public record FixerExchangeRateGetResponse(Map<String, Double> rates) {
}
