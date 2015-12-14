package com.pzf.liaotian.bean;

import java.io.Serializable;

/**
 * @desc:用户信息
 *BLOG:http://blog.sina.com.cn/cuil11
 * @date: 2015年7月3日 下午4:40:54
 * QQ2050542273
 * @email:15162925211@163.com
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String UserId;//
    private String channelId;
    private String nick;//
    private int headIcon;//
    private int group;

    public User(String UserId, String channelId, String nick, int headIcon,
            int group) {
        // TODO Auto-generated constructor stub
        this.UserId = UserId;
        this.channelId = channelId;
        this.nick = nick;
        this.headIcon = headIcon;
        this.group = group;
    }

    public User() {

    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(int headIcon) {
        this.headIcon = headIcon;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "User [UserId=" + UserId + ", channelId=" + channelId
                + ", nick=" + nick + ", headIcon=" + headIcon + ", group="
                + group + "]";
    }

}
