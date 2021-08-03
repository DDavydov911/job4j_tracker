package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434"), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 100D));
        assertNull(bank.findByRequisite("34", "5546"));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        Account account = new Account("34dcl", 100D);
        bank.addAccount(user.getPassport(), account);
        assertThat(bank.findByRequisite("3434", "34dcl").getBalance(), is(100D));
    }

    @Test
    public void transferMoney() {
        User srcUser = new User("1234", "Ivan Ivanov");
        Account srcAccount = new Account("0001", 7000D);
        User destUser = new User("2222", "San Sanych");
        Account destAccount = new Account("0002", 100D);
        BankService bank = new BankService();
        bank.addUser(srcUser);
        bank.addAccount(srcUser.getPassport(), srcAccount);
        bank.addUser(destUser);
        bank.addAccount(destUser.getPassport(), destAccount);
        bank.transferMoney(srcUser.getPassport(), srcAccount.getRequisite(),
                destUser.getPassport(), destAccount.getRequisite(), 1000);
        assertThat(destAccount.getBalance(), is(1100D));
        assertThat(srcAccount.getBalance(), is(6000D));
    }
}