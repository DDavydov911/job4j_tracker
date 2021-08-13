package ru.job4j.bank;

import java.util.*;

/**
 * Класс представляет собой подобие банковского сервиса с добавлением пользвателеей
 * с их данными паспорта и счетов, и проведения транзакций с одного счета на другой.
 */
public class BankService {
    /**
     * Коллекция хранит данные пользователей, где пользователи яв-ся ключем, а данные их
     * счетов храняться в другой коллекции
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя.
     * @param user Пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет пользователю новый счет, проверяя его сначала на существование
     * @param passport данные паспорта
     * @param account данные счета
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод находит и возвращает пользователя по данным паспорта
     * @param passport данные паспорта
     * @return возвращает пользователя
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(p -> passport.equals(p.getPassport()))
                .findFirst();
    }

    /**
     * Метод находит и возвращает реквизиты счета по паспорту пользователя
     * @param passport данные паспорта
     * @param requisite данные счета
     * @return возвращает пользователя
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(account -> requisite.equals(account.getRequisite()))
                .findFirst());
    }

    /**
     * Метод осуществляет перевод средств с одного счета на другой по паспорту пользователя,
     * предварительно проверяя существование счета и его баланс
     * @param srcPassport данные паспорта отправителя
     * @param srcRequisite данные счета отправителя
     * @param destPassport данные паспорта получателя
     * @param destRequisite данные счета получателя
     * @param amount баланс счета
     * @return возвращает результат перевода успех\неудача
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
            Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
            Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);

        if (srcAccount.isPresent() && destAccount.isPresent()
                && amount <= srcAccount.get().getBalance()) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
