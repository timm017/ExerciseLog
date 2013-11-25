package com.tjmothy.exerciselog;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

import com.example.exerciselog.R;

public class LogActivity extends Activity
{
	public static Context appContext;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log);
		// ActionBar gets initiated
		ActionBar actionbar = getActionBar();

		// Tell the ActionBar we want to use Tabs.
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// initiating both tabs and set text to it.
		ActionBar.Tab LogFormTab = actionbar.newTab().setText("Log Form");
		ActionBar.Tab LogViewTab = actionbar.newTab().setText("Log View");

		// create the two fragments we want to use for display content
		Fragment LogFormFragment = new LogFormFragment();
		Fragment LogViewFragment = new LogViewFragment();

		// set the Tab listener. Now we can listen for clicks.
		LogFormTab.setTabListener(new MyTabsListener(LogFormFragment, appContext));
		LogViewTab.setTabListener(new MyTabsListener(LogViewFragment, appContext));

		// add the two tabs to the actionbar
		actionbar.addTab(LogFormTab);
		actionbar.addTab(LogViewTab);
	}

}
