package software.ulpgc.moneycalculator.io.currency;

import com.google.gson.Gson;
import software.ulpgc.moneycalculator.io.APIFileDeserializer;
import software.ulpgc.moneycalculator.io.pojos.FixerCurrencyGetResponse;

public class FixerCurrencyDeserializer implements APIFileDeserializer {
    @Override
    public Object deserialize(String read) {
        return new Gson().fromJson(read, FixerCurrencyGetResponse.class);
    }
}
