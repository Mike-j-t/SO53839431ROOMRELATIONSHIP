package so53839431.so53839431roomrelationship;

import android.arch.persistence.room.RoomDatabase;

@android.arch.persistence.room.Database(entities = {Items.class,Category.class}, version = 1, exportSchema = false)
abstract class Database extends RoomDatabase {

    abstract public ItemsDAO itemsDAO();
    abstract public CategoryDAO categoryDao();
}
