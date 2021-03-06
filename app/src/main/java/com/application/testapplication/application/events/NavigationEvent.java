
package com.application.testapplication.application.events;

import com.application.testapplication.application.constants.AppConstants;

public class NavigationEvent<T> {

    public static final String EVENT_ON_NOTE_BOOK_ITEM_LONG_CLICK = "event_on_note_book_item_long_click";
    public static final String EVENT_CLEAR_DELETE_FLAG = "event_clear_delete_flag";
    public static final String EVENT_ON_NOTE_BOOK_ITEM_CLICK = "event_on_note_book_item_click";

    private String flag;
    private String tag;
    private T data;
    private int screenType;
    private String filter;

    public NavigationEvent(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setScreenType(@AppConstants.SCREEN_TYPE int type) {
        screenType = type;
    }

    public int getScreenType() {
        return screenType;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

}
