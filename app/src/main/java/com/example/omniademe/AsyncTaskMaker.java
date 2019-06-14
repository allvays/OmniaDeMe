package com.example.omniademe;

import android.os.AsyncTask;

public class AsyncTaskMaker {
    private OnTaskListener mListener;


    public AsyncTaskMaker(OnTaskListener listener) {
        mListener = listener;
    }

    public interface OnTaskListener {
        void onStatusProgress();

        void onComplete();
    }

    public void doSmth(Integer time) {

    }

    private static class MyAsyncTask extends AsyncTask<Integer, String, String> {
        private OnTaskListener mListener;

        public MyAsyncTask(OnTaskListener listener) {
            mListener = listener;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            return "DONE IN BCKGRND";
        }
    }
}
