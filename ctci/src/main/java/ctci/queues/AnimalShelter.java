package ctci.queues;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

class AnimalShelter {

    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();

    void enqueue(Animal animal) {
        if (animal instanceof Dog) {
            enqueueDog((Dog) animal);
        } else {
            enqueueCat((Cat) animal);
        }
    }

    void enqueueDog(Dog animal) {
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        animal.date = System.currentTimeMillis();
        dogs.addLast(animal);
    }

    void enqueueCat(Cat animal) {
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        animal.date = System.currentTimeMillis();
        cats.addLast(animal);
    }

    Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return deqeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        }
        Dog d = dogs.peek();
        Cat c = cats.peek();
        if (d.date < c.date) {
            return dequeueDog();
        }
        return deqeueCat();
    }

    Dog dequeueDog() {
        return dogs.poll();
    }


    Cat deqeueCat() {
        return cats.poll();
    }

    static class Animal {
        long date;
    }

    static class Dog extends Animal {
    }

    static class Cat extends Animal {
    }
}
