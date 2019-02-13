package me.daniel.ch1;


import java.util.*;
import java.util.stream.Collectors;

class Person implements Cloneable{
    private final String name;
    private final int age;

    private final String address;
    private final String etc;
    private List<Person> friends;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEtc() {
        return etc;
    }

    public List<Person> getFriends() {
        return friends;
    }

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.etc = builder.etc;
        this.friends = builder.friends;
    }

    public static class Builder {
        private String name;
        private int age;

        private String address;
        private String etc;
        private List<Person> friends = Collections.emptyList();

        Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }


        Builder address(String address) {
            this.address = address;
            return this;
        }

        Builder etc(String etc) {
            this.etc = etc;
            return this;
        }

        Builder friends(Person ...friends) {
            this.friends = Arrays.asList(friends).stream().map(Person::clone).collect(Collectors.toList());
            return this;
        }

        Person build() {
            return new Person(this);
        }
    }

    @Override
    public Person clone() {
        try {
            Person person = (Person)super.clone();
            person.friends = this.friends.stream().map(Person::clone).collect(Collectors.toList());
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}


public class DeepCopy {
    public static void main(String[] args) {
        Person person = new Person.Builder("kschoi", 20)
                .address("seoul")
                .etc("etc")
                .friends(new Person.Builder("lee", 32).build())
                .build();

        Person copyPerson = person.clone();
        System.out.println(copyPerson);
        System.out.println(copyPerson == person);
        System.out.println(copyPerson.getFriends() == person.getFriends());

    }
}
