<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="org.butioy.auth.dao.IAuthDepartmentMapper">
    <resultMap id="RM_auth_department" type="org.butioy.auth.domain.AuthDepartment">
        <id property="id" column="ID"/>
        <result property="name" column="NAME"/>
        <result property="remark" column="REMARK"/>
        <result property="status" column="STATUS"/>
        <result property="isDelete" column="IS_DELETE"/>
        <result property="addTime" column="ADD_TIME"/>
        <result property="modifyTime" column="MODIFY_TIME"/>
        <result property="addUserId" column="ADD_USER_ID"/>
    </resultMap>
    <resultMap id="RM_auth_department_count" type="org.butioy.auth.domain.AuthDepartment">
        <id property="id" column="ID"/>
        <result property="name" column="NAME"/>
        <result property="remark" column="REMARK"/>
        <result property="status" column="STATUS"/>
        <result property="isDelete" column="IS_DELETE"/>
        <result property="addTime" column="ADD_TIME"/>
        <result property="modifyTime" column="MODIFY_TIME"/>
        <result property="addUserId" column="ADD_USER_ID"/>
        <result property="permissionGroupCount" column="PERMISSION_GROUP_COUNT"/>
    </resultMap>

    <sql id="select_all_column">
        <![CDATA[
          ID, NAME, REMARK, STATUS, IS_DELETE, ADD_TIME, MODIFY_TIME, ADD_USER_ID
        ]]>
    </sql>

    <sql id="select_all_column_count">
        <![CDATA[
          ID, NAME, REMARK, STATUS, IS_DELETE, ADD_TIME, MODIFY_TIME, ADD_USER_ID, PERMISSION_GROUP_COUNT
        ]]>
    </sql>

    <sql id="select_all_column_by_t">
        <![CDATA[
          t.ID AS ID, t.NAME AS NAME, t.REMARK AS REMARK, t.STATUS AS STATUS, t.IS_DELETE AS IS_DELETE, t.ADD_TIME AS ADD_TIME, t.MODIFY_TIME AS MODIFY_TIME, t.ADD_USER_ID AS ADD_USER_ID
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
            <if test="@Ognl@isNotEmpty(remark)">
                REMARK,
            </if>
            <if test="@Ognl@isNotEmpty(status)">
                STATUS,
            </if>
            <if test="@Ognl@isNotEmpty(isDelete)">
                IS_DELETE,
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
            <if test="@Ognl@isNotEmpty(remark)">
                #{remark},
            </if>
            <if test="@Ognl@isNotEmpty(status)">
                #{status},
            </if>
            <if test="@Ognl@isNotEmpty(isDelete)">
                #{isDelete},
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
        </trim>
    </sql>

    <insert id="insert" parameterType="org.butioy.auth.domain.AuthDepartment" useGeneratedKeys="true">
        INSERT INTO auth_department <include refid="dynamic_insert_key"/>
        VALUES <include refid="dynamic_insert_value"/>
    </insert>

    <update id="update" parameterType="org.butioy.auth.domain.AuthDepartment">
        <if test="@Ognl@isNotEmpty(id)">
            UPDATE auth_department
            <set>
                <if test="@Ognl@isNotEmpty(name)">
                    NAME = #{name},
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
                <if test="@Ognl@isNotEmpty(addTime)">
                    ADD_TIME = #{addTime},
                </if>
                <if test="@Ognl@isNotEmpty(modifyTime)">
                    MODIFY_TIME = #{modifyTime},
                </if>
                <if test="@Ognl@isNotEmpty(addUserId)">
                    ADD_USER_ID = #{addUserId},
                </if>
            </set>
            WHERE ID=#{id}
        </if>
    </update>

    <delete id="deleteById" parameterType="int">
        DELETE FROM auth_department WHERE id=#{id}
    </delete>

    <delete id="deleteByParam" parameterType="map">
        DELETE FROM auth_department
        <where>
            <if test="@Ognl@isNotEmpty(id)">
                AND ID = #{id}
            </if>
            <if test="@Ognl@isNotEmpty(name)">
                AND NAME = #${name}
            </if>
            <if test="@Ognl@isNotEmpty(remark)">
                AND REMARK = ${remark}
            </if>
            <if test="@Ognl@isNotEmpty(status)">
                AND STATUS = #{status}
            </if>
            <if test="@Ognl@isNotEmpty(isDelete)">
                AND IS_DELETE = #{isDelete}
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
            <if test="@Ognl@isNotEmpty(ids)">
                AND ID IN (#{ids})
            </if>
        </where>
    </delete>

    <select id="findById" parameterType="int" resultMap="RM_auth_department">
        SELECT <include refid="select_all_column"/>
        FROM auth_department
        WHERE id=#{id}
    </select>

    <select id="findList" parameterType="map" resultMap="RM_auth_department">
        SELECT <include refid="select_all_column"/>
        FROM auth_department
        <where>
            <if test="@Ognl@isNotEmpty(id)">
                AND ID = #{id}
            </if>
            <if test="@Ognl@isNotEmpty(name)">
                AND NAME LIKE '%${name}%'
            </if>
            <if test="@Ognl@isNotEmpty(remark)">
                AND REMARK LIKE '%${remark}%'
            </if>
            <if test="@Ognl@isNotEmpty(status)">
                AND STATUS = #{status}
            </if>
            <if test="@Ognl@isNotEmpty(isDelete)">
                AND IS_DELETE = #{isDelete}
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
            <if test="@Ognl@isNotEmpty(ids)">
                AND ID IN (#{ids})
            </if>
        </where>
        <if test="@Ognl@isNotEmpty(orderBy)">
            ORDER BY #{orderBy}
        </if>
    </select>

    <select id="findListByUserId" parameterType="int" resultMap="RM_auth_department">
        SELECT <include refid="select_all_column_by_t"/>
        FROM auth_department t
        WHERE t.STATUS=1 AND t.IS_DELETE=0 AND t.ID IN
        (SELECT DISTINCT rp.DEPARTMENT_ID
        FROM AUTH_ROLE_PERMISSION rp
        INNER JOIN AUTH_ROLE r ON (r.ID=rp.ROLE_ID AND r.STATUS=1 AND r.IS_DELETE=0)
        INNER JOIN AUTH_USER_ROLE ur ON (ur.ROLE_ID=r.ID AND ur.USER_ID=#{value})
        )
    </select>

</mapper>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             