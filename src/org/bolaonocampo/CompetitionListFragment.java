package org.bolaonocampo;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

/**
 * User: Rogerio
 * Date: 12/3/13
 * Time: 2:17 PM
 */
public class CompetitionListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList competitions = new ArrayList();

        for (int i = 0; i < 25; i++)
            competitions.add("Competition " + (i + 1));

        setListAdapter(new CompetitionListAdapter(getActivity(), competitions));

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

//        this.setListAdapter(new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_activated_1, new String[] {"ABC", "DEF"}));

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Log.d(getClass().getSimpleName(), "Click");

//        getListView().setSelection(position);
        getListView().setItemChecked(position, true);

        Intent intent = new Intent();

        intent.setClass(getActivity(), EventListActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        getActivity().startActivity(intent);

//        super.onListItemClick(l, v, position, id);
    }

    class CompetitionListAdapter extends ArrayAdapter<String> {
        private Activity context;
        private ArrayList<String> competitionNames;

        public CompetitionListAdapter(Activity context, ArrayList<String> competitionNames) {
            super(context, R.layout.competition_row, competitionNames);
            this.context = context;
            this.competitionNames = competitionNames;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = convertView;

            if (rowView == null) {
                LayoutInflater inflater = context.getLayoutInflater();

                rowView = inflater.inflate(R.layout.competition_row, null);

                ViewHolder viewHolder = new ViewHolder();

                viewHolder.image = (ImageView) rowView.findViewById(R.id.competitionIcon);
                viewHolder.text = (TextView) rowView.findViewById(R.id.competitionName);

                rowView.setTag(viewHolder);
            }

            ViewHolder holder = (ViewHolder) rowView.getTag();

            String competitionName = competitionNames.get(position);

            holder.text.setText(competitionName);
            holder.image.setImageResource(R.drawable.ic_action_alarms);

            return rowView;
        }

        class ViewHolder {
            public TextView text;
            public ImageView image;
        }
    }
}
