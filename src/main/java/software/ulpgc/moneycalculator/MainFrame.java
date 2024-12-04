package software.ulpgc.moneycalculator;

import software.ulpgc.moneycalculator.control.Command;
import software.ulpgc.moneycalculator.view.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands = new HashMap<>();
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;

    public MainFrame() throws HeadlessException {
        this.setTitle("Money Calculator");
        this.setSize(1000,400);
        this.setBackground(Color.GRAY);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle();
        this.add(createMoneyDialog());
        this.add(createCurrencyDialog());
        this.add(createMoneyDisplay());
        this.add(createButton());
    }

    private void setTitle() {
        JLabel title = new JLabel("Currency conversion", JLabel.CENTER);
        title.setFont(new Font("New Font", Font.PLAIN, 60));
        this.add(title);
    }

    private JPanel createButton() {
        JButton calculateButton = new JButton("Calculate");

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
        panel.add(calculateButton);
        calculateButton.addActionListener(e -> commands.get("Calculate").execute());

        return panel;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return display;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public void put(String commandName, Command command) {
        commands.put(commandName, command);
    }
}
