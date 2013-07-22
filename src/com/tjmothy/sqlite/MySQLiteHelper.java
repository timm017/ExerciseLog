package com.tjmothy.sqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper
{
	public static final String TABLE_LOG = "log";
	static final String COLUMN_ID = "id";
	static final String COLUMN_EXERCISE_NAME = "exercise_name";
	static final String COLUMN_EXERCISE_WEIGHT = "exercise_weight";
	static final String COLUMN_EXERCISE_REPS = "exercise_reps";

	// Database creation sql statement
	private static final String TABLE_CREATE = "create table " + TABLE_LOG + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_EXERCISE_NAME + " VARCHAR(255)," + COLUMN_EXERCISE_WEIGHT
			+ " INT, " + COLUMN_EXERCISE_REPS + " INT);";

	private static final String DATABASE_NAME = "log.db";
	private static final int DATABASE_VERSION = 1;

	public MySQLiteHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) throws SQLException
	{
		db.execSQL(TABLE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		Log.w(MySQLiteHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion
				+ ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOG);
		onCreate(db);
	}

}
