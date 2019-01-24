package com.nepalpolice.cdppariwari.child;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.nepalpolice.cdppariwari.R;

public class ListViewAdapter extends BaseAdapter {

	// Declare Variables
	Context mContext;
	LayoutInflater inflater;
	private List<WorldPopulation> worldpopulationlist = null;
	private ArrayList<WorldPopulation> arraylist;

	public ListViewAdapter(Context context,
			List<WorldPopulation> worldpopulationlist) {
		mContext = context;
		this.worldpopulationlist = worldpopulationlist;
		inflater = LayoutInflater.from(mContext);
		this.arraylist = new ArrayList<WorldPopulation>();
		this.arraylist.addAll(worldpopulationlist);
	}

	public class ViewHolder {
		TextView name,mobile,address,email;
		ImageView image;
	}

	@Override
	public int getCount() {
		return worldpopulationlist.size();
	}

	@Override
	public WorldPopulation getItem(int position) {
		return worldpopulationlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup parent) {
		final ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.listview_item, null);
			// Locate the TextViews in listview_item.xml
			holder.name = (TextView) view.findViewById(R.id.contact_name);
			holder.mobile = (TextView) view.findViewById(R.id.contact_mobile);
			holder.address= (TextView) view.findViewById(R.id.contact_address);
			holder.email= (TextView) view.findViewById(R.id.contact_email);
			// Locate the ImageView in listview_item.xml
			holder.image = (ImageView) view.findViewById(R.id.contact_profile);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// Set the results into TextViews

		holder.name.setText(worldpopulationlist.get(position).getContact_name());

		holder.mobile.setText(worldpopulationlist.get(position).getContact_mobile());

		holder.address.setText(worldpopulationlist.get(position)
				.getContact_address()+",");
		holder.email.setText(worldpopulationlist.get(position)
				.getContact_email()+",");
		// Set the results into ImageView
		holder.image.setImageResource(worldpopulationlist.get(position)
				.getContact_image());
		// Listen for ListView Item Click
		final String email = worldpopulationlist.get(position).getContact_email().toString();
		final String phone = worldpopulationlist.get(position).getContact_mobile().toString();
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Send single item click data to SingleItemView Class
			//	Intent intent = new Intent(mContext, SingleItemView.class);
				// Pass all data rank
			//	intent.putExtra("rank",
					//	(worldpopulationlist.get(position).getRank()));
				// Pass all data country
			//	intent.putExtra("country",
				//		(worldpopulationlist.get(position).getCountry()));
				// Pass all data population
			//	intent.putExtra("population",
				//		(worldpopulationlist.get(position).getPopulation()));
				//// Pass all data flag
			//	intent.putExtra("flag",
			//			(worldpopulationlist.get(position).getFlag()));
				// Start SingleItemView Class
			//	mContext.startActivity(intent);
				CharSequence options[] = new CharSequence[]{"Email", "Call"};

				final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

				builder.setTitle("Select Options");
				builder.setItems(options, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {

						//Click Event for each item.
						if(i == 0){

							Intent intent = new Intent(Intent.ACTION_SEND);
							intent.setType("plain/text");
							intent.putExtra(Intent.EXTRA_EMAIL, new String[] { email });
							intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
							intent.putExtra(Intent.EXTRA_TEXT, "mail body");
							mContext.startActivity(Intent.createChooser(intent, ""));

						}

						if(i == 1){
							Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
							// callIntent.setData(Uri.parse("tel:"+uri));
							callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
							mContext.startActivity(callIntent);

						}

					}
				});

				builder.show();

			}





		});

		return view;
	}

	// Filter Class
	public void filter(String charText) {
		charText = charText.toLowerCase(Locale.getDefault());
		worldpopulationlist.clear();
		if (charText.length() == 0) {
			worldpopulationlist.addAll(arraylist);
		} else {
			for (WorldPopulation wp : arraylist) {
				if (wp.getContact_name().toLowerCase(Locale.getDefault())
						.contains(charText)) {
					worldpopulationlist.add(wp);
				}
			}
		}
		notifyDataSetChanged();
	}

}
