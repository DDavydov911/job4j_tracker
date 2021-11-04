package ru.job4j.stream;

public class Pet {
    private String animalType;
    private String name;
    private int age;
    private double weight;
    private double height;

    public static class Builder {
        private String animalType;
        private String name;
        private byte age;
        private double weight;
        private double height;

        Builder buildAnimalType(String animalType) {
            this.animalType = animalType;
            return this;
        }

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildWeight(double weight) {
            this.weight = weight;
            return this;
        }

        Builder buildHeight(double height) {
            this.height = height;
            return this;
        }

        Pet build() {
            Pet pet = new Pet();
            pet.animalType = animalType;
            pet.name = name;
            pet.age = age;
            pet.height = height;
            pet.weight = weight;
            return pet;
        }
    }

    @Override
    public String toString() {
        return "Pet{"
                + "animalType='" + animalType + '\''
                + ", name='" + name + '\''
                + ", age=" + age
                + ", weight=" + weight
                + ", height=" + height
                + '}';
    }

    public static void main(String[] args) {
        Pet pet = new Builder().buildAnimalType("Cat")
                .buildName("Murka")
                /*
                .buildAge((byte) 3)
                .buildHeight(0.27D)
                 */
                .buildWeight(3.1D)
                .build();
        System.out.println(pet);
    }
}
