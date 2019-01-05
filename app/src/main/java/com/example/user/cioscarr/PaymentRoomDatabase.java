package com.example.user.cioscarr;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.user.cioscarr.DAO.PaymentDAO;
import com.example.user.cioscarr.entity.Car;
import com.example.user.cioscarr.entity.Order;
import com.example.user.cioscarr.entity.Order_car;
import com.example.user.cioscarr.entity.Payment_for_db;
import com.example.user.cioscarr.entity.Person;
import com.example.user.cioscarr.entity.Supplier;

@Database(entities = {Person.class,Supplier.class,Order.class,Car.class,Order_car.class,Payment_for_db.class
}, version = 5, exportSchema = false)
public abstract class PaymentRoomDatabase extends RoomDatabase {

    private static PaymentRoomDatabase INSTANCE;

    public abstract PaymentDAO paymentDAO();

    public static PaymentRoomDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), PaymentRoomDatabase.class, "payment-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }



    public static void destroyInstance() {
        INSTANCE = null;
    }
}