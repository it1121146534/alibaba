package com.czxy.score.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @version v 1.0
 * @date 2019/7/25
 *
 * CREATE TABLE `tab_log` (
 *   `id` INT(11) NOT NULL AUTO_INCREMENT,
 *   `uid` INT(11) DEFAULT NULL,
 *   `username` VARCHAR(20) DEFAULT NULL,
 *   `operat` VARCHAR(20) DEFAULT NULL,
 *   `time` DATETIME DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=INNODB DEFAULT CHARSET=utf8;
 */

@Entity
@Table(name = "tab_log")
public class Log {
    @Id
    private Integer id;
    private Integer uid;
    private String username;
    private String operat;
    private String time;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", operat='" + operat + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public Log(Integer id, Integer uid, String username, String operat, String time) {
        this.id = id;
        this.uid = uid;
        this.username = username;
        this.operat = operat;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperat() {
        return operat;
    }

    public void setOperat(String operat) {
        this.operat = operat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Log() {
    }
}
