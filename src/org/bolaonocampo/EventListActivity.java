package org.bolaonocampo;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.Session;

import java.util.ArrayList;

/**
 * User: Rogerio
 * Date: 12/6/13
 * Time: 5:05 PM
 */
public class EventListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
//        getActionBar().setTitle("Events");
        getActionBar().setSubtitle(R.string.activity_event_list_name);
//        getActionBar().setDisplayShowTitleEnabled(true);

        ArrayList events = new ArrayList();

        for (int i = 0; i < 25; i++)
            events.add("Event " + (i + 1));

        setListAdapter(new EventListAdapter(this, events));

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_header, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_logout:
                logout();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void logout() {
        Session session = Session.getActiveSession();

        if (!session.isClosed()) {
            session.closeAndClearTokenInformation();

            Intent intent = new Intent(this, MainActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);

            finish();
        }
    }

    class EventListAdapter extends ArrayAdapter<String> {
        private Activity context;
        private ArrayList<String> eventNames;

        public EventListAdapter(Activity context, ArrayList<String> eventNames) {
            super(context, R.layout.competition_row, eventNames);
            this.context = context;
            this.eventNames = eventNames;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = convertView;

            if (rowView == null) {
                LayoutInflater inflater = context.getLayoutInflater();

                rowView = inflater.inflate(R.layout.event_row, null);

                ViewHolder viewHolder = new ViewHolder();

//                viewHolder.image = (ImageView) rowView.findViewById(R.id.competitionIcon);
                viewHolder.text = (TextView) rowView.findViewById(R.id.eventName);

                rowView.setTag(viewHolder);
            }

            ViewHolder holder = (ViewHolder) rowView.getTag();

            String eventName = eventNames.get(position);

            holder.text.setText(eventName);
//            holder.image.setImageResource(R.drawable.ic_action_alarms);

            return rowView;
        }

        class ViewHolder {
            public TextView text;
            public ImageView image;
        }
    }
}
