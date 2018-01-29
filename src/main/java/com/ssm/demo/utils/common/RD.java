package com.ssm.demo.utils.common;

import java.util.ArrayList;

/**
 * @author 懒♂癌
 * @date 2018-01-27 17:20
 */
public class RD {
    private int state;
    private String msg;
    private Object data;

    /**
     * 实例
     * @param state
     * @param msg
     * @param data
     */
    public RD(int state, String msg, Object data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 服务端操作成功
     */
    private static final int success=200;
    /**
     * 服务端操作失败
     */
    private static final int error=202;
    /**
     * 无访问权限
     */
    private static final int permissions=403;
    /**
     * 失败路径
     */
    private static final int errorPath=404;
    /**
     * 服务端报错
     */
    private static final int exception=500;

    /**
     * 成功处理
     * @return
     */
    public static RD success(){
        return new RD(success, "", new ArrayList<>());
    }

    /**
     * 成功处理
     * 返回 data
     * @param data
     * @return
     */
    public static RD success(Object data){
        return new RD(success, "", data);
    }

    /**
     * 成功处理
     * 返回 msg data
     * @param msg
     * @param data
     * @return
     */
    public static RD success(String msg, Object data){
        return new RD(success, msg, data == null ? new ArrayList<>() : data);
    }

    /**
     * 错误处理
     * 返回 msg
     * @return
     */
    public static RD error(String msg){
        return new RD(error, msg, new ArrayList<>());
    }

    /**
     * 错误处理
     * 返回 msg data
     * @param msg
     * @param data
     * @return
     */
    public static RD error(String msg, Object data){
        return new RD(error, msg, data == null ? new ArrayList<>() : data);
    }

    /**
     * 无权限处理
     * @return
     */
    public static RD permissions(){
        return new RD(permissions, "无访问权限", new ArrayList<>());
    }

    /**
     * 失败路径
     * @return
     */
    public static RD errorPath(){
        return new RD(errorPath,"接口不存在", new ArrayList<>());
    }

    /**
     * 服务端报错处理
     * @param msg
     * @return
     */
    public static RD exception(String msg){
        return new RD(exception, msg, new ArrayList<>());
    }
}
