package software.ulpgc.moneycalculator.io;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

import static org.jsoup.Connection.Method.GET;

public class FixerCurrencyReader implements CurrencyReader {
    private final String currencyAPIFileURL;

    public FixerCurrencyReader(String currencyAPIFileURL) {
        this.currencyAPIFileURL = currencyAPIFileURL;
    }

    @Override
    public String read() {
        try {
            return read(currencyAPIFileURL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String read(String apiFileURL) throws IOException {
        Connection.Response response = Jsoup.connect(apiFileURL)
                .ignoreContentType(true)
                .header("accept", "text/*")
                .method(GET)
                .execute();
        if (response.statusCode() != 200) throw new RuntimeException("Fatal Issue.");
        return response.body();
    }
}
