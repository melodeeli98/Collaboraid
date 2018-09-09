package pennappsf18.mega.collaboraid;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.constraint.solver.widgets.ResolutionDimension;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.File;

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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

    public void submit(View v) {
        EditText name = findViewById(R.id.editText);
        String nameStr = name.getText().toString();
        EditText shortDesc = findViewById(R.id.editText1);
        String shortDescStr = shortDesc.getText().toString();
        EditText longDesc = findViewById(R.id.editText2);
        String longDescStr = longDesc.getText().toString();


        ImageView imageView = findViewById(R.id.imageView);
        Bitmap bm = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        
        MainActivity.docs.add(new Document(nameStr, "", "", shortDescStr,
                longDescStr, bm, ""));

        super.onBackPressed();
    }
}
/*
    ImageView imageView = (ImageView) findViewById(R.id.imageView);
    Bitmap bm = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        MainActivity.docs.add(new Document("Joe Gonzales", "Old","Male", "Short description", "Long description", bm, "True" ));
        */