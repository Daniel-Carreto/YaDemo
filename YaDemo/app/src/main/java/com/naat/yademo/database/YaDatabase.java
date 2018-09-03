package com.naat.yademo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.naat.yademo.R;
import com.naat.yademo.model.Brand;
import com.naat.yademo.model.Service;
import com.naat.yademo.model.TypeService;

import java.util.ArrayList;
import java.util.List;

public class YaDatabase extends SQLiteOpenHelper {

    private static int VERSION = 1;

    private static String DATABASE_NAME = "YADEMODATABASE";
    private static String TABLE_BRAND = "T_BRAND";
    private static String T_BRAND_ID = "id";
    private static String T_BRAND_NAME = "name";
    private static String TABLE_SERVICE = "T_SERVICE";
    private static String T_SERVICE_ID = "id";
    private static String T_SERVICE_NAME = "name";
    private static String T_SERVICE_ICON = "icon";
    private static String T_SERVICE_ID_BRAND = "id_brand";
    private static String T_SERVICE_TYPE = "type";


    private static SQLiteDatabase.CursorFactory factory = null;
    private SQLiteDatabase database;
    private Context context;
    private Brand brand;
    private Service service;


    public YaDatabase(Context context) {
        super(context, DATABASE_NAME, factory, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.database = db;
        db.execSQL("CREATE TABLE " + TABLE_BRAND + "(" +
                T_BRAND_ID + " INTEGER," +
                T_BRAND_NAME + " TEXT)");

        db.execSQL("CREATE TABLE " + TABLE_SERVICE + "(" +
                T_SERVICE_ID + " INTEGER," +
                T_SERVICE_NAME + " TEXT," +
                T_SERVICE_ICON + " INTEGER," +
                T_SERVICE_ID_BRAND + " TEXT," +
                T_SERVICE_TYPE + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BRAND);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SERVICE);
        onCreate(db);
    }

    public boolean isInsertBrand(Brand brand) {
        boolean isInsert = false;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues insertValues = new ContentValues();
            insertValues.put(T_BRAND_ID, brand.getId());
            insertValues.put(T_BRAND_NAME, brand.getName());
            db.insert(TABLE_BRAND, null, insertValues);
            isInsert = true;
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
            isInsert = false;
        }
        return isInsert;

    }


    public boolean isInsertService(Service service,int idBrand) {
        boolean isInsert = false;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues insertValues = new ContentValues();
            insertValues.put(T_SERVICE_ID, service.getId());
            insertValues.put(T_SERVICE_NAME, service.getName());
            insertValues.put(T_SERVICE_ID_BRAND, idBrand);
            insertValues.put(T_SERVICE_ICON, service.getIcon());
            insertValues.put(T_SERVICE_TYPE, service.getType());
            db.insert(TABLE_SERVICE, null, insertValues);
            isInsert = true;
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
            isInsert = false;
        }
        return isInsert;
    }

    public ArrayList<Brand> getBrandList() {
        ArrayList<Brand> brandArrayList = new ArrayList<>();
        try {
            SQLiteDatabase db = getReadableDatabase();

            String table = TABLE_BRAND;
            String[] columns = {
                    T_BRAND_ID,
                    T_BRAND_NAME};

            Cursor cursor = db.query(table, columns, null,
                    null, null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    brand = new Brand();
                    brand.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(T_BRAND_ID))));
                    brand.setName(cursor.getString(cursor.getColumnIndex(T_BRAND_NAME)));
                    brandArrayList.add(brand);
                } while (cursor.moveToNext());
            }
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brandArrayList;
    }




    public ArrayList<Service> getServiceList(int idBrand) {
        ArrayList<Service> serviceArrayList = new ArrayList<>();
        try {
            SQLiteDatabase db = getReadableDatabase();

            String table = TABLE_SERVICE;
            String[] columns = {
                    T_SERVICE_ID,
                    T_SERVICE_NAME,
                    T_SERVICE_ICON,
                    T_SERVICE_TYPE};

            Cursor cursor = db.query(table, columns, T_SERVICE_ID_BRAND+" = "+idBrand,
                    null, null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    service = new Service();
                    service.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(T_SERVICE_ID))));
                    service.setName(cursor.getString(cursor.getColumnIndex(T_SERVICE_NAME)));
                    service.setIcon(Integer.parseInt(cursor.getString(cursor.getColumnIndex(T_SERVICE_ICON))));
                    serviceArrayList.add(service);
                } while (cursor.moveToNext());
            }
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serviceArrayList;
    }



    public boolean deleteAll(){
        boolean isDelete = false;
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.delete(TABLE_SERVICE, null, null);
            db.delete(TABLE_BRAND, null, null);
            isDelete = true;
            db.close();
        }catch (Exception e){
            isDelete = false;
            e.printStackTrace();
        }
        return isDelete;
    }


    public void initializeDatabase(){
        deleteAll();
        //Claro
        isInsertService(new Service(100, "Tiempo Aire", R.drawable.ic_claro, TypeService.TIEMPO_AIRE),1);
        isInsertService(new Service(200, "Tiempo Aire", R.drawable.ic_claro, TypeService.TIEMPO_AIRE),1);
        isInsertService(new Service(300, "Megas", R.drawable.ic_claro, TypeService.TIEMPO_AIRE),1);
        //Tuenti
        isInsertService(new Service(100, "Tiempo Aire", R.drawable.ic_tuenti, TypeService.TIEMPO_AIRE),2);
        isInsertService(new Service(200, "Tiempo Aire", R.drawable.ic_tuenti, TypeService.TIEMPO_AIRE),2);
        isInsertService(new Service(300, "Megas", R.drawable.ic_tuenti, TypeService.TIEMPO_AIRE),2);
        //Entel
        isInsertService(new Service(100, "Tiempo Aire", R.drawable.ic_entel, TypeService.TIEMPO_AIRE),3);
        isInsertService(new Service(200, "Tiempo Aire", R.drawable.ic_entel, TypeService.TIEMPO_AIRE),3);
        isInsertService(new Service(300, "Megas", R.drawable.ic_entel, TypeService.TIEMPO_AIRE),3);
        //Claro
        isInsertService(new Service(100, "Tiempo Aire", R.drawable.ic_claro, TypeService.TIEMPO_AIRE),4);
        isInsertService(new Service(200, "Tiempo Aire", R.drawable.ic_claro, TypeService.TIEMPO_AIRE),4);
        isInsertService(new Service(300, "Megas", R.drawable.ic_claro, TypeService.TIEMPO_AIRE),4);
        //Tuenti
        isInsertService(new Service(100, "Tiempo Aire", R.drawable.ic_tuenti, TypeService.TIEMPO_AIRE),5);
        isInsertService(new Service(200, "Tiempo Aire", R.drawable.ic_tuenti, TypeService.TIEMPO_AIRE),5);
        isInsertService(new Service(300, "Megas", R.drawable.ic_tuenti, TypeService.TIEMPO_AIRE),5);
        //Entel
        isInsertService(new Service(100, "Tiempo Aire", R.drawable.ic_entel, TypeService.TIEMPO_AIRE),6);
        isInsertService(new Service(200, "Tiempo Aire", R.drawable.ic_entel, TypeService.TIEMPO_AIRE),6);
        isInsertService(new Service(300, "Megas", R.drawable.ic_entel, TypeService.TIEMPO_AIRE),6);

        //Marcas
        isInsertBrand(new Brand(1,"Claro"));
        isInsertBrand(new Brand(2,"Tuenti"));
        isInsertBrand(new Brand(3,"Entel"));
        isInsertBrand(new Brand(4,"Claro"));
        isInsertBrand(new Brand(5,"Tuenti"));
        isInsertBrand(new Brand(6,"Entel"));
    }
}
