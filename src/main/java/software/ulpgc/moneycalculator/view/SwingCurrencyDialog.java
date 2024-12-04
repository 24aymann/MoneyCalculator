package software.ulpgc.moneycalculator.view;

import software.ulpgc.moneycalculator.model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog{
    private JComboBox<Currency> currencySelector;

    public SwingCurrencyDialog() {
        this.setLayout(new GridLayout(1, 2, 10, 10));
    }

    @Override
    public CurrencyDialog define(List<Currency> currencies) {
        add(createCurrencySelector(currencies, "From: "));
        add(createCurrencySelector(currencies, "To: "));
        return this;
    }

    private Component createCurrencySelector(List<Currency> currencies, String label) {
        JPanel panel = new JPanel();
        JLabel jLabel = new JLabel(label);
        panel.add(jLabel);

        JComboBox<Currency> comboBoxSelector = new JComboBox<>();
        for (Currency currency : currencies)
            comboBoxSelector.addItem(currency);
        this.currencySelector = comboBoxSelector;
        panel.add(comboBoxSelector);

        return panel;
    }

    @Override
    public Currency get() {
        return currencySelector.getItemAt(currencySelector.getSelectedIndex());
    }
}
