package pennappsf18.mega.collaboraid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home");

        String numPeopleWaitingText = "There are currently " + String.valueOf(MainActivity.numPeopleWaiting) + " people waiting for a response.";
        TextView numPeopleWaitingTextView = (TextView) view.findViewById(R.id.textView2);
        numPeopleWaitingTextView.setText(numPeopleWaitingText);

        String avgWaitTimeText = "The estimated wait time is " + String.valueOf(MainActivity.estimatedWaitTime) + " min.";
        TextView avgWaitTimeTextView = (TextView) view.findViewById(R.id.textView3);
        avgWaitTimeTextView.setText(avgWaitTimeText);
    }
}
