package factory;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by tayfuno on 29/03/16.
 */
public interface WeaponFactory {

    Weapon create (WeaponType name);

    static WeaponFactory factory(Consumer<Builder> consumer) {
        HashMap<WeaponType, Supplier<Weapon>> map = new HashMap<>();

        Builder b = new Builder() {
            @Override
            public void add(WeaponType name, Supplier<Weapon> supplier) {
                map.put(name, supplier);
            }
        };
        consumer.accept(b);

        WeaponFactory f = new WeaponFactory() {
            @Override
            public Weapon create(WeaponType name) {
                return map.get(name).get();
            }
        };

        return f;

    }
}
