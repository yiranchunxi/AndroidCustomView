package custom.study.com.bean;

/**
 * Created by Administrator on 2016/12/4.
 */

public class EventData {
    private int eventTag;

    private Object content;

    private String share_url;
    private String title;

    public EventData() {
        super();
        // TODO Auto-generated constructor stub
    }

    public EventData(int eventTag, Object content) {
        super();
        this.eventTag = eventTag;
        this.content = content;
    }

    public int getEventTag() {
        return eventTag;
    }

    public Object getContent() {
        return content;
    }

    public void setEventTag(int eventTag) {
        this.eventTag = eventTag;
    }

    public void setContent(Object content) {
        this.content = content;
    }


    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
