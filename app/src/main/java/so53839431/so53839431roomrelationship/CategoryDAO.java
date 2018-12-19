package so53839431.so53839431roomrelationship;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
interface CategoryDAO {
    @Query("SELECT * FROM Category")
    List<Category> getAllcategories();

    @Query("SELECT DISTINCT Category.* " +
            "FROM CATEGORY " +
            "INNER JOIN ITEMS ON category.id = Items.category " +
            "WHERE isexcluded = 0 " +
            "ORDER BY lower(category.name)")
    List<Category> getSpeacial();

    @Query("SELECT DISTINCT Category.* " +
            "FROM CATEGORY " +
            "INNER JOIN ITEMS ON category.id = Items.category " +
            "WHERE isexcluded = 0 " +
            "ORDER BY lower(category.name)")
    List<CatViewWithItemList> getSpeacial2();

    @Insert
    public long[] insertCategory(Category... Category);
}
