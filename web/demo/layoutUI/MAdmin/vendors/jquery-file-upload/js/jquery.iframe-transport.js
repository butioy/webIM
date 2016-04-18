<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="org.butioy.auth.dao.IAuthPermissionGroupMapper">
    <resultMap id="RM_auth_permission_group" type="org.butioy.auth.domain.AuthPermissionGroup">
        <id property="id" column="ID"/>
        <result property="name" column="NAME"/>
        <result property="depId" column="DEP_ID"/>
        <result property="addTime" column="ADD_TIME"/>
        <result property="modifyTime" column="MODIFY_TIME"/>
        <result property="addUserId" column="ADD_USER_ID"/>
        <result property="status" column="STATUS"/>
        <result property="isDelete" column="IS_DELETE"/>
    </resultMap>

    <resultMap id="RM_auth_permission_group_List" type="org.butioy.auth.domain.AuthPermissionGroup">
        <id property="id" column="ID"/>
        <result property="name" column="NAME"/>
        <result property="depId" column="DEP_ID"/>
        <collection property="permissions" ofType="org.butioy.auth.domain.AuthPermission">
            <id property="id" column="P_ID"/>
            <result property="name" column="P_NAME"/>
            <result property="url" column="P_URL"/>
            <result property="type" column="P_TYPE"/>
        </collection>
    </resultMap>

    <sql id="select_all_column">
        <![CDATA[
          ID, NAME, DEP_ID, ADD_TIME, MODIFY_TIME, ADD_USER_ID, STATUS, IS_DELETE
        ]]>
    </sql>

    <sql id="select_auth_permission_group_List_column">
        <![CDATA[
          t.ID AS ID, t.NAME AS NAME, t.DEP_ID AS DEP_ID, t.ADD_TIME AS ADD_TIME, t.MODIFY_TIME AS MODIFY_TIME, t.ADD_USER_ID AS ADD_USER_ID, t.STATUS AS STATUS, t.IS_DELETE AS IS_DELETE
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
            <if test="@Ognl@isNotEmpty(depId)">
                DEP_ID,
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
            <if test="@Ognl@isNotEmpty(depId)">
                #{depId},
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
        </trim>
    </sql>

    <insert id="insert" parameterType="org.butioy.auth.domain.AuthPermissionGroup" useGeneratedKeys="true" keyProperty="id">
        INSERT INTO auth_permission_group <include refid="dynamic_insert_key"/>
        VALUES <include refid="dynamic_insert_value"/>
    </insert>

    <update id="update" parameterType="org.butioy.auth.domain.AuthPermissionGroup">
        <if test="@Ognl@isNotEmpty(id)">
            UPDATE auth_permission_group
            <set>
                <if test="@Ognl@isNotEmpty(name)">
                    NAME = #{name},
                </if>
                <if test="@Ognl@isNotEmpty(depId)">
                    DEP_ID = #{depId},
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
            </set>
            WHERE ID=#{id}
        </if>
    </update>

    <delete id="deleteById" parameterType="int">
        DELETE FROM auth_permission_group WHERE id=#{id}
    </delete>

    <delete id="deleteByParam" parameterType="map">
        DELETE FROM auth_permission_group
        <where>
            <if test="@Ognl@isNotEmpty(id)">
                AND ID = #{id}
            </if>
            <if test="@Ognl@isNotEmpty(name)">
                AND NAME = #{name}
            </if>
            <if test="@Ognl@isNotEmpty(depId)">
                AND DEP_ID = #{depId}
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
            <if test="@Ognl@isNotEmpty(ids)">
                AND ID IN #{ids}
            </if>
            <if test="@Ognl@isNotEmpty(depIds)">
                AND DEP_ID IN (#{depIds})
            </if>
        </where>
    </delete>
    <select id="findById" parameterType="int" resultMap="RM_auth_permission_group">
        SELECT <include refid="select_all_column"/>
        FROM auth_permission_group
        WHERE id=#{id}
    </select>

    <select id="findList" parameterType="map" resultMap="RM_auth_permission_group">
        SELECT <include refid="select_all_column"/>
        FROM auth_permission_group
        <where>
            <if test="@Ognl@isNotEmpty(id)">
                AND ID = #{id}
            </if>
            <if test="@Ognl@isNotEmpty(name)">
                AND NAME LIKE '%${name}%'
            </if>
            <if test="@Ognl@isNotEmpty(depId)">
                AND DEP_ID = #{depId}
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
            <if test="@Ognl@isNotEmpty(ids)">
                AND ID IN #{ids}
            </if>
            <if test="@Ognl@isNotEmpty(depIds)">
                AND DEP_ID IN (#{depIds})
            </if>
        </where>
        <if test="@Ognl@isNotEmpty(orderBy)">
            ORDER BY #{orderBy}
        </if>
    </select>

    <select id="findPermissionGroupList" parameterType="map" resultMap="RM_auth_permission_group">
        SELECT <include refid="select_auth_permission_group_List_column"/>
        FROM auth_permission_group t
        WHERE t.STATUS=1 AND t.IS_DELETE=0 AND t.DEP_ID=#{depId} AND t.ID IN (
        SELECT DISTINCT rp.PERMISSION_GROUP_ID FROM AUTH_ROLE_PERMISSION rp
        INNER JOIN AUTH_USER_ROLE ur ON (rp.ROLE_ID=ur.ROLE_ID AND ur.USER_ID=#{userId})
        )
    </select>

    <select id="findKVByDepartment" parameterType="integer" resultType="org.butioy.framework.bean.KeyValue">
      SELECT t.ID AS k, t.NAME AS v FROM auth_permission_group t
      WHERE t.STATUS=1 AND t.IS_DELETE=0 AND t.DEP_ID=#{value}
    </select>

</mapper>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    