package com.psychological.cxks.bean;

public class UserInfoBean {
    /**
     * mobil : 15550029982
     * type : 1
     * userId : qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N
     * jiguang : {"id":3,"username":"qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N","password":"15550029982","nickname":"cxks_15550029982"}
     * token : 7BED0DC800062578B047E449FC4B3353C01691AF31D76DA917BB6DCAD5BA9CCC
     * username : cxks_15550029982
     */

    private String mobil;
    private int type;
    private String userId;
    private String token;
    private String username;
    private String img;
    private JiguangBean jiguang;

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public JiguangBean getJiguang() {
        return jiguang;
    }

    public void setJiguang(JiguangBean jiguang) {
        this.jiguang = jiguang;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public static class JiguangBean {
        /**
         * id : 3
         * username : qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N
         * password : 15550029982
         * nickname : cxks_15550029982
         */

        private int id;
        private String username;
        private String password;
        private String nickname;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }


}
