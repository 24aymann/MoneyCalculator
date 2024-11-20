package software.ulpgc.moneycalculator;

import software.ulpgc.moneycalculator.io.*;

public class Main {
    public static void main(String[] args) {
        CurrencyLoader loader = new CurrencyLoader(
                new FixerCurrencyReader("http://data.fixer.io/api/symbols?access_key=31547d8fcf138f06d26b4f66076050d1"),
                new FixerCurrencyAdapter(),
                new FixerCurrencyDeserializer()
        );

        System.out.println(loader.load());
    }
}
