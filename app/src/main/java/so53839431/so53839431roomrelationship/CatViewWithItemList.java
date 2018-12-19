package so53839431.so53839431roomrelationship;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class CatViewWithItemList {

    @Embedded
    public Category myCat;

    @Relation(parentColumn = "id",
            entityColumn = "category")
    public List<Items> ItemList;
}
