package custom.study.com;

import android.support.v4.app.Fragment;

import custom.study.com.fragment.PhotoGalleryFragment;

/**
 * Created by Administrator on 2018/7/26.
 */

public class PhotoGalleryActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return PhotoGalleryFragment.newInstance();
    }

    
}
