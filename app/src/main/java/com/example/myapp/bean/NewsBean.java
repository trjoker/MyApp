package com.example.myapp.bean;

import java.util.List;

/**
 * Created by Ryan on 19/04/2019.
 */
public class NewsBean {
    /**
     * date : 20190419
     * stories : [{"title":"从 1G 到 5G 的 30 年时间，经历过哪些精彩瞬间？","ga_prefix":"041909",
     * "images":["https://pic2.zhimg.com/v2-60f97572af9f5a0482185ea2d1c9fee1.jpg"],
     * "multipic":true,"type":0,"id":9710386},{"images":["https://pic2.zhimg
     * .com/v2-64468fa615313a87c02762e1fc9b8ce1.jpg"],"type":0,"id":9710345,"ga_prefix":"041908",
     * "title":"我在云南种大麻：从无人问津到疯狂圈地只有一夜之间"},{"title":"猪脑可以「起死回生」？那人类是不是也可以\u2026\u2026",
     * "ga_prefix":"041907","images":["https://pic3.zhimg.com/v2-d439577ed1c1bfa4270528d36f1b8996
     * .jpg"],"multipic":true,"type":0,"id":9710382},{"images":["https://pic4.zhimg
     * .com/v2-d54de2e2af6ab36fbad34b9e2821752f.jpg"],"type":0,"id":9710369,"ga_prefix":"041906",
     * "title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-bb0a0282fd989bddaa245af4de9dcc45.jpg",
     * "type":0,"id":9710345,"ga_prefix":"041908","title":"我在云南种大麻：从无人问津到疯狂圈地只有一夜之间"},{"image
     * ":"https://pic4.zhimg.com/v2-b970d78d08d95d92e2ec277ff3b68f5f.jpg","type":0,"id":9710382,
     * "ga_prefix":"041907","title":"猪脑可以「起死回生」？那人类是不是也可以\u2026\u2026"},{"image":"https://pic4
     * .zhimg.com/v2-22496d45675ef608c4dd81f9041167df.jpg","type":0,"id":9710307,
     * "ga_prefix":"041819","title":"来，看看这篇给蔡徐坤律师函的「改错」是如何让人尴尬到脸酸"},{"image":"https://pic4.zhimg
     * .com/v2-d9ebcf5d40d1563b93df0a9f9fdc5e17.jpg","type":0,"id":9710350,"ga_prefix":"041807",
     * "title":"华为 P30 Pro 拍的月亮是 PS 的吗？"},{"image":"https://pic1.zhimg
     * .com/v2-e61227b2e6f420f6c62a71f089db8100.jpg","type":0,"id":9710289,"ga_prefix":"041707",
     * "title":"三星 Galaxy Fold：它是一台手机，但屏幕告诉你它不是"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    @Override
    public String toString() {
        return date + "stories:" + stories.size() + "  top_stories:" + top_stories.size();

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * title : 从 1G 到 5G 的 30 年时间，经历过哪些精彩瞬间？
         * ga_prefix : 041909
         * images : ["https://pic2.zhimg.com/v2-60f97572af9f5a0482185ea2d1c9fee1.jpg"]
         * multipic : true
         * type : 0
         * id : 9710386
         */

        private String title;
        private String ga_prefix;
        private boolean multipic;
        private int type;
        private int id;
        private List<String> images;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic2.zhimg.com/v2-bb0a0282fd989bddaa245af4de9dcc45.jpg
         * type : 0
         * id : 9710345
         * ga_prefix : 041908
         * title : 我在云南种大麻：从无人问津到疯狂圈地只有一夜之间
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
