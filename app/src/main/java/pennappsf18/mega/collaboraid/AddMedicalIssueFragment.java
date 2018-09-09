package pennappsf18.mega.collaboraid;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.ThreadLocalRandom;

public class AddMedicalIssueFragment extends Fragment {

    ImageButton btnpic;
    ImageView imageView;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_add_medical_issue, container, false);
        btnpic = (ImageButton) rootView.findViewById(R.id.picbutton_id);
        imageView = (ImageView) rootView.findViewById(R.id.imageView);

        btnpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,
                        CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
                view.setVisibility(View.GONE);
            }
        });

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                Bitmap bmp = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                // convert byte array to Bitmap

                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
                        byteArray.length);

                imageView.setImageBitmap(bitmap);

                Integer randomNum = ThreadLocalRandom.current().nextInt(0, 10000 + 1);
                String imageFileName = randomNum.toString() + ".jpg";

                FirebaseStorage storage = FirebaseStorage.getInstance();
                // Create a storage reference from our app
                StorageReference storageRef = storage.getReferenceFromUrl("gs://collaboraid-edeba.appspot.com");
                //Create a reference to "imageRef.jpg"
                StorageReference imageRef = storageRef.child(imageFileName);
                // Create a reference to 'images/imageRef.jpg'
                StorageReference ImagesRef = storageRef.child("images/" + imageFileName);
                // While the file names are the same, the references point to different files
                imageRef.getName().equals(ImagesRef.getName());    // true
                imageRef.getPath().equals(ImagesRef.getPath());    // false

                // Get the data from an ImageView as bytes

                imageView.setDrawingCacheEnabled(true);
                imageView.buildDrawingCache();
                Bitmap btmp = imageView.getDrawingCache();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                btmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] info = baos.toByteArray();

                UploadTask uploadTask = imageRef.putBytes(info);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        System.out.println("sadness");
                        // Handle unsuccessful uploads
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    }
                });
            }
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
