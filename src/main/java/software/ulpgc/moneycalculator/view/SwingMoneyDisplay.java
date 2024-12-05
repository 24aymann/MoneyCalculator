package software.ulpgc.moneycalculator.view;

import software.ulpgc.moneycalculator.model.Money;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    @Override
    public void display(Money money) {
        this.setText("Result = " + money.toString());
    }
}
