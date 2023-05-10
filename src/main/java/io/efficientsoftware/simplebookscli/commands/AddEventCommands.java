package io.efficientsoftware.simplebookscli.commands;

import io.efficientsoftware.simplebookscli.model.BusinessInfoEvent;
import io.efficientsoftware.simplebookscli.service.AddDeleteService;
import io.efficientsoftware.simplebookscli.model.MoneyEvent;
import io.efficientsoftware.simplebookscli.model.TimeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class AddEventCommands {

    @Autowired
    private AddDeleteService addDeleteService;

    @ShellMethod
    public void setBusinessName(String name) {
        BusinessInfoEvent event = new BusinessInfoEvent(name);
        addDeleteService.add(event);
    }

    @ShellMethod("Log time to a project or customer")
    public void logTime(String date, String account, String description, String hoursToWorked) {
        TimeEvent timeRecord = new TimeEvent(date, account, description, hoursToWorked);
        addDeleteService.add(timeRecord);
    }

    @ShellMethod("Log a financial transaction")
    public void logRevenue(String date, String amount, String accountFrom, String accountTo,
                           @ShellOption(defaultValue = ShellOption.NULL) String description,
                           @ShellOption(defaultValue = ShellOption.NULL) String category) {
        MoneyEvent moneyRecord =
                new MoneyEvent(date, amount, accountFrom, accountTo, MoneyEvent.TRANSACTION_TYPE.REVENUE.toString(), description, category);
        addDeleteService.add(moneyRecord);
    }

    @ShellMethod("Log a financial transaction")
    public void logDirectExpense(String date, String amount, String accountFrom, String accountTo,
                                 @ShellOption(defaultValue = ShellOption.NULL) String description,
                                 @ShellOption(defaultValue = ShellOption.NULL) String category) {
        MoneyEvent moneyRecord = new MoneyEvent(date, amount,
                accountFrom, accountTo,
                MoneyEvent.TRANSACTION_TYPE.DIRECT_EXPENSE.toString(),
                description, category);
        addDeleteService.add(moneyRecord);
    }

}
