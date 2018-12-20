package so53839431.so53839431roomrelationship;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Category.class,parentColumns = "categoryid", childColumns = "category", onDelete =  CASCADE))
public class Items {
    @Embedded Category referencedCategory; //<<<<<<<<<< embeds the linked reference Category
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String category;
    private boolean isexcluded;

    public void setCategory(String category) {
        this.category = category;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIsexcluded(boolean isexcluded) {
        this.isexcluded = isexcluded;
    }

    public String getCategory() {
        return this.category;
    }

    public long getId() {
        return this.id;
    }

    public boolean isIsexcluded() {
        return this.isexcluded;
    }

}
