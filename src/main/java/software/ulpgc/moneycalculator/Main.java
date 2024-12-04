package software.ulpgc.moneycalculator;

import software.ulpgc.moneycalculator.control.CalculateCommand;
import software.ulpgc.moneycalculator.control.Command;
import software.ulpgc.moneycalculator.io.*;
import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.io.currency.CurrencyLoader;
import software.ulpgc.moneycalculator.io.currency.FixerCurrencyAdapter;
import software.ulpgc.moneycalculator.io.currency.FixerCurrencyDeserializer;
import software.ulpgc.moneycalculator.io.exchangerate.ExchangeRateLoader;
import software.ulpgc.moneycalculator.io.exchangerate.FixerExchangeRateAdapter;
import software.ulpgc.moneycalculator.io.exchangerate.FixerExchangeRateDeserializer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();

        CurrencyLoader currencyLoader = new CurrencyLoader(
                new FixerAPIFileReader("http://data.fixer.io/api/symbols?access_key=31547d8fcf138f06d26b4f66076050d1"),
                new FixerCurrencyAdapter(),
                new FixerCurrencyDeserializer()
        );

        ExchangeRateLoader exchangeRateLoader = new ExchangeRateLoader(
                new FixerAPIFileReader("https://api.exchangeratesapi.io/v1/latest?access_key=31547d8fcf138f06d26b4f66076050d1"),
                new FixerExchangeRateAdapter(),
                new FixerExchangeRateDeserializer()
        );

        CalculateCommand command = new CalculateCommand(
                mainFrame.getMoneyDialog().define(currencyLoader.load()),
                mainFrame.getCurrencyDialog().define(currencyLoader.load()),
                exchangeRateLoader,
                mainFrame.getMoneyDisplay()
        );
        mainFrame.put("Calculate", command);
        mainFrame.setVisible(true);
    }
}
