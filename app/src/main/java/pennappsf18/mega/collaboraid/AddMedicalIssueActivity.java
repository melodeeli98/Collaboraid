package pennappsf18.mega.collaboraid;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AddMedicalIssueActivity extends AppCompatActivity {

    private static String previousFragment;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        previousFragment = "";
        setContentView(R.layout.activity_add_medical_issue);

        Fragment fragment = new DisclaimerFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.add_medical_issue_frame, fragment);
        ft.commit();
    }


    @Override
    public void onBackPressed() {
        Fragment fragment = null;
        if ("DisclaimerFragment".equals(previousFragment)){
            fragment = new DisclaimerFragment();
            previousFragment = "";
        } else {
            super.onBackPressed();
            return;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.add_medical_issue_frame, fragment);
        ft.commit();
    }

    public void iUnderstand(View v){
        previousFragment = "DisclaimerFragment";
        Fragment fragment = new AddMedicalIssueFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.add_medical_issue_frame, fragment);
        ft.commit();
    }


}
