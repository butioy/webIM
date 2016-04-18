<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="org.butioy.auth.dao.IAuthPermissionMapper">
    <resultMap id="RM_auth_permission" type="org.butioy.auth.domain.AuthPermission">
        <id property="id" column="ID"/>
        <result property="name" column="NAME"/>
        <result property="url" column="URL"/>
        <result property="type" column="TYPE"/>
        <result property="remark" column="REMARK"/>
        <result property="addTime" column="ADD_TIME"/>
        <result property="modifyTime" column="MODIFY_TIME"/>
        <result property="addUserId" column="ADD_USER_ID"/>
        <result property="status" column="STATUS"/>
        <result property="isDelete" column="IS_DELETE"/>
        <result property="depId" column="DEP_ID"/>
        <result property="perGroupId" column="PER_GROUP_ID"/>
    </resultMap>

    <resultMap id="RM_auth_permission_all_info" type="org.butioy.auth.domain.AuthPermission">
        <id property="id" column="ID"/>
        <result property="name" column="NAME"/>
        <result property="url" column="URL"/>
        <result property="type" column="TYPE"/>
        <result property="remark" column="REMARK"/>
        <result property="addTime" column="ADD_TIME"/>
        <result property="modifyTime" column="MODIFY_TIME"/>
        <result property="addUserId" column="ADD_USER_ID"/>
        <result property="status" column="STATUS"/>
        <result property="isDelete" column="IS_DELETE"/>
        <result property="depId" column="DEP_ID"/>
        <result property="perGroupId" column="PER_GROUP_ID"/>
        <association property="department" javaType="org.butioy.auth.domain.AuthDepartment">
            <id property="id" column="DID"/>
            <id property="name" column="DNAME"/>
        </association>
        <association property="permissionGroup" javaType="org.butioy.auth.domain.AuthPermissionGroup">
            <id property="id" column="PID"/>
            <id property="name" column="PNAME"/>
        </association>
        <association property="user" javaType="org.butioy.auth.domain.AuthUser">
            <id property="id" column="PID"/>
            <id property="userName" column="USERNAME"/>
            <id property="fullName" column="FULLNAME"/>
        </association>
    </resultMap>

    <sql id="select_all_column">
        <![CDATA[
          ID, NAME, URL, TYPE, REMARK, ADD_TIME, MODIFY_TIME, ADD_USER_ID, STATUS, IS_DELETE, DEP_ID, PER_GROUP_ID
        ]]>
    </sql>

    <sql id="select_all_info">
        <![CDATA[
          t.ID AS ID, t.NAME AS NAME, t.URL AS URL, t.TYPE AS TYPE, t.REMARK AS REMARK, t.ADD_TIME AS ADD_TIME, t.MODIFY_TIME AS MODIFY_TIME, t.ADD_USER_ID AS ADD_USER_ID, t.STATUS AS STATUS,
          t.IS_DELETE AS IS_DELETE, t.DEP_ID AS DEP_ID, t.PER_GROUP_ID AS PER_GROUP_ID, d.ID AS DID, d.NAME AS DNAME, p.ID AS PID, p.NAME AS PNAME, u.ID AS UID, u.USER_NAME AS USERNAME, u.FULL_NAME AS FULLNAME
        ]]>
    </sql>

    <sql id="dynamic_insert_key">
        <trim prefix="( " suffix=" )" suffixOverrides=",">
            <if test="@Ognl@isNotEmpty(id)">
                ID,
            </if>
            <if test="@Ognl@isNotEmpty(name)">
                NAME,
            </if>
            <if test="@Ognl@isNotEmpty(url)">
                URL,
            </if>
            <if test="@Ognl@isNotEmpty(type)">
                TYPE,
            </if>
            <if test="@Ognl@isNotEmpty(remark)">
                REMARK,
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
            <if test="@Ognl@isNotEmpty(status)">
                STATUS,
            </if>
            <if test="@Ognl@isNotEmpty(isDelete)">
                IS_DELETE,
            </if>
            <if test="@Ognl@isNotEmpty(depId)">
                DEP_ID,
            </if>
            <if test="@Ognl@isNotEmpty(perGroupId)">
                PER_GROUP_ID,
            </if>

        </trim>
    </sql>

    <sql id="dynamic_insert_value">
        <trim prefix="( " suffix=" )" suffixOverrides=",">
            <if test="@Ognl@isNotEmpty(id)">
                #{id},
            </if>
            <if test="@Ognl@isNotEmpty(name)">
                #{name},
            </if>
            <if test="@Ognl@isNotEmpty(url)">
                #{url},
            </if>
            <if test="@Ognl@isNotEmpty(type)">
                #{type},
            </if>
            <if test="@Ognl@isNotEmpty(remark)">
                #{remark},
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
            <if test="@Ognl@isNotEmpty(status)">
                #{status},
            </if>
            <if test="@Ognl@isNotEmpty(isDelete)">
                #{isDelete},
            </if>
            <if test="@Ognl@isNotEmpty(depId)">
                #{depId},
            </if>
            <if test="@Ognl@isNotEmpty(perGroupId)">
                #{perGroupId},
            </if>
        </trim>
    </sql>

    <insert id="insert" parameterType="org.butioy.auth.domain.AuthPermission" useGeneratedKeys="true">
        INSERT INTO auth_permission <include refid="dynamic_insert_key"/>
        VALUES <include refid="dynamic_insert_value"/>
    </insert>

    <update id="update" parameterType="org.butioy.auth.domain.AuthPermission">
        <if test="@Ognl@isNotEmpty(id)">
            UPDATE auth_permission
            <set>
                <if test="@Ognl@isNotEmpty(name)">
                    NAME = #{name},
                </if>
                <if test="@Ognl@isNotEmpty(url)">
                    URL = #{url},
                </if>
                <if test="@Ognl@isNotEmpty(type)">
                    TYPE = #{type},
                </if>
                <if test="@Ognl@isNotEmpty(remark)">
                    REMARK = #{remark},
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
                <if test="@Ognl@isNotEmpty(status)">
                    STATUS = #{status},
                </if>
                <if test="@Ognl@isNotEmpty(isDelete)">
                    IS_DELETE = #{isDelete},
                </if>
                <if test="@Ognl@isNotEmpty(depId)">
                    DEP_ID = #{depId},
                </if>
                <if test="@Ognl@isNotEmpty(perGroupId)">
                    PER_GROUP_ID = #{perGroupId},
                </if>
            </set>
            WHERE ID=#{id}
        </if>
    </update>

    <delete id="deleteById" parameterType="int">
        DELETE FROM auth_permission WHERE id=#{id}
    </delete>

    <delete id="deleteByParam" parameterType="map">
        DELETE FROM auth_permission
        <where>
            <if test="@Ognl@isNotEmpty(id)">
                AND ID = #{id}
            </if>
            <if test="@Ognl@isNotEmpty(name)">
                AND NAME LIKE '%${name}%'
            </if>
            <if test="@Ognl@isNotEmpty(url)">
                AND URL = #{url}
            </if>
            <if test="@Ognl@isNotEmpty(type)">
                AND TYPE = #{type}
            </if>
            <if test="@Ognl@isNotEmpty(remark)">
                AND REMARK LIKE '%${remark}%'
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
            <if test="@Ognl@isNotEmpty(status)">
                AND STATUS = #{status}
            </if>
            <if test="@Ognl@isNotEmpty(isDelete)">
                AND IS_DELETE = #{isDelete}
            </if>
            <if test="@Ognl@isNotEmpty(depId)">
                AND DEP_ID = #{depId}
            </if>
            <if test="@Ognl@isNotEmpty(perGroupId)">
                AND PER_GROUP_ID = #{perGroupId}
            </if>
            <if test="@Ognl@isNotEmpty(ids)">
                AND ID IN (${ids})
            </if>
            <if test="@Ognl@isNotEmpty(depIds)">
                AND DEP_ID IN (#{depIds})
            </if>
            <if test="@Ognl@isNotEmpty(perGroupIds)">
                AND PER_GROUP_ID IN (#{perGroupIds})
            </if>
        </where>
    </delete>

    <select id="findById" parameterType="int" resultMap="RM_auth_permission">
        SELECT <include refid="select_all_column"/>
        FROM auth_permission
        WHERE id=#{id}
    </select>

    <select id="findList" parameterType="map" resultMap="RM_auth_permission">
        SELECT <include refid="select_all_column"/>
        FROM auth_permission
        <where>
            <if test="@Ognl@isNotEmpty(id)">
                AND ID = #{id}
            </if>
            <if test="@Ognl@isNotEmpty(name)">
                AND NAME LIKE '%${name}%'
            </if>
            <if test="@Ognl@isNotEmpty(url)">
                AND URL = #{url}
            </if>
            <if test="@Ognl@isNotEmpty(type)">
                AND TYPE = #{type}
            </if>
            <if test="@Ognl@isNotEmpty(remark)">
                AND REMARK LIKE '%${remark}%'
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
            <if test="@Ognl@isNotEmpty(status)">
                AND STATUS = #{status}
            </if>
            <if test="@Ognl@isNotEmpty(isDelete)">
                AND IS_DELETE = #{isDelete}
            </if>
            <if test="@Ognl@isNotEmpty(depId)">
                AND DEP_ID = #{depId}
            </if>
            <if test="@Ognl@isNotEmpty(perGroupId)">
                AND PER_GROUP_ID = #{perGroupId}
            </if>
            <if test="@Ognl@isNotEmpty(ids)">
                AND ID IN (${ids})
            </if>
            <if test="@Ognl@isNotEmpty(depIds)">
                AND DEP_ID IN (#{depIds})
            </if>
            <if test="@Ognl@isNotEmpty(perGroupIds)">
                AND PER_GROUP_ID IN (#{perGroupIds})
            </if>
        </where>
        <if test="@Ognl@isNotEmpty(orderBy)">
            ORDER BY #{orderBy}
        </if>
    </select>

    <select id="findListByPermGroup" parameterType="map" resultMap="RM_auth_permission">
        SELECT t.ID AS ID, t.NAME AS NAME, t.URL AS URL
        FROM auth_permission t
        INNER JOIN (
          SELECT DISTINCT p.PERMISSION_ID AS ID FROM auth_role_permission p
          INNER JOIN auth_user_role u ON p.ROLE_ID=u.ROLE_ID
          WHERE u.USER_ID=#{userId}
        ) s ON t.ID=s.ID
        <where>
            <if test="@Ognl@isNotEmpty(id)">
                AND t.ID = #{id}
            </if>
            <if test="@Ognl@isNotEmpty(name)">
                AND t.NAME LIKE '%${name}%'
            </if>
            <if test="@Ognl@isNotEmpty(url)">
                AND t.URL = #{url}
            </if>
            <if test="@Ognl@isNotEmpty(type)">
                AND t.TYPE = #{type}
            </if>
            <if test="@Ognl@isNotEmpty(remark)">
                AND t.REMARK LIKE '%${remark}%'
            </if>
            <if test="@Ognl@isNotEmpty(addTime)">
                AND t.ADD_TIME = #{addTime}
            </if>
            <if test="@Ognl@isNotEmpty(modifyTime)">
                AND t.MODIFY_TIME = #{modifyTime}
            </if>
            <if test="@Ognl@isNotEmpty(addUserId)">
                AND t.ADD_USER_ID = #{addUserId}
            </if>
            <if test="@Ognl@isNotEmpty(status)">
                AND t.STATUS = #{status}
            </if>
            <if test="@Ognl@isNotEmpty(isDelete)">
                AND t.IS_DELETE = #{isDelete}
            </if>
            <if test="@Ognl@isNotEmpty(depId)">
                AND t.DEP_ID = #{depId}
            </if>
            <if test="@Ognl@isNotEmpty(perGroupId)">
                AND t.PER_GROUP_ID = #{perGroupId}
            </if>
        </where>
        <if test="@Ognl@isNotEmpty(orderBy)">
            ORDER BY #{orderBy}
        </if>
    </select>

    <select id="findAllInfoList" parameterType="map" resultMap="RM_auth_permission_all_info">
        SELECT <include refid="select_all_info"/>
        FROM auth_permission t
        LEFT JOIN auth_department d ON t.DEP_ID = d.ID
        LEFT JOIN auth_permission_group p ON t.PER_GROUP_ID = p.ID
        LEFT JOIN auth_user u ON t.ADD_USER_ID = u.ID
        <where>
            <if test="@Ognl@isNotEmpty(id)">
                AND t.ID = #{id}
            </if>
            <if test="@Ognl@isNotEmpty(name)">
                AND t.NAME LIKE '%${name}%'
            </if>
            <if test="@Ognl@isNotEmpty(url)">
                AND t.URL = #{url}
            </if>
            <if test="@Ognl@isNotEmpty(type)">
                AND t.TYPE = #{type}
            </if>
            <if test="@Ognl@isNotEmpty(remark)">
                AND t.REMARK LIKE '%${remark}%'
            </if>
            <if test="@Ognl@isNotEmpty(addTime)">
                AND t.ADD_TIME = #{addTime}
            </if>
            <if test="@Ognl@isNotEmpty(modifyTime)">
                AND t.MODIFY_TIME = #{modifyTime}
            </if>
            <if test="@Ognl@isNotEmpty(addUserId)">
                AND t.ADD_USER_ID = #{addUserId}
            </if>
            <if test="@Ognl@isNotEmpty(status)">
                AND t.STATUS = #{status}
            </if>
            <if test="@Ognl@isNotEmpty(isDelete)">
                AND t.IS_DELETE = #{isDelete}
            </if>
            <if test="@Ognl@isNotEmpty(depId)">
                AND t.DEP_ID = #{depId}
            </if>
            <if test="@Ognl@isNotEmpty(perGroupId)">
                AND t.PER_GROUP_ID = #{perGroupId}
            </if>
        </where>
        <if test="@Ognl@isNotEmpty(orderBy)">
            ORDER BY #{orderBy}
        </if>
    </select>
</mapper>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 