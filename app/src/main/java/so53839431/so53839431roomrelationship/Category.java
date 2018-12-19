package so53839431.so53839431roomrelationship;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;

@Entity()
public class Category {

    @NonNull
    @PrimaryKey
    public String id;
    public String name;


    public void setName(String name) {
        this.name = name;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @NonNull
    public String getId() {
        return id;
    }
}
