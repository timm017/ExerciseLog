package com.tjmothy.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.tjmothy.exerciselog.SessionEntry;

public class SessionEntryDataSource
{

	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_EXERCISE_NAME,
			MySQLiteHelper.COLUMN_EXERCISE_WEIGHT, MySQLiteHelper.COLUMN_EXERCISE_REPS };

	public SessionEntryDataSource(Context context)
	{
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException
	{
		database = dbHelper.getWritableDatabase();
	}

	public void close()
	{
		dbHelper.close();
	}

	/**
	 * Creates a entry in the DB for a sessionEntry;
	 * @param sessionEntry
	 */
	public void createSessionEntry(SessionEntry sessionEntry)
	{
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_EXERCISE_NAME, sessionEntry.getName());
		values.put(MySQLiteHelper.COLUMN_EXERCISE_WEIGHT, sessionEntry.getWeight());
		values.put(MySQLiteHelper.COLUMN_EXERCISE_REPS, sessionEntry.getReps());
		database.insert(MySQLiteHelper.TABLE_LOG, null, values);
	}
}
