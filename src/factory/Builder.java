package factory;

import java.util.function.Supplier;

/**
 * Created by tayfuno on 29/03/16.
 */
public interface Builder {

    void add(WeaponType name, Supplier<Weapon> supplier);
}
