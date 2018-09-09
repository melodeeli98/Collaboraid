package pennappsf18.mega.collaboraid;

import android.graphics.Bitmap;

public class Document {

    private String mName, mAge_range, mSex, mShort_desc, mLong_desc, mUrgent;
    private Bitmap mImg;

    public Document(String name, String age_range, String sex, String short_desc,
                    String long_desc, Bitmap img, String urgent){
        mName = name;
        mAge_range = age_range;
        mSex = sex;
        mShort_desc = short_desc;
        mLong_desc = long_desc;
        mImg = img;
        mUrgent = urgent;
    }
}
