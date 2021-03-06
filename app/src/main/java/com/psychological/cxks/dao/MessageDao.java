package com.psychological.cxks.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.psychological.cxks.bean.Message;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MESSAGE".
*/
public class MessageDao extends AbstractDao<Message, Long> {

    public static final String TABLENAME = "MESSAGE";

    /**
     * Properties of entity Message.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Type = new Property(1, Integer.class, "type", false, "TYPE");
        public final static Property Msg = new Property(2, String.class, "msg", false, "MSG");
        public final static Property Sender_name = new Property(3, String.class, "sender_name", false, "SENDER_NAME");
        public final static Property Sender_img = new Property(4, String.class, "sender_img", false, "SENDER_IMG");
        public final static Property Receiver_name = new Property(5, String.class, "receiver_name", false, "RECEIVER_NAME");
        public final static Property Time = new Property(6, Long.class, "time", false, "TIME");
        public final static Property IsRead = new Property(7, Boolean.class, "isRead", false, "IS_READ");
    }


    public MessageDao(DaoConfig config) {
        super(config);
    }
    
    public MessageDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MESSAGE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TYPE\" INTEGER," + // 1: type
                "\"MSG\" TEXT," + // 2: msg
                "\"SENDER_NAME\" TEXT," + // 3: sender_name
                "\"SENDER_IMG\" TEXT," + // 4: sender_img
                "\"RECEIVER_NAME\" TEXT," + // 5: receiver_name
                "\"TIME\" INTEGER," + // 6: time
                "\"IS_READ\" INTEGER);"); // 7: isRead
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MESSAGE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Message entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(2, type);
        }
 
        String msg = entity.getMsg();
        if (msg != null) {
            stmt.bindString(3, msg);
        }
 
        String sender_name = entity.getSender_name();
        if (sender_name != null) {
            stmt.bindString(4, sender_name);
        }
 
        String sender_img = entity.getSender_img();
        if (sender_img != null) {
            stmt.bindString(5, sender_img);
        }
 
        String receiver_name = entity.getReceiver_name();
        if (receiver_name != null) {
            stmt.bindString(6, receiver_name);
        }
 
        Long time = entity.getTime();
        if (time != null) {
            stmt.bindLong(7, time);
        }
 
        Boolean isRead = entity.getIsRead();
        if (isRead != null) {
            stmt.bindLong(8, isRead ? 1L: 0L);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Message entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(2, type);
        }
 
        String msg = entity.getMsg();
        if (msg != null) {
            stmt.bindString(3, msg);
        }
 
        String sender_name = entity.getSender_name();
        if (sender_name != null) {
            stmt.bindString(4, sender_name);
        }
 
        String sender_img = entity.getSender_img();
        if (sender_img != null) {
            stmt.bindString(5, sender_img);
        }
 
        String receiver_name = entity.getReceiver_name();
        if (receiver_name != null) {
            stmt.bindString(6, receiver_name);
        }
 
        Long time = entity.getTime();
        if (time != null) {
            stmt.bindLong(7, time);
        }
 
        Boolean isRead = entity.getIsRead();
        if (isRead != null) {
            stmt.bindLong(8, isRead ? 1L: 0L);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Message readEntity(Cursor cursor, int offset) {
        Message entity = new Message( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // type
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // msg
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sender_name
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // sender_img
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // receiver_name
            cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6), // time
            cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0 // isRead
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Message entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setType(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setMsg(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSender_name(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSender_img(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setReceiver_name(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setTime(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
        entity.setIsRead(cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Message entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Message entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Message entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
