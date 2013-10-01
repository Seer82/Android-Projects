package com.example.baseadapters;

import java.util.ArrayList;
import java.util.Scanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView MylistView;
	Context context;
	AlertDialog dialog1;
	ArrayAdapter<String> MyListadapter;
	String Data1;
    ArrayList<String> Myarray = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Myarray.add("mark");
		Myarray.add("colin");
		Myarray.add("modo");

		context = this;
		MylistView = (ListView) findViewById(R.id.ListView);

		MyListadapter = new ArrayAdapter<String>(this, R.layout.activity_main,
				R.id.textView1, Myarray);
		MylistView.setAdapter(MyListadapter);

		MylistView.setOnItemClickListener(new Listener());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;

	}

	private class Listener implements OnItemClickListener {

		@Override
		public void onItemClick(final AdapterView<?> adapter1, View view,
				int position, long arg3) {

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

									final EditText text = (EditText) dialog1
											.findViewById(R.id.EditText1);
									String Data1 = text.getText().toString();
									System.out.println(Data1);

									Myarray.add(Data1);// adding input string
														// from Edit Text to
														// array
									MyListadapter.notifyDataSetChanged();
									
									

								}

							})
					.setNegativeButton(R.string.cancel,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {

									dialog.cancel();

								}
							});
			dialog1 = builder.create();
			dialog1 = builder.show();

		}

	}

}
