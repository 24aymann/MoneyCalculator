package software.ulpgc.moneycalculator.io.exchangerate;

import com.google.gson.Gson;
import software.ulpgc.moneycalculator.io.APIFileDeserializer;
import software.ulpgc.moneycalculator.io.pojos.FixerExchangeRateGetResponse;

public class FixerExchangeRateDeserializer implements APIFileDeserializer {
    @Override
    public Object deserialize(String read) {
        return new Gson().fromJson(read, FixerExchangeRateGetResponse.class);
    }
}
