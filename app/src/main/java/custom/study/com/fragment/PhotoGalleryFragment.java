package custom.study.com.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import custom.study.com.R;
import custom.study.com.net.ThumbnailDownloader;

/**
 * Created by Administrator on 2018/7/26.
 */

public class PhotoGalleryFragment extends Fragment {

    private RecyclerView mPhotoRecyclerView;

    private List<String> list=new ArrayList<>();

    private ThumbnailDownloader<PhotoHolder> mThumbnailDownloader;

    public static PhotoGalleryFragment newInstance(){
        return new PhotoGalleryFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533200721&di=3ca81f51a0374c99480f33c4ca84eb7d&imgtype=jpg&er=1&src=http%3A%2F%2F06.imgmini.eastday.com%2Fmobile%2F20170701%2F20170701174756_e10335fa75e6e356e4e62e38ce8c1dc0_1.jpeg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533200721&di=3ca81f51a0374c99480f33c4ca84eb7d&imgtype=jpg&er=1&src=http%3A%2F%2F06.imgmini.eastday.com%2Fmobile%2F20170701%2F20170701174756_e10335fa75e6e356e4e62e38ce8c1dc0_1.jpeg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533200721&di=3ca81f51a0374c99480f33c4ca84eb7d&imgtype=jpg&er=1&src=http%3A%2F%2F06.imgmini.eastday.com%2Fmobile%2F20170701%2F20170701174756_e10335fa75e6e356e4e62e38ce8c1dc0_1.jpeg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533200721&di=3ca81f51a0374c99480f33c4ca84eb7d&imgtype=jpg&er=1&src=http%3A%2F%2F06.imgmini.eastday.com%2Fmobile%2F20170701%2F20170701174756_e10335fa75e6e356e4e62e38ce8c1dc0_1.jpeg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533200721&di=3ca81f51a0374c99480f33c4ca84eb7d&imgtype=jpg&er=1&src=http%3A%2F%2F06.imgmini.eastday.com%2Fmobile%2F20170701%2F20170701174756_e10335fa75e6e356e4e62e38ce8c1dc0_1.jpeg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533200721&di=3ca81f51a0374c99480f33c4ca84eb7d&imgtype=jpg&er=1&src=http%3A%2F%2F06.imgmini.eastday.com%2Fmobile%2F20170701%2F20170701174756_e10335fa75e6e356e4e62e38ce8c1dc0_1.jpeg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533200721&di=3ca81f51a0374c99480f33c4ca84eb7d&imgtype=jpg&er=1&src=http%3A%2F%2F06.imgmini.eastday.com%2Fmobile%2F20170701%2F20170701174756_e10335fa75e6e356e4e62e38ce8c1dc0_1.jpeg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533200721&di=3ca81f51a0374c99480f33c4ca84eb7d&imgtype=jpg&er=1&src=http%3A%2F%2F06.imgmini.eastday.com%2Fmobile%2F20170701%2F20170701174756_e10335fa75e6e356e4e62e38ce8c1dc0_1.jpeg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533200721&di=3ca81f51a0374c99480f33c4ca84eb7d&imgtype=jpg&er=1&src=http%3A%2F%2F06.imgmini.eastday.com%2Fmobile%2F20170701%2F20170701174756_e10335fa75e6e356e4e62e38ce8c1dc0_1.jpeg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533200721&di=3ca81f51a0374c99480f33c4ca84eb7d&imgtype=jpg&er=1&src=http%3A%2F%2F06.imgmini.eastday.com%2Fmobile%2F20170701%2F20170701174756_e10335fa75e6e356e4e62e38ce8c1dc0_1.jpeg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533200721&di=3ca81f51a0374c99480f33c4ca84eb7d&imgtype=jpg&er=1&src=http%3A%2F%2F06.imgmini.eastday.com%2Fmobile%2F20170701%2F20170701174756_e10335fa75e6e356e4e62e38ce8c1dc0_1.jpeg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533200721&di=3ca81f51a0374c99480f33c4ca84eb7d&imgtype=jpg&er=1&src=http%3A%2F%2F06.imgmini.eastday.com%2Fmobile%2F20170701%2F20170701174756_e10335fa75e6e356e4e62e38ce8c1dc0_1.jpeg");



        Handler responseHanlder=new Handler();

        mThumbnailDownloader=new ThumbnailDownloader<>(responseHanlder);


        mThumbnailDownloader.setmThumbnailDownloadListener((target, thumbnail) -> {

            Drawable drawable=new BitmapDrawable(getResources(),thumbnail);
            target.bindDrawable(drawable);
        });

        mThumbnailDownloader.start();
        mThumbnailDownloader.getLooper();


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mThumbnailDownloader.clearQueue();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mThumbnailDownloader.quit();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v=inflater.inflate(R.layout.fragment_photo_gallery,container,false);

        mPhotoRecyclerView=v.findViewById(R.id.fragment_photo_gallery_recycler_view);

        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        setupAdapter();

        return  v;
    }

    private void setupAdapter() {

        if(isAdded()){

            mPhotoRecyclerView.setAdapter(new PhotoAdapter(list));
        }
    }


    private class PhotoHolder extends RecyclerView.ViewHolder{

        private ImageView mItemImageView;
        public PhotoHolder(View itemView) {
            super(itemView);
            mItemImageView=itemView.findViewById(R.id.fragment_photo_gallery_image_view);

        }

        public void bindDrawable(Drawable drawable){
            mItemImageView.setImageDrawable(drawable);
        }
    }

    private class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder>{

        private List<String> mGalleryItems;

        public PhotoAdapter(List<String> galleryItems){
            mGalleryItems=galleryItems;
        }



        @NonNull
        @Override
        public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater=LayoutInflater.from(getActivity());
            View view=inflater.inflate(R.layout.gallery_item,parent,false);

            return new PhotoHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
            String url=mGalleryItems.get(position);
            Drawable placeholder=getResources().getDrawable(R.drawable.cccc);
            holder.bindDrawable(placeholder);
            mThumbnailDownloader.queueThumbnail(holder,url);
        }

        @Override
        public int getItemCount() {
            return mGalleryItems.size();
        }
    }
}
