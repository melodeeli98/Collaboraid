package pennappsf18.mega.collaboraid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AddMedicalIssueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medical_issue);

        Fragment fragment = new AddMedicalIssueActivityFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.add_medical_issue_frame, fragment);
        ft.commit();
    }

    public void iUnderstand(View v){
        Fragment fragment = new MyMedicalIssuesFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.add_medical_issue_frame, fragment);
        ft.commit();
    }


}
