package org.bolaonocampo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.Session;

/**
 * User: Rogerio
 * Date: 12/2/13
 * Time: 5:16 PM
 */
public class Header extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.header);

//        init();
    }

    /*
    private void init() {

        TextView userNameView = (TextView) findViewById(R.id.userNameView);

        userNameView.setText(UserSession.getInstance().getUserName());

        Button logoutButton = (Button) findViewById(R.id.logoutButton);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Session session = Session.getActiveSession();

                if (!session.isClosed()) {
                    session.closeAndClearTokenInformation();

                    finish();
                }
            }
        });

    }*/
}
