//package ru.job4j.ooa;
//
//public final class Airbus extends Aircraft {
//    private final static int COUNT_ENGINE;
//
//    private String name;
//
//    public Airbus(String name) {
//        if ("A380".equals(name)) {
//            this.COUNT_ENGINE = 4;
//        } else {
//            this.COUNT_ENGINE = 2;
//        }
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public void printModel() {
//        System.out.println("Модель самолета: " + name);
//    }
//
//    public void printCountEngine() {
//        System.out.println("Количество двигателей равно: " + COUNT_ENGINE);
//    }
//
//    @Override
//    public String toString() {
//        return "Airbus{"
//                + "name='" + name + '\''
//                + '}';
//    }
//}
