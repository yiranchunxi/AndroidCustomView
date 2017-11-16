package custom.study.com.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/7/20.
 */

public class Book implements Parcelable {



    public int bookId;
    public String bookName;

    public Book() {

    }

    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }
    private Book(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
         dest.writeInt(bookId);
         dest.writeString(bookName);
    }


    public static final  Parcelable.Creator<Book> CREATOR=new Parcelable.Creator<Book>(){


        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public String toString() {
        return String.format("[bookId:%s, bookName:%s]", bookId, bookName);
    }
}
