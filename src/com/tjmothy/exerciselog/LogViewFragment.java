package com.tjmothy.exerciselog;

import com.example.exerciselog.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

@SuppressLint("NewApi")
public class LogViewFragment extends Fragment
{

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.log_view_fragment, container, false);
		// Create text view
		Button button = (Button) view.findViewById(R.id.button_log);
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Log.i("AFragment", "clicked button");
			}
		});
		return view;
	}

}
