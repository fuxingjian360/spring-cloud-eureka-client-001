package com.gupao.xing.jian.common.http;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ResultVO2 implements Serializable {
    private int code;
    private String msg;
    private List<UserInfo2> data;

    public ResultVO2(){}

    public ResultVO2(int code, String msg, List<UserInfo2> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<UserInfo2> getData() {
        return data;
    }

    public void setData(List<UserInfo2> data) {
        this.data = data;
    }

    static class UserInfo2 {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column user_info2_t.id
         *
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        private Long id;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column user_info2_t.name
         *
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        private String name;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column user_info2_t.create_date
         *
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date createDate;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column user_info2_t.update_date
         *
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date updateDate;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column user_info2_t.score
         *
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        private Double score;

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column user_info2_t.id
         *
         * @return the value of user_info2_t.id
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        public Long getId() {
            return id;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column user_info2_t.id
         *
         * @param id the value for user_info2_t.id
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        public void setId(Long id) {
            this.id = id;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column user_info2_t.name
         *
         * @return the value of user_info2_t.name
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        public String getName() {
            return name;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column user_info2_t.name
         *
         * @param name the value for user_info2_t.name
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        public void setName(String name) {
            this.name = name == null ? null : name.trim();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column user_info2_t.create_date
         *
         * @return the value of user_info2_t.create_date
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        public Date getCreateDate() {
            return createDate;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column user_info2_t.create_date
         *
         * @param createDate the value for user_info2_t.create_date
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column user_info2_t.update_date
         *
         * @return the value of user_info2_t.update_date
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        public Date getUpdateDate() {
            return updateDate;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column user_info2_t.update_date
         *
         * @param updateDate the value for user_info2_t.update_date
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        public void setUpdateDate(Date updateDate) {
            this.updateDate = updateDate;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column user_info2_t.score
         *
         * @return the value of user_info2_t.score
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        public Double getScore() {
            return score;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column user_info2_t.score
         *
         * @param score the value for user_info2_t.score
         * @mbg.generated Sun Apr 19 18:26:06 CST 2020
         */
        public void setScore(Double score) {
            this.score = score;
        }
    }
}
