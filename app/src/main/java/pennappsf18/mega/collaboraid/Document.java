package pennappsf18.mega.collaboraid;

import android.graphics.Bitmap;

public class Document {

    private String mName, mAge_range, mSex, mShort_desc, mLong_desc;
    private Bitmap mImg;
    private int mUrgent; // 1 if life or death, 0 if not

    public Document(String name, String age_range, String sex, String short_desc,
                    String long_desc, Bitmap img, int urgent){
        mName = name;
        mAge_range = age_range;
        mSex = sex;
        mShort_desc = short_desc;
        mLong_desc = long_desc;
        mImg = img;
        mUrgent = urgent;
    }
}
