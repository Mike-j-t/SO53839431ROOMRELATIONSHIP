package so53839431.so53839431roomrelationship;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Database mRoomDB;
    int process_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRoomDB = Room.databaseBuilder(this, Database.class, "mydb").build();
        addSomeData();
    }

    private void addSomeData() {
        this.process_count++;
        new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * Add data if none exists
                 */
                SupportSQLiteDatabase supdb = mRoomDB.getOpenHelper().getWritableDatabase();
                Cursor csr = supdb.query("SELECT * FROM  Category");
                if (csr.getCount() < 1) {
                    mRoomDB.categoryDao().insertCategory(initialCategories());
                }
                csr = supdb.query("SELECT * FROM Items");
                if (csr.getCount() < 1) {
                    mRoomDB.itemsDAO().insertItem(initialItems());
                }
                csr.close();

                /**
                 * DO the various listings
                 */
                List<Category> categoryList = mRoomDB.categoryDao().getAllcategories();
                List<Items> itemsList = mRoomDB.itemsDAO().getAllItems();
                for (Category c: categoryList) {
                    Log.d("CATEGORY","Category is " + c.getName() + " Category ID is " + c.getCategoryid());
                }
                for (Items i: itemsList) {
                    Log.d("ITEM","Item is " + i.getId() + " Category reference is " + i.getCategory() + " Is Excluded is " + Boolean.toString(i.isIsexcluded()));
                }
                /*
                List<Category> categoryList2 = mRoomDB.categoryDao().getSpeacial();
                for (Category c: categoryList2) {
                    Log.d("CATEGORY2","Category is " + c.getName() + " reference is " + c.getCategoryid());
                }
                */

                /*
                List<CatViewWithItemList> catViewWithItemLists = mRoomDB.categoryDao().getSpeacial2();
                for (CatViewWithItemList cvwil: catViewWithItemLists) {
                    Log.d("CATVIEWITEM","Category = " + cvwil.myCat.getCategoryid() + " ID = " + cvwil.ItemList.get(0).getId() + " IsExcluded = " + Boolean.toString(cvwil.ItemList.get(0).isIsexcluded()));
                }
                */

                /**
                 *  This may be waht you want
                 */
                List<Items> itemsList1 = mRoomDB.itemsDAO().getItemsWithCategory();
                for (Items i: itemsList1) {
                    Log.d(
                            "ITEMWITHCAT",
                            "Item id =" + i.getId() +
                                    " Category reference is " + i.getCategory() +
                                    " Is Excluded is " + Boolean.toString(i.isIsexcluded()) +
                                    " Referenced Category is " + i.referencedCategory.getCategoryid() +
                                    " Referenced Category name is " + i.referencedCategory.getName());
                }
            }
        }).start();
    }

    private Category[] initialCategories() {
        Category c1 = new Category();
        c1.setCategoryid("a");
        c1.setName("firstname");
        Category c2 = new Category();
        c2.setCategoryid("b");
        c2.setName("secondname");
        Category c3 = new Category();
        c3.setCategoryid("c");
        c3.setName("thirdname");
        Category c4 = new Category();
        c4.setCategoryid("d");
        c4.setName("fourthname");
        return new Category[]{c1,c2,c3,c4};
    }

    private Items[] initialItems() {
        Items i1 = new Items();
        i1.setCategory("a");
        i1.setIsexcluded(false);
        Items i2 = new Items();
        i2.setCategory("c");
        i2.setIsexcluded(false);
        Items i3 = new Items();
        i3.setIsexcluded(false);
        Items i4 = new Items();
        i4.setCategory("b");
        i4.setIsexcluded(false);
        Items i5 = new Items();
        i5.setCategory("b");
        i5.setIsexcluded(true);
        Items i6 = new Items();
        i6.setIsexcluded(true);
        Items i7 = new Items();
        i7.setCategory("d");
        i7.setIsexcluded(true);
        Items i8 = new Items();
        i8.setCategory("d");
        i8.setIsexcluded(false);
        return new Items[]{i1,i2,i3,i4,i5,i6,i7,i8};
    }
}
