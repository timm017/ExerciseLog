package com.tjmothy.exerciselog;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exerciselog.R;
import com.tjmothy.sqlite.SessionEntryDataSource;

@SuppressLint("NewApi")
public class LogFormFragment extends Fragment
{

	EditText etExerciseName;
	EditText etExerciseWeight;
	EditText etExerciseReps;
	SessionEntry se = new SessionEntry();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		final Context context = getActivity();
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.log_form_fragment, container, false);
		// Create text view

		etExerciseName = (EditText) view.findViewById(R.id.et_exercise_name);
		etExerciseWeight = (EditText) view.findViewById(R.id.et_exercise_weight);
		etExerciseReps = (EditText) view.findViewById(R.id.et_exercise_reps);

		Button button = (Button) view.findViewById(R.id.button_log);
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				int weight = 0;
				int reps = 0;
				boolean everythingOK = true;
				String name = etExerciseName.getText().toString();
				try
				{
					reps = Integer.parseInt(etExerciseReps.getText().toString());
					weight = Integer.parseInt(etExerciseWeight.getText().toString());
					Toast.makeText(context, "Rep or weight null", Toast.LENGTH_LONG).show();
				}
				catch (NumberFormatException nfe)
				{
					everythingOK = false;
				}
				if (name.equalsIgnoreCase("") || name == null)
				{
					everythingOK = false;
					Toast.makeText(context, "Blank name!", Toast.LENGTH_LONG).show();
				}
				if (everythingOK)
				{
					se.setName(name);
					se.setWeight(weight);
					se.setReps(reps);
					SessionEntryDataSource sed = new SessionEntryDataSource(context);
					sed.open();
					sed.createSessionEntry(se);
				}
			}
		});
		return view;
	}

}
