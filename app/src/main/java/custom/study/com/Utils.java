package custom.study.com;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2018/6/20.
 */

public class Utils {

    public static float dpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * metrics.density;
    }
}
