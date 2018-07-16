package widget;

import com.squareup.otto.Bus;

/**
 * Created by Yan on 2018/3/7.
 * otto event Instance()
 */

public class BusProvider extends Bus {

    private static class BusProviderHelper{
        static BusProvider mInstance=new BusProvider();
    }

    public static BusProvider getInstance(){
        return BusProviderHelper.mInstance;
    }


}
