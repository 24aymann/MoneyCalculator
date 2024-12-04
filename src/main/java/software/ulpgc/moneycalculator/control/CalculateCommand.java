package software.ulpgc.moneycalculator.control;

import software.ulpgc.moneycalculator.io.exchangerate.ExchangeRateLoader;
import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.model.ExchangeRate;
import software.ulpgc.moneycalculator.model.Money;
import software.ulpgc.moneycalculator.view.CurrencyDialog;
import software.ulpgc.moneycalculator.view.MoneyDialog;
import software.ulpgc.moneycalculator.view.MoneyDisplay;


public class CalculateCommand implements Command{
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }


    @Override
    public void execute() {
        Currency currency = currencyDialog.get();
        Money money = moneyDialog.get();
        ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), currency);
        Money operationResult = new Money(money.amount() * exchangeRate.rate(), currency);
        moneyDisplay.display(operationResult);
    }
}
