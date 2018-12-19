package so53839431.so53839431roomrelationship;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
interface ItemsDAO {
    @Insert
    public long[] insertItem(Items... Items);

    @Query("SELECT * FROM Items")
    public List<Items> getAllItems();

}
