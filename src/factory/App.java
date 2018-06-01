package factory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by tayfuno on 29/03/16.
 */
public class App {

    public static void main(String[] args) {

        Consumer<Builder> consumer = new Consumer<Builder>() {
            @Override
            public void accept(Builder builder) {
                builder.add(WeaponType.SWORD, new Supplier<Weapon>() {
                    @Override
                    public Weapon get() {
                        return new Sword();
                    }
                });
                builder.add(WeaponType.AXE, new Supplier<Weapon>() {
                    @Override
                    public Weapon get() {
                        return new Axe();
                    }
                });
                builder.add(WeaponType.SPEAR, new Supplier<Weapon>() {
                    @Override
                    public Weapon get() {
                        return new Spear();
                    }
                });
            }
        };

        WeaponFactory fac = WeaponFactory.factory(consumer);
        Weapon weapon = fac.create(WeaponType.AXE);
        System.out.println("weapon = " + weapon);

        List names = new ArrayList();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");


        Consumer c = System.out::println;
        names.forEach(c);
    }
}
