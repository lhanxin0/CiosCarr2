package com.example.user.cioscarr;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.user.cioscarr.DAO.PaymentDAO;
import com.example.user.cioscarr.DAO.carDAO;
import com.example.user.cioscarr.DAO.orderDAO;
import com.example.user.cioscarr.DAO.order_carDAO;
import com.example.user.cioscarr.DAO.personInterface;
import com.example.user.cioscarr.DAO.supplierDAO;
import com.example.user.cioscarr.entity.Car;
import com.example.user.cioscarr.entity.Order;
import com.example.user.cioscarr.entity.Order_car;
import com.example.user.cioscarr.entity.Payment_for_db;
import com.example.user.cioscarr.entity.Person;
import com.example.user.cioscarr.entity.Supplier;


@Database(entities = {Person.class,Supplier.class,Order.class,Car.class,Order_car.class,Payment_for_db.class
}, version = 3, exportSchema = false)
public abstract class PersonRoomDatabase extends RoomDatabase {

    public abstract personInterface PersonDao();
    public abstract supplierDAO supplierDAO();
    public abstract orderDAO orderDAO();
    public abstract order_carDAO order_carDAO();
    public abstract PaymentDAO paymentDAO();
    public abstract carDAO carDAO();

    private static PersonRoomDatabase INSTANCE;

   public static PersonRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (PersonRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PersonRoomDatabase.class, "ciosCarr_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }

        }
        return INSTANCE;

    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onCreate (@NonNull SupportSQLiteDatabase db){
                    super.onCreate(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final personInterface mDao;
        private final supplierDAO sDao;
        private final carDAO cDao;
        private final order_carDAO ocDao;
        private final PaymentDAO pDao;
        private final orderDAO oDao;
//        String[] words = {"a", "crocodile", "cobra"};

        PopulateDbAsync(PersonRoomDatabase db) {
            mDao = db.PersonDao();
            sDao = db.supplierDAO();
            oDao = db.orderDAO();
            cDao = db.carDAO();
            ocDao = db.order_carDAO();
            pDao = db.paymentDAO();

        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created
           // mDao.deleteAll();
            mDao.insert(new Person("HanXin","lhanxin0"
                    ,"langkawi",
                    "981208027685",
                    "0124981425",
                    "lhanxin0@gmail.com"));

            sDao.insert(new Supplier("S0001",
                    "teikChun","01223131313",
                    "213112313","gg","Setapak"));

            oDao.insert(new Order("O0001",3.0,"lhanxin0","OC0001"));

            cDao.insert(new Car("C0001",
                    "Nissan","grey","bestCar",
                    2.0,"Available","S0001"));

            ocDao.insert(new Order_car("OC0001","21/12/1111","21/12/1111", "11:11", "12:12","O0001", "C0001"));
            pDao.insert(new Payment_for_db("P0001","Credit", "21/12/1111", "4848100049641080", "Paid", "O0001"));

            return null;
        }
    }



}
//            for (int i = 0; i <= words.length - 1; i++) {
//                Person person = new Person(words[i],"ac","1111122dd");
//                mDao.insert(person);
//            }