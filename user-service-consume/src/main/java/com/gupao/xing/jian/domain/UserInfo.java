package com.gupao.xing.jian.domain;

public class UserInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info_t.id
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info_t.name
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info_t.sex
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info_t.age
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    private Short age;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info_t.id
     *
     * @return the value of user_info_t.id
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info_t.id
     *
     * @param id the value for user_info_t.id
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info_t.name
     *
     * @return the value of user_info_t.name
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info_t.name
     *
     * @param name the value for user_info_t.name
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info_t.sex
     *
     * @return the value of user_info_t.sex
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info_t.sex
     *
     * @param sex the value for user_info_t.sex
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info_t.age
     *
     * @return the value of user_info_t.age
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    public Short getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info_t.age
     *
     * @param age the value for user_info_t.age
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    public void setAge(Short age) {
        this.age = age;
    }
}