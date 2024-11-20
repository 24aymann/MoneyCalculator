package software.ulpgc.moneycalculator.io;

import com.google.gson.Gson;
import software.ulpgc.moneycalculator.io.pojos.FixerCurrencyGetResponse;

public class FixerCurrencyDeserializer implements CurrencyDeserializer{
    @Override
    public Object deserialize(String read) {
        return new Gson().fromJson(read, FixerCurrencyGetResponse.class);
    }
}
