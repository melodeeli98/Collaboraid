package pennappsf18.mega.collaboraid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import pennappsf18.mega.collaboraid.dummy.DummyContent;

public class PeopleInNeedActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_in_need);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        CaseFragment.OnListFragmentInteractionListener onSelect = new CaseFragment.OnListFragmentInteractionListener() {
            @Override
            public void onListFragmentInteraction(Document doc) {

            }
        };

        mAdapter = new MyCaseRecyclerViewAdapter(MainActivity.docs, onSelect);
        mRecyclerView.setAdapter(mAdapter);
    }
}
