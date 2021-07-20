//package ru.job4j.bank;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class BankService {
//    private Map<User, List<Account>> users = new HashMap<>();
//
//    public void addUser(User user) {
//        if (!users.containsKey(user)) {
//            users.put(user, new ArrayList<>());
//        }
//    }
//
//    public void addAccount(String passport, Account account) {
//        for (User user : users.keySet()) {
//                List<Account> list = new ArrayList<>();
//                list.add(account);
//                users.put(user, list);
//            }
//        }
//
//    }
//
//    public User findByPassport(String passport) {
//        for (User user : users.keySet()) {
//            if (passport.equals(user.getPassport())) {
//                return user;
//            }
//        }
//        return null;
//    }
//
//    public Account findByRequisite(String passport, String requisite) {
//        return null;
//    }
//
//    public boolean transferMoney(String srcPassport, String srcRequisite,
//                                 String destPassport, String destRequisite, double amount) {
//        boolean rsl = false;
//        return rsl;
//    }
//}
