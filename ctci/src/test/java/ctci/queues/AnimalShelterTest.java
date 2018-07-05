package ctci.queues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalShelterTest {

    AnimalShelter shelter;
    AnimalShelter.Dog oldDog, dog, youngDog;
    AnimalShelter.Cat oldCat, cat, youngCat;
    @Before
    public void setUp() throws Exception {
        shelter = new AnimalShelter();
        oldDog = new AnimalShelter.Dog();
        dog = new AnimalShelter.Dog();
        youngDog = new AnimalShelter.Dog();
        oldCat = new AnimalShelter.Cat();
        cat = new AnimalShelter.Cat();
        youngCat = new AnimalShelter.Cat();
    }

    @Test
    public void enqueue_dequeue_any() throws Exception {
        shelter.enqueue(dog);
        shelter.enqueue(cat);
        shelter.enqueue(oldDog);
        shelter.enqueue(youngCat);

        assertEquals(dog, shelter.dequeueAny());
        assertEquals(cat, shelter.dequeueAny());
        assertEquals(oldDog, shelter.dequeueAny());
        assertEquals(youngCat, shelter.dequeueAny());
    }

    @Test
    public void enqueue_dequeue_dog() throws Exception {
        shelter.enqueue(oldDog);
        shelter.enqueue(cat);

        shelter.enqueueDog(dog);
        shelter.enqueueDog(youngDog);


        assertEquals(oldDog, shelter.dequeueDog());
        assertEquals(dog, shelter.dequeueDog());
        assertEquals(youngDog, shelter.dequeueDog());
    }

    @Test
    public void deqeueDog() throws Exception {
        shelter.enqueue(oldCat);
        shelter.enqueue(cat);
        shelter.enqueue(youngCat);
        shelter.enqueueDog(youngDog);

        assertEquals(youngDog, shelter.dequeueDog());
    }

    @Test
    public void enqueueCat() throws Exception {
    }

    @Test
    public void deqeueCat() throws Exception {
    }

}