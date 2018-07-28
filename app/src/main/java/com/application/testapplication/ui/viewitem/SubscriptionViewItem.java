
package com.application.testapplication.ui.viewitem;

import android.databinding.ViewDataBinding;

import com.application.testapplication.R;
import com.application.testapplication.ui.base.recycler_adapter.AdapterItem;
import com.application.testapplication.ui.base.recycler_adapter.RecyclerAdapterNotifier;
import com.application.testapplication.ui.base.recycler_adapter.RecyclerAdapterViewHolder;
import com.application.testapplication.ui.model.data.Subscription;

public class SubscriptionViewItem extends AdapterItem<SubscriptionViewItem.Holder> {

    private Subscription mData;

    @Override
    public boolean onFilter(String searchTerm) {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_subscription;
    }

    @Override
    public Object getData() {
        return mData;
    }

    @Override
    public void setData(Object obj) {
        mData = (Subscription) obj;
    }

    @Override
    protected void bindData(Holder holder, Object data, int position) {
    }

    @Override
    protected void onViewRecycled(Holder holder) {

    }

    public static class Holder extends RecyclerAdapterViewHolder {

        public Holder(ViewDataBinding itemView, RecyclerAdapterNotifier adapter) {
            super(itemView, adapter);
        }
    }
}