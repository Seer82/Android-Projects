package com.example.expandableadapter;



import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.TextView;

public class MainActivity extends ExpandableListActivity {

	ExpandableListView MylistView;
	Context context;
	AlertDialog dialog1;

	String Data1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = this;
		ExpandableListView MylistView = (ExpandableListView) findViewById(android.R.id.list);
		class MyListAdapter extends BaseExpandableListAdapter {
			// Sample data set. children[i] contains the children (String[]) for
			// groups[i].
			private String[] groups = { "General", "Premise", "Sample" };
			private String[][] children = { { "empty" }, { "empty" },
					{ "1", "2", "3" } };
			private String[][][] grandChildren = { { { "Item No",
					"Floor Plan Ref", "Area Surveyed",
					"Material Description & Comments", "Quantity", "Sample No",
					"Lab Results", "Asbestos Type", "Surface Treatment",
					"Extent Of Damage", "Product Type", } } };

			@Override
			public Object getChild(int groupPosition, int childPosition) {
				return children[groupPosition][childPosition];

			}

			@Override
			public long getChildId(int groupPosition, int childPosition) {
				return childPosition;

			}

			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				TextView textView = getGenericView();
				textView.setText(getChild(groupPosition, childPosition)
						.toString());
				return textView;
			}

			@Override
			public int getChildrenCount(int groupPosition) {
				return children[groupPosition].length;

			}

			@Override
			public Object getGroup(int groupPosition) {
				return groups[groupPosition];

			}

			@Override
			public int getGroupCount() {
				return groups.length;

			}

			@Override
			public long getGroupId(int groupPosition) {
				return groupPosition;

			}

			@SuppressLint("NewApi")
			public TextView getGenericView() {
				// Layout parameters for the ExpandableListView
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT, 64);

				TextView textView = new TextView(context, null,
						android.R.id.list);

				return textView;
			}

			@Override
			public View getGroupView(int groupPosition, boolean isExpanded,
					View convertView, ViewGroup parent) {
				TextView textView = getGenericView();
				textView.setText(getGroup(groupPosition).toString());
				return textView;

			}

			@Override
			public boolean hasStableIds() {
				return true;

			}

			@Override
			public boolean isChildSelectable(int groupPosition,
					int childPosition) {
				return true;

			}

			public void notifyDataSetInvalidated() {

			};
		}
		MyListAdapter ListAdapter1 = new MyListAdapter();

		MylistView.setAdapter(ListAdapter1);

	

		ListAdapter1.notifyDataSetChanged();
		
		MylistView.setOnChildClickListener(new Listener());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;

		/*
		 * }
		 * 
		 * public interface DialogInterface1 extends OnChildClickListener{
		 * 
		 * public void onChildClick();
		 * 
		 * }
		 */
		
	}
	
	
 class Listener implements OnChildClickListener {

		public void onChildClick(ExpandableListView MylistView, View view,// not sure if if its the expandable view or adapter, one site said it needs to use your 
				//expandable list view as the first parameter.
				int position, long arg3) {

			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				// Inflate and set the layout for the dialog
				// Pass null as the parent view because its going in the dialog
				// layout

				
				builder.setView(
						inflater.inflate(R.layout.custom_dialogue, null))
						// Add action buttons
						.setPositiveButton(R.string.enterdata,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {

										final EditText text = (EditText) dialog1
												.findViewById(R.id.EditText1);
										String Data1 = text.getText().toString();
										System.out.println(Data1);

									

									}

									

								})
						.setNegativeButton(R.string.cancel,
								new DialogInterface.OnClickListener() {//need the interface to use childlisterner and onChildClick
									public void onClick(DialogInterface dialog,
											int id) {

										dialog.cancel();

									}

									
								});
				dialog1 = builder.create();
				dialog1 = builder.show();

			}

		@Override
		public boolean onChildClick(ExpandableListView parent, View v,
				int groupPosition, int childPosition, long id) {
			// TODO Auto-generated method stub
			return false;
		}

		}

	}
