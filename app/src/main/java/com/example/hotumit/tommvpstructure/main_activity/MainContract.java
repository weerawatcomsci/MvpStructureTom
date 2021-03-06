package com.example.hotumit.tommvpstructure.main_activity;



import com.example.hotumit.tommvpstructure.model.Notice;
import com.example.hotumit.tommvpstructure.model.dao.PhotoItemDao;
import com.example.hotumit.tommvpstructure.model.dao.PhotoListManager;

import java.util.ArrayList;

/**
 * Created by bpn on 12/6/17.
 */

public interface MainContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     * */
    interface presenter{

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     **/
    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<PhotoItemDao> noticeArrayList);

        void onResponseFailure(Throwable throwable);

    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetNoticeIntractor {

        interface OnFinishedListener {
            void onFinished(ArrayList<PhotoItemDao> noticeArrayList);
            void onFinishedLoadNewer(ArrayList<PhotoItemDao> noticeArrayList);
       /*     void onRefreshPhoto(ArrayList<PhotoListManager> loadNewPhoto);*/
            void onFailure(Throwable t);
        }

        void getNoticeArrayList(OnFinishedListener onFinishedListener);
        void getNoticeArrayListNewer(OnFinishedListener onFinishedListener);
    }
}
