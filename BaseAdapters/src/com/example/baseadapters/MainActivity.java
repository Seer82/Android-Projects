package com.example.baseadapters;

import java.util.ArrayList;
import java.util.Scanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView listView;

	Context context;
	AlertDialog dialog;
	String Data1;

	ArrayList<String> array = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		array.add("mark");
		array.add("colin");
		
		
		String[] stuff = array.toArray(new String[array.size()]);// setting the array list to a String Array

		context = this;
		listView = (ListView) findViewById(R.id.ListView);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.activity_main, R.id.textView1, stuff);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new Listener());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class Listener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> adapter, View view,
				int position, long arg3) {

			// TextView textView = (TextView) view.findViewById(R.id.textView1);

			// String text = textView.getText().toString();

			/*
			 * Toast.makeText(context, text + " clicked at position " +
			 * position, Toast.LENGTH_LONG).show();
			 */
			Scanner scanner = new Scanner(System.in);
			Data1 = scanner.toString();

			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			// Inflate and set the layout for the dialog
			// Pass null as the parent view because its going in the dialog
			// layout
			builder.setView(inflater.inflate(R.layout.custom_dialogue, null))

					// Add action buttons
					.setPositiveButton(R.string.enterdata,
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int id) {

									array.add(Data1);

								}
							})
					.setNegativeButton(R.string.cancel,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {

									dialog.cancel();

								}
							});
			dialog = builder.create();
			dialog = builder.show();

		}

	}

}
