<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="org.butioy.auth.dao.IAuthUserMapper">

    <resultMap id="RM_auth_user" type="org.butioy.auth.domain.AuthUser">
        <id property="id" column="ID"/>
        <result property="userName" column="USER_NAME"/>
        <result property="fullName" column="FULL_NAME"/>
        <result property="password" column="PASSWORD"/>
        <result property="sex" column="SEX"/>
        <result property="birthday" column="BIRTHDAY"/>
        <result property="userType" column="USER_TYPE"/>
        <result property="headImg" column="HEAD_IMG"/>
        <result property="addTime" column="ADD_TIME"/>
        <result property="modifyTime" column="MODIFY_TIME"/>
        <result property="addUserId" column="ADD_USER_ID"/>
        <result property="remark" column="REMARK"/>
        <result property="status" column="STATUS"/>
        <result property="isDelete" column="IS_DELETE"/>
    </resultMap>

    <sql id="select_all_column">
        <![CDATA[
          ID, USER_NAME, FULL_NAME, PASSWORD, SEX, BIRTHDAY, USER_TYPE, HEAD_IMG, ADD_TIME, MODIFY_TIME, ADD_USER_ID, REMARK, STATUS, IS_DELETE
        ]]>
    </sql>

    <sql id="dynamic_insert_key">
        <trim prefix="( " suffix=" )" suffixOverrides=",">
            <if test="@Ognl@isNotEmpty(userName)">
                USER_NAME,
            </if>
            <if test="@Ognl@isNotEmpty(fullName)">
                FULL_NAME,
            </if>
            <if test="@Ognl@isNotEmpty(password)">
                PASSWORD,
            </if>
            <if test="@Ognl@isNotEmpty(sex)">
                SEX,
            </if>
            <if test="@Ognl@isNotEmpty(birthday)">
                BIRTHDAY,
            </if>
            <if test="@Ognl@isNotEmpty(userType)">
                USER_TYPE,
            </if>
            <if test="@Ognl@isNotEmpty(headImg)">
                HEAD_IMG,
            </if>
            <if test="@Ognl@isNotEmpty(addTime)">
                ADD_TIME,
            </if>
            <if test="@Ognl@isNotEmpty(modifyTime)">
                MODIFY_TIME,
            </if>
            <if test="@Ognl@isNotEmpty(addUserId)">
                ADD_USER_ID,
            </if>
            <if test="@Ognl@isNotEmpty(remark)">
                REMARK,
            </if>
            <if test="@Ognl@isNotEmpty(status)">
                STATUS,
            </if>
            <if test="@Ognl@isNotEmpty(isDelete)">
                IS_DELETE,
            </if>
        </trim>
    </sql>

    <sql id="dynamic_insert_value">
        <trim prefix="( " suffix=" )" suffixOverrides=",">
            <if test="@Ognl@isNotEmpty(userName)">
                #{userName},
            </if>
            <if test="@Ognl@isNotEmpty(fullName)">
                #{fullName},
            </if>
            <if test="@Ognl@isNotEmpty(password)">
                #{password},
            </if>
            <if test="@Ognl@isNotEmpty(sex)">
                #{sex},
            </if>
            <if test="@Ognl@isNotEmpty(birthday)">
                #{birthday},
            </if>
            <if test="@Ognl@isNotEmpty(userType)">
                #{userType},
            </if>
            <if test="@Ognl@isNotEmpty(headImg)">
                #{headImg},
            </if>
            <if test="@Ognl@isNotEmpty(addTime)">
                #{addTime},
            </if>
            <if test="@Ognl@isNotEmpty(modifyTime)">
                #{modifyTime},
            </if>
            <if test="@Ognl@isNotEmpty(addUserId)">
                #{addUserId},
            </if>
            <if test="@Ognl@isNotEmpty(remark)">
                #{remark},
            </if>
            <if test="@Ognl@isNotEmpty(status)">
                #{status},
            </if>
            <if test="@Ognl@isNotEmpty(isDelete)">
                #{isDelete},
            </if>
        </trim>
    </sql>

    <insert id="insert" parameterType="org.butioy.auth.domain.AuthUser" useGeneratedKeys="true" keyProperty="id">
        INSERT INTO auth_user
        <include refid="dynamic_insert_key"/>
        VALUES
        <include refid="dynamic_insert_value"/>
    </insert>

    <insert id="batchInsert" parameterType="list">
        INSERT INTO auth_user
        (USER_NAME,FULL_NAME,PASSWORD,SEX,BIRTHDAY,USER_TYPE,HEAD_IMG,ADD_TIME,MODIFY_TIME,
        ADD_USER_ID,REMARK,STATUS,IS_DELETE) VALUES
        <foreach collection ="list" item ="item" index ="index" separator =",">
        (#{item.userName},#{item.fullName},#{item.password},#{item.sex},#{item.birthday},
        #{item.userType},#{item.headImg},#{item.addTime},#{item.modifyTime},#{item.addUserId},
        #{item.remark},#{item.status},#{item.isDelete})
        </foreach >
    </insert>

    <update id="update" parameterType="org.butioy.auth.domain.AuthUser">
        <if test="@Ognl@isNotEmpty(id)">
            UPDATE auth_user
            <set>
                <if test="@Ognl@isNotEmpty(userName)">
                    USER_NAME = #{userName},
                </if>
                <if test="@Ognl@isNotEmpty(fullName)">
                    FULL_NAME = #{fullName},
                </if>
                <if test="@Ognl@isNotEmpty(password)">
                    PASSWORD = #{password},
                </if>
                <if test="@Ognl@isNotEmpty(sex)">
                    SEX = #{sex},
                </if>
                <if test="@Ognl@isNotEmpty(birthday)">
                    BIRTHDAY = #{birthday},
                </if>
                <if test="@Ognl@isNotEmpty(userType)">
                    USER_TYPE = #{userType},
                </if>
                <if test="@Ognl@isNotEmpty(headImg)">
                    HEAD_IMG = #{headImg},
                </if>
                <if test="@Ognl@isNotEmpty(addTime)">
                    ADD_TIME = #{addTime},
                </if>
                <if test="@Ognl@isNotEmpty(modifyTime)">
                    MODIFY_TIME = #{modifyTime},
                </if>
                <if test="@Ognl@isNotEmpty(addUserId)">
                    ADD_USER_ID = #{addUserId},
                </if>
                <if test="@Ognl@isNotEmpty(remark)">
                    REMARK = #{remark},
                </if>
                <if test="@Ognl@isNotEmpty(status)">
                    STATUS = #{status},
                </if>
                <if test="@Ognl@isNotEmpty(isDelete)">
                    IS_DELETE = #{isDelete},
                </if>
            </set>
            WHERE ID=#{id}
        </if>
    </update>

    <delete id="deleteById" parameterType="int">
        DELETE FROM auth_user WHERE id=#{id}
    </delete>

    <delete id="deleteByParam" parameterType="map">
        DELETE FROM auth_user
        <where>
            <if test="@Ognl@isNotEmpty(id)">
                AND ID = #{id}
            </if>
            <if test="@Ognl@isNotEmpty(userName)">
                AND USER_NAME = #{userName}
            </if>
            <if test="@Ognl@isNotEmpty(fullName)">
                AND FULL_NAME = #{fullName}
            </if>
            <if test="@Ognl@isNotEmpty(password)">
                AND PASSWORD = #{password}
            </if>
            <if test="@Ognl@isNotEmpty(sex)">
                AND SEX = #{sex}
            </if>
            <if test="@Ognl@isNotEmpty(birthday)">
                AND BIRTHDAY = #{birthday}
            </if>
            <if test="@Ognl@isNotEmpty(userType)">
                AND USER_TYPE = #{userType}
            </if>
            <if test="@Ognl@isNotEmpty(headImg)">
                AND HEAD_IMG = #{headImg}
            </if>
            <if test="@Ognl@isNotEmpty(addTime)">
                AND ADD_TIME = #{addTime}
            </if>
            <if test="@Ognl@isNotEmpty(modifyTime)">
                AND MODIFY_TIME = #{modifyTime}
            </if>
            <if test="@Ognl@isNotEmpty(addUserId)">
                AND ADD_USER_ID = #{addUserId}
            </if>
            <if test="@Ognl@isNotEmpty(remark)">
                AND REMARK = #{remark}
            </if>
            <if test="@Ognl@isNotEmpty(status)">
                AND STATUS = #{status}
            </if>
            <if test="@Ognl@isNotEmpty(isDelete)">
                AND IS_DELETE = #{isDelete}
            </if>
            <if test="@Ognl@isNotEmpty(ids)">
                AND ID IN (#{ids})
            </if>
        </where>
    </delete>

    <select id="findById" parameterType="int" resultMap="RM_auth_user">
        SELECT <include refid="select_all_column"/> FROM auth_user WHERE id=#{id}
    </select>

    <select id="findList" parameterType="map" resultMap="RM_auth_user">
        SELECT <include refid="select_all_column"/> FROM auth_user
        <where>
            <if test="@Ognl@isNotEmpty(id)">
                AND ID = #{id}
            </if>
            <if test="@Ognl@isNotEmpty(userName)">
                AND USER_NAME LIKE '%${userName}%'
            </if>
            <if test="@Ognl@isNotEmpty(fullName)">
                AND FULL_NAME LIKE '%${fullName}%'
            </if>
            <if test="@Ognl@isNotEmpty(password)">
                AND PASSWORD = #{password}
            </if>
            <if test="@Ognl@isNotEmpty(sex)">
                AND SEX = #{sex}
            </if>
            <if test="@Ognl@isNotEmpty(birthday)">
                AND BIRTHDAY = #{birthday}
            </if>
            <if test="@Ognl@isNotEmpty(userType)">
                AND USER_TYPE = #{userType}
            </if>
            <if test="@Ognl@isNotEmpty(headImg)">
                AND HEAD_IMG = #{headImg}
            </if>
            <if test="@Ognl@isNotEmpty(addTime)">
                AND ADD_TIME = #{addTime}
            </if>
            <if test="@Ognl@isNotEmpty(modifyTime)">
                AND MODIFY_TIME = #{modifyTime}
            </if>
            <if test="@Ognl@isNotEmpty(addUserId)">
                AND ADD_USER_ID = #{addUserId}
            </if>
            <if test="@Ognl@isNotEmpty(remark)">
                AND REMARK = #{remark}
            </if>
            <if test="@Ognl@isNotEmpty(status)">
                AND STATUS = #{status}
            </if>
            <if test="@Ognl@isNotEmpty(isDelete)">
                AND IS_DELETE = #{isDelete}
            </if>
            <if test="@Ognl@isNotEmpty(ids)">
                AND ID IN (#{ids})
            </if>
        </where>
        <if test="@Ognl@isNotEmpty(orderBy)">
            ORDER BY #{orderBy}
        </if>
    </select>

    <select id="findByUserName" parameterType="java.lang.Strin