package com.example.androiddevelopment.zadatak20glumac.db.model;

import android.opengl.GLU;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.microedition.khronos.opengles.GL;

/**
 *
 * Created by SNinkovic_ns on 4.3.2017.
 */
@DatabaseTable(tableName = Glumac.TABLE_NAME_USERS)
public class Glumac {

    public static final String TABLE_NAME_USERS = "glumci";

    public static final String FIELD_NAME_ID  =  "id";
    public static final String FIELD_NAME_NAME = "name";
    public static final String FILED_NAME_DESCRIBE = "describe";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private String id;

    @DatabaseField(columnName = FIELD_NAME_NAME)
    private String name;

    @DatabaseField(columnName = FILED_NAME_DESCRIBE)
    private String describe;

    public Glumac(){
    }

    public Glumac(int id, String name, String describe){
        this.id=id;
        this.name=name;
        this.describe=describe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }


}
