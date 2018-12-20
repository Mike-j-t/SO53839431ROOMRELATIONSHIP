package so53839431.so53839431roomrelationship;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity()
public class Category {

    @NonNull
    @PrimaryKey
    private String categoryid;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryid(@NonNull String id) {
        this.categoryid = id;
    }

    public String getName() {
        return name;
    }

    @NonNull
    public String getCategoryid() {
        return categoryid;
    }
}
