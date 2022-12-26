package ua.ypon.springcourse.dao;

import org.springframework.stereotype.Component;
import ua.ypon.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Vasya", 23, "vasya@meta.ua"));
        people.add(new Person(++PEOPLE_COUNT, "Anya", 26, "anya@ukr.net"));
        people.add(new Person(++PEOPLE_COUNT, "Tanya", 34, "tna@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Igor", 38, "igor@i.ua"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().
                filter(person -> person.getId() == id).
                findAny().
                orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
